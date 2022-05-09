package com.example.bookmanager;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String user;
    private String due;
    private String priority;
    private String unavail;
    private String pubyear;
    private String owner;
    private String comment;
    private String takeout;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
        
    }
}