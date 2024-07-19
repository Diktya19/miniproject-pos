package com.bootcamp.northwind.model.entity;

import com.bootcamp.northwind.model.request.CategoryRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_desc")
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ProductEntity> product = new ArrayList<>();

    public CategoryEntity(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public CategoryEntity(CategoryRequest request) {
        BeanUtils.copyProperties(request, this);
    }

    public void getProduct(ProductEntity productEntity){
        this.product.add(productEntity);
        productEntity.setCategory(this);
    }
}
