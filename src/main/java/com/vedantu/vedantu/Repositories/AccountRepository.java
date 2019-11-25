package com.vedantu.vedantu.Repositories;

import com.vedantu.vedantu.DAO.Accounts;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccountRepository extends MongoRepository <Accounts, String> {
    List<Accounts>findByAccountId(String accountId);

    Accounts findByUserProfileId(String userProfileId);
}
