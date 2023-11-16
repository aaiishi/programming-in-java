package agh.ii.prinjava.proj2.dal;

import agh.ii.prinjava.proj2.model.Movie;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The {@code ImdbTop250} interface provides access to movie data from the IMDb Top 250 list.
 * It defines a method to retrieve a list of {@link Movie} objects from a CSV data source.
 */
public interface ImdbTop250 {

    /**
     * Reads movie data from a CSV file and returns an {@link Optional} containing an immutable list of {@link Movie} objects.
     * It skips the first line of the CSV assuming it to be header information.
     *
     * @return an {@code Optional<List<Movie>>} which contains an unmodifiable list of movies if read successfully,
     *         or an empty {@code Optional} if an {@link IOException} occurs
     */
    static Optional<List<Movie>> movies() {
        try (Stream<String> lines = Files.lines(Path.of("datasources/imdb_top250.csv"))) {
            return Optional.of(
                    lines.skip(1) // Skips the CSV header
                            .map(Movie::of) // Converts each CSV line into a Movie object
                            .collect(Collectors.collectingAndThen(
                                    Collectors.toList(), // Collects to a List
                                    Collections::unmodifiableList // Converts to an unmodifiable List
                            ))
            );
        } catch (IOException e) {
            e.printStackTrace(); // Exception handling, prints the stack trace
        }
        return Optional.empty(); // Returns an empty Optional in case of exception
    }
}
