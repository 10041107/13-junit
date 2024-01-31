package com.ojiraphers.section02.lifecycle;

import org.junit.jupiter.api.*;

public class LifeCycleAnnotationTests {
    /*
    모든 테스트 메소드와 라이프 사이클 관련 메소드는 abstrect이면 안되고, void형으로 작성해야 한다.
    또한 접근 제한자는 사용하지 않아도 되지만(default),private이면 안된다.

    작동 순서
        beforeAll
        beforeEach
        test1
        afterEach
        beforeEach
        test2
        afterEach
        afterAll
     */

    @BeforeAll // 테스트를 실행시키기 전에 딱 한번 실행함
    public  static void beforeAll(){
        System.out.println("beforeAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }
    /*

    t각각의 테스트 메소드가 동작한 직후 동작한다.
    Test, RepeatTest, ParameterizedTest, testFactory가 실행된 이후 동작한다.
    주로 단위 테스트들이 수행한 이후 사용한 자원을 해체할 목적으로 사용한다.
     */
    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }
}
