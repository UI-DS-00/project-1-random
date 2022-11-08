package com.example.imdb.file;

import com.example.imdb.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class TSVFile {

    public static Movie[] readMovies(String fileName) throws IOException {

        String[] lines = Files.readAllLines(Path.of(fileName)).toArray(new String[0]);
        Movie[] allMovies = new Movie[lines.length - 1];

        boolean firstLine = true;
        int i = 0;

        for (String s : lines) {

            if (firstLine) {
                firstLine = false;
                continue;
            }

            String[] parts = s.split("\t");

            for (int j = 0; j < parts.length; j++)
                if (Objects.equals(parts[j], "\\N")) parts[j] = "0";

            allMovies[i++] = Movie.builder()
                    .titleId(parts[0])
                    .type(TitleType.valueOf(parts[1].toUpperCase()))
                    .title(parts[2])
                    .isAdult(Boolean.parseBoolean(parts[4]))
                    .startYear(Integer.parseInt(parts[5]))
                    .endYear(Integer.parseInt(parts[6]))
                    .runtimeMinutes(Integer.parseInt(parts[7]))
                    .genres(parts[8])
                    .build();
        }

        return allMovies;
    }

    public static Person[] readPersons(String fileName) throws IOException {

        String[] lines = Files.readAllLines(Path.of(fileName)).toArray(new String[0]);
        Person[] people = new Person[lines.length - 1];

        boolean firstLine = true;
        int i = 0;

        for (String s : lines) {

            if (firstLine) {
                firstLine = false;
                continue;
            }

            String[] parts = s.split("\t");

            for (int j = 0; j < parts.length; j++)
                if (Objects.equals(parts[j], "\\N")) parts[j] = "0";

            people[i++] = Person.builder()
                    .id(parts[0])
                    .name(parts[1])
                    .birthYear(Integer.parseInt(parts[2]))
                    .deathYear(Integer.parseInt(parts[3]))
                    .professions(parts[4])
                    .knownForTitles(parts[5])
                    .build();

            String[] titles = parts[5].split("\\,");
            for (String st: titles) {
                people[i - 1].getKnownForTitlesList().add(st);

            }

        }
        return people;
    }

    public static Rating[] readRatings(String fileName) throws IOException {

        String[] lines = Files.readAllLines(Path.of(fileName)).toArray(new String[0]);
        Rating[] ratings = new Rating[lines.length - 1];

        boolean firstLine = true;
        int i = 0;

        for (String s : lines) {

            if (firstLine) {
                firstLine = false;
                continue;
            }

            String[] parts = s.split("\t");

            for (int j = 0; j < parts.length; j++)
                if (Objects.equals(parts[j], "\\N")) parts[j] = "0";

            ratings[i++] = Rating.builder()
                    .titleId(parts[0])
                    .avgRating(Float.parseFloat(parts[1]))
                    .numVotes(Integer.parseInt(parts[2]))
                    .build();
        }

        return ratings;

    }

    public static SeriesEpisode[] readEpisodes(String fileName) throws IOException {

        String[] lines = Files.readAllLines(Path.of(fileName)).toArray(new String[0]);
        SeriesEpisode[] episodes = new SeriesEpisode[lines.length - 1];

        boolean firstLine = true;
        int i = 0;

        for (String s : lines) {

            if (firstLine) {
                firstLine = false;
                continue;
            }

            String[] parts = s.split("\t");

            for (int j = 0; j < parts.length; j++)
                if (Objects.equals(parts[j], "\\N")) parts[j] = "0";

            episodes[i++] = SeriesEpisode.builder()
                    .titleId(parts[0])
                    .parent(Movie.builder().titleId(parts[1]).build())
                    .seasonNumber(Integer.parseInt(parts[2]))
                    .episodeNumber(Integer.parseInt(parts[3]))
                    .build();
        }

        return episodes;
    }
}
