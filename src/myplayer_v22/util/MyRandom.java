package myplayer_v22.util;

import aic2023.user.UnitController;

public class MyRandom {
    private UnitController uc;

    public MyRandom(UnitController uc) {
        this.uc = uc;
    }

    public int nextInt(int maxExclusive) {
        return (int) Math.floor(uc.getRandomDouble() * maxExclusive);
    }

    public int nextInt(int minInclusive, int maxExclusive) {
        return nextInt(maxExclusive - minInclusive) + minInclusive;
    }

    public boolean chance(double percentage) {
        return nextInt(1000) < percentage * 1000;
    }

    public <T> T choice(T[] array) {
        return array[nextInt(array.length - 1)];
    }

    public <T> T[] shuffle(T[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = nextInt(i + 1);

            T temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }

        return array;
    }
}
