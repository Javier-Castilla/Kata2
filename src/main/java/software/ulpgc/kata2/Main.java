package software.ulpgc.kata2;

import software.ulpgc.kata2.io.DatasetDownloader;
import software.ulpgc.kata2.io.TsvFileTitleDeserializer;
import software.ulpgc.kata2.io.TsvFileTitleReader;
import software.ulpgc.kata2.model.Title;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File file = new File(DatasetDownloader.checkFile());
        List<Title> titles = new TsvFileTitleReader(file, new TsvFileTitleDeserializer()).read();
        Map<Title.TitleType, Long> hist = titles.stream()
                .collect(
                        Collectors.groupingBy(
                                Title::titleType,
                                Collectors.counting()
                        )
                );
        hist.entrySet().forEach(System.out::println);
    }
}
