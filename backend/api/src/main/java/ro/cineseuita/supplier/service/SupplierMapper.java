package ro.cineseuita.supplier.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.cineseuita.supplier.api.dto.SupplierDetailDto;
import ro.cineseuita.supplier.api.dto.SupplierListDto;
import ro.cineseuita.supplier.entity.Supplier;

@Mapper
public interface SupplierMapper {

    @Mapping(source = "_id", target = "id")
    SupplierListDto toListDto(Supplier supplier);

    @Mapping(source = "_id", target = "id")
    SupplierDetailDto toDetailDto(Supplier supplier);
}
