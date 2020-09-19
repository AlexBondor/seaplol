package ro.cineseuita.contractingauthority.repository;

import ro.cineseuita.contractingauthority.entity.ContractingAuthority;
import ro.cineseuita.contractingauthority.entity.ContractingAuthorityFilter;

import java.util.List;

public interface ContractingAuthorityCustomRepository {
    List<ContractingAuthority> findAll(ContractingAuthorityFilter filter);

    long count(ContractingAuthorityFilter filter);
}
