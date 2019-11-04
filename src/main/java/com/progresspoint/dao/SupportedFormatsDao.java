package com.progresspoint.dao;

import java.io.File;
import java.util.List;

public interface SupportedFormatsDao {

    List<List<String>> getListOfSupportedFormats(File path);

    File getPath();
}
