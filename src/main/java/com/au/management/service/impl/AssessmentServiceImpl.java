package com.au.management.service.impl;

import com.au.management.dao.AssessmentDao;
import com.au.management.model.Assessment;
import com.au.management.model.AssessmentResult;
import com.au.management.model.OperationStatus;
import com.au.management.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    private AssessmentDao assessmentDao;

    @Override
    public List<Assessment> getAssessmentList() {
        return assessmentDao.selectAllAssessment();
    }

    @Override
    public Assessment getAssessmentById(int id) {
        return assessmentDao.selectAssessmentById(id);
    }

    @Override
    public OperationStatus addAssessment(Assessment assessment) {
        return assessmentDao.insertNewAssessment(assessment);
    }

    @Override
    public OperationStatus updateAssessment(int id, Assessment assessment) {
        return assessmentDao.updateAssessment(id, assessment);
    }

    @Override
    public OperationStatus deleteAssessment(int id) {
        return assessmentDao.deleteAssessment(id);
    }

    @Override
    public List<AssessmentResult> getAssessmentResults(int id) {
        return assessmentDao.selectAssesmentResultById(id);
    }
}
