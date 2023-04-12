package com.example.thebest_youdo.repository;

import com.example.thebest_youdo.model.entity.ServiceProduct;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServiceRepository extends PagingAndSortingRepository<ServiceProduct, UUID> {

    @Query("select s from ServiceProduct s where s.id = :serviceId and s.createdBy.id = :userId")
    ServiceProduct findByIdAndByUserId(UUID serviceId, UUID userId);
}
