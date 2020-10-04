package ro.cineseuita.contractingauthority.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityDetailDto;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityListDto;
import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;

@Mapper
public interface ContractingAuthorityMapper {

    @Mapping(source = "_id", target = "id")
    ContractingAuthorityListDto toListDto(ContractingAuthorityEssentials contractingAuthority);

    @Mapping(source = "_id", target = "id")
    ContractingAuthorityDetailDto toDetailDto(ContractingAuthorityEssentials contractingAuthority);

}
