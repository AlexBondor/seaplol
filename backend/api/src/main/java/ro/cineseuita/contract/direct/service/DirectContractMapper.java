package ro.cineseuita.contract.direct.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.cineseuita.contract.direct.api.dto.DirectContractDto;
import ro.cineseuita.contract.direct.api.dto.DirectContractListDto;
import ro.cineseuita.contract.direct.entity.DirectContract;

@Mapper
public interface DirectContractMapper {

    @Mapping(source = "_id", target = "id")
    @Mapping(source = "corruption", target = "corruption")
    DirectContractListDto toListDto(DirectContract directContract);

    @Mapping(source = "_id", target = "id")
    DirectContractDto toDetailDto(DirectContract directContract);
}
