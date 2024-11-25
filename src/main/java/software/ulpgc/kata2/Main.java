package software.ulpgc.kata2;

import software.ulpgc.kata2.io.TsvFileFilmDeserializer;
import software.ulpgc.kata2.io.TsvFileFilmReader;
import software.ulpgc.kata2.model.Film;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File file = new File("data/title.basics.tsv");
        List<Film> films = new TsvFileFilmReader(file, new TsvFileFilmDeserializer()).read();
        Map<Film.Genre, Integer> histogram = new HashMap<>();
        for (Film film : films)
            for (Film.Genre genre : film.genres())
                histogram.put(genre, histogram.getOrDefault(genre, 0) + 1);

        for (Film.Genre genre : histogram.keySet())
            System.out.println(genre + " " + histogram.get(genre));
    }
}
