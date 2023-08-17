package com.example.userdetail.service;

import com.example.userdetail.model.UserDetail;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDetailService  {
    List<UserDetail> getAllUser();
    void save(UserDetail userDetail);
    UserDetail getById(Long id);
    void deleteWithId(long id);

}
