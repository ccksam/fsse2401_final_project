package com.fsse2401.final_project.service.impl;

import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import com.fsse2401.final_project.repository.UserRepository;
import com.fsse2401.final_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData) {
        return userRepository.findByFirebaseUid(firebaseUserData.getFirebaseUid())
                .orElseGet(() -> (userRepository.save(new UserEntity(firebaseUserData))));
    }
}
