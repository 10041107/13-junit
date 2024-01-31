package com.ojiraphers.section05.custom;

public class CustomAnnotationTests {

    @WindowsTests // 커스텀된 어노테이션이 적용됨
    public void testOwnWindowsOs(){

    }

    @DevelopmentTest
    public void testDevelopmentCustomTag(){

    }

    @ProductionTests
    public void testProductCustomTag(){}


}
