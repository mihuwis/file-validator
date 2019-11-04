package com.progresspoint.dao;

import com.progresspoint.model.FileData;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileToCheckReader {

    private String filePath;
    private FileData fileToCheck;

    public FileToCheckReader(String filePath) {
        this.filePath = filePath;
        this.fileToCheck = createEntityFromFileData(filePath);
    }

    private FileData createEntityFromFileData(String filePath) {
        return new FileData(
                extractExtensionFrom(filePath),
                getListOfMagicNumbers(filePath)
        );
    }

    private String extractExtensionFrom(String filePath) {
        String[] pathArr = filePath.split("\\.");
        return pathArr[pathArr.length - 1];
    }

    private List<Integer> getListOfMagicNumbers(String filePath) {
        int i;
        List<Integer> magicNumberList = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(filePath)) {
            while ((i = inputStream.read()) != -1 && magicNumberList.size() < 17) {
                magicNumberList.add(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return magicNumberList;
    }

    public FileData getFileToCheck() {
        return fileToCheck;
    }

    public String getFilePath() {
        return filePath;
    }
}
