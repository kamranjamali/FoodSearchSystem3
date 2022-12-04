package com.restaurant.serviceImpl;

import com.restaurant.entities.UserEntity;
import com.restaurant.repository.UserRepository;
import com.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserEntity createUser(UserEntity user) {
        return this.userRepository.save(user);
    }
    @Override
    public UserEntity updateUser(UserEntity user) {
        UserEntity updatedUser = this.userRepository.save(user);
        return updatedUser;
    }
    @Override
    public UserEntity findById(Long userId) {
        UserEntity userEntity = this.userRepository.findById(userId).get();
        return userEntity;
    }
    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> alluser = this.userRepository.findAll();
        return alluser;
    }
    @Override
    public void delete(UserEntity userEntity) {
        this.userRepository.delete(userEntity);
    }

}
