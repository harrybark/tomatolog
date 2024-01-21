package com.daylog.tomatolog.repository;

import com.daylog.tomatolog.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {

}
