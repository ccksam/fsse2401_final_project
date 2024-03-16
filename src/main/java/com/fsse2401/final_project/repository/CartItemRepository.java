package com.fsse2401.final_project.repository;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer> {
    @Query(value = "SELECT * FROM cart_item ci " +
            "WHERE ci.user_uid = :uid " +
            "AND ci.product_pid = :pid",
            nativeQuery = true)
    Optional<CartItemEntity> findCartItemByUserAndProduct(
            @Param("uid") Integer userUid,
            @Param("pid") Integer productPid
    );
}
