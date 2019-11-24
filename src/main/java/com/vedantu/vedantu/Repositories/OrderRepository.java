package com.vedantu.vedantu.Repositories;

import com.vedantu.vedantu.DAO.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Orders, String> {
    Orders findByTrackId(String trackId);
}
