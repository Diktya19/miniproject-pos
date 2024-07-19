package com.bootcamp.northwind.repository;

import com.bootcamp.northwind.model.entity.LookupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LookupRepo extends JpaRepository<LookupEntity, String> {
    List<LookupEntity> findByGroups(String groups);
    Optional<LookupEntity> findByCode(String code);
}
