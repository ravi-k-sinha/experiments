package tserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by it on 29/10/15.
 */
public class TestServer {

    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(9999);
        ExecutorService service = new ThreadPoolExecutor(
                1, 1, 50, TimeUnit.SECONDS,  new ArrayBlockingQueue<Runnable>(5));

        int counter = 0;
        System.out.println("Ready for connection (Max 10)");
        while(true) {
            if (counter++ == 10) {
                System.out.println("Handled ten clients. Now retiring, if you want start me again");
                break;
            }

            Socket clientSocket = socket.accept();

            service.submit(new MyWorker(clientSocket));

        }

    }
}

class MyWorker implements Runnable {

    Socket clientSocket = null;

    MyWorker(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        System.out.println("Will respond after ten seconds");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            clientSocket.getOutputStream().write("Hello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Said hello to the client");

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
