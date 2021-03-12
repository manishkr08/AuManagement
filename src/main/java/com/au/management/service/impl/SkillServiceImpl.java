package com.au.management.service.impl;

import com.au.management.dao.SkillDao;
import com.au.management.model.Skill;
import com.au.management.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDao skillDao;

    @Override
    public List<Skill> getAllSkills() {
        return skillDao.selectAllSkill();
    }
}
