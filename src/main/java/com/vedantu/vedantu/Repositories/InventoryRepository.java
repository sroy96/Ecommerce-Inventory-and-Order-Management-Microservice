package com.vedantu.vedantu.Repositories;

import com.vedantu.vedantu.DAO.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
    Inventory findByItemId(String itemId);
}
