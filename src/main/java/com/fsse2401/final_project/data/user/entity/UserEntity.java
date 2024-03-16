package com.fsse2401.final_project.data.user.entity;

import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;
import jakarta.persistence.*;

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

    public UserEntity() {
    }

    public UserEntity(FirebaseUserData userData) {
        this.email = userData.getEmail();
        this.firebaseUid = userData.getFirebaseUid();
    }
}
