package com.au.management.service.impl;

import com.au.management.dao.TrainerDao;
import com.au.management.model.Trainer;
import com.au.management.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerDao trainerDao;

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerDao.selectAllTrainers();
    }
}
