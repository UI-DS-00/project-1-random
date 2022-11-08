package com.example.imdb.model;

import com.example.imdb.model.requests.PersonRequest;
import com.example.imdb.model.responses.PersonResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Person {
    @Id
    private String id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    private String professions;
    private String knownForTitles;
    @Transient
    private List<String> professionsList;
    @Transient
    private List<String> knownForTitlesList;

    public PersonRequest request() {
        return PersonRequest.builder()
                .id(id)
                .name(name)
                .birthYear(birthYear)
                .deathYear(deathYear)
                .professions(professions)
                .knownForTitles(knownForTitles)
                .build();
    }

    public PersonResponse response() {
        return PersonResponse.builder()
                .id(id)
                .name(name)
                .birthYear(birthYear)
                .deathYear(deathYear)
                .professions(professions)
                .knownForTitles(knownForTitles)
                .build();
    }
}
