package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String[] buffArr;
                    String answer = "";
                    while (!(str).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("?msg=")) {
                            buffArr = str.split(" ");
                            if ("Exit".equals(buffArr[1].substring(6))) {
                                server.close();
                            } else if ("Hello".equals(buffArr[1].substring(6))) {
                                answer = "Hello";
                            } else {
                                answer = "What";
                            }
                        }
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                }
            }
        }
    }
}
