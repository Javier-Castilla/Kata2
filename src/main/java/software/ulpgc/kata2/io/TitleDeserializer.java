package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Title;

public interface TitleDeserializer {
    Title deserialize(String line);
}
