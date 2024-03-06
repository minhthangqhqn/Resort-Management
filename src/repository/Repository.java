package repository;

import java.io.File;

public interface Repository<T, C> {
    final String path = new File("src").getAbsolutePath();

    void loadFromFile(C entities);

    void writeIntoFile(C entities);
}