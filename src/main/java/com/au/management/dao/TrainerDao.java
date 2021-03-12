package com.au.management.dao;

import com.au.management.model.Trainer;

import java.util.List;

public interface TrainerDao {

    List<Trainer> selectAllTrainers();

}
