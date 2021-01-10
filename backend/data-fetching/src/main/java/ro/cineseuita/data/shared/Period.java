package ro.cineseuita.data.shared;

import java.util.Arrays;
import java.util.List;

public enum Period {
    _2018(2018),
    _2019(2019),
    _2020(2020),
    _ALL(-1);

    private int numVal;

    Period(int numVal) {
        this.numVal = numVal;
    }

    public static List<Period> getYears() {
        return Arrays.asList(_2018, _2019, _2020);
    }

    public int getNumVal() {
        return numVal;
    }
}
