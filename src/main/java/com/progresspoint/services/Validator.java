package com.progresspoint.services;

import com.progresspoint.dao.FileToCheckReader;
import com.progresspoint.dao.SupportedFormatListCreator;
import com.progresspoint.dao.SupportedFormatsDaoFromCSV;

import java.io.File;

public class Validator {

    private FileToCheckReader fileDao;

    private SupportedFormatListCreator listCreator;

    public Validator(String filePath, String supportedFormatsCsv) {
        this.fileDao = new FileToCheckReader(filePath);
        this.listCreator = new SupportedFormatListCreator(new SupportedFormatsDaoFromCSV(new File(supportedFormatsCsv)));
    }

    public String getFileExtension(){
        return null;
    }


}
