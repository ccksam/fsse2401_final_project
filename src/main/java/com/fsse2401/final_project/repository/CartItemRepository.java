package com.fsse2401.final_project.repository;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    // derived method version = Optional<CartItemEntity> findByUserAndProduct (UserEntity user, ProductEntity product)


    // (findByUserUid) select ue1_0.uid,ue1_0.email,ue1_0.firebase_uid,ue1_0.first_name,ue1_0.last_name from user ue1_0 where ue1_0.firebase_uid=?
    //SELECT * FROM cart_item ci WHERE  ci.user_uid = ?
    @Query(value = "SELECT * FROM cart_item ci WHERE  ci.user_uid = :uid", nativeQuery = true)
    List<CartItemEntity> findByUserUid(@Param("uid") Integer userUid);

    // JPA derived query equivalent to above native query?
    //select cie1_0.cid,cie1_0.product_pid,cie1_0.quantity,cie1_0.user_uid from cart_item cie1_0 left join user u1_0 on u1_0.uid=cie1_0.user_uid where u1_0.firebase_uid=?
    //select ue1_0.uid,ue1_0.email,ue1_0.firebase_uid,ue1_0.first_name,ue1_0.last_name from user ue1_0 where ue1_0.uid=?
    List<CartItemEntity> findByUser_FirebaseUid(String firebaseUid);

    List<CartItemEntity> findByUser(UserEntity user);

    Optional<CartItemEntity> findByUser_FirebaseUidAndProduct_Pid(String firebaseUid, Integer pid);

    Integer deleteByUser_FirebaseUidAndProduct_Pid(String firebaseUid, Integer pid);
}
