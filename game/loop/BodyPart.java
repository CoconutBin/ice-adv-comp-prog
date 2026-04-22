package game.loop;

import java.util.Random;

public enum BodyPart {
    HEAD(1, "Head"), BODY(2, "Body"), LEGS(3, "Legs");

    private final int id;
    private final String name;

    BodyPart(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    @Override
    public String toString() { return name; }

    public static BodyPart fromId(int id) {
        for (BodyPart part : values()) {
            if (part.getId() == id) return part;
        }
        throw new IllegalArgumentException("Invalid BodyPart ID: " + id);
    }

    public static BodyPart getRandomPart(Random rand) {
        return values()[rand.nextInt(values().length)];
    }

    public static BodyPart getRandomPartExcluding(Random rand, BodyPart exclude) {
        BodyPart part = exclude;
        while (part == exclude) {
            part = values()[rand.nextInt(values().length)];
        }
        return part;
    }
}
