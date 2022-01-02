import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) throws Exception {
        //String host = "127.0.0.1";
        String host = "netology.homework";
        int port = 8084;
        try {
            Socket socket = new Socket(host, port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String question1 = in.readLine();
            System.out.println(question1);// Введите имя

            String name = reader.readLine();
            out.println(name);
            String answer1 = in.readLine();
            System.out.println(answer1);// Порт

            String question2 = in.readLine();
            System.out.println(question2);
            String juiceAnswer = reader.readLine();
            out.println(juiceAnswer); // Про сок
            String answer2 = in.readLine();
            System.out.println(answer2);

            String question3 = in.readLine();
            System.out.println(question3);
            String cookieAnswer = reader.readLine();
            out.println(cookieAnswer); // Про печенья
            String answer3 = in.readLine();
            System.out.println(answer3);


            socket.close();
            in.close();
            out.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
