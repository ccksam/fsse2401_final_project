package com.fsse2401.final_project.repository;

import com.fsse2401.final_project.data.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<ProductEntity> findAllAsList();
}
