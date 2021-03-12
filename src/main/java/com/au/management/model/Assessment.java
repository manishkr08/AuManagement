package com.au.management.model;

import com.au.management.model.enums.AssessmentType;

import java.util.Date;
import java.util.List;

public class Assessment {

    private int id;
    private String name;
    private String description;
    private AssessmentType type;
    private int creatorId;
    private Course course;
    private int maxMarks;
    private List<Tag> tags;
    private Date dateCreated;
    private Date dateModified;
    private List<Skill> prerequisite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AssessmentType getType() {
        return type;
    }

    public void setType(AssessmentType type) {
        this.type = type;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public List<Skill> getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(List<Skill> prerequisite) {
        this.prerequisite = prerequisite;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", creatorId=" + creatorId +
                ", course=" + course +
                ", maxMarks=" + maxMarks +
                ", tags=" + tags +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", prerequisite=" + prerequisite +
                '}';
    }
}
