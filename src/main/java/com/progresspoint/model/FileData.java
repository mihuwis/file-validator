package com.progresspoint.model;

import java.util.List;
import java.util.Objects;

public class FileData {

    private final String extension;
    private final List<Integer> magicNumbers;

    public FileData(String extension, List<Integer> magicNumbers) {
        this.extension = extension;
        this.magicNumbers = magicNumbers;
    }

    public String getExtension() {
        return extension;
    }

    public List<Integer> getMagicNumbers() {
        return magicNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return extension.equals(fileData.extension) &&
                magicNumbers.equals(fileData.magicNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extension, magicNumbers);
    }

    @Override
    public String toString() {
        return "FileData{" +
                "extension='" + extension + '\'' +
                ", magicNumbers=" + magicNumbers +
                '}';
    }
}
