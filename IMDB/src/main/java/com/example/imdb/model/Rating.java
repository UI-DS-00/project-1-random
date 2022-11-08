package com.example.imdb.model;

import com.example.imdb.model.requests.RatingRequest;
import com.example.imdb.model.responses.RatingCommentResponse;
import com.example.imdb.model.responses.RatingResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue
    private Integer id;
    private String titleId;
    private Float avgRating;
    private Integer numVotes;

    public RatingRequest request() {
        return RatingRequest.builder()
                .titleId(titleId)
                .avgRating(avgRating)
                .numVotes(numVotes)
                .build();
    }

    public RatingResponse response() {
        return RatingResponse.builder()
                .titleId(titleId)
                .avgRating(avgRating)
                .numVotes(numVotes)
                .build();
    }

    public RatingCommentResponse commentResponse() {
        return RatingCommentResponse.builder()
                .avgRating(avgRating)
                .numVotes(numVotes)
                .build();
    }
}
