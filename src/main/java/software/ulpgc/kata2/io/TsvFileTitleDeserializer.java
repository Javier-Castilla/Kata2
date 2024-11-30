package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Title;

import java.time.Year;

public class TsvFileTitleDeserializer implements TitleDeserializer {
    @Override
    public Title deserialize(String line) {
        String[] fields = line.split("\t");
        return new Title(
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

    private Title.Genre[] getGenresArray(String field) {
        if (isNullCharacter(field)) return new Title.Genre[0];
        String[] split = field.split(",");
        Title.Genre[] genres = new Title.Genre[split.length];
        for (int i = 0; i < split.length; i++)
            genres[i] = toGenre(split[i]);
        return genres;
    }

    private Title.Genre toGenre(String string) {
        return Title.Genre.valueOf(normalizeString(string));
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

    private Title.TitleType toTitleType(String field) {
        return Title.TitleType.valueOf(normalizeString(field));
    }

    private String normalizeString(String field) {
        String result = String.valueOf(field.toUpperCase().charAt(0));
        return result + field.substring(1).replace("-", "");
    }
}
