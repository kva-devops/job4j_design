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
        dirFile = Path.of(cachingDir + "/" + key);
        try {
            result = Files.readString(dirFile);
            cache.put(key, new SoftReference<>(result));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}