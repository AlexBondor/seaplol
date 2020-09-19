package ro.cineseuita.contractingauthority.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityDetailDto;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityListDto;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityMinimalDto;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthoritySearchDto;
import ro.cineseuita.contractingauthority.entity.ContractingAuthority;

@Mapper
public interface ContractingAuthorityMapper {

    @Mapping(source = "_id", target = "id")
    ContractingAuthorityListDto toListDto(ContractingAuthority contractingAuthority);

    @Mapping(source = "_id", target = "id")
    ContractingAuthorityDetailDto toDetailDto(ContractingAuthority contractingAuthority);

    @Mapping(source = "_id", target = "id")
    ContractingAuthoritySearchDto toSearchDto(ContractingAuthority authority);

    @Mapping(source = "_id", target = "id")
    ContractingAuthorityMinimalDto toMinimalDto(ContractingAuthority authority);

}
