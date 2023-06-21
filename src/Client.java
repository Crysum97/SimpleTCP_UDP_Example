import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.stream.Stream;

public class Client {
    Socket s;
    BufferedReader br;

    public Client() {
    }

    public void connect(String host, int port) throws IOException {
        this.s = new Socket(host, port);
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    public void readOnce() throws IOException {
        String received = br.readLine();
        System.out.println(received);
        br.close();
        s.close();
    }

    public void read() {
        br.lines().forEach(System.out::println);
    }


    public static void main(String[] args) throws IOException {
        Client c = new Client();
        c.connect("localhost", 10000);
        c.read();
    }
}
