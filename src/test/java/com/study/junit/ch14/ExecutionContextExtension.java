package com.study.junit.ch14;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;
import java.util.Properties;

public class ExecutionContextExtension implements ExecutionCondition { // 조건부 테스트 실행 extension 생성

    // 메서드 재정의를 통해 테스트를 활성화할지 말지 결정하는 ConditionEvaluationResult 객체 반환
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {

        Properties properties = new Properties();
        String executionContext = "";

        try {
            properties.load(ExecutionContextExtension.class.getClassLoader()
                    .getResourceAsStream("context.properties"));
            executionContext = properties.getProperty("context");

            if(!"regular".equalsIgnoreCase(executionContext) &&
               !"low".equalsIgnoreCase(executionContext)) {
                return ConditionEvaluationResult.disabled(
                        "Test disabled outside regular and low contexts"
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ConditionEvaluationResult.enabled("Test enabled on the " +  executionContext + " context");
    }
}
