package com.example.userdetail.implement;

import com.example.userdetail.model.Skills;
import com.example.userdetail.repository.SkillRepository;
import com.example.userdetail.service.SkillService;

import java.util.List;
import java.util.Optional;

public class SkillImpl implements SkillService {
    private final SkillRepository skillRepository;

    public SkillImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public List<Skills> getAllSkill() {
        return skillRepository.findAll();
    }

    @Override
    public void save(Skills skills) {
        skillRepository.save(skills);

    }

    @Override
    public Skills getById(Long id) {
        Optional<Skills> optional = skillRepository.findById(id);
        Skills skills = null;
        if(optional.isPresent()){
            skills = optional.get();
        }else
            throw new RuntimeException(
                    "skills not found for id : " + id);
        return skills;
    }

    @Override
    public void deleteWithId(long id) {
        skillRepository.findById(id);
    }
}

