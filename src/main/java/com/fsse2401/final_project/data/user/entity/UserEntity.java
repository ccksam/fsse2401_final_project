package com.fsse2401.final_project.data.user.entity;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String firebaseUid;
    @Column(length = 30)
    private String firstName, lastName;

    // non-use attribute, just for cascade operation on CartItemEntity
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CartItemEntity> cart;

    public UserEntity() {
    }

    public UserEntity(FirebaseUserData userData) {
        this.email = userData.getEmail();
        this.firebaseUid = userData.getFirebaseUid();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    public List<CartItemEntity> getCart() {
        return cart;
    }

    public void setCart(List<CartItemEntity> cart) {
        this.cart = cart;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
