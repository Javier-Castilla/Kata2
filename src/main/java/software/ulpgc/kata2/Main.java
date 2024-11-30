package software.ulpgc.kata2;

import software.ulpgc.kata2.io.TsvFileTitleDeserializer;
import software.ulpgc.kata2.io.TsvFileTitleReader;
import software.ulpgc.kata2.model.Title;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("data/title.basics.tsv");
        List<Title> titles = new TsvFileTitleReader(file, new TsvFileTitleDeserializer()).read();
        titles.forEach(System.out::println);
    }
}
