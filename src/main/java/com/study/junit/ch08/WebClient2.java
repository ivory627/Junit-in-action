package com.study.junit.ch08;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClient2 {
    public String getContent(ConnectionFactory connectionFactory) {

        String workingcontent;
        StringBuffer content = new StringBuffer();

        try (InputStream is = connectionFactory.getData()) {
            int count;
            while (-1 != (count = is.read())) {
                content.append(new String(Character.toChars(count)));
            }
            workingcontent = content.toString();
        } catch (Exception e) {
            workingcontent = null;
        }

        return workingcontent;
    }
}
