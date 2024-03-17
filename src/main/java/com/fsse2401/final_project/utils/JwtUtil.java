package com.fsse2401.final_project.utils;

import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtUtil {
    // In case FirebaseUserData become more complex, required more info / checking to instantiate,
    //  separate those logic in JwTUtil, rather than put everything on FirebaseUserData constructor.
    public static FirebaseUserData getFirebaseUserData(JwtAuthenticationToken jwtAuthenticationToken) {
        return new FirebaseUserData(jwtAuthenticationToken);
    }
}
