package ro.cineseuita.contractingauthority.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ro.cineseuita.contractingauthority.entity.ContractingAuthority;
import ro.cineseuita.contractingauthority.entity.ContractingAuthorityDetails;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContractingAuthorityMapper {

    @Mapping(source = "address.city", target = "city")
    @Mapping(source = "address.county", target = "county")
    @Mapping(target = "participantStatus", ignore = true)
    ContractingAuthority fromDetailsToBasic(ContractingAuthorityDetails contractingAuthorityDetails);

}
