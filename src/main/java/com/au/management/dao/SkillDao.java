package com.au.management.dao;

import com.au.management.model.Skill;

import java.util.List;

public interface SkillDao {

    List<Skill> selectAllSkill();

    List<Skill> selectSkillByAssessmentId(int id);
}
