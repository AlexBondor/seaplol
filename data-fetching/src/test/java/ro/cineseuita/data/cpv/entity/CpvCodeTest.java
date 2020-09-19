package ro.cineseuita.data.cpv.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CpvCodeTest {

    @Test
    public void getNumberOfTrailingZeros() {
        assertEquals(6, CpvCodeBuilder.aCpvCode().withCodeSimplified("03000000").build().getNumberOfTrailingZeros());
        assertEquals(5, CpvCodeBuilder.aCpvCode().withCodeSimplified("03100000").build().getNumberOfTrailingZeros());
        assertEquals(4, CpvCodeBuilder.aCpvCode().withCodeSimplified("03110000").build().getNumberOfTrailingZeros());
        assertEquals(3, CpvCodeBuilder.aCpvCode().withCodeSimplified("03111000").build().getNumberOfTrailingZeros());
        assertEquals(2, CpvCodeBuilder.aCpvCode().withCodeSimplified("03111100").build().getNumberOfTrailingZeros());
        assertEquals(6, CpvCodeBuilder.aCpvCode().withCodeSimplified("72000000").build().getNumberOfTrailingZeros());
        assertEquals(5, CpvCodeBuilder.aCpvCode().withCodeSimplified("72300000").build().getNumberOfTrailingZeros());
        assertEquals(4, CpvCodeBuilder.aCpvCode().withCodeSimplified("72310000").build().getNumberOfTrailingZeros());
        assertEquals(3, CpvCodeBuilder.aCpvCode().withCodeSimplified("72311000").build().getNumberOfTrailingZeros());
        assertEquals(2, CpvCodeBuilder.aCpvCode().withCodeSimplified("72311100").build().getNumberOfTrailingZeros());
    }
}