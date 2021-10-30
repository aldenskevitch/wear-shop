package com.solvd.wearshopproject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class WordCount {

    private static final Logger LOGGER = LogManager.getLogger();

    private File file;
    private File resultFile = new File("result.txt");

    public WordCount(String textPath) {
        this.file = FileUtils.getFile(textPath);
    }

    public void calculateWords() throws IOException {
        List<String> list;
        Set<String> set;
        TreeMap<String, Integer> resultMap = new TreeMap<>();
        Map<String, Integer> result = new LinkedHashMap<>();
        String data = StringUtils.lowerCase(String.valueOf(FileUtils.readLines(file, Charset.defaultCharset())));

        data = data.replaceAll(",", "");
        data = data.replaceAll("\\.", "");
        data = data.replaceAll(";", "");
        data = data.replaceAll(":", "");
        data = data.replaceAll("\\(", "");
        data = data.replaceAll("\\)", "");
        data = data.replaceAll("\"", "");
        data = data.replaceAll("\\[", "");
        data = data.replaceAll("]", "");
        data = data.replaceAll(" - ", "");
        data = data.replaceAll(" &", "");

        set = new TreeSet<>(Arrays.asList(data.split(" ")));
        list = new ArrayList<>(set);

        String finalData = data;
        list.forEach(i -> {
            LOGGER.debug(i + ":" + StringUtils.countMatches(finalData, i + " "));
            resultMap.put(i, StringUtils.countMatches(finalData, i + " "));
        });

        resultMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .forEach(e -> result.put(e.getKey(), e.getValue()));

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
