package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.util.Objects;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String dirFile;
        if (cache.isEmpty()) {
            System.out.println("start loading init cache");
            File file = new File(cachingDir);
            if (file.isDirectory()) {
                for (String nextFileName : Objects.requireNonNull(file.list())) {
                    dirFile = cachingDir + "/" + nextFileName;
                    System.out.println(dirFile);
                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(dirFile)))) {
                        StringBuilder rsl = new StringBuilder();
                        String buff;
                        while ((buff = br.readLine()) != null) {
                            rsl.append(buff);
                            rsl.append(" ");
                        }
                        cache.put(nextFileName, new SoftReference<>(rsl.toString()));
                        System.out.printf("putting key: %s%n", nextFileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return cache.get(key).get();
        } else {
            dirFile = cachingDir + "/" + key;
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(dirFile)))) {
                StringBuilder rsl = new StringBuilder();
                String buff;
                while ((buff = br.readLine()) != null) {
                    rsl.append(buff);
                    rsl.append(" ");
                }
                cache.put(key, new SoftReference<>(rsl.toString()));
                return rsl.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
