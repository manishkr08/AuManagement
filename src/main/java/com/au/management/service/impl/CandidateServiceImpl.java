package com.au.management.service.impl;

import com.au.management.dao.CandidateDao;
import com.au.management.model.Assessment;
import com.au.management.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CandidateServiceImpl implements CandidateService {

    private int minStudentCount = 5;
    private int totalStudent = 15;

    @Autowired
    private CandidateDao candidateDao;

    private String[] feedbacks = new String[] {
            "Test was hard.",
            "it was easy.",
            "it was helpful and made me realized what i am lacking.",
            "Test was good.",
            "Trainer is really helpful.",
            "It was super hard.",
            "Cant understand anything"
    };

    Random random = new Random();

    @Override
    public void takeDummyAssessment(Assessment assessment) {

        int candidateTookTest = random.nextInt(totalStudent) + minStudentCount;

        for (int candidate = 1; candidate <= candidateTookTest; candidate ++) {
            String feedback = feedbacks[random.nextInt(feedbacks.length)];
            int marks = random.nextInt(assessment.getMaxMarks());
            candidateDao.insertDummyData(candidate, assessment.getId(), marks, feedback);
        }
    }
}
