package com.fsse2401.final_project.data.user.domainObject;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

@Setter
@Getter
public class FirebaseUserData {
    private String firebaseUid;
    private String email;
    private String firstName, lastName;

    public FirebaseUserData(JwtAuthenticationToken jwtToken) {
        this.firebaseUid = (String) jwtToken.getTokenAttributes().get("user_id");
        this.email = (String) jwtToken.getTokenAttributes().get("email");
    }
}
