package com.springrest.springrest.entities;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@ToString
@Document(collection = "CourseService")
public class Course {
    @Id
    private long id; // UUID.randomUUID().toString();
    private String title;
    private String description;
//    public Course(long id, String title, String description) {
//        super();
//        this.id = id;
//        this.title = title;
//        this.description = description;
//    }
//    public Course() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//    public long getId() {
//        return id;
//    }
//    public void setId(long id) {
//        this.id = id;
//    }
//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    @Override
//    public String toString() {
//        return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
//    }


}
