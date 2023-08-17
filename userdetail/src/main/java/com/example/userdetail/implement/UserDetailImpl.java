package com.example.userdetail.implement;

import com.example.userdetail.model.UserDetail;
import com.example.userdetail.repository.UserDetailRepository;
import com.example.userdetail.service.UserDetailService;

import java.util.List;
import java.util.Optional;

public class UserDetailImpl implements UserDetailService {
    private final UserDetailRepository userDetailRepository;

    public UserDetailImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public List<UserDetail> getAllUser() {
        return userDetailRepository.findAll();
    }

    @Override
    public void save(UserDetail userDetail) {
        userDetailRepository.save(userDetail);

    }

    @Override
    public UserDetail getById(Long id) {
        Optional<UserDetail> optional = userDetailRepository.findById(id);
        UserDetail userDetail = null;
        if(optional.isPresent()){
            userDetail = optional.get();
        }else
            throw new RuntimeException(
                    "userDetail not found for id : " + id);
        return userDetail;
    }

    @Override
    public void deleteWithId(long id) {
        userDetailRepository.findById(id);
    }
}

