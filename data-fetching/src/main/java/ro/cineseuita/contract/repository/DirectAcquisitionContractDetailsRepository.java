package ro.cineseuita.contract.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ro.cineseuita.contract.entity.direct.DirectAcquisitionContractDetails;

import java.util.List;

public interface DirectAcquisitionContractDetailsRepository extends MongoRepository<DirectAcquisitionContractDetails, Long> {

    List<DirectAcquisitionContractDetails> findAllByContractingAuthorityID(Long id);

    List<DirectAcquisitionContractDetails> findAllBySupplierId(Long id);

    DirectAcquisitionContractDetails findByDirectAcquisitionID(Long directAcquisitionId);

    Page<DirectAcquisitionContractDetails> findAllBySysDirectAcquisitionStateID(Integer id, PageRequest of);

    Page<DirectAcquisitionContractDetails> findAllBySysDirectAcquisitionStateIDAndYear(Integer id, Integer year, PageRequest of);

    @Query(value = "{}", fields = "{supplierId : 1, contractingAuthorityID : 1}")
    List<DirectAcquisitionContractDetails> findAllSuppliersAndContractingAuthorities();

    Page<DirectAcquisitionContractDetails> findAllBySysDirectAcquisitionStateIDAndContractingAuthorityID(Integer id, Long caId, PageRequest of);

    Page<DirectAcquisitionContractDetails> findAllBySysDirectAcquisitionStateIDAndSupplierId(Integer id, Long supplierId, PageRequest of);
}
