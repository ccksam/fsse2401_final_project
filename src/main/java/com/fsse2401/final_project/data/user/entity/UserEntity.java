package com.fsse2401.final_project.data.user.entity;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
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

    public UserEntity(FirebaseUserData userData) {
        this.email = userData.getEmail();
        this.firebaseUid = userData.getFirebaseUid();
    }
}
