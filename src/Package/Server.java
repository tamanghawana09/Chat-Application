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
    static JLabel lbl = new JLabel();
    static JLabel lbl2 = new JLabel();
    static JLabel heading = new JLabel();
    static JTextArea tf = new JTextArea();
    static JTextArea tf3 = new JTextArea();
    static JButton btn = new JButton();
    static String sendingMessage;
    static String receivingMessage;
    static PrintWriter printWriter;

    public void layout() {
        int x = 100;
        int y = 200;

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(x, y);
        frame.setLayout(null);

        heading.setBounds(10, 10, 300, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setText("CHAT APPLICATION");
        frame.add(heading);

        lbl2.setBounds(350,10,200,40);
        frame.add(lbl2);

        lbl.setBounds(10, 400, 50, 30);
        lbl.setText("Server: ");
        frame.add(lbl);

        tf.setBounds(60, 400, 300, 30);
        tf3.setEditable(false);
        frame.add(tf);

        tf3.setBounds(20, 60, 450, 300);
        frame.add(tf3);

        btn.setBackground(Color.GRAY);
        btn.setForeground(Color.WHITE);
        btn.setBounds(380, 400, 80, 30);
        btn.setText("Send");
        frame.add(btn);
        btn.addActionListener(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            sendingMessage = tf.getText();
            System.out.println(sendingMessage);
            tf3.setText(sendingMessage);
            printWriter.println(sendingMessage);
            tf.setText("");  // Clear the input text area after sending
        }
    }

    public static void main(String[] args) {
        Server obj = new Server();
        obj.layout();

        try {
            ServerSocket ss = new ServerSocket(12345);
            Socket socket = ss.accept();
            lbl2.setText("Client is connected");

            BufferedReader socketData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream, true);

            while (true) {

                receivingMessage = socketData.readLine();
                tf3.setText(receivingMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
