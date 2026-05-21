public class MoodSystem {

    public static String currentMood = "happy";

    public static void updateMood(String message) {

        message = message.toLowerCase();

        if(message.contains("love")) {
            currentMood = "love";
        }
        else if(message.contains("bye")) {
            currentMood = "sad";
        }
        else if(message.contains("angry") || message.contains("stupid")) {
            currentMood = "angry";
        }
        else {
            currentMood = "happy";
        }
    }
}