package ro.cineseuita.contract.direct.service;

import org.springframework.data.domain.Page;
import ro.cineseuita.contract.direct.api.dto.DirectContractDto;
import ro.cineseuita.contract.direct.api.dto.DirectContractExpandedItemDto;
import ro.cineseuita.contract.direct.api.dto.DirectContractListDto;
import ro.cineseuita.data.essentials.directcontract.repository.DirectAcquisitionContractFilter;

import java.util.List;

public interface DirectContractService {

    List<DirectContractListDto> findAll();

    DirectContractDto get(Long id);

    Page<DirectContractListDto> getAllForSupplier(Long supplierId, DirectAcquisitionContractFilter directAcquisitionContractFilter);

    Page<DirectContractListDto> getAllForContractingAuthority(Long contractingAuthorityId, DirectAcquisitionContractFilter directAcquisitionContractFilter);

    List<DirectContractExpandedItemDto> detailsForExpandedRow(Long contractId);
}
