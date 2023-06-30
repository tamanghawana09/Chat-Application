package Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements ActionListener {
    static JFrame frame = new JFrame("Server");
    static  JLabel lbl = new JLabel();
    static JLabel heading = new JLabel();
    static JTextField tf = new JTextField();
    static JTextField tf3 = new JTextField();
    static JButton btn = new JButton();
    static JButton btn2 = new JButton("Connect");
    public void layout(){
        int x = 100;
        int y = 200;

        frame.setSize(600,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(x,y);
        frame.setVisible(true);
        frame.setLayout(null);

        heading.setBounds(10,10,500,40);
        heading.setFont(new Font("Arial",Font.BOLD,30));
        heading.setText("CHAT APPLICATION");
        frame.add(heading);

        btn2.setBounds(450,10,100,40);
        btn2.setBackground(Color.BLUE);
        btn2.setForeground(Color.WHITE);
        frame.add(btn2);

        lbl.setBounds(10,400,50,30);
        lbl.setText("Server: ");
        frame.add(lbl);

        tf.setBounds(60,400,300,30);
        frame.add(tf);

        tf3.setBounds(20,60,450,300);
        frame.add(tf3);

        btn.setBackground(Color.GRAY);
        btn.setForeground(Color.WHITE);
        btn.setBounds(380,400,80,30);
        btn.setText("Send");
        frame.add(btn);
        btn.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn2)
        {
            try{
                ServerSocket ss = new ServerSocket(12345);
                Socket socket = ss.accept();
                System.out.println("A client is connected");
                BufferedReader socketData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String userInput = tf.getText();
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream,true);
                String sendingMessage, receivingMessage;
                if(e.getSource() == btn) {
                    while (true) {
                        sendingMessage = userInput;
                        printWriter.println(sendingMessage);
                        tf3.setText("Server: " + sendingMessage);

                        printWriter.flush();
                        receivingMessage = socketData.readLine();
                        tf3.setText("Client: " + receivingMessage);
                    }
                }
            }catch(IOException e2){
                e2.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        Server obj = new Server();
        obj.layout();

    }
}
