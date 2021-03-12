package com.au.management.model;

public class AssessmentResult {

    private int id;
    private int candidateId;
    private int marks;
    private String feedback;

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AssessmentResult{" +
                "id=" + id +
                ", candidateId=" + candidateId +
                ", marks=" + marks +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
