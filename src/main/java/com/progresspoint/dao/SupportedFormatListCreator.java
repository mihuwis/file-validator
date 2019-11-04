package com.progresspoint.dao;

import com.progresspoint.model.FileData;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class SupportedFormatListCreator {

    private SupportedFormatsDao supportedFormatsDao;
    private File path;

    public SupportedFormatListCreator(SupportedFormatsDao supportedFormatsDao) {
        this.supportedFormatsDao = supportedFormatsDao;
        this.path = supportedFormatsDao.getPath();
    }

    public List<FileData> createListOfSupportedFiles() {
        List<List<String>> data = supportedFormatsDao.getListOfSupportedFormats(path);
        return data.stream()
                .map(list -> new FileData(list.get(0), createListOfMagicNumbers(list))).collect(Collectors.toList());
    }

    private List<Integer> createListOfMagicNumbers(List<String> listToConvert) {
        return listToConvert.stream()
                .filter(item -> item.matches("-?\\d+(\\.\\d+)?"))
                .map(Integer::parseInt).collect(Collectors.toList());
    }
}
