package Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Client implements ActionListener {
    Server server = new Server();
    static JFrame frame2 = new JFrame("Client");
    static JLabel lbl2 = new JLabel();
    static JLabel heading = new JLabel();
    static JTextField tf2 = new JTextField();
    static JTextField tf4 = new JTextField();
    static JButton btn = new JButton("Connect");
    static JButton btn2 = new JButton();
    public void layout(){

        int a = 800;
        int b = 200;

        frame2.setSize(600,500);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setLocation(a,b);
        frame2.setVisible(true);
        frame2.setLayout(null);

        heading.setBounds(10,10,500,40);
        heading.setFont(new Font("Arial",Font.BOLD,30));
        heading.setText("CHAT APPLICATION");
        frame2.add(heading);

        lbl2.setBounds(10,400,50,30);
        lbl2.setText("Client: ");
        frame2.add(lbl2);

        tf2.setBounds(60,400,300,30);
        frame2.add(tf2);

        tf4.setBounds(20,60,450,300);
        frame2.add(tf4);

        btn.setBounds(500,10,100,40);
        btn.setBackground(Color.BLUE);
        btn.setForeground(Color.WHITE);
        frame2.add(btn);


        btn2.setBackground(Color.GRAY);
        btn2.setForeground(Color.WHITE);
        btn2.setBounds(380,400,80,30);
        btn2.setText("Send");
        frame2.add(btn2);
        btn2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            try {
                Socket socket = new Socket("127.0.0.1", 12345);
                System.out.println("A server is connected");
                BufferedReader socketData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String userInput = tf2.getText();
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream,true);
                String sendingMessage, receivingMessage;
                if(e.getSource() == btn2) {
                    while (true) {
                        receivingMessage = socketData.readLine();
                        tf4.setText("Server: " + receivingMessage);
                        sendingMessage = userInput;
                        printWriter.println(sendingMessage);
                        tf4.setText("\nClient: " + sendingMessage);
                        printWriter.flush();
                    }
                }
            }catch(IOException e2 ){
                e2.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Client obj2 = new Client();
        obj2.layout();

    }
}
