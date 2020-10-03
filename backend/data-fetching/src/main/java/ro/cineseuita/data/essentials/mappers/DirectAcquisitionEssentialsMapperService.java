package ro.cineseuita.data.essentials.mappers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionType;
import ro.cineseuita.data.essentials.directcontract.entity.CpvCodeEssentials;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractEssentials;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractMinimal;
import ro.cineseuita.data.shared.entityComponents.GenericSeapData;

import java.util.stream.Collectors;

@Service
public class DirectAcquisitionEssentialsMapperService {


    private final DirectAcquisitionItemEssentialsMapperService directAcquisitionItemEssentialsMapperService;

    @Autowired
    public DirectAcquisitionEssentialsMapperService(DirectAcquisitionItemEssentialsMapperService directAcquisitionItemEssentialsMapperService) {
        this.directAcquisitionItemEssentialsMapperService = directAcquisitionItemEssentialsMapperService;
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
        contractEssentials.setCpvCode(mapToCpvCodeEssentials(contractDetails.getCpvCode()));
        contractEssentials.setCorruption(contractDetails.getCorruption());
        contractEssentials.setSysDirectAcquisitionStateID(contractDetails.getSysDirectAcquisitionStateID());

        contractEssentials.setContractingAuthorityId(contractDetails.getContractingAuthorityID());
        contractEssentials.setSupplierId(contractDetails.getSupplierId());
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
