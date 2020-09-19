package ro.cineseuita.data.shared.requests;

public class FetchSupplierDetails extends FetchParticipant {

    public FetchSupplierDetails(Long supplierId) {
        super(supplierId, ParticipantType.OFERTANT);
    }

    @Override
    public String getMockResponse() {
        return "{\"id\":100123377,\"name\":\"EURO UZINTERM S.R.L.\",\"cui\":\"41686241\",\"participantType\":\"Ofertant\",\"participantTypeId\":3,\"participantStatus\":2,\"participantEntityState\":{\"id\":2,\"text\":\"Inregistrat\",\"localeKey\":\"Common.Clasiff.SysEntityState.Registered\"},\"retrievedTimestamp\":\"2020-09-08T11:13:11.7437962+03:00\",\"registration\":{\"registrationTimestamp\":\"2020-09-08T10:52:17+03:00\",\"invalidationTimestamp\":null,\"legalRepresentative\":\"Calin Virgil\"},\"address\":{\"city\":\"Pantelimon\",\"county\":\"Ilfov\",\"contactPerson\":\"Calin Virgil\",\"address\":\"Strada: Tractorului, Nr. 11A, Sector: -, Judet: Ilfov, Localitate: Pantelimon, Cod postal: 077145\",\"postalCode\":\"077145\",\"phone\":\"+40 726003336\",\"fax\":null,\"website\":\"www.eurouzinterm.ro\"},\"notices\":null,\"supplierProceduresInfo\":[{\"participantQuality\":\"Castigator\",\"directAcquisition\":0,\"requestForQuotation\":0,\"openBids\":0,\"restrictedBids\":0,\"eBids\":0,\"simplifiedProcedureBids\":0,\"total\":0},{\"participantQuality\":\"Participant\",\"directAcquisition\":0,\"requestForQuotation\":0,\"openBids\":0,\"restrictedBids\":0,\"eBids\":0,\"simplifiedProcedureBids\":0,\"total\":0}],\"catalog\":{\"published\":0,\"valid\":0,\"notExpired\":0,\"awardedDirectAcquisitions\":0},\"caProceduresOngoing\":null,\"caProceduresAwarded\":null,\"caProceduresCancelled\":null}";
    }
}
