package software.ulpgc.kata2.model;

import java.time.Year;

public record Film(String id, TitleType titleType, String primaryTitle, String originalString, boolean isAdult, Year startYear, Year endYear, int runtimeMinutes, Genre[] genres) {
    public enum TitleType {
        VideoGame,
        TvPilot,
        Movie,
        TvSeries,
        TvMiniSeries,
        Short,
        TvSpecial,
        TvShort,
        Video,
        TvMovie,
        TvEpisode
    }

    public enum Genre {
        Action,
        Adult,
        Adventure,
        Animation,
        Biography,
        Comedy,
        Crime,
        Documentary,
        Drama,
        Family,
        Fantasy,
        FilmNoir,
        GameShow,
        History,
        Horror,
        Music,
        Musical,
        Mystery,
        News,
        RealityTV,
        Romance,
        SciFi,
        Short,
        Sport,
        TalkShow,
        Thriller,
        War,
        Western
    }
}
