package com.au.management.dao;

import com.au.management.model.Tag;

import java.util.List;

public interface TagDao {

    List<Tag> selectAllTags() ;

    List<Tag> selectTagByAssessmentId(int id);
}
