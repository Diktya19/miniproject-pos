package com.bootcamp.northwind.sImpl;

import com.bootcamp.northwind.model.entity.CategoryEntity;
import com.bootcamp.northwind.model.entity.ProductEntity;
import com.bootcamp.northwind.model.request.CategoryRequest;
import com.bootcamp.northwind.model.request.ProductRequest;
import com.bootcamp.northwind.repository.CategoryRepo;
import com.bootcamp.northwind.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public List<CategoryRequest> getAll() {
        List<CategoryEntity> categories = this.categoryRepo.findAll();
        if (categories.isEmpty()){
            return Collections.emptyList();
        }

        return categories.stream()
                .map(CategoryRequest::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryRequest> getById(Long id) {
        CategoryEntity entity = this.categoryRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        return Optional.of(new CategoryRequest(entity));
    }

    @Override
    public Optional<CategoryRequest> save(CategoryRequest request) {
        if (request == null){
            return Optional.empty();
        }

        CategoryEntity categories = new CategoryEntity(request);
        BeanUtils.copyProperties(request, categories);

        if (!request.getProduct().isEmpty()){
            for (ProductRequest productRequest :request.getProduct()){
                ProductEntity productEntity = new ProductEntity();
                BeanUtils.copyProperties(productRequest, productEntity);
                // add data product
                categories.getProduct(productEntity);
            }
        }

        try {
            this.categoryRepo.save(categories);
            log.info("Save category to database success");
            return Optional.of(new CategoryRequest(categories));
        }catch (Exception e){
            log.error("Save category to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryRequest> update(CategoryRequest request, Long id) {
        CategoryEntity entity = this.categoryRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try {
            this.categoryRepo.save(entity);
            log.info("Update category to database success");
            return Optional.of(new CategoryRequest(entity));
        }catch (Exception e){
            log.error("Update category to database failed, error: {} ", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryRequest> delete(Long id) {
        CategoryEntity result = this.categoryRepo.findById(id).orElse(null);
        if (result == null){
            log.warn("Category with id: {} not found", id);
            return Optional.empty();
        }

        try {
            this.categoryRepo.delete(result);
            log.info("Delete Category from database success");
            return Optional.of(new CategoryRequest(result));
        }catch (Exception e){
            log.error("Delete category from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
