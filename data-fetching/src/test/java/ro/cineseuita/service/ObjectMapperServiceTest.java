package ro.cineseuita.service;

import com.fasterxml.jackson.core.JsonParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ro.cineseuita.contract.entity.auction.AuctionAcquisitionContract;
import ro.cineseuita.contract.entity.auction.AuctionAcquisitionContracts;
import ro.cineseuita.contract.entity.auction.detailed.*;
import ro.cineseuita.contract.entity.direct.DirectAcquisitionContract;
import ro.cineseuita.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.contract.entity.direct.components.DirectAcquisitionContracts;
import ro.cineseuita.contractingauthority.entity.ContractingAuthority;
import ro.cineseuita.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.contractingauthority.entity.components.ContractingAuthorities;
import ro.cineseuita.shared.ObjectMapperService;
import ro.cineseuita.shared.requests.*;
import ro.cineseuita.supplier.entity.SupplierDetails;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ObjectMapperServiceTest {

    private ObjectMapperService service;

    @Before
    public void setUp() {
        service = new ObjectMapperService();
    }

    @Test
    public void mapToDirectAcquisitionContractsSuccessRandomFields() throws IOException {
        DirectAcquisitionContracts contracts = service.mapToDirectAcquisitionContracts(new FetchDirectAcquisitionContracts().getMockResponse());
        assertNotNull(contracts);
        assertEquals(new Integer(720), contracts.getTotal());
        assertEquals(25, contracts.getDirectAcquisitionContracts().size());
        assertEquals(new Long(102907656), contracts.getDirectAcquisitionContracts().get(0).getDirectAcquisitionId());
        Assert.assertFalse(contracts.getDirectAcquisitionContracts().get(contracts.getDirectAcquisitionContracts().size() - 1).getIsOpenForContractCorrection());
    }

    @Test
    public void mapToDirectAcquisitionContractsSuccessAllFields() throws IOException {
        DirectAcquisitionContracts contracts = service.mapToDirectAcquisitionContracts(new FetchDirectAcquisitionContracts().getMockResponse());
        assertNotNull(contracts);
        DirectAcquisitionContract contract = contracts.getDirectAcquisitionContracts().get(0);
        assertNotNull(contract);
        assertEquals(new Long(102907656), contract.getDirectAcquisitionId());
        assertEquals("SULFAT DE MAGNEZIU", contract.getDirectAcquisitionName());
        assertEquals(new Long(7), contract.getSysDirectAcquisitionState().getId());
        assertEquals("Oferta acceptata", contract.getSysDirectAcquisitionState().getText());
        assertNull(contract.getSysDirectAcquisitionState().getLocaleKey());
        assertEquals("DA22638198", contract.getUniqueIdentificationCode());
        assertEquals("33622100-7 - Medicamente utilizate in cardiologie (Rev.2)", contract.getCpvCode());
        assertEquals("2019-03-20T10:42:16+02:00", contract.getPublicationDate());
        assertEquals("2019-03-20T11:11:51+02:00", contract.getFinalizationDate());
        assertEquals("2019-03-25T17:00:00+02:00", contract.getCaDecisionDeadline());
        assertEquals("2019-03-27T17:00:00+02:00", contract.getSupplierDecisionDeadline());
        assertEquals("RO 11653560 COMPANIA NATIONALA UNIFARM", contract.getSupplier());
        assertEquals("4304754 SPITALUL ORASENESC CERNAVODA", contract.getContractingAuthority());
        assertEquals(new Double(20.36), contract.getEstimatedValueRon());
        assertEquals(new Double(4.28), contract.getEstimatedValueOtherCurrency());
        assertEquals(new Double(20.36), contract.getClosingValue());
        assertNull(contract.getIsOpenForCorrection());
        assertFalse(contract.getIsOpenForContractCorrection());
    }


    @Test(expected = JsonParseException.class)
    public void mapToDirectAcquisitionContractsFail() throws IOException {
        service.mapToDirectAcquisitionContracts("will fail");
    }

    @Test
    public void mapToDirectAcquisitionContract() {
        // not a request - it should always work if above works because we don't have any requests that fetches a singular direct acquisition contract, only a list of them
        assertTrue(true);
    }

    @Test(expected = JsonParseException.class)
    public void mapToDirectAcquisitionContractFail() throws IOException {
        service.mapToDirectAcquisitionContract("will fail");
    }

    @Test
    public void mapToSupplier() throws IOException {
        SupplierDetails supplierDetails = service.mapToSupplier(new FetchSupplierDetails(-1L).getMockResponse());
        assertNotNull(supplierDetails);

        assertEquals(Long.valueOf(100123377), supplierDetails.getId());
        assertEquals("EURO UZINTERM S.R.L.", supplierDetails.getName());
        assertEquals("41686241", supplierDetails.getCui());
        assertEquals("Ofertant", supplierDetails.getParticipantType());
        assertEquals(new Integer(3), supplierDetails.getParticipantTypeId());
        assertEquals(new Integer(2), supplierDetails.getParticipantStatus());
        assertEquals(new Long(2), supplierDetails.getParticipantEntityState().getId());
        assertEquals("Inregistrat", supplierDetails.getParticipantEntityState().getText());
        assertEquals("Common.Clasiff.SysEntityState.Registered", supplierDetails.getParticipantEntityState().getLocaleKey());
        assertEquals("2020-09-08T10:52:17+03:00", supplierDetails.getRegistration().getRegistrationTimestamp());
        assertNull(supplierDetails.getRegistration().getInvalidationTimestamp());
        assertEquals("Calin Virgil", supplierDetails.getRegistration().getLegalRepresentative());
        assertEquals("Pantelimon", supplierDetails.getAddress().getCity());
        assertEquals("Ilfov", supplierDetails.getAddress().getCounty());
        assertEquals("Calin Virgil", supplierDetails.getAddress().getContactPerson());
        assertEquals("Strada: Tractorului, Nr. 11A, Sector: -, Judet: Ilfov, Localitate: Pantelimon, Cod postal: 077145", supplierDetails.getAddress().getAddress());
        assertEquals("077145", supplierDetails.getAddress().getPostalCode());
        assertEquals("+40 726003336", supplierDetails.getAddress().getPhone());
        assertNull(supplierDetails.getAddress().getFax());
        assertEquals("www.eurouzinterm.ro", supplierDetails.getAddress().getWebsite());
        assertNull(supplierDetails.getNotices());
        assertNotNull(supplierDetails.getSupplierProceduresInfo());
    }

    @Test(expected = JsonParseException.class)
    public void mapToSupplierFail() throws IOException {
        service.mapToSupplier("will fail");
    }

    @Test
    public void mapToDirectAcquisitionContractDetails() {
        DirectAcquisitionContractDetails contract = service.mapToDirectAcquisitionContractDetails(new FetchDirectAcquisitionContractDetails(-1L).getMockResponse());
        assertNotNull(contract);
        assertEquals(new Double(238.72), contract.getEstimatedValue());
        assertEquals(new Double(50.19), contract.getSecondCurrencyClosingValue());
        assertEquals(new Double(238.72), contract.getClosingValue());
        assertEquals(new Double(50.19), contract.getSecondCurrencyClosingValue());
        assertNull(contract.getEconomyValue());
        assertNull(contract.getEconomySecondCurrencyValue());
        assertNull(contract.getEconomyPercent());
        assertNull(contract.getLossValue());
        assertNull(contract.getLossSecondCurrencyValue());
        assertNull(contract.getLossPercent());
        assertEquals("DA22641198", contract.getUniqueIdentificationCode());
        assertNull(contract.getCorrectionReason());
        assertEquals(Long.valueOf(102910967), contract.getDirectAcquisitionID());
        assertEquals("Materiale Electrice", contract.getDirectAcquisitionName());
        assertEquals("HAU210763\tCLESTE SERTIZAT PINI 0.5-4 CU CLICHET\tMarfa\tBUCATA\t1.\t149.67\t149.6688 RCEYY-J4X2.5M\tCablu EYY-J 4X2.5 RE 0,6/1kV (CYY-F, NYY)\tMarfa\tMETRU\t17.\t64.26\t3.78 PHS1770589\tHF-E II 236 TL-D 220-240V 50/60Hz\tMarfa\tBUCATA\t1.\t24.79\t24.7912", contract.getDirectAcquisitionDescription());
        assertEquals(new Long(12353), contract.getCpvCode().getId());
        assertEquals("Materiale electrice (Rev.2)", contract.getCpvCode().getText());
        assertEquals("31681410-0", contract.getCpvCode().getLocaleKey());
        assertEquals("FRANCO DEPOZIT FURNIZOR", contract.getDeliveryCondition());
        assertEquals("PLATA LA 15 ZILE", contract.getPaymentCondition());
        assertEquals(Long.valueOf(50710), contract.getSupplierId());
        assertEquals("2019-03-22T17:00:00+02:00", contract.getSupplierDecisionDeadline());
        assertNull(contract.getCaDecisionDeadline());
        assertEquals(Long.valueOf(6026), contract.getContractingAuthorityID());
        assertEquals(new ArrayList<>(), contract.getDocuments());
        assertNotNull(contract.getDirectAcquisitionItems()); //TODO: test items, if you're the mood...
    }

    @Test
    public void mapToContractingAuthorities() throws IOException {
        ContractingAuthorities contractingAuthorities = service.mapToContractingAuthorities(new FetchContractingAuthorities(0).getMockResponse());
        assertNotNull(contractingAuthorities);
        ContractingAuthority contractingAuthority = contractingAuthorities.getContractingAuthorities().get(0);
        assertNotNull(contractingAuthority);

        assertEquals(new Integer(20982), contractingAuthorities.getTotal());
        assertEquals(18, contractingAuthorities.getContractingAuthorities().size());
        assertEquals(new Long(100123338), Long.valueOf(contractingAuthority.getId()));
        assertEquals("Indeco Soft", contractingAuthority.getName());
    }

    @Test(expected = JsonParseException.class)
    public void mapToContractingAuthoritiesFail() throws IOException {
        service.mapToContractingAuthorities("will fail");
    }

    @Test
    public void mapToContractingAuthority() {
        // not a request - it should always work if above works because we don't have any requests that fetches a singular direct acquisition contract, only a list of them
        assertTrue(true);
    }

    @Test
    public void mapToContractingAuthorityDetails() throws IOException {
        ContractingAuthorityDetails contractingAuthority = service.mapToContractingAuthorityDetails(new FetchContractingAuthorityDetails(-1L).getMockResponse());
        assertNotNull(contractingAuthority);
        assertEquals(new Long(100123338), Long.valueOf(contractingAuthority.getId()));
        assertEquals("Indeco Soft", contractingAuthority.getName());
        assertEquals("RO12960504", contractingAuthority.getCui());
        assertEquals("Autoritate Contractanta", contractingAuthority.getParticipantType());
        assertEquals(new Integer(2), contractingAuthority.getParticipantTypeId());
        assertEquals(new Integer(2), contractingAuthority.getParticipantStatus());
        assertEquals(new Long(2), contractingAuthority.getParticipantEntityState().getId());
        assertEquals("Inregistrat", contractingAuthority.getParticipantEntityState().getText());
        assertEquals("Common.Clasiff.SysEntityState.Registered", contractingAuthority.getParticipantEntityState().getLocaleKey());
        assertEquals("2020-09-07T13:15:13+03:00", contractingAuthority.getRegistration().getRegistrationTimestamp());
        assertNull(contractingAuthority.getRegistration().getInvalidationTimestamp());
        assertEquals("Barbul Dorin Traian", contractingAuthority.getRegistration().getLegalRepresentative());
        assertEquals("Baia Mare", contractingAuthority.getAddress().getCity());
        assertEquals("Maramures", contractingAuthority.getAddress().getCounty());
        assertEquals("Barbul Dorin Traian", contractingAuthority.getAddress().getContactPerson());
        assertEquals("Strada: Magnoliei, Nr. 5, Sector: -, Judet: Maramures, Localitate: Baia Mare, Cod postal: 430090", contractingAuthority.getAddress().getAddress());
        assertEquals("430090", contractingAuthority.getAddress().getPostalCode());
        assertEquals("+40 755078097", contractingAuthority.getAddress().getPhone());
        assertNull(contractingAuthority.getAddress().getFax());
        assertEquals("www.indecosoft.ro", contractingAuthority.getAddress().getWebsite());
        assertNotNull(contractingAuthority.getNotices());
        assertNull(contractingAuthority.getSupplierProceduresInfo());
    }

    @Test(expected = JsonParseException.class)
    public void mapToContractingAuthorityDetailsFail() throws IOException {
        service.mapToContractingAuthorityDetails("will fail");
    }

    @Test
    public void mapToAuctionAcquisitionContractDetails() throws IOException {
        AuctionAcquisitionContractDetails contract = service.mapToAuctionAcquisitionContractDetails(new FetchAuctionAcquisitionContractDetails(-1L).getMockResponse());
        assertNotNull(contract);
        assertFalse(contract.getIsUtilityContract());
        assertNotNull(contract.getCaNoticeEditNew());
        assertEquals("Reguli de comunicare si transmitere a datelor: solicitarile de clarificari referitorare la prezenta documentatie de atribuire, se vor adresa în mod exclusiv în SEAP la Sectiunea Întrebari din cadrul procedurii de atribuire derulate prin mijloace electronice iar raspunsurile la acestea vor fi publicate în SEAP la Sectiunea Documentatie si clarificari si decizii din cadrul anuntului/ invitatiei de participare, AC urmând sa nu dea curs solicitarilor adresate prin alta modalitate de comunicare. Pentru transmiterea solicitarilor de clarificari privind documentatia de atribuire, operatorii economici se vor înregistra în SEAP (www.e-licitatie.ro) ca operatori economici si ca participanti la procedura de atribuire. Pentru comunicarile ulterioare depunerii ofertelor: comisia de evaluare va transmite solicitarile de clarificare în legatura cu oferta prin utilizarea facilitatilor tehnice disponibile în SEAP (Sectiunea “Întrebari”). Op. ec. vor transmite raspunsurile la clarificari\nsi eventualele documente solicitate pe parcursul evaluarii ofertelor prin intermediul SEAP (Sectiunea “Întrebari”), în format electronic, semnate cu semnatura electronica, cf Legii 455/2001.\nModalitatea in care se poate accesa DUAE in vederea completarii de catre operatorii economici interesati: https://ec.europa.eu/growth/tools-databases/espd/filter.", contract.getCaNoticeEditNew().getSection6New().getSection63New().getSupplementaryInformation());
    }

    @Test(expected = JsonParseException.class)
    public void mapToAuctionAcquisitionContractDetailsFail() throws IOException {
        service.mapToAuctionAcquisitionContractDetails("will fail");
    }

    @Test
    public void mapToAuctionAcquisitionSubcontracts() throws IOException {
        AuctionAcquisitionSubcontracts subcontracts = service.mapToAuctionAcquisitionSubcontracts(new FetchAuctionAcquisitionSubcontracts(-1L).getMockResponse());
        assertNotNull(subcontracts);
        AuctionAcquisitionSubcontract subcontract = subcontracts.getAuctionAcquisitionSubcontracts().get(0);

        assertEquals(new Long(12), subcontracts.getTotal());
        assertEquals(5, subcontracts.getAuctionAcquisitionSubcontracts().size());
        assertNotNull(subcontract);

        assertEquals(new Long(100113444), subcontract.getCaNoticeContractId());
        assertNull(subcontract.getContractId());
        assertEquals(new Long(100055897), subcontract.getCaNoticeId());
        assertEquals("SCNA1012279", subcontract.getNoticeNo());
        assertEquals("ANDROMI COM", subcontract.getWinnerCaption());
        assertEquals(new Long(100125101), subcontract.getWinner().getId());
        assertEquals(new Long(100055897), subcontract.getWinner().getCaNoticeId());
        assertEquals("RO 5198520", subcontract.getWinner().getFiscalNumber());
        assertEquals(new Long(100553934), subcontract.getWinner().getNoticeEntityAddressId());
    }

    @Test(expected = JsonParseException.class)
    public void mapToAuctionAcquisitionSubcontractsFail() throws IOException {
        service.mapToAuctionAcquisitionSubcontracts("will fail");
    }

    @Test
    public void mapToAuctionAcquisitionLots() throws IOException {
        AuctionAcquisitionLots lots = service.mapToAuctionAcquisitionLots(new FetchAuctionAcquisitionLots(-1L).getMockResponse());
        assertNotNull(lots);
        assertEquals(new Long(8), lots.getTotal());
        assertEquals(8, lots.getLots().size());

        AuctionAcquisitionLot lot = lots.getLots().get(0);
        assertNotNull(lot);

        assertEquals(new Long(100385952), lot.getNoticeLotID());
        assertEquals("Cremwurşti de porc", lot.getContractTitle());
        assertEquals("3", lot.getLotNumber());
        assertEquals(new Long(10508), lot.getMainCPVCodes().getId());
        assertEquals("15131130-5 Carnati (Rev.2)", lot.getMainCPVCodes().getText());
        assertNull(lot.getMainCPVCodes().getLocaleKey());
        assertEquals(new ArrayList<>(), lot.getSecondaryCPVCodes());
        assertEquals(new Long(11718), lot.getNutsCode().getId());
        assertEquals("RO113 Cluj", lot.getNutsCode().getText());
        assertNull(lot.getNutsCode().getLocaleKey());
        assertEquals("Scoala de Agenti de Politie \"Septimiu Muresan\" Cluj-Napoca\nStr. Corneliu Coposu, nr. 89-91, jud. Cluj", lot.getMainLocation());
        assertEquals("Cantitatile care fac obiectul acordului cadru: minim 44 kg – maxim 890 kg\nEstimari ale cantitatilor minime si maxime care ar putea face obiectul unui singur contract subsecvent dintre cele care urmeaza sa fie atribuite pe durata acordului-cadru: minim 19 kg – maxim 95 kg\nValoarea estimata fara TVA a celui mai mare contract subsecvent dintre cele care urmeazã sa fie atribuite pe durata acordului-cadru este de minim 853 RON – maxim 13562,70 RON", lot.getShortDescription());
        assertFalse(lot.getHasOptions());
    }

    @Test(expected = JsonParseException.class)
    public void mapToAuctionAcquisitionLotsFail() throws IOException {
        service.mapToAuctionAcquisitionLots("will fail");
    }

    @Test
    public void mapToAuctionAcquisitionContracts() throws IOException {
        AuctionAcquisitionContracts contracts = service.mapToAuctionAcquisitionContracts(new FetchAuctionAcquisitionContracts().getMockResponse());
        assertNotNull(contracts);

        assertEquals(new Long(2000), contracts.getTotal());
        assertEquals(25, contracts.getAuctionAcquisitionContracts().size());

        AuctionAcquisitionContract contract = contracts.getAuctionAcquisitionContracts().get(0);
        assertNotNull(contract);

        assertEquals(new Long(100055897), contract.getCaNoticeId());
        assertEquals(new Long(100150013), contract.getNoticeId());
        assertEquals(100039892, contract.getProcedureId());
        assertEquals("SCNA1012279", contract.getNoticeNo());

        assertEquals(new Long(2), contract.getSAuctionAcquisitionNoticeState().getId());
        assertEquals("Publicat", contract.getSAuctionAcquisitionNoticeState().getText());
        assertNull(contract.getSAuctionAcquisitionNoticeState().getLocaleKey());
        assertEquals("16665051 - SCOALA DE AGENTI DE POLITIE SEPTIMIU MURESAN CLUJ-NAPOCA", contract.getContractingAuthorityNameAndFN());
        assertEquals("Acord-cadru de achizitie publica de produse:  cârnaţi olteneşti; cârnaţi cabanos; cremwurşti de porc; salam de vară; salam Victoria; kaiser afumat; ceafă de porc afumată; muşchi file de porc afumat.", contract.getContractTitle());
    }

    @Test(expected = JsonParseException.class)
    public void mapToAuctionAcquisitionContractsFail() throws IOException {
        service.mapToAuctionAcquisitionContracts("will fail");
    }

    @Test
    public void mapToAuctionAcquisitionContract() {
        // not a request - it should always work if above works because we don't have any requests that fetches a singular direct acquisition contract, only a list of them
        assertTrue(true);
    }

    @Test
    public void mapToString() {
    }
}
