package ro.cineseuita.contract.direct.service;

import ro.cineseuita.contract.direct.api.dto.DirectContractDto;
import ro.cineseuita.contract.direct.api.dto.DirectContractListDto;

import java.util.List;

public interface DirectContractService {

    List<DirectContractListDto> findAll();

    DirectContractDto get(Long id);

    List<DirectContractListDto> findAllForSupplier(Long supplierId);

    List<DirectContractListDto> findAllForContractingAuthority(Long caId);
}
