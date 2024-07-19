package com.bootcamp.northwind.model.request;

import com.bootcamp.northwind.model.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    private Long id;
    private String categoryName;
    private String description;
    private List<ProductRequest> product = new ArrayList<>();

    public CategoryRequest(CategoryEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (!entity.getProduct().isEmpty()){
            this.product = entity.getProduct()
                    .stream().map(ProductRequest::new).collect(Collectors.toList());
        }
    }
}
