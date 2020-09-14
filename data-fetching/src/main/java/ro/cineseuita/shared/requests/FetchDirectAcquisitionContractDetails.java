package ro.cineseuita.shared.requests;

public class FetchDirectAcquisitionContractDetails implements GetRequest {

    private static final String URL = "http://e-licitatie.ro/api-pub/PublicDirectAcquisition/getView/";
    private static final String URL_REFERER = "http://e-licitatie.ro/pub/direct-acquisition/view/";
    private final Long contractId;

    public FetchDirectAcquisitionContractDetails(Long contractId) {
        this.contractId = contractId;
    }

    @Override
    public String getUrl() {
        return URL + contractId;
    }

    @Override
    public String getReferer() {
        return URL_REFERER + contractId;
    }

    @Override
    public String getMockResponse() {
        return "{\"estimatedValue\":238.72,\"secondCurrencyEstimatedValue\":50.19,\"closingValue\":238.72,\"secondCurrencyClosingValue\":50.19,\"economyValue\":null,\"economySecondCurrencyValue\":null,\"economyPercent\":null,\"lossValue\":null,\"lossSecondCurrencyValue\":null,\"lossPercent\":null,\"publicationDate\":\"2019-03-20T12:59:18+02:00\",\"supplierDecisionDate\":null,\"caDecisionDate\":null,\"finalizationDate\":null,\"uniqueIdentificationCode\":\"DA22641198\",\"correctionReason\":null,\"directAcquisitionID\":102910967,\"directAcquisitionName\":\"Materiale Electrice\",\"directAcquisitionDescription\":\"HAU210763\\tCLESTE SERTIZAT PINI 0.5-4 CU CLICHET\\tMarfa\\tBUCATA\\t1.\\t149.67\\t149.6688 RCEYY-J4X2.5M\\tCablu EYY-J 4X2.5 RE 0,6/1kV (CYY-F, NYY)\\tMarfa\\tMETRU\\t17.\\t64.26\\t3.78 PHS1770589\\tHF-E II 236 TL-D 220-240V 50/60Hz\\tMarfa\\tBUCATA\\t1.\\t24.79\\t24.7912\",\"cpvCode\":{\"id\":12353,\"text\":\"Materiale electrice (Rev.2)\",\"localeKey\":\"31681410-0\"},\"deliveryCondition\":\"FRANCO DEPOZIT FURNIZOR\",\"paymentCondition\":\"PLATA LA 15 ZILE\",\"supplierId\":50710,\"supplierDecisionDeadline\":\"2019-03-22T17:00:00+02:00\",\"caDecisionDeadline\":null,\"contractingAuthorityID\":6026,\"documents\":[],\"directAcquisitionItems\":[{\"directAcquisitionItemID\":104323078,\"catalogItemID\":100957326,\"catalogItemHistoryID\":108606331,\"sysCatalogItemStateID\":2,\"catalogItemCode\":\"LC-MATERIALE ELECTRICE/2\",\"catalogItemName\":\"Materiale Electrice\",\"catalogItemDescription\":\"HAU210763\\tCLESTE SERTIZAT PINI 0.5-4 CU CLICHET\\tMarfa\\tBUCATA\\t1.\\t149.67\\t149.6688\\nRCEYY-J4X2.5M\\tCablu EYY-J 4X2.5 RE 0,6/1kV (CYY-F, NYY)\\tMarfa\\tMETRU\\t17.\\t64.26\\t3.78\\nPHS1770589\\tHF-E II 236 TL-D 220-240V 50/60Hz\\tMarfa\\tBUCATA\\t1.\\t24.79\\t24.7912\",\"catalogItemPrice\":238.72,\"itemClosingPrice\":238.72,\"itemEstimatedPrice\":238.72,\"secondCurrencyEstimatedPrice\":50.19,\"itemQuantity\":1.0,\"itemRequestedQuantity\":1.0,\"itemMeasureUnit\":\"bucata\",\"isRejectedBySupplier\":false,\"hasQuantityCorrection\":false,\"imageUrl\":null,\"imageThumbUrl\":null,\"associatedPaapDetailName\":null,\"assignedUserEmail\":\"adrian.cristea@arc-electronic.ro\",\"cpvCode\":{\"id\":12353,\"text\":\"Materiale electrice (Rev.2)\",\"localeKey\":\"31681410-0\"},\"isExpired\":null,\"itemHistory\":null}],\"supplierRejectionReason\":null,\"caRejectionReason\":null,\"isOpenForCorrection\":null,\"isOpenForContractCorrection\":false,\"daAwardNoticeID\":null,\"assignedCAUser\":{\"id\":101187,\"text\":\"TROLEIBUZE\",\"localeKey\":\"TROLEIBUZE\"},\"assignedSupplierUser\":null,\"financingType\":false,\"sysAcquisitionContractType\":{\"id\":1,\"text\":\"Furnizare\",\"localeKey\":\"Common.Clasiff.SysAcquisitionContractType.Supply\"},\"sysAcquisitionContractTypeID\":1,\"sysEuropeanFund\":null,\"sysEuropeanFundID\":null,\"sysDirectAcquisitionState\":{\"id\":2,\"text\":\"Ofertare\",\"localeKey\":\"Common.Clasiff.SysDirectAcquisitionState.Published\"},\"sysDirectAcquisitionStateID\":2,\"isExpired\":null}";
    }
}
