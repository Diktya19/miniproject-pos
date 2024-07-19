package com.bootcamp.northwind.service;

import com.bootcamp.northwind.model.request.SupplierModel;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<SupplierModel> getAll();
    SupplierModel getById(Long id);
    Optional<SupplierModel> save(SupplierModel request);
    Optional<SupplierModel> update(SupplierModel request, Long id);
    Optional<SupplierModel> delete(Long id);
}
