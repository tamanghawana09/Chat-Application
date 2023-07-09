package Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Client implements ActionListener {
    static JFrame frame2 = new JFrame("Client");
    static JLabel lbl1 = new JLabel();
    static JLabel lbl2 = new JLabel();
    static JLabel heading = new JLabel();
    static JTextField tf2 = new JTextField();
    static JTextArea tf4 = new JTextArea();
    static JButton btn2 = new JButton();
    static String sendingMessage;
    static String receivingMessage;
    static PrintWriter printWriter;

    public void layout() {

        int a = 800;
        int b = 200;

        frame2.setSize(500, 500);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setLocation(a, b);
        frame2.setLayout(null);

        heading.setBounds(10, 10, 300, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setText("CHAT APPLICATION");
        frame2.add(heading);

        lbl1.setBounds(350, 10, 200, 40);
        frame2.add(lbl1);

        lbl2.setBounds(10, 400, 50, 30);
        lbl2.setText("Client: ");
        frame2.add(lbl2);

        tf2.setBounds(60, 400, 300, 30);
        frame2.add(tf2);

        tf4.setBounds(20, 60, 450, 300);
        tf4.setEditable(false);  // Prevent manual editing
        frame2.add(tf4);

        btn2.setBackground(Color.GRAY);
        btn2.setForeground(Color.WHITE);
        btn2.setBounds(380, 400, 80, 30);
        btn2.setText("Send");
        frame2.add(btn2);
        btn2.addActionListener(this);

        frame2.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn2) {
            sendingMessage = tf2.getText();
            System.out.println("Server is connected");
            tf4.setText(sendingMessage);
            printWriter.println(sendingMessage);
            tf2.setText("");  // Clear the input text field after sending
        }
    }

    public static void main(String[] args) {
        Client obj2 = new Client();
        obj2.layout();

        try {
            Socket socket = new Socket("127.0.0.1", 12345);
            lbl1.setText("Server is connected");

            BufferedReader socketData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream outputStream = socket.getOutputStream();
             printWriter = new PrintWriter(outputStream, true);

            while (true) {
                receivingMessage = socketData.readLine();
                tf4.setText(receivingMessage);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
