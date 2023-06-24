package Package;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    static Main main = new Main();
    public void serverMessage(){
        try {
            ServerSocket ss = new ServerSocket(12345);
            Socket socket = ss.accept();
            BufferedReader socketData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String userInput = main.tf.getText();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream,true);
            String sendingMessage, receivingMessage;
            while(true){
                sendingMessage = userInput;
                printWriter.println(sendingMessage);
                main.tf3.setText("Server: " + sendingMessage);
                printWriter.flush();
                receivingMessage = socketData.readLine();
                main.tf3.setText("Client: " + receivingMessage);

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server obj = new Server();
        obj.serverMessage();
    }
}
