package ro.cineseuita.data.shared.requests;

public class FetchAuctionAcquisitionContractDetails implements GetRequest {

    private static final String URL = "http://e-licitatie.ro/api-pub/C_PUBLIC_CANotice/get/";
    private static final String REFERER = "https://e-licitatie.ro/pub/notices/ca-notices/view-c/";
    private final Long id;

    public FetchAuctionAcquisitionContractDetails(Long id) {
        this.id = id;
    }

    @Override
    public String getUrl() {
        return URL + id;
    }

    @Override
    public String getReferer() {
        return REFERER + id;
    }

    @Override
    public String getMockResponse() {
        return "{\"isUtilityContract\":false,\"caNoticeEdit_New\":{\"publicationDetailsModel\":{\"caPublicationDate\":\"2018-08-29T09:19:32+03:00\",\"publicationDate\":\"2018-06-05T23:29:17+03:00\",\"jouePublicationNumber\":\"2018/S 106-241862\",\"noticeNo\":\"CN1000921\"},\"section0_New\":{\"sentToJOUE\":true,\"tedNoticeNo\":\"2018/S 106-241862\",\"completeTedModel\":{\"caNoticeId\":0,\"ojeuNoticeNoYear\":\"2018\",\"ojeuNoticeNoSecondPart\":\" 106\",\"ojeuNoticeNoThirdPart\":\"241862\",\"ojeuNoticeDate\":null},\"canEdit\":true,\"caNoticeId\":0,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section1_New\":{\"section1_1\":{\"caAddress\":{\"noticeId\":100065062,\"officialName\":\"COMPANIA NATIONALA DE ADMINISTRARE A INFRASTRUCTURII RUTIERE S.A.\",\"address\":\"Strada: Golescu Dinicu, nr. 38, Sector: -, Judet: Bucuresti\",\"city\":\"Bucuresti\",\"cityItem\":{\"id\":1779,\"text\":\"Bucuresti\",\"localeKey\":\"\"},\"postalCode\":\"010873\",\"postalCodeItem\":null,\"countryID\":1,\"country\":\"Romania\",\"countryItem\":{\"id\":1,\"text\":\"Romania\",\"localeKey\":\"RO\"},\"county\":{\"id\":4,\"text\":\"Bucuresti\",\"localeKey\":\"B\"},\"email\":\"achizitiipublicebuget@andnet.ro; horia.nicolae@andnet.ro\",\"phone\":\"+40 212643310\",\"fax\":\"+40 212643417\",\"contactPoints\":\"Ioana Silvia Barbulescu\",\"attentionTo\":\"Ioana Silvia Barbulescu\",\"caMainAddressUrl\":\"www.cnadnr.ro\",\"buyerProfileUrl\":\"www.e-licitatie.ro\",\"nutsCodeID\":42,\"nutsCode\":\"System.Data.Entity.DynamicProxies.NUTSCode_547C7532A1C13D2DD8DABA397AFE64934E6300F80287E631C82996E76CE950EB\",\"nutsCodeItem\":{\"id\":42,\"text\":\"RO321 Bucuresti\",\"localeKey\":null},\"contactPerson\":\"Ioana Silvia Barbulescu\",\"internetAddressesUrl\":[\"www.cnadnr.ro\"],\"electronicInfoAccessUrl\":null,\"electronicDocumentsSendingUrl\":null,\"isSME\":false,\"sysNoticeEntityTypeID\":1,\"noticeEntityAddressId\":100221926,\"entityId\":1907,\"entityItem\":null,\"isPublishingAgreed\":null,\"nationalIDNumber\":\"16054368\"},\"canEdit\":false,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section1_2_New\":{\"isCommonProcurement\":false,\"commonProcurementLaw\":null,\"isAwardedByCentralAcquisitionOrgan\":false,\"otherCANoticeAdresses\":[],\"canEdit\":false,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section1_4_New\":{\"caTypeId\":18,\"caType\":{\"id\":18,\"text\":\"Organism de drept public\",\"localeKey\":\"Common.Clasiff.ContractingAuthorityType.BodyGuvernedByLow\"},\"ifOthersThenSpecify\":null,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section1_5\":{\"mainActivityId\":7,\"mainActivity\":{\"id\":7,\"text\":\"Constructii si amenajari teritoriale\",\"localeKey\":\"Common.Clasiff.ActivityType.HousingAndComunityAmenities\"},\"ifOthersThenSpecify\":null,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null}},\"section2_New\":{\"section2_1_New\":{\"contractTitle\":\"Servicii de mentenanta pentru sistemul de monitorizare a traficului si a conditiilor de circulatie pentru Autostrada A2, sector Medgidia -Constanta -DRDP-Constanta\",\"referenceNumber\":\"5\",\"mainCPVCode\":{\"id\":17455,\"text\":\"Repararea si intretinerea echipamentului informatic (Rev.2)\",\"localeKey\":\"50312000-5\"},\"sysAcquisitionContractType\":{\"id\":2,\"text\":\"Servicii\",\"localeKey\":\"Common.Clasiff.SysAcquisitionContractType.Services\"},\"shortDescription\":\"Servicii de mentenanta pentru sistemul de monitorizare a traficului si a conditiilor de circulatie pentru Autostrada A2, sector Medgidia -Constanta, conform cerintelor tehnice inscrise in caietul de sarcini.\\n\\nIn conformitate cu prevederile art. 160 alin. (1) din Legea nr. 98/2016, termenul limita la care orice operator economic interesat are dreptul de a solicita clarificari sau informatii suplimentare in legatura cu documentatia de atribuire\\neste de maxim 15 zile inainte de data limita de depunere a ofertelor.\\n In conformitate cu prevederile art. 160 alin. (2) din Legea nr. 98/2016 termenul limita la care autoritatea contractanta va raspunde in mod clar si complet tuturor solicitarilor de clarficare/informatiilor suplimentare este in a 10 zi inainte de data limita de depunere a ofertelor.\",\"hasLots\":false,\"shouldShowSection217\":true,\"totalAcquisitionValue\":915510.84,\"totalRONAcquisitionValueForPAAP\":915510.84,\"lowestOffer\":0.0,\"highestOffer\":0.0,\"currency\":{\"id\":1,\"text\":\"Leu\",\"localeKey\":\"RON\"},\"canEdit\":false,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section2_2_New\":{\"showPublishingAgreedSection\":false,\"previousPublication\":true,\"descriptionList\":[{\"noticeLotID\":100095560,\"contractTitle\":\"Default lot\",\"lotNumber\":\"1\",\"mainCPVCodes\":{\"id\":17455,\"text\":\"50312000-5 Repararea si intretinerea echipamentului informatic (Rev.2)\",\"localeKey\":null},\"secondaryCPVCodes\":[],\"nutsCode\":{\"id\":28,\"text\":\"RO223 Constanta\",\"localeKey\":null},\"mainLocation\":\"Constanta\",\"shortDescription\":\"Servicii de mentenanta pentru sistemul de monitorizare a traficului si a conditiilor de circulatie pentru Autostrada A2, sector Medgidia -Constanta, conform cerintelor tehnice inscrise in caietul de sarcini.\",\"noticeAwardCriteriaList\":[],\"hasOptions\":false,\"optionsDescription\":null,\"isEUFunded\":false,\"euProject\":null,\"supplementaryInformation\":null,\"monthDuration\":12,\"dayDuration\":null,\"startDate\":null,\"completionDate\":null,\"showSysAwardCriteriaType\":true,\"sysAwardCriteriaTypeId\":1,\"sysAwardCriteriaType\":{\"id\":1,\"text\":\"Pretul cel mai scazut\",\"localeKey\":null},\"sysEuropeanFundId\":null,\"sysEuropeanFund\":null,\"sysFinancingTypeId\":null,\"sysFinancingType\":{\"id\":2,\"text\":\"Fonduri bugetare\",\"localeKey\":null},\"communityProgramReference\":null,\"estimatedValue\":null,\"minEstimatedValue\":null,\"maxEstimatedValue\":null,\"currency\":{\"id\":1,\"text\":\"Leu\",\"localeKey\":null},\"lotInfo\":\"Atribuit\"}],\"canEdit\":false,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null}},\"section4_New\":{\"section4_1_New\":{\"sysProcedureTypeId\":1,\"sysProcedureType\":{\"id\":1,\"text\":\"Licitatie deschisa\",\"localeKey\":null},\"isAcceleratedProcedure\":null,\"acceleratedProcedureJustification\":\"\",\"sysContractAssigmentTypeId\":1,\"sysContractAssigmentType\":null,\"hasElectronicAuction\":false,\"hasGpaAgreement\":false,\"canEdit\":false,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section4_2_New\":{\"hasPreviousPublicationNotice\":true,\"tedModel\":{\"caNoticeId\":0,\"ojeuNoticeNoYear\":\"2018\",\"ojeuNoticeNoSecondPart\":\" 106\",\"ojeuNoticeNoThirdPart\":\"241862\",\"ojeuNoticeDate\":null},\"previousPublicationNoticeNumber\":\"2018/S 106-241862\",\"isCeasingDynamicAquisitions\":false,\"isCACeasingSendingInvitations\":false,\"canEdit\":null,\"updateTed\":false,\"caNoticeId\":0,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null}},\"section5\":{\"contractLotList\":[{\"section5_2\":{\"section5_2_0\":{\"contractNo\":\"99/49501\",\"contractTitle\":\"Contract de ,,Servicii de mentenanta pentru sistemul de monitorizare a traficului si a conditiilor de circulatie pentru Autostrada A2, sector Medgidia - Constanta\\\"\",\"caNoticeContractId\":100017742,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section5_2_1\":{\"contractSignDate\":\"2018-08-24T00:00:00+03:00\",\"caNoticeContractId\":100017742,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section5_2_2\":{\"numberOfReceivedOffers\":3,\"numberOfReceivedOffersFromSme\":2,\"numberOfReceivedOffersUe\":0,\"numberOfReceivedOffersNonUe\":0,\"numberOfReceivedElectronicOffers\":3,\"contractAssignedToGroupOfSuppliers\":false,\"isPublishingAgreed\":true,\"caNoticeContractId\":100017742,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section5_2_3\":{\"nameAndAddress\":[{\"noticeId\":null,\"officialName\":\"SAN ELECTROTERM GRUP S.R.L.\",\"address\":\"Strada Interioară 2, Nr. 2\",\"city\":\"Constanta\",\"cityItem\":{\"id\":3181,\"text\":\"Constanta\",\"localeKey\":\"\"},\"postalCode\":\"900229\",\"postalCodeItem\":null,\"countryID\":1,\"country\":\"Romania\",\"countryItem\":{\"id\":1,\"text\":\"Romania\",\"localeKey\":\"RO\"},\"county\":{\"id\":15,\"text\":\"Constanta\",\"localeKey\":\"CT\"},\"email\":\"office@sangrup.ro\",\"phone\":\"+40 241627700\",\"fax\":\"+40 241627700\",\"contactPoints\":null,\"attentionTo\":null,\"caMainAddressUrl\":\"www.sangrup.ro\",\"buyerProfileUrl\":null,\"nutsCodeID\":28,\"nutsCode\":\"System.Data.Entity.DynamicProxies.NUTSCode_547C7532A1C13D2DD8DABA397AFE64934E6300F80287E631C82996E76CE950EB\",\"nutsCodeItem\":{\"id\":28,\"text\":\"RO223 Constanta\",\"localeKey\":null},\"contactPerson\":null,\"internetAddressesUrl\":[\"www.sangrup.ro\"],\"electronicInfoAccessUrl\":null,\"electronicDocumentsSendingUrl\":null,\"isSME\":true,\"sysNoticeEntityTypeID\":20,\"noticeEntityAddressId\":100221932,\"entityId\":15536,\"entityItem\":null,\"isPublishingAgreed\":null,\"nationalIDNumber\":\"15344614\"}],\"isPublishingAgreed\":true,\"caNoticeContractId\":100017742,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section5_2_4\":{\"totalContractValue\":915510.84,\"useTotalContractValue\":true,\"estimatedContractValue\":1200000.0,\"ronExchangeRate\":1.0,\"lowestOffer\":null,\"highestOffer\":null,\"ronLowestOffer\":null,\"ronHighestOffer\":null,\"currency\":{\"id\":1,\"text\":\"RON\",\"localeKey\":\"RON\"},\"ronContractValue\":915510.84,\"isPublishingAgreed\":true,\"caNoticeContractId\":100017742,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section5_2_5\":{\"isSubcontractingPossible\":false,\"subcontractedValueNoVAT\":null,\"subcontractedPercent\":null,\"currency\":{\"id\":1,\"text\":\"RON\",\"localeKey\":\"RON\"},\"shortDescription\":null,\"caNoticeContractId\":100017742,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section5_2_6\":{\"valueNoVat\":0.0,\"currency\":null,\"caNoticeContractId\":100017742,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section5_2_7\":{\"numberOfAwardedContracts\":0,\"caNoticeContractId\":0,\"caNoticeId\":0,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section5_2_8\":{\"isFromEu\":true,\"isNotFromEu\":false,\"country\":{\"id\":0,\"text\":null,\"localeKey\":null},\"caNoticeContractId\":100017742,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section5_2_9\":{\"contractAwardedToSingleVariant\":false,\"caNoticeContractId\":100017742,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section5_2_10\":{\"offersExcludedForUnjustifiedLowPrice\":false,\"caNoticeContractId\":100017742,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"caNoticeId\":0,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"caNoticeContractId\":100017742,\"contractId\":0,\"caNoticeId\":100012441,\"contractNo\":\"99/49501\",\"contractDate\":\"2018-08-24T00:00:00+03:00\",\"contractTitle\":\"Contract de ,,Servicii de mentenanta pentru sistemul de monitorizare a traficului si a conditiilor de circulatie pentru Autostrada A2, sector Medgidia - Constanta\\\"\",\"sysContractAssignmentType\":null,\"noticeNo\":\"CAN1003798\",\"sysContractPhase\":null,\"contractValue\":915510.84,\"defaultCurrencyContractValue\":null,\"currency\":{\"id\":1,\"text\":\"RON\",\"localeKey\":\"RON\"},\"awardedNoticeLotList\":[{\"noticeLotId\":100095560,\"noticeContractObjectId\":100022017,\"no\":\"1\",\"title\":\"Default lot\",\"value\":0.0,\"procedureLotId\":null}],\"supplierWinners\":[{\"id\":100018292,\"caNoticeId\":100012441,\"name\":\"SAN ELECTROTERM GRUP S.R.L.\",\"fiscalNumber\":\"15344614\",\"noticeEntityAddressId\":100221932,\"entityId\":15536,\"isSME\":null,\"address\":{\"noticeId\":null,\"officialName\":\"SAN ELECTROTERM GRUP S.R.L.\",\"address\":\"Strada Interioară 2, Nr. 2\",\"city\":\"Constanta\",\"cityItem\":{\"id\":3181,\"text\":\"Constanta\",\"localeKey\":\"\"},\"postalCode\":\"900229\",\"postalCodeItem\":null,\"countryID\":1,\"country\":\"Romania\",\"countryItem\":{\"id\":1,\"text\":\"Romania\",\"localeKey\":\"RO\"},\"county\":{\"id\":15,\"text\":\"Constanta\",\"localeKey\":\"CT\"},\"email\":\"office@sangrup.ro\",\"phone\":\"+40 241627700\",\"fax\":\"+40 241627700\",\"contactPoints\":null,\"attentionTo\":null,\"caMainAddressUrl\":\"www.sangrup.ro\",\"buyerProfileUrl\":null,\"nutsCodeID\":28,\"nutsCode\":\"System.Data.Entity.DynamicProxies.NUTSCode_547C7532A1C13D2DD8DABA397AFE64934E6300F80287E631C82996E76CE950EB\",\"nutsCodeItem\":{\"id\":28,\"text\":\"RO223 Constanta\",\"localeKey\":null},\"contactPerson\":null,\"internetAddressesUrl\":[\"www.sangrup.ro\"],\"electronicInfoAccessUrl\":null,\"electronicDocumentsSendingUrl\":null,\"isSME\":false,\"sysNoticeEntityTypeID\":20,\"noticeEntityAddressId\":100221932,\"entityId\":15536,\"entityItem\":null,\"isPublishingAgreed\":null,\"nationalIDNumber\":\"15344614\"},\"source\":3}],\"parentContractId\":null,\"isSignedBySu\":null,\"originalContractId\":0,\"isCurrentVersion\":false,\"actions\":{\"canEdit\":false,\"canView\":true,\"canDelete\":false,\"canModify\":false,\"canOpenContract\":false,\"canCreateContract\":false,\"canCorrectContract\":false,\"canModifyCompetitionResume\":false},\"conditions\":{\"hasCompetitionResumeSection\":false},\"sysContractFrameworkTypeId\":1}],\"cancelledLotList\":[],\"section52A\":{\"caNoticeId\":100012441,\"currency\":{\"id\":1,\"text\":\"RON\",\"localeKey\":\"RON\"}}},\"section6_New\":{\"section6_3_New\":{\"supplementaryInformation\":\"Reguli de comunicare si transmitere a datelor: solicitarile de clarificari referitorare la prezenta documentatie de atribuire, se vor adresa în mod exclusiv în SEAP la Sectiunea Întrebari din cadrul procedurii de atribuire derulate prin mijloace electronice iar raspunsurile la acestea vor fi publicate în SEAP la Sectiunea Documentatie si clarificari si decizii din cadrul anuntului/ invitatiei de participare, AC urmând sa nu dea curs solicitarilor adresate prin alta modalitate de comunicare. Pentru transmiterea solicitarilor de clarificari privind documentatia de atribuire, operatorii economici se vor înregistra în SEAP (www.e-licitatie.ro) ca operatori economici si ca participanti la procedura de atribuire. Pentru comunicarile ulterioare depunerii ofertelor: comisia de evaluare va transmite solicitarile de clarificare în legatura cu oferta prin utilizarea facilitatilor tehnice disponibile în SEAP (Sectiunea “Întrebari”). Op. ec. vor transmite raspunsurile la clarificari\\nsi eventualele documente solicitate pe parcursul evaluarii ofertelor prin intermediul SEAP (Sectiunea “Întrebari”), în format electronic, semnate cu semnatura electronica, cf Legii 455/2001.\\nModalitatea in care se poate accesa DUAE in vederea completarii de catre operatorii economici interesati: https://ec.europa.eu/growth/tools-databases/espd/filter.\",\"canEdit\":false,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section6_4_1_New\":{\"disputeHandleOrganization\":{\"noticeId\":100065062,\"officialName\":\"Consiliul National de Solutionare a Contestatiilor\",\"address\":\"Str. Stavropoleos nr. 6, sector 3\",\"city\":\"Bucuresti\",\"cityItem\":null,\"postalCode\":\"030084\",\"postalCodeItem\":null,\"countryID\":1,\"country\":\"Romania\",\"countryItem\":{\"id\":1,\"text\":\"Romania\",\"localeKey\":\"RO\"},\"county\":null,\"email\":\"office@cnsc.ro\",\"phone\":\"+40 213104641\",\"fax\":\"+40 213104642 / +40 218900745\",\"contactPoints\":null,\"attentionTo\":null,\"caMainAddressUrl\":\"http://www.cnsc.ro\",\"buyerProfileUrl\":\"www.e-licitatie.ro\",\"nutsCodeID\":42,\"nutsCode\":\"System.Data.Entity.DynamicProxies.NUTSCode_547C7532A1C13D2DD8DABA397AFE64934E6300F80287E631C82996E76CE950EB\",\"nutsCodeItem\":{\"id\":42,\"text\":\"RO321 Bucuresti\",\"localeKey\":null},\"contactPerson\":null,\"internetAddressesUrl\":[\"http://www.cnsc.ro\"],\"electronicInfoAccessUrl\":null,\"electronicDocumentsSendingUrl\":null,\"isSME\":false,\"sysNoticeEntityTypeID\":11,\"noticeEntityAddressId\":100221928,\"entityId\":null,\"entityItem\":null,\"isPublishingAgreed\":null,\"nationalIDNumber\":null},\"canEdit\":false,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section6_4_2_New\":null,\"section6_4_3_New\":{\"disputeProcedure\":\"Persoana care se considera vatamata poate sesiza CNSC. Termenele de exercitare a caii de atac sunt cele prevazute la art.8 din Legea nr.101/2016, modificata si completata prin Ordonanta de Urgenta 107/2017.\",\"canEdit\":false,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"section6_4_4_New\":{\"disputeInformationService\":{\"noticeId\":100065062,\"officialName\":\"Departamentul Juridic -Directia Regionala de Drumuri si Poduri Constanta\",\"address\":\"Strada Prelungirea Traian, fara numar;\",\"city\":\"Constanta\",\"cityItem\":null,\"postalCode\":\"900716\",\"postalCodeItem\":null,\"countryID\":1,\"country\":\"Romania\",\"countryItem\":{\"id\":1,\"text\":\"Romania\",\"localeKey\":\"RO\"},\"county\":null,\"email\":\"net@drdpct.ro\",\"phone\":\"+40 241581147\",\"fax\":\"+40 241584371\",\"contactPoints\":null,\"attentionTo\":null,\"caMainAddressUrl\":\"www.drdpct.ro\",\"buyerProfileUrl\":\"www.e-licitatie.ro\",\"nutsCodeID\":28,\"nutsCode\":\"System.Data.Entity.DynamicProxies.NUTSCode_547C7532A1C13D2DD8DABA397AFE64934E6300F80287E631C82996E76CE950EB\",\"nutsCodeItem\":{\"id\":28,\"text\":\"RO223 Constanta\",\"localeKey\":null},\"contactPerson\":null,\"internetAddressesUrl\":[\"www.drdpct.ro\"],\"electronicInfoAccessUrl\":null,\"electronicDocumentsSendingUrl\":null,\"isSME\":false,\"sysNoticeEntityTypeID\":13,\"noticeEntityAddressId\":100221927,\"entityId\":null,\"entityItem\":null,\"isPublishingAgreed\":null,\"nationalIDNumber\":null},\"canEdit\":false,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null},\"shouldShowSection6_4_567\":false,\"section6_4_567_New\":null,\"section6_5_New\":{\"noticeSendDate\":\"2018-08-29T09:19:32+03:00\",\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null}},\"annexD_New\":{\"noOfferForOpenProcedure\":null,\"noOfferForRestrictedProcedure\":null,\"bargainPurchase\":null,\"noticeID\":null,\"areProductsResearchAndStudy\":false,\"isForceMajeure\":false,\"isSupplementaryServiceCompliantOrdered\":false,\"isNewServiceARepetition\":false,\"isAssignedToAProjectContestWinner\":false,\"areProductsStockExchangeListed\":false,\"isSupplierCeasingOperations\":false,\"isSuppliedFromBankruptcy\":false,\"sysReasonForUniqueOfferer\":null,\"isAcquisitionDirectiveCompliant\":false,\"explanation\":null,\"canEdit\":false,\"unawardedSysNoticeType\":null,\"unawardedSysNoticeTypeId\":null,\"unawardedNoticeNo\":null,\"caNoticeId\":100012441,\"sectionName\":null,\"sectionCode\":null,\"noticePreviousPublication\":null}},\"caNoticeEdit_New_U\":null,\"cNoticeId\":100003024,\"isView\":true,\"errorList\":[],\"hasErrors\":false,\"title\":\"Servicii de mentenanta pentru sistemul de monitorizare a traficului si a conditiilor de circulatie pentru Autostrada A2, sector Medgidia -Constanta -DRDP-Constanta\",\"caNoticeID\":100012441,\"isPPP\":false,\"noticeID\":100065062,\"previousPublicationNoticeID\":100021510,\"previousPublicationNoticeNumber\":null,\"sysContractAssignmentTypeID\":1,\"sysNoticeState\":{\"id\":2,\"text\":\"Publicat\",\"localeKey\":\"Common.Clasiff.SysNoticeState.Published\"},\"sysNoticeType\":{\"id\":3,\"text\":\"Anunt de atribuire\",\"localeKey\":\"Common.Clasiff.SysNoticeType.ContractAwardNotice\"},\"prevPubSysNoticeType\":{\"id\":2,\"text\":\"Anunt de participare\",\"localeKey\":\"Common.Clasiff.SysNoticeType.ContractNotice\"},\"contractingAuthorityType\":{\"id\":18,\"text\":\"Organism de drept public\",\"localeKey\":\"Common.Clasiff.ContractingAuthorityType.BodyGuvernedByLow\"},\"sysNoticeVersion\":{\"id\":2,\"text\":\"Formulare in format > 2016\",\"localeKey\":\"Common.Clasiff.SysNoticeVersion.NewFormat\"},\"procedureId\":100005785,\"isOnlineProcedure\":false,\"isLeProcedure\":false,\"paapModel\":{\"paapDetailName\":\"\",\"procedureType\":\"\",\"uniqueIdentificationCode\":null,\"acquisitionValue\":0.0,\"contractAcquisitionValue\":915510.84,\"currency\":\"RON\",\"paapDetailId\":0,\"paapName\":\"\",\"paapYear\":null,\"paapVersion\":null,\"sysFinancingType\":null,\"cpvCode\":null,\"localStrategyObjective\":null,\"isOnline\":null,\"responsibleUnit\":null,\"valueLeftToAllocateRON\":null},\"paapSpentValue\":0.0,\"entityId\":1907,\"legislationType\":{\"id\":3,\"text\":\"Legea nr. 98/23.05.2016\",\"localeKey\":\"Common.Clasiff.SysLegislationType.LAW_98_2016\"},\"procedureType\":{\"id\":1,\"text\":\"Licitatie deschisa\",\"localeKey\":null},\"parentCaNoticeId\":null,\"parentSysNoticeVersionId\":null,\"isCorrecting\":false,\"isCompleting\":false,\"isModifNotice\":false,\"versionNumber\":null,\"totalNotAwardedLots\":0,\"ackDocs\":[],\"noticeNumber\":\"CAN1003798\",\"createDate\":\"0001-01-01T00:00:00+02:00\",\"isCA\":false,\"acAssignedUser\":null,\"procedureHasLots\":false,\"publicationDate\":\"2018-08-30T01:55:18+03:00\",\"sentToJOUE\":true,\"tedNoticeNo\":\"2018/S 106-241862\",\"ackDocsCount\":0,\"initState\":null,\"actions\":{\"canVerify\":false,\"canPreview\":false,\"canDelete\":false,\"canAssociateUser\":false,\"canGoBack\":false,\"canPublish\":false,\"canPrint\":true,\"canCorrect\":false,\"canComplete\":false,\"canEdit\":false,\"canEditPaap\":false,\"canEditTed\":false,\"canAddCancelledLots\":false,\"canGetCancelledLots\":false,\"canDeleteCancelledLots\":false,\"canGenerateContracts\":false,\"canGenerateOnPublish\":false,\"canEditCurrency\":false,\"canGenerateAwardingSection\":false,\"canAddNewContract\":false,\"canAddSubsequentContract\":false,\"canAddFrameworkAgreementContract\":false,\"canAddManualErrata\":false},\"conditions\":{\"hasPP\":true,\"isOnline\":true,\"hasEA\":false,\"isFrameworkAgreement\":false,\"isUtility\":false,\"hasVersions\":false,\"hasErrata\":false,\"hasAckDocuments\":false,\"hasAnnexD\":false,\"hasLots\":false,\"hasCancelledLotsSection\":false,\"hasAwardedLotsSection\":true,\"showRONColumnsOnContractList\":false}}";
    }
}