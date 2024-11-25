package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Film;

public interface FilmDeserializer {
    Film deserialize(String line);
}
