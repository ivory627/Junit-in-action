package com.study.junit.ch08;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.imposters.ByteBuddyClassImposteriser;
import org.jmock.junit5.JUnit5Mockery;
import org.junit.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestWebClientJMock {

    // JMock 확장 등록
    @RegisterExtension
    Mockery context = new JUnit5Mockery() {
        { // JMock에서 인터페이스가 아닌 클래스에 대한 모의 객체를 생성해야할 때 imposteriser 속성을 정의해야한다.
            setImposteriser(ByteBuddyClassImposteriser.INSTANCE);
        }
    };

    @Test
    public void testGetContentOk() throws Exception {
        ConnectionFactory factory = context.mock(ConnectionFactory.class);
        InputStream mockStream = context.mock(InputStream.class);

        context.checking(new Expectations(){
            {
                oneOf(factory).getData();
                will(returnValue(mockStream));

                atLeast(1).of(mockStream).read();
                will(onConsecutiveCalls(
                        returnValue(Integer.valueOf((byte)'W')),
                        returnValue(Integer.valueOf((byte)'o')),
                        returnValue(Integer.valueOf((byte)'r')),
                        returnValue(Integer.valueOf((byte)'k')),
                        returnValue(Integer.valueOf((byte)'s')),
                        returnValue(Integer.valueOf((byte)'!')), returnValue(-1)));

                oneOf(mockStream).close();
            }
        });

        WebClient2 client = new WebClient2();
        String workingContent = client.getContent(factory);
        assertEquals("Works!", workingContent);
    }

    @Test
    public void testGetContentCannotCloseInputStream() throws Exception {
        ConnectionFactory factory = context.mock(ConnectionFactory.class);
        InputStream mockStream =  context.mock(InputStream.class);

        context.checking(new Expectations(){
            {
                oneOf(factory).getData();
                will(returnValue(mockStream));
                oneOf(mockStream).read();
                will(returnValue(-1));
                oneOf(mockStream).close();
                will(throwException(new IOException("cannot close")));
            }
        });

        WebClient2 client = new WebClient2();
        String workingContent = client.getContent(factory);

        assertNull(workingContent);
    }
}
