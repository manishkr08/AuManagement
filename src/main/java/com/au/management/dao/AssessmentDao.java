package com.au.management.dao;

import com.au.management.model.Assessment;
import com.au.management.model.AssessmentResult;
import com.au.management.model.OperationStatus;

import java.util.List;

public interface AssessmentDao {

    Assessment selectAssessmentById(int id);

    List<Assessment> selectAllAssessment();

    OperationStatus insertNewAssessment(Assessment assessment);

    OperationStatus updateAssessment(int id, Assessment assessment);

    OperationStatus deleteAssessment(int id);

    List<AssessmentResult> selectAssesmentResultById(int id);
}
