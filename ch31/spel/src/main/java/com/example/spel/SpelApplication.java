package com.example.spel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpelApplication {

    public static void main(String[] args) {
        spelTest1();
        spelTest2();
        spelTest3();
        spelTest4();
        spelTest5();
        spelTest6();
        spelTest7();
        spelTest8();
        spelTest9();
        spelTest10();
        SpringApplication.run(SpelApplication.class, args);
    }

    private static void spelTest1() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("'Hello World'");
        String value = (String) expression.getValue();
        System.out.println(value);
    }

    private static void spelTest2() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("'Hello World'.concat('!')");
        String value = expression.getValue(String.class);
        System.out.println(value);
    }

    private static void spelTest3() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) expression.getValue();
        System.out.println(Arrays.toString(bytes));
    }

    private static void spelTest4() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("'Hello World'.bytes.length");
        Integer value = (Integer) expression.getValue();
        System.out.println(value);
    }

    private static void spelTest5() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("new String('Hello World').toUpperCase()");
        String value = (String) expression.getValue();
        System.out.println(value);
    }

    @Data
    @AllArgsConstructor
    private static class Person {
        private String name;
        private Integer age;
        private Address address;

        @Override
        public String toString() {
            return "%s, %d years old, from %s.".formatted(name, age, address.getCountry());
        }
    }

    @Data
    @AllArgsConstructor
    private static class Address {
        private String country;
        private String city;
    }

    private static void spelTest6() {
        Person person = new Person("icexmoon", 20, new Address("China", "NanJin"));
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("name");
        String name = (String) expression.getValue(person);
        System.out.println(name);
        expression = expressionParser.parseExpression("address.country");
        String country = (String) expression.getValue(person);
        System.out.println(country);
        expression = expressionParser.parseExpression("toString()");
        String personText = (String) expression.getValue(person);
        System.out.println(personText);
    }

    private static void spelTest7() {
        Person person = new Person("icexmoon", 20, new Address("China", "NanJin"));
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("age == 20");
        Boolean result = expression.getValue(person, Boolean.class);
        System.out.println(result);
    }

    @Setter
    @Getter
    private static class MyList {
        private List<Boolean> list = new ArrayList<>();
    }

    private static void spelTest8() {
        EvaluationContext evaluationContext = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        MyList myList = new MyList();
        myList.list.add(0, false);
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("list[0]");
        expression.setValue(evaluationContext, myList, "true");
        System.out.println(myList.list.get(0));
    }

    private static void spelTest9(){
        SpelParserConfiguration spelParserConfiguration = new SpelParserConfiguration(true, true);
        MyList myList = new MyList();
        SpelExpressionParser expressionParser = new SpelExpressionParser(spelParserConfiguration);
        Expression expression = expressionParser.parseExpression("list[2]");
        expression.setValue(myList, true);
        System.out.println(myList.list);
    }

    private static void spelTest10(){
        SpelParserConfiguration spelParserConfiguration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, null);
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser(spelParserConfiguration);
        Expression expression = spelExpressionParser.parseExpression("'hello'");
        expression.getValue(String.class);
    }
}
