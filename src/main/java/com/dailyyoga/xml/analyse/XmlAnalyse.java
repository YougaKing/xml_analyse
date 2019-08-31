package com.dailyyoga.xml.analyse;

import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.IOException;

public class XmlAnalyse {

    public static void main(String[] args) {

        File dir  =new File("D:\\StudioProjects\\android_h2\\dailyyoga\\yoga_h2\\src\\main\\res\\drawable");
        XmlReader reader = new XmlReader();

        try {
            reader.analyse(dir);
            reader.println();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
