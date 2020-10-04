package ro.cineseuita.data.essentials.directcontract.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractEssentials;
import ro.cineseuita.data.essentials.directcontract.repository.DirectAcquisitionContractEssentialsCustomRepository;
import ro.cineseuita.data.essentials.directcontract.repository.DirectAcquisitionContractFilter;
import ro.cineseuita.data.essentials.shared.CustomRepository;

import java.util.List;

public class DirectAcquisitionContractEssentialsRepositoryImpl extends CustomRepository implements DirectAcquisitionContractEssentialsCustomRepository {

    private final MongoOperations operations;

    @Autowired
    public DirectAcquisitionContractEssentialsRepositoryImpl(final MongoOperations operations) {
        this.operations = operations;
    }

    @Override
    public List<DirectAcquisitionContractEssentials> findAllBySupplierId(Long supplierId, final DirectAcquisitionContractFilter filter) {
        final Query query = buildFilterQuery(filter);
        addConstraint("supplier.id", supplierId, query);
        return operations.find(query, DirectAcquisitionContractEssentials.class);
    }

    @Override
    public long countBySupplierId(Long supplierId, final DirectAcquisitionContractFilter filter) {
        final Query query = buildFilterQuery(filter);
        addConstraint("supplier.id", supplierId, query);
        return operations.count(query, DirectAcquisitionContractEssentials.class);
    }

    @Override
    public List<DirectAcquisitionContractEssentials> findAllByContractingAuthorityId(Long contractingAuthorityId, DirectAcquisitionContractFilter filter) {
        final Query query = buildFilterQuery(filter);
        addConstraint("contractingAuthority.id", contractingAuthorityId, query);
        return operations.find(query, DirectAcquisitionContractEssentials.class);
    }

    @Override
    public long countByContractingAuthorityId(Long contractingAuthorityId, DirectAcquisitionContractFilter filter) {
        final Query query = buildFilterQuery(filter);
        addConstraint("contractingAuthority.id", contractingAuthorityId, query);
        return operations.count(query, DirectAcquisitionContractEssentials.class);
    }

}
