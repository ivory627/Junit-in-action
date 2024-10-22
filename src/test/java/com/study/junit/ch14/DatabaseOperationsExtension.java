package com.study.junit.ch14;

import com.study.junit.ch14.jdbc.ConnectionManager;
import com.study.junit.ch14.jdbc.TablesManager;
import org.junit.jupiter.api.extension.*;

import java.sql.Connection;
import java.sql.Savepoint;

// 네 가지 생애주기 인터페이스 구현
public class DatabaseOperationsExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

    private Connection connection; // 커넥션 얻기 위한 필드
    private Savepoint savepoint; // 데이터베이스 상태기록용 필드

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        connection = ConnectionManager.openConnection();
        TablesManager.dropTable(connection);
        TablesManager.createTable(connection);
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        ConnectionManager.closeConnection();
    }


    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        // 자동커밋 비활성화로 테스트에서 변경된 데이터가 커밋되는것을 막음
        connection.setAutoCommit(false);
        savepoint = connection.setSavepoint("savepoint");
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        connection.rollback(savepoint);
    }
}
