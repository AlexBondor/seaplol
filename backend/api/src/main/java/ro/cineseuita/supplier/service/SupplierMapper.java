package ro.cineseuita.supplier.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.cineseuita.data.essentials.supplier.entity.SupplierEssentials;
import ro.cineseuita.supplier.api.dto.SupplierDetailDto;
import ro.cineseuita.supplier.api.dto.SupplierListDto;

@Mapper
public interface SupplierMapper {

    @Mapping(source = "_id", target = "id")
    SupplierListDto toListDto(SupplierEssentials supplier);

    @Mapping(source = "_id", target = "id")
    SupplierDetailDto toDetailDto(SupplierEssentials supplier);
}
