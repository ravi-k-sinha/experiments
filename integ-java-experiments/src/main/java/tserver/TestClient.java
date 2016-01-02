package tserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by it on 29/10/15.
 */
public class TestClient {

    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket("127.0.0.1", 9999);
        socket.setSoTimeout(1000);

        InputStream inputStream = socket.getInputStream();

        System.out.println("Got the input stream");

        Thread.sleep(15000);

        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));

        while(bf.ready() == false) {
            System.out.println("Didn't receive response yet, sleeping for some time");
            Thread.sleep(250);
        }

        System.out.println("Server says " + bf.readLine());

        bf.close();

    }
}
