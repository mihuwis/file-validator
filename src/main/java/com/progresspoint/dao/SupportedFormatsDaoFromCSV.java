package com.progresspoint.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SupportedFormatsDaoFromCSV implements SupportedFormatsDao {

    private final File path;

    public SupportedFormatsDaoFromCSV(File path) {
        this.path = path;
    }

    @Override
    public List<List<String>> getListOfSupportedFormats(File path) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("No such file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    @Override
    public File getPath() {
        return path;
    }
}
