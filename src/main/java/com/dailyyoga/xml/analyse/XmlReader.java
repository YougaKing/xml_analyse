package com.dailyyoga.xml.analyse;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XmlReader {


    private static final String TAG = XmlReader.class.getName();
    private Map<String, XmlType> mXmlMap = new HashMap<String, XmlType>();
    private XmlPullParserFactory mFactory;

    public XmlReader() {
        try {
            mFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    public void analyse(File dir) throws IOException, XmlPullParserException {
        if (dir == null) return;
        if (dir.isFile()) {
            analyseFile(dir);
            return;
        }
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                analyse(file);
            } else {
                analyseFile(file);
            }
        }
    }

    public void analyseFile(File file) {
        try {
            if (!file.getName().endsWith(".xml")) return;
            XmlPullParser parser = mFactory.newPullParser();
            parser.setInput(new FileInputStream(file), "UTF-8");

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG://开始解析
                        XmlType xmlType = mXmlMap.get(nodeName);
                        if (xmlType == null) {
                            xmlType = new XmlType(nodeName, file.getAbsolutePath());
                            mXmlMap.put(nodeName, xmlType);
                        } else {
                            xmlType.addFileName(file.getAbsolutePath());
                        }
                        return;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            System.out.println(TAG + "--file:" + file.getAbsolutePath());
            e.printStackTrace();
        }
    }

    public void println() {
        for (String key : mXmlMap.keySet()) {
            System.out.println(TAG + "--" + key + ":" + mXmlMap.get(key).getFileSize());
        }
    }
}
