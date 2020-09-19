package ro.cineseuita.data.shared.requests;

import org.joda.time.DateTime;

import java.io.UnsupportedEncodingException;

public class FetchDirectAcquisitionContracts extends PostRequestBase {

    private static final String URL = "http://e-licitatie.ro/api-pub/DirectAcquisitionCommon/GetDirectAcquisitionList/";
    private static final String URL_REFERER = "http://e-licitatie.ro/pub/direct-acquisitions/list/1";
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    private Integer pageSize;
    private Boolean showOngoingDa;
    private String cookieContext;
    private Integer pageIndex;
    private Long sysDirectAcquisitionStateId;
    private DateTime finalizationDateStart;
    private DateTime finalizationDateEnd;
    private DateTime publicationDateStart;
    private DateTime publicationDateEnd;
    private Long contractingAuthorityId;

    public FetchDirectAcquisitionContracts() {
        buildParams();
    }

    protected void buildParams() {
        params.put("pageSize", getPageSize());
        params.put("showOngoingDa", isShowOngoingDa());
        params.put("cookieContext", getCookieContext());
        params.put("pageIndex", getPageIndex());
        params.put("sysDirectAcquisitionStateId", getSysDirectAcquisitionStateId());
        params.put("finalizationDateStart", getFinalizationDateStart());
        params.put("finalizationDateEnd", getFinalizationDateEnd());
        params.put("publicationDateStart", getPublicationDateStart());
        params.put("publicationDateEnd", getPublicationDateEnd());
        params.put("contractingAuthorityId", getContractingAuthorityId());
    }

    @Override
    public byte[] getContentData() throws UnsupportedEncodingException {
        buildParams();
        return buildContentData(params);
    }

    @Override
    public String getUrl() {
        return URL;
    }

    @Override
    public String getReferer() {
        return URL_REFERER;
    }

