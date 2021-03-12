package com.au.management.controller;

import com.au.management.model.Tag;
import com.au.management.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api/tags")
public class TagsController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public List<Tag> getTagList() {
        return tagService.getAllTags();
    }

}
