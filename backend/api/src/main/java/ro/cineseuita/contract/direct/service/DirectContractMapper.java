package ro.cineseuita.contract.direct.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.cineseuita.contract.direct.api.dto.DirectContractDto;
import ro.cineseuita.contract.direct.api.dto.DirectContractListDto;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractEssentials;

@Mapper
public interface DirectContractMapper {

  @Mapping(source = "_id", target = "id")
  @Mapping(target = "finalizationDate", dateFormat = "dd/MM/yyyy")
  DirectContractListDto toListDto(DirectAcquisitionContractEssentials directContract);

  @Mapping(source = "_id", target = "id")
  DirectContractDto toDetailDto(DirectAcquisitionContractEssentials directContract);
}
