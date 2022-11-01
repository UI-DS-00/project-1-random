package com.example.imdb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Data
@Entity
@Table
public class Person {
    @Id
    private String id;
    private String name;
    private int birthYear;
    private int deathYear;
    private String professions;
    private String knownForTitles;
    @Transient
    private List<String> professionsList;
    @Transient
    private List<String> knownForTitlesList;
}