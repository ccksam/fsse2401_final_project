package com.fsse2401.final_project.data.user.domainObject;

import com.fsse2401.final_project.data.user.entity.UserEntity;

public class UserResponseData {
    private Integer uid;
    private String email;
    private String firebaseUid;
    private String firstName;
    private String lastName;

    public UserResponseData(UserEntity user) {
        this.uid = user.getUid();
        this.email = user.getEmail();
        this.firebaseUid = user.getFirebaseUid();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
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
