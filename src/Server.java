import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Server {

    static ServerSocket server;

    static {
        try {
            server = new ServerSocket(10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     Socket s;
    BufferedWriter bw;

    public Server() throws IOException {
    }

    public void accept() throws IOException {
        this.s = server.accept();
        bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
    }

    public void writeOnce(String str) throws IOException {
        bw.write(str);
        bw.flush();
        bw.close();
        s.close();
        server.close();
    }

    public void write(String str) throws IOException {
        bw.write(str);
        bw.flush();
    }

    public void close() throws IOException {
        bw.close();
        s.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server s = new Server();
        s.accept();
        s.write("Test\n");
        s.write("Test\n");
        s.write("Test\n");
        s.write("Test\n");
        s.close();


    }

}
