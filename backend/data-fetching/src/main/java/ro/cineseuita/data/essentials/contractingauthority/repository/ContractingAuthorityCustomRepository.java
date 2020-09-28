package ro.cineseuita.data.essentials.contractingauthority.repository;

import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;

import java.util.List;

public interface ContractingAuthorityCustomRepository {
    List<ContractingAuthorityEssentials> findAll(ContractingAuthorityFilter filter);

    long count(ContractingAuthorityFilter filter);
}
