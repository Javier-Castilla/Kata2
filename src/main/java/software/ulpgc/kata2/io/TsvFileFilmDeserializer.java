package software.ulpgc.kata2.io;

import org.jfree.chart.title.Title;
import software.ulpgc.kata2.model.Film;

import java.time.Year;

public class TsvFileFilmDeserializer implements FilmDeserializer {
    @Override
    public Film deserialize(String line) {
        String[] fields = line.split("\t");
        return new Film(
                fields[0],
                toTitleType(fields[1]),
                fields[2],
                fields[3],
                toBoolean(fields[4]),
                toYear(fields[5]),
                toYear(fields[6]),
                toInteger(fields[7]),
                getGenresArray(fields[8])
        );
    }

    private Film.Genre[] getGenresArray(String field) {
        if (isNullCharacter(field))return new Film.Genre[0];
        String[] split = field.split(",");
        Film.Genre[] genres = new Film.Genre[split.length];
        for (int i = 0; i < split.length; i++)
            genres[i] = toGenre(split[i]);
        return genres;
    }

    private Film.Genre toGenre(String s) {
        return Film.Genre.valueOf(normalize(s));
    }

    private Year toYear(String field) {
        return Year.of(toInteger(field));
    }

    private int toInteger(String field) {
        return isNullCharacter(field) ? 0 : Integer.parseInt(field);
    }

    private boolean isNullCharacter(String field) {
        return field.equals("\\N");
    }

    private boolean toBoolean(String field) {
        return Boolean.parseBoolean(field);
    }

    private Film.TitleType toTitleType(String field) {
        return Film.TitleType.valueOf(normalize(field));
    }

    private String normalize(String field) {
        String result = String.valueOf(field.toUpperCase().charAt(0));
        return result + field.substring(1).replace("-", "");
    }
}
