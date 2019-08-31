package com.dailyyoga.xml.analyse;

import java.util.ArrayList;
import java.util.List;

public class XmlType {
    private String type;
    private List<String> fileNames;

    public XmlType(String type, String name) {
        this.type = type;
        this.fileNames = new ArrayList<String>();
        this.fileNames.add(name);
    }

    public void addFileName(String name) {
        this.fileNames.add(name);
    }

    public int getFileSize() {
        return fileNames.size();
    }
}
