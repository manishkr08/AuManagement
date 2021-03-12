package com.au.management.service.impl;

import com.au.management.dao.TagDao;
import com.au.management.model.Tag;
import com.au.management.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImp implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public List<Tag> getAllTags() {
        return tagDao.selectAllTags();
    }
}
