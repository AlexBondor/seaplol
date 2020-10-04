package ro.cineseuita.data.essentials.directcontract.repository;

import org.springframework.data.mongodb.repository.Query;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractEssentials;

import java.util.List;

public interface DirectAcquisitionContractEssentialsCustomRepository {

    List<DirectAcquisitionContractEssentials> findAllBySupplierId(Long supplierId, DirectAcquisitionContractFilter filter);

    long countBySupplierId(Long supplierId, DirectAcquisitionContractFilter filter);

    List<DirectAcquisitionContractEssentials> findAllByContractingAuthorityId(Long contractingAuthorityId, DirectAcquisitionContractFilter filter);

    long countByContractingAuthorityId(Long contractingAuthorityId, DirectAcquisitionContractFilter filter);

}
