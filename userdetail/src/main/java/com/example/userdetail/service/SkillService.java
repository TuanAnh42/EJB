package com.example.userdetail.service;

import com.example.userdetail.model.Skills;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillService {
    List<Skills> getAllSkill();
    void save(Skills skills);
    Skills getById(Long id);
    void deleteWithId(long id);
}
