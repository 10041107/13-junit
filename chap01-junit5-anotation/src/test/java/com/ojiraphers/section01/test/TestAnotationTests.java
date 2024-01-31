package com.ojiraphers.section01.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

public class TestAnotationTests {

    /*

    junit platform
    - jvm에서 테스트 프레임웤르르 슬행하기 위한 테스트 엔진을 제공한다.
    2.junit Jumper
    - junit5에서 테스트를 작성하고 실해앟기 위한 엔진을 제공한다.
    3. junit vintage
    -junit3,4를 기반으로 돌아가는 테스트 엔진을 제공해 준다.

    테스트 클래스는 적어도 한개 이상의 @Test어노테이션이 달린 메소드를 가진 클래스이다.
    테스트 클래스는 abstract면 안되고, 한개의 생성자를 가지고 있어야 한다.
    (두 개 이상 작성하면 런타임 시 PreconditionViollationExcaption이 발생한다.
    아무런 생성자도 작성하지 않으면 기본 생성자는 컴파일러가 자동으로 추가한다.
     */

    public TestAnotationTests(){}
    /*

    기본적인 테스트 메소드를 만들기 위해 사용하는 어노테이션이다.
    @Test메소드는 단독으로 실행이 가능하다.

     */
    @Test
    @DisplayName("테스트 메소드")
    public void  testMethod(){

    }

    @Test
    @DisplayName("displayname우선순위 테스트")
    public void 테스트_메소드2(){
        /*
        클래스 레벨 @DisplayNameGenerator를 붙이게 되면 언더바를 공백으로 처리하여 텍스트 이름을 부여해준다.
        단, @Display과 중복 작성 시에는 DisplayName에 부여한 테스트 이름의 우선권을 가진다.
         */
    }

}
