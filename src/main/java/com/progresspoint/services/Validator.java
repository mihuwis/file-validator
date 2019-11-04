package com.progresspoint.services;

import com.progresspoint.dao.FileToCheckReader;
import com.progresspoint.dao.SupportedFormatListCreator;
import com.progresspoint.dao.SupportedFormatsDaoFromCSV;
import com.progresspoint.model.FileData;

import java.io.File;
import java.util.List;
import java.util.stream.IntStream;

public class Validator {

    private FileToCheckReader fileDao;

    private SupportedFormatListCreator listCreator;

    public Validator(String filePath, String supportedFormatsFilePath) {
        this.fileDao = new FileToCheckReader(filePath);
        this.listCreator = new SupportedFormatListCreator(
                new SupportedFormatsDaoFromCSV(new File(supportedFormatsFilePath)));
    }

    public String getFileExtension(){
        FileData fileToCheck = fileDao.getFileToCheck();
        List<FileData> fileDataList = listCreator.createListOfSupportedFiles();

        for(FileData fileData: fileDataList){
            if(fileData.getExtension().equals(fileToCheck.getExtension())
                    && areListsEquals(fileToCheck.getMagicNumbers(), fileData.getMagicNumbers())){
                return fileToCheck.getExtension();
            }
            if(areListsEquals(fileToCheck.getMagicNumbers(), fileData.getMagicNumbers())){
                return fileData.getExtension();
            }
        }
        throw new RuntimeException("No such file support");
    }

    private boolean areListsEquals(List<Integer> fileToCheck, List<Integer> supportedFormatsMagicNumbersList){
        long matchingMagicNumbers = IntStream
                .range(0, supportedFormatsMagicNumbersList.size())
                .filter(x -> fileToCheck.get(x).equals(supportedFormatsMagicNumbersList.get(x))).count();
        return matchingMagicNumbers == (long) supportedFormatsMagicNumbersList.size();
    }


}
