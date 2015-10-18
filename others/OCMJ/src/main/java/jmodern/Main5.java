package jmodern;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.io.FiberServerSocketChannel;
import co.paralleluniverse.fibers.io.FiberSocketChannel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Main5 {
    static final int PORT = 1234;
    static final Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws Exception {
        new Fiber(() -> {
            try {
                System.out.println("Starting server");
                FiberServerSocketChannel socket = FiberServerSocketChannel.open().bind(new InetSocketAddress(PORT));
                for (;;) {
                    FiberSocketChannel ch = socket.accept();
                    new Fiber(() -> {
                        try {
                            ByteBuffer buf = ByteBuffer.allocateDirect(1024);
                            int n = ch.read(buf);
                            String response = "HTTP/1.0 200 OK\r\nDate: Fri, 31 Dec 1999 23:59:59 GMT\r\n"
                                            + "Content-Type: text/html\r\nContent-Length: 0\r\n\r\n";
                            n = ch.write(charset.newEncoder().encode(CharBuffer.wrap(response)));
                            ch.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("started");
        Thread.sleep(Long.MAX_VALUE);
    }
}