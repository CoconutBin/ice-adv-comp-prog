package attacks.question;

public enum Subject {
    CALCULUS_I(1, "Calculus I"),
    PHYSICS_I(2, "Physics for Engineers"),
    CALCULUS_II(3, "Calculus II"),
    PHYSICS_II(4, "Physics and Electronics for Engineers"),
    COMP_PROG(5, "Computer Programming"),
    ADV_COMP_PROG(6, "Advance Computer Programming"),
    PROB_STAT_DATA(7, "Probability and Statistics for Data Analysis");

    private final int id;
    private final String displayName;

    Subject(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int getId() { return id; }
    public String getDisplayName() { return displayName; }
    
    public static Subject fromId(int id) {
        for (Subject s : Subject.values()) {
            if (s.id == id) return s;
        }
        throw new IllegalArgumentException("Invalid subject ID: " + id);
    }
}
