package ro.cineseuita.contractingauthority.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityDetailDto;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityListDto;
import ro.cineseuita.contractingauthority.api.dto.DedicatedSupplierDto;
import ro.cineseuita.data.contractingauthority.entity.components.DedicatedSupplier;
import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;

import java.util.Arrays;

@Mapper
public interface ContractingAuthorityMapper {

    @Mapping(source = "_id", target = "id")
    ContractingAuthorityListDto toListDto(ContractingAuthorityEssentials contractingAuthority);

    @Mapping(source = "_id", target = "id")
    @Mapping(source = "dedicatedSuppliers", target = "dedicatedSuppliers", qualifiedByName = "dedicatedSupplierMapper")
    ContractingAuthorityDetailDto toDetailDto(ContractingAuthorityEssentials contractingAuthority);

    @Named("dedicatedSupplier")
    static DedicatedSupplierDto dedicatedSupplierMapper(DedicatedSupplier dedicatedSupplier) {
        DedicatedSupplierDto dedicatedSupplierDto = new DedicatedSupplierDto();

        dedicatedSupplierDto.setSupplierName(dedicatedSupplier.getSupplierName());

        DedicatedSupplierDto.DedicatedSupplierData caData = new DedicatedSupplierDto.DedicatedSupplierData();
        caData.setLabel("Contracte cu instituția");
        caData.setContractsCount(dedicatedSupplier.getTotalContractsCountDedicatedToCA());
        caData.setContractsValue(dedicatedSupplier.getPercentageOfContractsValueDedicatedToCA());

        DedicatedSupplierDto.DedicatedSupplierData totalData = new DedicatedSupplierDto.DedicatedSupplierData();
        totalData.setLabel("Total contracte");
        totalData.setContractsCount(dedicatedSupplier.getTotalAmountOfContractsBasedOnPercentage());
        totalData.setContractsValue(dedicatedSupplier.getTotalValueOfContractsBasedOnPercentage());

        dedicatedSupplierDto.setData(Arrays.asList(caData, totalData));

        return dedicatedSupplierDto;
    }

}
