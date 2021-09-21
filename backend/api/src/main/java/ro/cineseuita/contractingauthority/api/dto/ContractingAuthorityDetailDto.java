package ro.cineseuita.contractingauthority.api.dto;


import ro.cineseuita.shared.ParticipantDetailDto;

import java.util.List;

public class ContractingAuthorityDetailDto extends ParticipantDetailDto {
  private List<DedicatedSupplierDto> dedicatedSuppliers;

  public List<DedicatedSupplierDto> getDedicatedSuppliers() {
    return dedicatedSuppliers;
  }

  public void setDedicatedSuppliers(List<DedicatedSupplierDto> dedicatedSuppliers) {
    this.dedicatedSuppliers = dedicatedSuppliers;
  }
}
