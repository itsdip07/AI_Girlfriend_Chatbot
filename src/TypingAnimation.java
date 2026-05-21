import javax.swing.*;

public class TypingAnimation {

    public static void typeMessage(JTextArea area, String sender, String message) {

        new Thread(() -> {

            try {

                area.append(sender + ": ");

                for(char c : message.toCharArray()) {

                    area.append(String.valueOf(c));

                    Thread.sleep(35);
                }

                area.append("\n");

            } catch(Exception e) {
                e.printStackTrace();
            }

        }).start();
    }
}