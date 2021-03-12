package com.au.management.controller;

import com.au.management.model.Assessment;
import com.au.management.model.AssessmentResult;
import com.au.management.model.OperationStatus;
import com.au.management.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api/assessment")
public class AssessmentController {

    @Autowired
    AssessmentService assessmentService;

    @PostMapping
    public OperationStatus addAssessment(@RequestBody Assessment assessment) {
        System.out.println(assessment);
        return assessmentService.addAssessment(assessment);
    }

    @GetMapping
    public List<Assessment> getAssessmentList() {
        return assessmentService.getAssessmentList();
    }

    @GetMapping("/{id}")
    public Assessment getAssessmentById(@PathVariable int id) {
        return assessmentService.getAssessmentById(id);
    }

    @PutMapping("/{id}")
    public OperationStatus updateAssessment(@PathVariable int id, @RequestBody Assessment assessment) {
        return assessmentService.updateAssessment(id, assessment);
    }

    @DeleteMapping("/{id}")
    public OperationStatus deleteAssessment(@PathVariable int id) {
        return assessmentService.deleteAssessment(id);
    }

    @GetMapping("/marks/{id}")
    public List<AssessmentResult> getAssessmentResults(@PathVariable int id) {
        return assessmentService.getAssessmentResults(id);
    }

}
