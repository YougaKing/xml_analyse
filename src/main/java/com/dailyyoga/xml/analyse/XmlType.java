package com.dailyyoga.xml.analyse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlType {
    private String type;
    private List<String> fileNames;
    private long length;

    public XmlType(String type, String name) {
        this.type = type;
        this.fileNames = new ArrayList<String>();
        this.fileNames.add(name);
        length(name);
    }

    public void addFileName(String name) {
        this.fileNames.add(name);
        length(name);
    }

    private void length(String name) {
        File file = new File(name);
        length += file.length();
    }


    public int getFileSize() {
        return fileNames.size();
    }

    public long getLength() {
        return length;
    }
}
