import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(8084);
            System.out.println("Server start");
            Socket clientSocket = socket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection accepted");
            out.println("Write your name"); //about the name
            String name = in.readLine();
            out.println(String.format("Hi, %s, your port is %d ",name, clientSocket.getPort()));

            //question about juice
            out.println("Do u want some juice, " + name + " ? (y/n)");
            String juiceAnswer = in.readLine();
            if (juiceAnswer.equals("y")) {
                out.println("Then drink it");
            } else if (juiceAnswer.equals("n")) {
                out.println("Of course u can refuse");
            } else out.println("I don't understand u");

            //question about cookies
            out.println("Do u want some cookies, " + name + " ? (y/n)");
            String cookieAnswer = in.readLine();
            if (cookieAnswer.equals("y")) {
                out.println("Then taste it and get to work");
            } else if (cookieAnswer.equals("n")) {
                out.println("So just return to work");
            } else out.println("I don't understand u, so let's start our work");

            clientSocket.close();
            in.close();
            out.close();
            socket.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
