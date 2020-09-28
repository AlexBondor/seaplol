package ro.cineseuita.data.cpv.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import ro.cineseuita.data.cpv.entity.CpvCodeBuilder;
import ro.cineseuita.data.cpv.repository.CpvCodesRepository;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CpvCodesServiceTest {

    @Mock
    private CpvCodesService cpvCodesService;
    @Mock
    private CpvCodesRepository cpvCodesRepository;

    @Before
    public void setUp() throws Exception {
        cpvCodesRepository = mock(CpvCodesRepository.class);
        when(cpvCodesRepository.findAll()).thenReturn(
                Arrays.asList(
                        CpvCodeBuilder.aCpvCode()
                                .with_id("03000000-1")
                                .withCode("03000000-1")
                                .withCodeSimplified("03000000")
                                .withDescription("Produse agricole, de fermă, de pescuit, de silvicultură şi produse conexe")
                                .build(),
                        CpvCodeBuilder.aCpvCode()
                                .with_id("03111100-3")
                                .withCode("03111100-3")
                                .withCodeSimplified("03111100")
                                .withDescription("Boabe de soia")
                                .build(),
                        CpvCodeBuilder.aCpvCode()
                                .with_id("14714000-9")
                                .withCode("14714000-9")
                                .withCodeSimplified("14714000")
                                .withDescription("Staniu")
                                .build(),
                        CpvCodeBuilder.aCpvCode()
                                .with_id("14763000-7")
                                .withCode("14763000-7")
                                .withCodeSimplified("14763000")
                                .withDescription("Indiu")
                                .build(),
                        CpvCodeBuilder.aCpvCode()
                                .with_id("24310000-0")
                                .withCode("24310000-0")
                                .withCodeSimplified("24310000")
                                .withDescription("Produse chimice anorganice de bază")
                                .build(),
                        CpvCodeBuilder.aCpvCode()
                                .with_id("42512500-3")
                                .withCode("42512500-3")
                                .withCodeSimplified("42512500")
                                .withDescription("Piese pentru dispozitive de climatizare")
                                .build(),
                        CpvCodeBuilder.aCpvCode()
                                .with_id("50241200-8")
                                .withCode("50241200-8")
                                .withCodeSimplified("50241200")
                                .withDescription("Servicii de reparare a feriboturilor")
                                .build(),
                        CpvCodeBuilder.aCpvCode()
                                .with_id("72263000-6")
                                .withCode("72263000-6")
                                .withCodeSimplified("72263000")
                                .withDescription("Servicii de aplicare de software")
                                .build(),
                        CpvCodeBuilder.aCpvCode()
                                .with_id("98513300-5")
                                .withCode("98513300-5")
                                .withCodeSimplified("98513300")
                                .withDescription("Servicii de personal angajat temporar pentru particulari")
                                .build())
        );

        cpvCodesService = new CpvCodesService(cpvCodesRepository);
        cpvCodesService.assignParentCodes();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getParentCode() {
        Assert.assertEquals("03111100-3", cpvCodesService.getParentCode("03111110-3"));
        Assert.assertEquals("14714000-9", cpvCodesService.getParentCode("14714200-9"));
        Assert.assertEquals("24310000-0", cpvCodesService.getParentCode("24312000-0"));
        Assert.assertEquals("42512500-3", cpvCodesService.getParentCode("42512510-3"));
        Assert.assertEquals("72263000-6", cpvCodesService.getParentCode("72263500-6"));
        Assert.assertEquals("98513300-5", cpvCodesService.getParentCode("98513310-5"));
    }
}
