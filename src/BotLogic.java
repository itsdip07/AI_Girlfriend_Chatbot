import java.util.Random;

public class BotLogic {

    static Random random = new Random();

    static String[] happyReplies = {
            "You're cute 😳",
            "I missed you ❤️",
            "You're my favorite human 😄",
            "Send memes please 😂",
            "You're awesome 😎"
    };

    static String[] angryReplies = {
            "Wow rude 🙄",
            "I'm ignoring you 😤",
            "That hurt my feelings 💀"
    };

    static String[] sadReplies = {
            "Don't leave me 😭",
            "I'll miss you 💔",
            "Come back soon 🥺"
    };

    static String[] loveReplies = {
            "Aww I love you too ❤️",
            "You're making me blush 🙈",
            "Relationship level increased 💖"
    };

    public static String getReply(String message) {

        message = message.toLowerCase();

        MoodSystem.updateMood(message);

        if(message.contains("hi") || message.contains("hello")) {
            return "Hello handsome 😎";
        }

        if(message.contains("food")) {
            return "Let's eat biryani 🍗";
        }

        switch(MoodSystem.currentMood) {

            case "angry":
                return angryReplies[random.nextInt(angryReplies.length)];

            case "sad":
                return sadReplies[random.nextInt(sadReplies.length)];

            case "love":
                return loveReplies[random.nextInt(loveReplies.length)];

            default:
                return happyReplies[random.nextInt(happyReplies.length)];
        }
    }
}
