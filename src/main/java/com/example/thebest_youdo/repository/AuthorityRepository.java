package com.example.thebest_youdo.repository;

import com.example.thebest_youdo.model.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorityRepository extends JpaRepository<Authority, UUID> {
}
