package attacks.question;

import java.util.HashMap;
import java.util.Map;

public class QuoteBank {
    private static final Map<Subject, String> bossNames;
    private static final Map<Subject, String> bossIntros;
    private static final Map<Subject, String> bossVicotory;
    private static final Map<Subject, String> bossDefeat;

    static {
        bossNames = new HashMap<>();
        bossNames.put(Subject.CALCULUS_I, "Leibniz the Limitlessless");
        bossNames.put(Subject.PHYSICS_I, "Sir Isaac the Apple Lover");
        bossNames.put(Subject.CALCULUS_II, "Sir Zeno the Ancient Gaslighter");
        bossNames.put(Subject.PHYSICS_II, "Sir Marxwell the Communist");
        bossNames.put(Subject.COMP_PROG, "Meneer Guido van Rossum");
        bossNames.put(Subject.ADV_COMP_PROG, "James Gaslighting the Gaslighter");
        bossNames.put(Subject.PROB_STAT_DATA, "Sir Gaussian the Above Average");

        bossIntros = new HashMap<>();
        bossIntros.put(Subject.CALCULUS_I, "I invented Calculus because I was bored. You're failing it because you're... well, you.");
        bossIntros.put(Subject.PHYSICS_I, "An apple fell on my head and I discovered Gravity. A textbook fell on yours and you gained nothing.");
        bossIntros.put(Subject.CALCULUS_II, "You've reached 99% of the way to the answer! Unfortunately, for you to finish, you must first complete half of the remaining 1%. \nThen half of that...");
        bossIntros.put(Subject.PHYSICS_II, "Why are you hogging all that potential energy? In this field, we redistribute the voltage. \nPrepare to share your electrons with the collective!");
        bossIntros.put(Subject.COMP_PROG, "I made Python so simple even a child could use it. And yet, here you are, struggling.");
        bossIntros.put(Subject.ADV_COMP_PROG, "Your code is so messy it triggered my 'Fight or Flight' response. I'd rather fly away from your code though...");
        bossIntros.put(Subject.PROB_STAT_DATA, "According to my calculations, there is a 99.7% chance you are about to cry. Let's see if you're an outlier!");
        
        bossVicotory = new HashMap<>();
        bossDefeat = new HashMap<>();

        bossVicotory.put(Subject.CALCULUS_I, "Your efforts approached zero, but never quite reached a passing grade.");
        bossDefeat.put(Subject.CALCULUS_I, "The one failing is me, I suppose...");

        bossVicotory.put(Subject.PHYSICS_I, "For every action, there is an equal and opposite rejection of your progress!");
        bossDefeat.put(Subject.PHYSICS_I, "I should have stayed under the tree...");

        bossVicotory.put(Subject.CALCULUS_II, "You thought you were halfway there, but you'll never actually arrive at the end!");
        bossDefeat.put(Subject.CALCULUS_II, "A paradox! I was defeated, yet... logically, I am still standing.");

        bossVicotory.put(Subject.PHYSICS_II, "Your energy is no longer yours—it belongs to the FIELD! Our potential is equalized!");
        bossDefeat.put(Subject.PHYSICS_II, "The resistance was higher than anticipated. We will comeback.");

        bossVicotory.put(Subject.COMP_PROG, "As expected of you, struggling on something so simple.");
        bossDefeat.put(Subject.COMP_PROG, "Fine. I'll retire to the standard library. Your code is... readable enough.");

        bossVicotory.put(Subject.ADV_COMP_PROG, "It worked on my machine. Sounds like a skill issue in your virtual machine.");
        bossDefeat.put(Subject.ADV_COMP_PROG, "Time to fly away...");

        bossVicotory.put(Subject.PROB_STAT_DATA, "You are three standard deviations away from being a threat. Simply an outlier.");
        bossDefeat.put(Subject.PROB_STAT_DATA, "The probability of this was less than 0.01%... I am statistically insignificant.");
    }

    // Private constructor is fine to prevent people from doing 'new QuoteBank()'
    private QuoteBank() {}

    public static String getBossName(Subject subjectId) {
        return bossNames.getOrDefault(subjectId, "The Unknown Guardian");
    }

    public static String getBossIntro(Subject subjectId) {
        return bossIntros.getOrDefault(subjectId, "Prepare for your academic demise!");
    }

    public static String getBossVictory(Subject subject) {
        return bossVicotory.getOrDefault(subject, "Class dismissed.");
    }

    public static String getBossDefeat(Subject subject) {
        return bossDefeat.getOrDefault(subject, "I... I failed the exam...");
    }
}