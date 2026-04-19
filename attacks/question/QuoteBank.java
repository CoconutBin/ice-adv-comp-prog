package attacks.question;

import java.util.HashMap;
import java.util.Map;

public class QuoteBank {
    private static final Map<Integer, String> bossNames;
    private static final Map<Integer, String> bossIntros;

    static {
        bossNames = new HashMap<>();
        bossNames.put(1, "Leibniz the Limitlessless");
        bossNames.put(2, "Sir Isaac the Apple Lover");
        bossNames.put(3, "Sir Zeno the Ancient Gaslighter");
        bossNames.put(4, "Sir Marxwell the Communist");
        bossNames.put(5, "Meneer Guido van Rossum");
        bossNames.put(6, "James Gaslighting the Gaslighter");
        bossNames.put(7, "Sir Gaussian the Above Average");

        bossIntros = new HashMap<>();
        bossIntros.put(1, "I invented Calculus because I was bored. You're failing it because you're... well, you.");
        bossIntros.put(2, "An apple fell on my head and I discovered Gravity. A textbook fell on yours and you gained nothing.");
        bossIntros.put(3, "You've reached 99% of the way to the answer! Unfortunately, for you to finish, you must first complete half of the remaining 1%. \nThen half of that...");
        bossIntros.put(4, "Why are you hogging all that potential energy? In this field, we redistribute the voltage. \nPrepare to share your electrons with the collective!");
        bossIntros.put(5, "I made Python so simple even a child could use it. And yet, here you are, struggling.");
        bossIntros.put(6, "Your code is so messy it triggered my 'Fight or Flight' response. I'd rather flight from your code though.");
        bossIntros.put(7, "According to my calculations, there is a 99.7% chance you are about to cry. Let's see if you're an outlier!");
    }

    // Private constructor is fine to prevent people from doing 'new QuoteBank()'
    private QuoteBank() {}

    public static String getBossName(int subjectId) {
        return bossNames.getOrDefault(subjectId, "The Unknown Guardian");
    }

    public static String getBossIntro(int subjectId) {
        return bossIntros.getOrDefault(subjectId, "Prepare for your academic demise!");
    }
}