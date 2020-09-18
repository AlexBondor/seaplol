package ro.cineseuita.contractingauthority.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityCpvBasicStatsDto;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityDetailDto;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityListDto;
import ro.cineseuita.contractingauthority.entity.ContractingAuthorityFilter;
import ro.cineseuita.contractingauthority.service.ContractingAuthorityService;
import ro.cineseuita.cpv.entity.NationalCpvData;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contracting_authorities")
public class ContractingAuthorityController {
    private final ContractingAuthorityService contractingAuthorityService;

    @Autowired
    public ContractingAuthorityController(final ContractingAuthorityService contractingAuthorityService) {
        this.contractingAuthorityService = contractingAuthorityService;
    }

    @GetMapping()
    public Page<ContractingAuthorityListDto> findAll(ContractingAuthorityFilter pagination) {
        return contractingAuthorityService.findAll(pagination);
    }

    @GetMapping("/{id}")
    public ContractingAuthorityDetailDto get(@PathVariable Long id) {
        return contractingAuthorityService.get(id);
    }

    @GetMapping("/getCpvBasicStatsForContractingAuthority/{id}")
    public ContractingAuthorityCpvBasicStatsDto getCpvBasicStatsForContractingAuthority(@PathVariable Long id) {
        return contractingAuthorityService.getCpvBasicStatsForContractingAuthority(id);
    }

    @GetMapping("/treeMap/{id}")
    public List<Map> treeMap(@PathVariable Long id) {
        return contractingAuthorityService.treeMap(id);
    }


}
