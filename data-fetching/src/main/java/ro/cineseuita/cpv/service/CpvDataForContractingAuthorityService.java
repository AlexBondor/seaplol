package ro.cineseuita.cpv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.contract.service.DirectAcquisitionContractService;
import ro.cineseuita.contractingauthority.repository.ContractingAuthorityRepository;
import ro.cineseuita.contractingauthority.service.ContractingAuthorityService;
import ro.cineseuita.cpv.entity.CpvDataForContractingAuthority;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CpvDataForContractingAuthorityService {

    private final DirectAcquisitionContractService directAcquisitionContractService;
    private final ContractingAuthorityRepository contractingAuthorityRepository;

    @Autowired
    public CpvDataForContractingAuthorityService(DirectAcquisitionContractService directAcquisitionContractService, ContractingAuthorityService contractingAuthorityService, ContractingAuthorityRepository contractingAuthorityRepository) {
        this.directAcquisitionContractService = directAcquisitionContractService;
        this.contractingAuthorityRepository = contractingAuthorityRepository;
    }

    public void computeCpvDataForContractingAuthorities() {
        final long count = contractingAuthorityRepository.count();
        AtomicInteger i = new AtomicInteger();
        contractingAuthorityRepository.findAllJustIds().stream()
                .parallel()
                .forEach(contractingAuthority -> {
                            final CpvDataForContractingAuthority cpvDataForContractingAuthority = new CpvDataForContractingAuthority();
                            System.out.printf("Computing cpv for contracting authority %d/%d", i.getAndIncrement(), count);
                            directAcquisitionContractService.getAllAcceptedDirectAcquisitionContractDetailsForContractingAuthorityStreamed(contractingAuthority.getId())
                                    .forEach(directAcquisitionContractDetails ->
                                    {
                                        // TBC after next phase
                                    });
                        }

                );
    }

}
