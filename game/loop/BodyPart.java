package game.loop;

import java.util.Random;

public enum BodyPart {
    HEAD("Head"),
    BODY("Body"),
    LEGS("Legs");

    private final String name;

    BodyPart(String name) {
        this.name = name;
    }

    @Override
    public String toString() { return name; }

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
