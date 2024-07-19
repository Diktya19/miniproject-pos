package com.bootcamp.northwind.sImpl;

import com.bootcamp.northwind.model.entity.SupplierEntity;
import com.bootcamp.northwind.model.request.SupplierModel;
import com.bootcamp.northwind.repository.SupplierRepo;
import com.bootcamp.northwind.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepo supplierRepo;
    @Override
    public List<SupplierModel> getAll() {
        return this.supplierRepo.findAll()
                .stream()
                .map(SupplierModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierModel getById(Long id) {
        return this.supplierRepo.findById(id)
                .map(SupplierModel::new)
                .orElse(null);
    }

    @Override
    public Optional<SupplierModel> save(SupplierModel request) {
        if (request == null){
            return Optional.empty();
        }

        SupplierEntity entity = new SupplierEntity(request);
        try {
            this.supplierRepo.save(entity);
            log.info("Save supplier to database success");
            return Optional.of(new SupplierModel(entity));
        }catch (Exception e){
            log.error("Save supplier to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierModel> update(SupplierModel request, Long id) {
        SupplierEntity entity = this.supplierRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        try {
            this.supplierRepo.save(entity);
            log.info("Update supplier to database success");
            return Optional.of(new SupplierModel(entity));
        }catch (Exception e){
            log.error("Update supplier to database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierModel> delete(Long id) {
        SupplierEntity result = this.supplierRepo.findById(id).orElse(null);
        if (result == null){
            log.warn("supplier with id: {} not found", id);
            return Optional.empty();
        }

        try {
            this.supplierRepo.delete(result);
            log.info("Delete supplier from database success");
            return Optional.of(new SupplierModel(result));
        }catch (Exception e){
            log.error("Delete supplier from database failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
