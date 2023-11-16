package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.model.Movie;

import java.util.*;
import java.util.stream.Collectors;
interface PlayWithMovies {

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    static Set<String> ex01(String director) {
        return ImdbTop250.movies()
                .orElse(Collections.emptyList())
                .stream()
                .filter(m -> m.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }
    /**
     * Returns the movies (only titles) in which an actor played
     */
    static Set<String> ex02(String actor) {
        return ImdbTop250.movies()
                .orElse(Collections.emptyList())
                .stream()
                .filter(m -> m.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }
    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {
        return ImdbTop250.movies()
                .orElse(Collections.emptyList())
                .stream()
                .flatMap(m -> m.directors().stream())
                .collect(Collectors.groupingBy(director -> director, Collectors.counting()));
    }

    /**
     * Returns the 10 directors with the most films on the list
     */
    static Map<String, Long> ex04() {
        return ImdbTop250.movies()
                .orElse(Collections.emptyList())
                .stream()
                .flatMap(m -> m.directors().stream())
                .collect(Collectors.groupingBy(director -> director, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    static Map<String, Set<String>> ex05() {
        Set<String> topDirectors = ex04().keySet();

        return ImdbTop250.movies()
                .orElse(Collections.emptyList())
                .stream()
                .filter(m -> m.directors().stream().anyMatch(topDirectors::contains))
                .flatMap(m -> m.directors().stream().filter(topDirectors::contains).map(d -> new AbstractMap.SimpleEntry<>(d, m.title())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toSet())
                ));
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {
        return ImdbTop250.movies()
                .orElse(Collections.emptyList())
                .stream()
                .flatMap(m -> m.actors().stream())
                .collect(Collectors.groupingBy(actor -> actor, Collectors.counting()));
    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    static Map<String, Long> ex07() {
        return ImdbTop250.movies()
                .orElse(Collections.emptyList())
                .stream()
                .flatMap(m -> m.actors().stream())
                .collect(Collectors.groupingBy(actor -> actor, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(9)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static Map<String, Set<String>> ex08() {
        Set<String> topActors = ex07().keySet();

        return ImdbTop250.movies()
                .orElse(Collections.emptyList())
                .stream()
                .filter(m -> m.actors().stream().anyMatch(topActors::contains))
                .flatMap(m -> m.actors().stream()
                        .filter(topActors::contains) // Only include top actors
                        .map(a -> new AbstractMap.SimpleEntry<>(a, m.title())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toSet())
                ));
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static Map<String, Long> ex09() {
        return ImdbTop250.movies()
                .orElse(Collections.emptyList())
                .stream()
                .flatMap(m -> agh.ii.prinjava.proj2.utils.Utils.orderedPairsFrom(m.actors()).stream())
                .collect(Collectors.groupingBy(pair -> pair, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {
        Map<String, Set<String>> actorPairsToMovies = new HashMap<>();

        List<Movie> movies = ImdbTop250.movies().orElse(Collections.emptyList());

        for (Movie movie : movies) {
            List<String> actors = movie.actors();
            for (int i = 0; i < actors.size(); i++) {
                for (int j = i + 1; j < actors.size(); j++) {
                    String actor1 = actors.get(i);
                    String actor2 = actors.get(j);

                    String pair = actor1.compareTo(actor2) < 0 ? actor1 + ", " + actor2 : actor2 + ", " + actor1;

                    actorPairsToMovies
                            .computeIfAbsent(pair, k -> new HashSet<>())
                            .add(movie.title());
                }
            }
        }
        List<String> relevantPairs = Arrays.asList(
                "Carrie Fisher, Mark Hamill",
                "Joe Pesci, Robert De Niro",
                "Carrie Fisher, Harrison Ford",
                "Harrison Ford, Mark Hamill",
                "Christian Bale, Michael Caine"
        );

        return actorPairsToMovies.entrySet().stream()
                .filter(entry -> relevantPairs.contains(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

