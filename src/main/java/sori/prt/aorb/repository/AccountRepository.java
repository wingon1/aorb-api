package sori.prt.aorb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sori.prt.aorb.domain.Account;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {
}
