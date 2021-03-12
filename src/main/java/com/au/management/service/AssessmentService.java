package com.au.management.service;

import com.au.management.model.Assessment;
import com.au.management.model.AssessmentResult;
import com.au.management.model.OperationStatus;

import java.util.List;

public interface AssessmentService {

    List<Assessment> getAssessmentList();

    Assessment getAssessmentById(int id);

    OperationStatus addAssessment(Assessment assessment);

    OperationStatus updateAssessment(int id, Assessment assessment);

    OperationStatus deleteAssessment(int id);

    List<AssessmentResult> getAssessmentResults(int id);

}