    @Override
    public String getMockResponse() {
        return "{\"total\":720,\"items\":[{\"directAcquisitionId\":102907656,\"directAcquisitionName\":\"SULFAT DE MAGNEZIU\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22638198\",\"cpvCode\":\"33622100-7 - Medicamente utilizate in cardiologie (Rev.2)\",\"publicationDate\":\"2019-03-20T10:42:16+02:00\",\"finalizationDate\":\"2019-03-20T11:11:51+02:00\",\"caDecisionDeadline\":\"2019-03-25T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-27T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4304754 SPITALUL ORASENESC CERNAVODA\",\"estimatedValueRon\":20.36,\"estimatedValueOtherCurrency\":4.28,\"closingValue\":20.36,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102906801,\"directAcquisitionName\":\"TETATOX VACCIN TET. ADS. *0.5 ML *10 Fi. (BBNCIPD)\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22637398\",\"cpvCode\":\"33651600-4 - Vaccinuri (Rev.2)\",\"publicationDate\":\"2019-03-20T10:07:35+02:00\",\"finalizationDate\":\"2019-03-20T10:40:29+02:00\",\"caDecisionDeadline\":\"2019-03-25T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-22T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4322270 Spitalul MUnicipal \\\"Anton Cincu\\\" Tecuci\",\"estimatedValueRon\":3398.20,\"estimatedValueOtherCurrency\":714.45,\"closingValue\":3398.20,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102906626,\"directAcquisitionName\":\"AMIOKORDIN 150mg/3ml*5 Fi sol. inj. 3ml\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22637255\",\"cpvCode\":\"33622000-6 - Medicamente pentru sistemul cardiovascular (Rev.2)\",\"publicationDate\":\"2019-03-20T10:01:14+02:00\",\"finalizationDate\":\"2019-03-20T10:43:28+02:00\",\"caDecisionDeadline\":\"2019-03-25T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-22T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"5808334 SPITALUL MUNICIPAL ORASTIE\",\"estimatedValueRon\":444.0,\"estimatedValueOtherCurrency\":93.35,\"closingValue\":444.0,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102905633,\"directAcquisitionName\":\"TETATOX VACCIN TET. ADS. *0.5 ML *10 Fi. (BBNCIPD)\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22636358\",\"cpvCode\":\"33651600-4 - Vaccinuri (Rev.2)\",\"publicationDate\":\"2019-03-20T09:23:34+02:00\",\"finalizationDate\":\"2019-03-20T09:42:10+02:00\",\"caDecisionDeadline\":\"2019-03-25T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-29T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4751469 SPITALUL  MUNICIPAL MEDIAS\",\"estimatedValueRon\":5097.30,\"estimatedValueOtherCurrency\":1071.67,\"closingValue\":5097.30,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102904333,\"directAcquisitionName\":\"HEPARINA GALENIKA 5000UI/ml - 5ml=SUPLIM MARTIE FARM 43\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22635221\",\"cpvCode\":\"33621100-0 - Antitrombotice (Rev.2)\",\"publicationDate\":\"2019-03-20T07:59:48+02:00\",\"finalizationDate\":\"2019-03-20T09:19:13+02:00\",\"caDecisionDeadline\":\"2019-03-25T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-22T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4278728 SPITALUL JUDETEAN DE URGENTA BACAU\",\"estimatedValueRon\":1115.20,\"estimatedValueOtherCurrency\":234.46,\"closingValue\":1115.20,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102904278,\"directAcquisitionName\":\"TETATOX VACCIN TET. ADS. *0.5 ML *10 Fi. (BBNCIPD)\",\"sysDirectAcquisitionState\":{\"id\":3,\"text\":\"Conditii refuzate\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22635171\",\"cpvCode\":\"33651600-4 - Vaccinuri (Rev.2)\",\"publicationDate\":\"2019-03-20T07:51:33+02:00\",\"finalizationDate\":\"2019-03-20T09:08:33+02:00\",\"caDecisionDeadline\":null,\"supplierDecisionDeadline\":\"2019-03-29T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4751469 SPITALUL  MUNICIPAL MEDIAS\",\"estimatedValueRon\":5097.30,\"estimatedValueOtherCurrency\":1071.67,\"closingValue\":5097.30,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102900869,\"directAcquisitionName\":\"TETATOX VACCIN TET. ADS. *0.5 ML *10 Fi. (BBNCIPD)\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22631952\",\"cpvCode\":\"33651600-4 - Vaccinuri (Rev.2)\",\"publicationDate\":\"2019-03-19T13:33:56+02:00\",\"finalizationDate\":\"2019-03-19T13:36:48+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"5632555 SPITAL MUNICIPAL MOTRU\",\"estimatedValueRon\":1699.10,\"estimatedValueOtherCurrency\":357.52,\"closingValue\":1699.10,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102900821,\"directAcquisitionName\":\"TETATOX VACCIN TET. ADS. *0.5 ML *10 Fi. (BBNCIPD)\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22631897\",\"cpvCode\":\"33651600-4 - Vaccinuri (Rev.2)\",\"publicationDate\":\"2019-03-19T13:31:07+02:00\",\"finalizationDate\":\"2019-03-19T13:53:35+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-22T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4304754 SPITALUL ORASENESC CERNAVODA\",\"estimatedValueRon\":1699.10,\"estimatedValueOtherCurrency\":357.52,\"closingValue\":1699.10,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102900555,\"directAcquisitionName\":\"TETATOX VACCIN TET. ADS. *0.5 ML *10 Fi. (BBNCIPD)\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22631684\",\"cpvCode\":\"33651620-0 - Vaccinuri impotriva difteriei si antitetanos (Rev.2)\",\"publicationDate\":\"2019-03-19T13:19:45+02:00\",\"finalizationDate\":\"2019-03-19T15:20:49+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4701371 Spitalul Municipal de Urgenta Pascani\",\"estimatedValueRon\":5097.30,\"estimatedValueOtherCurrency\":1072.55,\"closingValue\":5097.30,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102899775,\"directAcquisitionName\":\"HEPARINA GALENIKA 5000UI/ml - 5ml\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22630996\",\"cpvCode\":\"33621100-0 - Antitrombotice (Rev.2)\",\"publicationDate\":\"2019-03-19T12:48:50+02:00\",\"finalizationDate\":\"2019-03-19T13:59:44+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-22T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4283325 Centrul Medical de Diagnostic, Tratament Ambulatoriu si Medicina Preventiva\",\"estimatedValueRon\":1115.20,\"estimatedValueOtherCurrency\":234.66,\"closingValue\":1115.20,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102899350,\"directAcquisitionName\":\"AMIOKORDIN 150mg/3ml*5 Fi sol. inj. 3ml\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22630696\",\"cpvCode\":\"33622000-6 - Medicamente pentru sistemul cardiovascular (Rev.2)\",\"publicationDate\":\"2019-03-19T12:33:47+02:00\",\"finalizationDate\":\"2019-03-19T12:37:08+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4483765 Spitalul Orasenesc Sannicolau Mare\",\"estimatedValueRon\":296.0,\"estimatedValueOtherCurrency\":62.28,\"closingValue\":296.0,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102899078,\"directAcquisitionName\":\"TETATOX VACCIN TET. ADS. *0.5 ML *10 Fi. (BBNCIPD)\",\"sysDirectAcquisitionState\":{\"id\":3,\"text\":\"Conditii refuzate\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22630332\",\"cpvCode\":\"33651600-4 - Vaccinuri (Rev.2)\",\"publicationDate\":\"2019-03-19T12:15:12+02:00\",\"finalizationDate\":\"2019-03-19T12:23:58+02:00\",\"caDecisionDeadline\":null,\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"5632555 SPITAL MUNICIPAL MOTRU\",\"estimatedValueRon\":1699.10,\"estimatedValueOtherCurrency\":357.52,\"closingValue\":1699.10,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102897630,\"directAcquisitionName\":\"TETATOX VACCIN TET. ADS. *0.5 ML *10 Fi. (BBNCIPD)\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22629116\",\"cpvCode\":\"33651500-3 - Imunoseruri si imunoglobuline (Rev.2)\",\"publicationDate\":\"2019-03-19T11:16:46+02:00\",\"finalizationDate\":\"2019-03-19T11:41:37+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-22T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4721239 Spitalul Orasenesc Faurei\",\"estimatedValueRon\":849.55,\"estimatedValueOtherCurrency\":178.76,\"closingValue\":849.55,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102897383,\"directAcquisitionName\":\"ALCOOL SANITAR 70%, flacon 0.5 ml\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22628742\",\"cpvCode\":\"24322500-2 - Alcool (Rev.2)\",\"publicationDate\":\"2019-03-19T11:00:42+02:00\",\"finalizationDate\":\"2019-03-19T11:31:47+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"7422690 Serviciul de Ambulanta Judetean Arad\",\"estimatedValueRon\":275.0,\"estimatedValueOtherCurrency\":57.86,\"closingValue\":275.0,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102897007,\"directAcquisitionName\":\"INTRATECT - IMUNOGLOBULINA UMANA NORMALA 5g/100ml\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22628403\",\"cpvCode\":\"33621000-9 - Medicamente pentru sange si pentru organele hematopoietice (Rev.2)\",\"publicationDate\":\"2019-03-19T10:46:06+02:00\",\"finalizationDate\":\"2019-03-19T10:51:22+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4055750 SPITALUL JUDETEAN DE URGENTA BUZAU\",\"estimatedValueRon\":4160.12,\"estimatedValueOtherCurrency\":875.35,\"closingValue\":4160.12,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102896739,\"directAcquisitionName\":\"ACHIZITIE DIRECTA\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22628176\",\"cpvCode\":\"33621100-0 - Antitrombotice (Rev.2)\",\"publicationDate\":\"2019-03-19T10:36:53+02:00\",\"finalizationDate\":\"2019-03-19T10:44:53+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4192936 SPITALUL PROF. DR. CONSTANTIN ANGELESCU\",\"estimatedValueRon\":345.20,\"estimatedValueOtherCurrency\":72.64,\"closingValue\":345.20,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102895506,\"directAcquisitionName\":\"SULFAT DE MAGNEZIU 250 mg\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22627614\",\"cpvCode\":\"33622100-7 - Medicamente utilizate in cardiologie (Rev.2)\",\"publicationDate\":\"2019-03-19T10:11:27+02:00\",\"finalizationDate\":\"2019-03-19T12:33:21+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-22T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"2540589 SPITALUL JUDETEAN DE URGENTA VALCEA\",\"estimatedValueRon\":254.50,\"estimatedValueOtherCurrency\":53.55,\"closingValue\":254.50,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102895875,\"directAcquisitionName\":\"ALCOOL SANITAR 70%, flacon 0.5 ml\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22627433\",\"cpvCode\":\"24322500-2 - Alcool (Rev.2)\",\"publicationDate\":\"2019-03-19T10:03:32+02:00\",\"finalizationDate\":\"2019-03-19T12:34:23+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4300752 SPITALUL MUNICIPAL MEDGIDIA\",\"estimatedValueRon\":550.0,\"estimatedValueOtherCurrency\":115.73,\"closingValue\":550.0,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102895195,\"directAcquisitionName\":\"AMIOKORDIN 150mg/3ml*5 Fi sol. inj. 3ml\",\"sysDirectAcquisitionState\":{\"id\":3,\"text\":\"Conditii refuzate\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22627134\",\"cpvCode\":\"33622000-6 - Medicamente pentru sistemul cardiovascular (Rev.2)\",\"publicationDate\":\"2019-03-19T09:50:42+02:00\",\"finalizationDate\":\"2019-03-19T09:52:02+02:00\",\"caDecisionDeadline\":null,\"supplierDecisionDeadline\":\"2019-03-26T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"3695247 SPITAL ORASENESC TG LAPUS\",\"estimatedValueRon\":296.0,\"estimatedValueOtherCurrency\":62.28,\"closingValue\":296.0,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102895449,\"directAcquisitionName\":\"PPD TUBERCULIN MAMMALIAN 5 UT/0.1 ML*1ML*10 FL.*10 DZ - PT. DISPENSARUL TBC\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22627076\",\"cpvCode\":\"33680000-0 - Articole farmaceutice (Rev.2)\",\"publicationDate\":\"2019-03-19T09:48:41+02:00\",\"finalizationDate\":\"2019-03-19T09:52:08+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4395086 SPITALUL MUNICIPAL CARACAL\",\"estimatedValueRon\":3726.0,\"estimatedValueOtherCurrency\":784.01,\"closingValue\":3726.0,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102895221,\"directAcquisitionName\":\"AMIOKORDIN 150mg/3ml*5 Fi sol. inj. 3ml\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22626968\",\"cpvCode\":\"33622000-6 - Medicamente pentru sistemul cardiovascular (Rev.2)\",\"publicationDate\":\"2019-03-19T09:44:20+02:00\",\"finalizationDate\":\"2019-03-19T09:47:29+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4448199 SPITALUL ORASENESC BUMBESTI-JIU\",\"estimatedValueRon\":29.60,\"estimatedValueOtherCurrency\":6.23,\"closingValue\":29.60,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102895401,\"directAcquisitionName\":\"INTRATECT - IMUNOGLOBULINA UMANA NORMALA 5g/100ml\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22626957\",\"cpvCode\":\"33621000-9 - Medicamente pentru sange si pentru organele hematopoietice (Rev.2)\",\"publicationDate\":\"2019-03-19T09:43:58+02:00\",\"finalizationDate\":\"2019-03-19T09:44:56+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"4426352 Spitalul Clinic de Urgenta pentru Copii Cluj-Napoca\",\"estimatedValueRon\":2080.06,\"estimatedValueOtherCurrency\":437.68,\"closingValue\":2080.06,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102895108,\"directAcquisitionName\":\"Achizitie TETATOX VACCIN TET. ADS. *0.5 ML\",\"sysDirectAcquisitionState\":{\"id\":3,\"text\":\"Conditii refuzate\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22626730\",\"cpvCode\":\"33651600-4 - Vaccinuri (Rev.2)\",\"publicationDate\":\"2019-03-19T09:32:45+02:00\",\"finalizationDate\":\"2019-03-19T09:46:50+02:00\",\"caDecisionDeadline\":null,\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"7530616 Spitalul Orasenesc Turceni\",\"estimatedValueRon\":3398.20,\"estimatedValueOtherCurrency\":715.03,\"closingValue\":3398.20,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102894887,\"directAcquisitionName\":\"SULFAT DE MAGNEZIU\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22626577\",\"cpvCode\":\"33622100-7 - Medicamente utilizate in cardiologie (Rev.2)\",\"publicationDate\":\"2019-03-19T09:25:22+02:00\",\"finalizationDate\":\"2019-03-19T16:21:55+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"1061626 SPITALUL JUDETEAN RESITA\",\"estimatedValueRon\":20.36,\"estimatedValueOtherCurrency\":4.28,\"closingValue\":20.36,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false},{\"directAcquisitionId\":102894728,\"directAcquisitionName\":\"TETATOX VACCIN TET. ADS. *0.5 ML *10 Fi.\",\"sysDirectAcquisitionState\":{\"id\":7,\"text\":\"Oferta acceptata\",\"localeKey\":null},\"uniqueIdentificationCode\":\"DA22626398\",\"cpvCode\":\"33651600-4 - Vaccinuri (Rev.2)\",\"publicationDate\":\"2019-03-19T09:16:54+02:00\",\"finalizationDate\":\"2019-03-19T09:21:37+02:00\",\"caDecisionDeadline\":\"2019-03-24T17:00:00+02:00\",\"supplierDecisionDeadline\":\"2019-03-21T17:00:00+02:00\",\"supplier\":\"RO 11653560 COMPANIA NATIONALA UNIFARM\",\"contractingAuthority\":\"2845125 SPITALUL DE ORTOPEDIE SI TRAUMATOLOGIE AZUGA\",\"estimatedValueRon\":849.55,\"estimatedValueOtherCurrency\":178.76,\"closingValue\":849.55,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false}],\"searchTooLong\":false}";
    }

