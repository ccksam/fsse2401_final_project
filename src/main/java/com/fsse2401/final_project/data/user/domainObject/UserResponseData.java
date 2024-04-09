package com.fsse2401.final_project.data.user.domainObject;

import com.fsse2401.final_project.data.user.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
}
