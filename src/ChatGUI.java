import javax.swing.*;
import java.awt.*;

public class ChatGUI extends JFrame {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;
    JButton darkModeButton;

    boolean darkMode = true;

    public ChatGUI() {

        setTitle("AI Girlfriend Chatbot 💖");
        setSize(500, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Chat Area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Input
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));

        // Buttons
        sendButton = new JButton("Send 💌");
        darkModeButton = new JButton("🌙");

        // Bottom Panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1,2));
        buttonPanel.add(darkModeButton);
        buttonPanel.add(sendButton);

        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        applyDarkMode();

        // Send Button Action
        sendButton.addActionListener(e -> sendMessage());

        inputField.addActionListener(e -> sendMessage());

        // Dark Mode Toggle
        darkModeButton.addActionListener(e -> toggleTheme());

        setVisible(true);

        botReply("Hii 😄 I missed you...");
    }

    private void sendMessage() {

        String userText = inputField.getText();

        if(userText.trim().isEmpty()) return;

        chatArea.append("You: " + userText + "\n");

        ChatHistory.saveChat("You: " + userText);

        inputField.setText("");

        String reply = BotLogic.getReply(userText);

        botReply(reply);
    }

    private void botReply(String message) {

        ChatHistory.saveChat("Bot: " + message);

        TypingAnimation.typeMessage(chatArea, "Bot", message);
    }

    private void toggleTheme() {

        darkMode = !darkMode;

        if(darkMode) {
            applyDarkMode();
        } else {
            applyLightMode();
        }
    }

    private void applyDarkMode() {

        chatArea.setBackground(new Color(43,43,43));
        chatArea.setForeground(Color.WHITE);

        inputField.setBackground(new Color(58,58,58));
        inputField.setForeground(Color.WHITE);

        sendButton.setBackground(new Color(255,105,180));
        sendButton.setForeground(Color.WHITE);

        darkModeButton.setBackground(Color.DARK_GRAY);
        darkModeButton.setForeground(Color.WHITE);
    }

    private void applyLightMode() {

        chatArea.setBackground(Color.WHITE);
        chatArea.setForeground(Color.BLACK);

        inputField.setBackground(Color.WHITE);
        inputField.setForeground(Color.BLACK);

        sendButton.setBackground(Color.PINK);
        sendButton.setForeground(Color.BLACK);

        darkModeButton.setBackground(Color.LIGHT_GRAY);
        darkModeButton.setForeground(Color.BLACK);
    }
}