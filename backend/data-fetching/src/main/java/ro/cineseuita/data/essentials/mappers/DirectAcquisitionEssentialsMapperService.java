package ro.cineseuita.data.essentials.mappers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionType;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthority;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDataRepository;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractEssentials;
import ro.cineseuita.data.essentials.directcontract.entity.components.DirectAcquisitionContractMinimal;
import ro.cineseuita.data.supplier.entity.Supplier;
import ro.cineseuita.data.supplier.repository.SupplierDataRepository;

import java.util.stream.Collectors;

import static ro.cineseuita.data.essentials.directcontract.entity.components.CpvCodeEssentials.fromGenericSeapData;
import static ro.cineseuita.data.essentials.directcontract.entity.components.ParticipantMinimal.fromParticipant;

@Service
public class DirectAcquisitionEssentialsMapperService {


    private final DirectAcquisitionItemEssentialsMapperService directAcquisitionItemEssentialsMapperService;
    private final ContractingAuthorityDataRepository contractingAuthorityDataRepository;
    private final SupplierDataRepository supplierDataRepository;

    @Autowired
    public DirectAcquisitionEssentialsMapperService(DirectAcquisitionItemEssentialsMapperService directAcquisitionItemEssentialsMapperService, ContractingAuthorityDataRepository contractingAuthorityDataRepository, SupplierDataRepository supplierDataRepository) {
        this.directAcquisitionItemEssentialsMapperService = directAcquisitionItemEssentialsMapperService;
        this.contractingAuthorityDataRepository = contractingAuthorityDataRepository;
        this.supplierDataRepository = supplierDataRepository;
    }

    public DirectAcquisitionContractEssentials mapToDirectAcquisitionContractEssentials(DirectAcquisitionContractDetails contractDetails) {
        DirectAcquisitionContractEssentials contractEssentials = new DirectAcquisitionContractEssentials();
        contractEssentials.set_id(contractDetails.getDirectAcquisitionID());
        contractEssentials.setName(contractDetails.getDirectAcquisitionName());
        contractEssentials.setDescription(contractDetails.getDirectAcquisitionDescription());
        contractEssentials.setEstimatedValue(contractDetails.getEstimatedValue());
        contractEssentials.setClosingValue(contractDetails.getClosingValue());
        contractEssentials.setClosingValueSecondCurrency(contractDetails.getSecondCurrencyClosingValue());
        contractEssentials.setPublicationDate(new DateTime(contractDetails.getPublicationDate()));
        contractEssentials.setFinalizationDate(new DateTime(contractDetails.getFinalizationDate()));
        contractEssentials.setDeliveryCondition(contractDetails.getDeliveryCondition());
        contractEssentials.setPaymentCondition(contractDetails.getPaymentCondition());
        contractEssentials.setCpvCode(fromGenericSeapData(contractDetails.getCpvCode()));

        ContractingAuthority contractingAuthority = contractingAuthorityDataRepository.findById(contractDetails.getContractingAuthorityID()).get();
        contractEssentials.setContractingAuthority(fromParticipant(contractingAuthority));
        contractEssentials.setContractingAuthorityId(contractingAuthority.getId());

        Supplier supplier = supplierDataRepository.findById(contractDetails.getSupplierId()).get();
        contractEssentials.setSupplier(fromParticipant(supplier));
        contractEssentials.setSupplierId(supplier.getId());

        contractEssentials.setProblems(contractDetails.getProblems().getProblems());
        contractEssentials.setProblemsCount(contractDetails.getProblems().getProblemsCount());

        contractEssentials.setDirectAcquisitionItems(
                contractDetails
                        .getDirectAcquisitionItems()
                        .stream()
                        .map(directAcquisitionItemEssentialsMapperService::mapToDirectAcquisitionItemEssentials)
                        .collect(Collectors.toList())
        );

        contractEssentials.setYear(contractDetails.getYear());

        return contractEssentials;
    }

    public DirectAcquisitionContractMinimal mapToDirectAcquisitionContractMinimal(DirectAcquisitionContractDetails contractDetails) {
        DirectAcquisitionContractMinimal contractMinimal = new DirectAcquisitionContractMinimal();

        contractMinimal.set_id(contractDetails.getDirectAcquisitionID());
        contractMinimal.setName(contractDetails.getDirectAcquisitionName());
        contractMinimal.setClosingValue(contractDetails.getClosingValue());
        contractMinimal.setCpvCode(fromGenericSeapData(contractDetails.getCpvCode()));
        contractMinimal.setType(DirectAcquisitionType.fromVal(contractDetails.getSysAcquisitionContractTypeID()));
        contractMinimal.setFinalizationDate(new DateTime(contractDetails.getFinalizationDate()));

        return contractMinimal;
    }

}
