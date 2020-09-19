package ro.cineseuita.data.supplier.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ro.cineseuita.data.supplier.entity.Supplier;
import ro.cineseuita.data.supplier.entity.SupplierDetails;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplierMapper {

    @Mapping(source = "address.city", target = "city")
    @Mapping(source = "address.county", target = "county")
    @Mapping(target = "participantStatus", ignore = true)
    Supplier fromDetailsToBasic(SupplierDetails supplierDetails);

}
