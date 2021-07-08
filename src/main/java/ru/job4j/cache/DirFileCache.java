package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        Path dirFile;
        String result;
        if (cache.isEmpty()) {
            System.out.println("start loading init cache");
            Path filePath = Paths.get(cachingDir);
            if (filePath.toFile().isDirectory()) {
                for (String nextFileName : Objects.requireNonNull(filePath.toFile().list())) {
                    dirFile = Path.of(cachingDir + "/" + nextFileName);
                    System.out.println(dirFile);
                    try {
                        result = Files.readString(dirFile);
                        cache.put(nextFileName, new SoftReference<>(result));
                        System.out.printf("putting key: %s%n", nextFileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return cache.get(key).get();
        } else {
            dirFile = Path.of(cachingDir + "/" + key);
            try {
                result = Files.readString(dirFile);
                cache.put(key, new SoftReference<>(result));
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}