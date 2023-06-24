
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class example extends JFrame {
    private JTextArea chatBox;
    private JTextField messageField;

    public example() {
        setTitle("Chat Application");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a text area to display the chat history
        chatBox = new JTextArea();
        chatBox.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatBox);
        add(scrollPane, BorderLayout.CENTER);

        // Create a panel for the message input and send button
        JPanel inputPanel = new JPanel(new BorderLayout());

        // Create a text field for entering messages
        messageField = new JTextField();
        inputPanel.add(messageField, BorderLayout.CENTER);

        // Create a button to send messages
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            chatBox.append("You: " + message + "\n");
            messageField.setText("");
            // Send the message to the other user or perform any required actions
            receiveMessage("Sample received message");
        }
    }

    private void receiveMessage(String message) {
        chatBox.append("Friend: " + message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new example();
            }
        });
    }
}
