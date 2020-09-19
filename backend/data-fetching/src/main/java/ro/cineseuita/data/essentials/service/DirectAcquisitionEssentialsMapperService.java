package ro.cineseuita.data.essentials.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.entity.direct.components.DirectAcquisitionType;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.data.essentials.entity.DirectAcquisitionContractMinimal;
import ro.cineseuita.data.essentials.entity.directacquisitions.CpvCodeEssentials;
import ro.cineseuita.data.essentials.entity.directacquisitions.DirectAcquisitionContractEssentials;
import ro.cineseuita.data.shared.entityComponents.GenericSeapData;
import ro.cineseuita.data.supplier.entity.SupplierDetails;

import java.util.stream.Collectors;

@Service
public class DirectAcquisitionEssentialsMapperService {


    private final SupplierEssentialsMapperService supplierEssentialsMapperService;
    private final DirectAcquisitionItemEssentialsMapperService directAcquisitionItemEssentialsMapperService;
    private final ContractingAuthorityEssentialsMapperService contractingAuthorityEssentialsMapperService;

    @Autowired
    public DirectAcquisitionEssentialsMapperService(SupplierEssentialsMapperService supplierEssentialsMapperService, DirectAcquisitionItemEssentialsMapperService directAcquisitionItemEssentialsMapperService, ContractingAuthorityEssentialsMapperService contractingAuthorityEssentialsMapperService) {
        this.supplierEssentialsMapperService = supplierEssentialsMapperService;
        this.directAcquisitionItemEssentialsMapperService = directAcquisitionItemEssentialsMapperService;
        this.contractingAuthorityEssentialsMapperService = contractingAuthorityEssentialsMapperService;
    }

    public DirectAcquisitionContractEssentials mapToDirectAcquisitionContractEssentials(DirectAcquisitionContractDetails contractDetails, SupplierDetails supplierDetails, ContractingAuthorityDetails contractingAuthorityDetails) {
        DirectAcquisitionContractEssentials contractEssentials = new DirectAcquisitionContractEssentials();
        contractEssentials.set_id(contractDetails.getDirectAcquisitionID());
        contractEssentials.setName(contractDetails.getDirectAcquisitionName());
        contractEssentials.setDescription(contractDetails.getDirectAcquisitionDescription());
        contractEssentials.setEstimatedValue(contractDetails.getEstimatedValue());
        contractEssentials.setClosingValue(contractDetails.getClosingValue());
        contractEssentials.setPublicationDate(new DateTime(contractDetails.getPublicationDate()));
        contractEssentials.setFinalizationDate(new DateTime(contractDetails.getFinalizationDate()));
        contractEssentials.setDeliveryCondition(contractDetails.getDeliveryCondition());
        contractEssentials.setPaymentCondition(contractDetails.getPaymentCondition());
        contractEssentials.setCpvCode(mapToCpvCodeEssentials(contractDetails.getCpvCode()));
        contractEssentials.setCorruption(contractDetails.getCorruption());

        contractEssentials.setContractingAuthority(contractingAuthorityEssentialsMapperService.mapToContractingAuthorityEssentials(contractingAuthorityDetails));
        contractEssentials.setSupplier(supplierEssentialsMapperService.mapToSupplierWithContractsForDirectAcquisitionEssentials(supplierDetails));
        contractEssentials.setDirectAcquisitionItems(
                contractDetails
                        .getDirectAcquisitionItems()
                        .stream()
                        .map(directAcquisitionItemEssentialsMapperService::mapToDirectAcquisitionItemEssentials)
                        .collect(Collectors.toList())
        );

        return contractEssentials;
    }

    public DirectAcquisitionContractMinimal mapToDirectAcquisitionContractMinimal(DirectAcquisitionContractDetails contractDetails) {
        DirectAcquisitionContractMinimal contractMinimal = new DirectAcquisitionContractMinimal();

        contractMinimal.set_id(contractDetails.getDirectAcquisitionID());
        contractMinimal.setName(contractDetails.getDirectAcquisitionName());
        contractMinimal.setClosingValue(contractDetails.getClosingValue());
        contractMinimal.setCpvCode(mapToCpvCodeEssentials(contractDetails.getCpvCode()));
        contractMinimal.setType(DirectAcquisitionType.fromVal(contractDetails.getSysAcquisitionContractTypeID()));
        contractMinimal.setFinalizationDate(new DateTime(contractDetails.getFinalizationDate()));

        return contractMinimal;
    }

    private CpvCodeEssentials mapToCpvCodeEssentials(GenericSeapData cpvCode) {
        CpvCodeEssentials cpvCodeEssentials = new CpvCodeEssentials();
        cpvCodeEssentials.set_id(cpvCode.getId());
        cpvCodeEssentials.setCode(cpvCode.getText());

        return cpvCodeEssentials;
    }
}