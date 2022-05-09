package com.example.bookmanager.bookinfo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Bookinfo {
    private Long id;
    private String title;
    private String owner;
    private String author;
    private String genre;
    private String pubyear;
    private String comment;
    private String priority;
    private String unavail;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
        
    }
}