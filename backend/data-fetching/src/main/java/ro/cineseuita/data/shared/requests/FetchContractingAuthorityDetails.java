package ro.cineseuita.data.shared.requests;

public class FetchContractingAuthorityDetails extends FetchParticipant {

    public FetchContractingAuthorityDetails(Long id) {
        super(id, ParticipantType.AUTORITATE_CONTRACTANTA);
    }

    @Override
    public String getMockResponse() {
        return "{\"id\":100123338,\"name\":\"Indeco Soft\",\"cui\":\"RO12960504\",\"participantType\":\"Autoritate Contractanta\",\"participantTypeId\":2,\"participantStatus\":2,\"participantEntityState\":{\"id\":2,\"text\":\"Inregistrat\",\"localeKey\":\"Common.Clasiff.SysEntityState.Registered\"},\"retrievedTimestamp\":\"2020-09-08T11:12:08.7272778+03:00\",\"registration\":{\"registrationTimestamp\":\"2020-09-07T13:15:13+03:00\",\"invalidationTimestamp\":null,\"legalRepresentative\":\"Barbul Dorin Traian\"},\"address\":{\"city\":\"Baia Mare\",\"county\":\"Maramures\",\"contactPerson\":\"Barbul Dorin Traian\",\"address\":\"Strada: Magnoliei, Nr. 5, Sector: -, Judet: Maramures, Localitate: Baia Mare, Cod postal: 430090\",\"postalCode\":\"430090\",\"phone\":\"+40 755078097\",\"fax\":null,\"website\":\"www.indecosoft.ro\"},\"notices\":{\"priorInformation\":0,\"contract\":0,\"contractAward\":0,\"designContest\":0,\"resultDesignContest\":0,\"publicWorksConcession\":0,\"simplifiedContract\":0,\"rfqInvitation\":0},\"supplierProceduresInfo\":null,\"catalog\":null,\"caProceduresOngoing\":{\"participantQuality\":null,\"directAcquisition\":0,\"requestForQuotation\":null,\"openBids\":null,\"restrictedBids\":null,\"eBids\":0,\"simplifiedProcedureBids\":null,\"total\":0},\"caProceduresAwarded\":{\"participantQuality\":null,\"directAcquisition\":0,\"requestForQuotation\":null,\"openBids\":null,\"restrictedBids\":null,\"eBids\":0,\"simplifiedProcedureBids\":null,\"total\":0},\"caProceduresCancelled\":{\"participantQuality\":null,\"directAcquisition\":0,\"requestForQuotation\":null,\"openBids\":null,\"restrictedBids\":null,\"eBids\":0,\"simplifiedProcedureBids\":null,\"total\":0}}";
    }
}
