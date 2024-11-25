package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Film;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvFileFilmReader implements FilmReader {
    private final File file;
    private final FilmDeserializer deserializer;

    public TsvFileFilmReader(File file, FilmDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public List<Film> read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            return readWith(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Film> readWith(BufferedReader reader) throws IOException {
        String line;
        List<Film> films = new ArrayList<>();
        while ((line = reader.readLine()) != null)
            films.add(deserializer.deserialize(line));
        return films;
    }
}
