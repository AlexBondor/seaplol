package ro.cineseuita.contractingauthority.service;

import org.springframework.data.domain.Page;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityDetailDto;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityListDto;
import ro.cineseuita.data.essentials.contractingauthority.repository.ContractingAuthorityFilter;

import java.util.List;
import java.util.Map;

public interface ContractingAuthorityService {
  Page<ContractingAuthorityListDto> findAll(ContractingAuthorityFilter filter);

  ContractingAuthorityDetailDto get(Long id);

  List<Map> treeMap(Long id);
}
