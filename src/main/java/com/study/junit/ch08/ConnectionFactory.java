package com.study.junit.ch08;

import java.io.InputStream;

public interface ConnectionFactory {
    InputStream getData() throws Exception;
}
