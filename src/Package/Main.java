package Package;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main implements ActionListener {
    JFrame frame = new JFrame("Chat Application");
    JLabel lbl = new JLabel();
    JLabel lbl2 = new JLabel();
    JLabel heading = new JLabel();
    JTextField tf = new JTextField();
    JTextField tf2 = new JTextField();
    JButton btn = new JButton();
    JButton btn2 = new JButton();
    public void layout(){


        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);


        heading.setBounds(10,10,500,40);
        heading.setFont(new Font("Arial",Font.BOLD,30));
        heading.setText("CHAT APPLICATION");
        frame.add(heading);

        lbl.setBounds(10,60,50,30);
        lbl.setText("Server: ");
        frame.add(lbl);

        lbl2.setBounds(10,100,50,30);
        lbl2.setText("Client: ");
        frame.add(lbl2);

        tf.setBounds(60,60,300,30);
        frame.add(tf);

        tf2.setBounds(60,100,300,30);
        frame.add(tf2);

        btn.setBackground(Color.GRAY);
        btn.setForeground(Color.WHITE);
        btn.setBounds(380,60,80,30);
        btn.setText("Send");
        frame.add(btn);
        btn.addActionListener(this);

        btn2.setBackground(Color.GRAY);
        btn2.setForeground(Color.WHITE);
        btn2.setBounds(380,100,80,30);
        btn2.setText("Send");
        frame.add(btn2);
        btn2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            try {
                ServerSocket ss = new ServerSocket(12345);
                Socket socket = ss.accept();

                BufferedReader socketData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream,true);
                String sendingMessage, receivingMessage;
                while(true){
                    sendingMessage = tf.getText();


                }

            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.layout();
    }
}