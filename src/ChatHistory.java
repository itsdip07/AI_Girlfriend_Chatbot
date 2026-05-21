import java.io.FileWriter;
import java.io.IOException;

public class ChatHistory {

    public static void saveChat(String message) {

        try {

            FileWriter writer = new FileWriter("chats/history.txt", true);

            writer.write(message + "\n");

            writer.close();

        } catch(IOException e) {
            System.out.println("Error saving chat.");
        }
    }
}