package com.solvd.wearshopproject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Function;

public class WordCount {

    private static final Logger LOGGER = LogManager.getLogger();

    private File file;
    private File resultFile = new File("result.txt");

    public WordCount(String textPath) {
        this.file = FileUtils.getFile(textPath);
    }

    public void calculateWords(Function<String, String> data,Function<Map<String, Integer>, Map<String, Integer>> result) throws IOException {
        List<String> list;
        Set<String> set;
        Map<String, Integer> resultMap = new TreeMap<>();
        String uncleanData = StringUtils.lowerCase(String.valueOf(FileUtils.readLines(file, Charset.defaultCharset())));
        String finalData = data.apply(uncleanData);

        set = new TreeSet<>(Arrays.asList(finalData.split(" ")));
        list = new ArrayList<>(set);

        list.forEach(i -> {
            LOGGER.debug(i + ":" + StringUtils.countMatches(finalData, i + " "));
            resultMap.put(i, StringUtils.countMatches(finalData, i + " "));
        });

        FileUtils.writeLines(resultFile, Collections.singleton(result.toString()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCount wordCount = (WordCount) o;
        return Objects.equals(file, wordCount.file) && Objects.equals(resultFile, wordCount.resultFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, resultFile);
    }
}
