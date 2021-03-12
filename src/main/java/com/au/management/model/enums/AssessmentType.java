package com.au.management.model.enums;

public enum AssessmentType {

    QUIZ (1),
    MCQ (2),
    ASSIGNMENT (3),
    PROJECT (4);

    private int type;
    AssessmentType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }
}
