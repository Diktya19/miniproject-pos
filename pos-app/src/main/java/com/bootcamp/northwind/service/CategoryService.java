package com.bootcamp.northwind.service;

import com.bootcamp.northwind.model.request.CategoryRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryRequest> getAll();
    Optional<CategoryRequest> getById(Long id);
    Optional<CategoryRequest> save(CategoryRequest request);
    Optional<CategoryRequest> update(CategoryRequest request, Long id);
    Optional<CategoryRequest> delete(Long id);
}
