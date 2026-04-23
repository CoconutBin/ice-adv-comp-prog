package attacks.question;

public enum Subject {
    CALCULUS_I("Calculus I"),
    PHYSICS_I("Physics for Engineers"),
    CALCULUS_II("Calculus II"),
    PHYSICS_II("Physics and Electronics for Engineers"),
    COMP_PROG("Computer Programming"),
    ADV_COMP_PROG("Advanced Computer Programming"),
    PROB_STAT_DATA("Probability and Statistics for Data Analysis");

    private final String displayName;

    public String getDisplayName() {
        return displayName;
    }

    Subject(String displayName) {
        this.displayName = displayName;
    }
}
