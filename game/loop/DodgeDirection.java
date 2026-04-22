package game.loop;

import java.util.Random;

public enum DodgeDirection {
    LEFT(1), RIGHT(2), DUCK(3);

    private final int id;

    DodgeDirection(int id) {
        this.id = id;
    }

    public int getId() { return id; }

    public static DodgeDirection fromId(int id) {
        for (DodgeDirection dir : values()) {
            if (dir.getId() == id) return dir;
        }
        throw new IllegalArgumentException("Invalid DodgeDirection ID: " + id);
    }

    public static DodgeDirection getRandomDirection(Random rand) {
        return values()[rand.nextInt(values().length)];
    }

    public static DodgeDirection getRandomDirectionExcluding(Random rand, DodgeDirection exclude) {
        DodgeDirection dir = exclude;
        while (dir == exclude) {
            dir = values()[rand.nextInt(values().length)];
        }
        return dir;
    }
}
