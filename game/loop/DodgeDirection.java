package game.loop;

import java.util.Random;

public enum DodgeDirection {
    LEFT,
    RIGHT,
    DUCK;

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
