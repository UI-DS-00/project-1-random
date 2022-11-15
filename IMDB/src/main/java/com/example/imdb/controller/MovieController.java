package com.example.imdb.controller;

import com.example.imdb.model.requests.MovieRequest;
import com.example.imdb.model.responses.MovieResponse;
import com.example.imdb.model.responses.PersonResponse;
import com.example.imdb.model.responses.RatingResponse;
import com.example.imdb.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest request) {
        return new ResponseEntity<>(movieService.addMovie(request), HttpStatus.CREATED);
    }

    @PutMapping("/movies/{titleId}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable String titleId,
                                                     @RequestBody MovieRequest request) {
        return new ResponseEntity<>(movieService.updateMovie(titleId, request), HttpStatus.OK);
    }

    @DeleteMapping("/movies/{titleId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String titleId) {
        movieService.deleteMovie(titleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieResponse>> getMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/movies/{titleId}")
    public ResponseEntity<MovieResponse> getMovie(@PathVariable String titleId) {
        return new ResponseEntity<>(movieService.getMovieById(titleId), HttpStatus.OK);
    }

    @GetMapping("/movies/{titleId}/directors")
    public ResponseEntity<List<PersonResponse>> getDirectors(@PathVariable String titleId) {
        return new ResponseEntity<>(movieService.getDirectors(titleId), HttpStatus.OK);
    }

    @GetMapping("/movies/{titleId}/actors")
    public ResponseEntity<List<PersonResponse>> getActors(@PathVariable String titleId) {
        return new ResponseEntity<>(movieService.getActors(titleId), HttpStatus.OK);
    }

    @GetMapping("/movies/{titleId}/ratings")
    public ResponseEntity<RatingResponse> getRating(@PathVariable String titleId) {
        return new ResponseEntity<>(movieService.getRating(titleId), HttpStatus.OK);
    }

    @GetMapping("/movies/actors/{id}")
    public ResponseEntity<List<MovieResponse>> getMoviesByActor(@PathVariable String id) {
        return new ResponseEntity<>(movieService.findByActor(id), HttpStatus.OK);
    }

    @GetMapping("/movies/directors/{name}")
    public ResponseEntity<List<MovieResponse>> getMoviesByDirector(@PathVariable String name) {
        return new ResponseEntity<>(movieService.findByDirectors_Name(name), HttpStatus.OK);
    }

    // filters

    @GetMapping("/movies/title/{title}")
    public ResponseEntity<List<MovieResponse>> getMoviesByTitle(@PathVariable String title) {
        return new ResponseEntity<>(movieService.findByTitleContaining(title), HttpStatus.OK);
    }

    @GetMapping("/movies/type/{type}")
    public ResponseEntity<List<MovieResponse>> getMoviesByType(@PathVariable String type) {
        return new ResponseEntity<>(movieService.findByType(type), HttpStatus.OK);
    }

    @GetMapping("/movies/genre/{genre}")
    public ResponseEntity<List<MovieResponse>> getMoviesByGenre(@PathVariable String genre) {
        return new ResponseEntity<>(movieService.findByGenresContaining(genre), HttpStatus.OK);
    }

    @GetMapping("/movies/start-year/{year}")
    public ResponseEntity<List<MovieResponse>> getMoviesByYear(@PathVariable Integer year) {
        return new ResponseEntity<>(movieService.findByStartYear(year), HttpStatus.OK);
    }

    @GetMapping("/movies/end-year/{year}")
    public ResponseEntity<List<MovieResponse>> getMoviesByEndYear(@PathVariable Integer year) {
        return new ResponseEntity<>(movieService.findByEndYear(year), HttpStatus.OK);
    }

    @GetMapping("/movies/start-year/{y1}/{y2}")
    public ResponseEntity<List<MovieResponse>> getMoviesByYear(@PathVariable Integer y1,
                                                               @PathVariable Integer y2) {
        return new ResponseEntity<>(movieService.findByStartYearBetween(y1, y2), HttpStatus.OK);
    }

    @GetMapping("/movies/end-year/{y1}/{y2}")
    public ResponseEntity<List<MovieResponse>> getMoviesByEndYear(@PathVariable Integer y1,
                                                                  @PathVariable Integer y2) {
        return new ResponseEntity<>(movieService.findByEndYearBetween(y1, y2), HttpStatus.OK);
    }

}