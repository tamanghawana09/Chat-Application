package Package;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main implements ActionListener {
    JFrame frame = new JFrame("Server");
    JFrame frame2 = new JFrame("Client");
    JLabel lbl = new JLabel();
    JLabel lbl2 = new JLabel();
    JLabel heading = new JLabel();
    JTextField tf = new JTextField();
    JTextField tf2 = new JTextField();
    JTextField tf3 = new JTextField();
    JTextField tf4 = new JTextField();
    JButton btn = new JButton();
    JButton btn2 = new JButton();
    public void layout(){
        int x = 100;
        int y = 200;
        int a = 800;
        int b = 200;

        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(x,y);
        frame.setVisible(true);
        frame.setLayout(null);

        frame2.setSize(500,500);
        frame2.setLocation(a,b);
        frame2.setVisible(true);
        frame2.setLayout(null);

        heading.setBounds(10,10,500,40);
        heading.setFont(new Font("Arial",Font.BOLD,30));
        heading.setText("CHAT APPLICATION");
        frame.add(heading);

        heading.setBounds(10,10,500,40);
        heading.setFont(new Font("Arial",Font.BOLD,30));
        heading.setText("CHAT APPLICATION");
        frame2.add(heading);

        lbl.setBounds(10,400,50,30);
        lbl.setText("Server: ");
        frame.add(lbl);

        lbl2.setBounds(10,400,50,30);
        lbl2.setText("Client: ");
        frame2.add(lbl2);

        tf.setBounds(60,400,300,30);
        frame.add(tf);

        tf3.setBounds(20,20,450,350);
        frame.add(tf3);

        tf2.setBounds(60,400,300,30);
        frame2.add(tf2);

        tf4.setBounds(20,60,450,300);
        frame2.add(tf4);

        btn.setBackground(Color.GRAY);
        btn.setForeground(Color.WHITE);
        btn.setBounds(380,400,80,30);
        btn.setText("Send");
        frame.add(btn);
        btn.addActionListener(this);

        btn2.setBackground(Color.GRAY);
        btn2.setForeground(Color.WHITE);
        btn2.setBounds(380,400,80,30);
        btn2.setText("Send");
        frame2.add(btn2);
        btn2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Server server = new Server();
        Client client = new Client();
        if(e.getSource() == btn){
           server.serverMessage();
        }
        if(e.getSource() == btn2)
        {
            client.clientMessage();
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.layout();
    }
}