    @Override
    public String getContentType() {
        return CONTENT_TYPE;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean isShowOngoingDa() {
        return showOngoingDa;
    }

    public void setShowOngoingDa(Boolean showOngoingDa) {
        this.showOngoingDa = showOngoingDa;
    }

    public String getCookieContext() {
        return cookieContext;
    }

    public void setCookieContext(String cookieContext) {
        this.cookieContext = cookieContext;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Long getSysDirectAcquisitionStateId() {
        return sysDirectAcquisitionStateId;
    }

    public void setSysDirectAcquisitionStateId(Long sysDirectAcquisitionStateId) {
        this.sysDirectAcquisitionStateId = sysDirectAcquisitionStateId;
    }

    public DateTime getFinalizationDateStart() {
        return finalizationDateStart;
    }

    public void setFinalizationDateStart(DateTime finalizationDateStart) {
        this.finalizationDateStart = finalizationDateStart;
    }

    public DateTime getFinalizationDateEnd() {
        return finalizationDateEnd;
    }

    public void setFinalizationDateEnd(DateTime finalizationDateEnd) {
        this.finalizationDateEnd = finalizationDateEnd;
    }

    public DateTime getPublicationDateStart() {
        return publicationDateStart;
    }

    public void setPublicationDateStart(DateTime publicationDateStart) {
        this.publicationDateStart = publicationDateStart;
    }

    public DateTime getPublicationDateEnd() {
        return publicationDateEnd;
    }

    public void setPublicationDateEnd(DateTime publicationDateEnd) {
        this.publicationDateEnd = publicationDateEnd;
    }

    public Long getContractingAuthorityId() {
        return contractingAuthorityId;
    }

    public void setContractingAuthorityId(Long contractingAuthorityId) {
        this.contractingAuthorityId = contractingAuthorityId;
    }

}
