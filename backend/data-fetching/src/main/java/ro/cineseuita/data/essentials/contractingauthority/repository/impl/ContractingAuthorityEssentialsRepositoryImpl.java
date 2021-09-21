package ro.cineseuita.data.essentials.contractingauthority.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;
import ro.cineseuita.data.essentials.contractingauthority.repository.ContractingAuthorityCustomRepository;
import ro.cineseuita.data.essentials.contractingauthority.repository.ContractingAuthorityFilter;
import ro.cineseuita.data.essentials.shared.CustomRepository;

import java.util.List;

@Repository
public class ContractingAuthorityEssentialsRepositoryImpl extends CustomRepository implements ContractingAuthorityCustomRepository {
    private final MongoOperations operations;

    @Autowired
    public ContractingAuthorityEssentialsRepositoryImpl(final MongoOperations operations) {
        this.operations = operations;
    }

    @Override
    public List<ContractingAuthorityEssentials> findAll(final ContractingAuthorityFilter filter) {
        final Query query = buildFilterQuery(filter);
        return operations.find(query, ContractingAuthorityEssentials.class);
    }

    @Override
    public long count(final ContractingAuthorityFilter filter) {
        final Query query = buildFilterQuery(filter);
        return operations.count(query, ContractingAuthorityEssentials.class);
    }

}
