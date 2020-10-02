package ro.cineseuita.data.contract.auction.entity;

import java.util.Arrays;
import java.util.List;

public enum AuctionType {

    ANUNT_PARTICIPARE(13),
    INVITATIE_PARTICIPARE(3),
    ANUNT_SIMPLIFICAT(18),
    CONCESIONARI(16),
    REZULTAT_CONCURS_SOLUTII(8);


    private final Integer value;

    AuctionType(final Integer newValue) {
        value = newValue;
    }

    public static List<Integer> ALL() {
        return Arrays.asList(ANUNT_PARTICIPARE.value, INVITATIE_PARTICIPARE.value, ANUNT_SIMPLIFICAT.value, CONCESIONARI.value, REZULTAT_CONCURS_SOLUTII.value);
    }

    public Integer getValue() {
        return value;
    }

}
