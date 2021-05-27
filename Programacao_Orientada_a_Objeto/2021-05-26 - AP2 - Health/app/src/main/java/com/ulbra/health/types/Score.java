package com.ulbra.health.types;

public enum Scores {
    AGE(new int[] {1,2,3,4,6,8}),
    SEX(new int[] {1,2,3,4,6,7}),
    WEIGHT(new int[] {0,1,2,3,5,7}),
    ACTIVITY(new int[] {1,2,3,5,6,8}),
    SMOKES(new int[] {0,1,2,4,6,10}),
    PRESSURE(new int[] {1,2,3,4,6,8}),
    ILLNESS_IN_FAMILY(new int[] {1,2,3,4,6,7}),
    CHOLESTEROL(new int[] {1,2,3,4,5,7});


    private final int[] ints;
    Scores(int[] ints) {
        this.ints = ints;
    }

    public int[] scores() {
        return this.ints;
    }

    public static int[] getScore(int position) {
        switch (position) {
            case 0:
                return AGE.scores();
            case 1:
                return SEX.scores();
            case 2:
                return WEIGHT.scores();
            case 3:
                return ACTIVITY.scores();
            case 4:
                return SMOKES.scores();
            case 5:
                return PRESSURE.scores();
            case 6:
                return ILLNESS_IN_FAMILY.scores();
            case 7:
                return CHOLESTEROL.scores();
            default:
                return null;
        }
    }
}
