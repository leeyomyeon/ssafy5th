package lab.ssafy.browser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkHttpServer {

    public static void main(String[] args) throws IOException {

        try (ServerSocket ss = new ServerSocket(8081)) {
            System.out.println("[WebServer is ready]");

            while (true) {
                try ( Socket socket = ss.accept() ) {

                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

                    String html = "<html><body><h1>Hello SSAFY!! 와우!</h1></body></html>";
                    bw.write("HTTP/1.1 200 OK \r\n"); //404 Not Found?
                    bw.write("Content-Type: text/html;charset=utf-8\r\n");
                    bw.write("\r\n");
                    bw.write(html);
                    bw.write("\r\n");
                    bw.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
