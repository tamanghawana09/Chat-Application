package Package;

import java.io.*;
import java.net.Socket;

public class Client {
    Main main2 = new Main();
    public void clientMessage(){
        try {
            Socket socket = new Socket("127.0.0.1", 12345);
            BufferedReader socketData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String userInput = main2.tf2.getText();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream,true);
            String sendingMessage, receivingMessage;
            while(true){
                receivingMessage = socketData.readLine();
                main2.tf4.setText("Server: " + receivingMessage);
                sendingMessage = userInput;
                printWriter.println(sendingMessage);
                main2.tf4.setText("Client: " + sendingMessage);
                printWriter.flush();
            }
        }catch(IOException e ){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client obj2 = new Client();
        obj2.clientMessage();
    }
}
