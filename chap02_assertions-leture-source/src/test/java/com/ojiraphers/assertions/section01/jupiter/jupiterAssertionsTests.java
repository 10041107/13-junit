package com.ojiraphers.assertions.section01.jupiter;

import com.ojiraphers.assertions.section02.member.Member;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class jupiterAssertionsTests {
    /*
    junit jupiter는 junit4로부터 온 assrtion메소드와 새롭게 자바 8 람다 표현식으로 추가한 메소드를 제공한다.
    모든 jupiter assertions의 메소드는 정적(static)메소드 형태로 제공하고 있다.

    테스트 코드의 기본 구조
    given: 테스트 시 필요한 파라미터를 준비한다.
    when:테스트 할 메소드를 호출한다.
    then: 실행 결과를 검증
     */

    @Test
    @DisplayName("더하기 기능 테스트")
    void testAssertEquals(){
        // given단계
        int firstNum = 10;
        int secondNum = 20;
        int expected = 30;

        //when단계
        Calculator caculator = new Calculator();
        int result = caculator.plusTwoNumbers(firstNum,secondNum);
        
        //then단계
//        Assertions.assertEquals(expected, result);

        //실패 시 호출할 메세지
//        Assertions.assertEquals(expected, result, "실패하는 경우 이게 보임");

//        //오차의 허용 범위를 지정할 수 있다.
//        Assertions.assertEquals(expected, result, 1);
//
//        // 람다 표현식을 이용한 결과는 동일하지만 불필요한 경우 메세지를 만들지 않도록 자연로딩을 이용한다.
//        Assertions.assertEquals(expected, result, () -> "실패할 때 보여줄 메세지");

    }

    @Test
    @DisplayName("인스턴스 동일성 비교 테스트")
    void testAssertNotEqualWithInstances(){
        ///given + when
        Object obj1 = new Object();
        Object obj2 = new Object();

        //then
        Assertions.assertNotEquals(obj1,obj2);
    }
    //assertNull(actual)메소드는 레퍼런스 변수가 null값을 가지는지를 판단한다.
    @Test
    @DisplayName("null인지 테스트")
    void testAssertNull(){
        //given
        String str;
        //when
        str = null;

        //then
        Assertions.assertNull(str);
    }

    @Test
    @DisplayName("두 값이 같은지 확인")
    void testAssertTrue(){
        int num1 = 10;
        int num2 = 10;

        boolean result = num1==num2;

        //Assertions.assertTrue(result);
//        Assertions.assertEquals(result,num2 == num1);
        Assertions.assertFalse(result);
    }
    @Test
    @DisplayName("동시에 여러가지 값에 대한 검증을 수행하는 경우 테스트")
    void testAssertAll(){
        String firstName = "길동";
        String lastName = "홍";

        Person person = new Person(firstName, lastName);

        Assertions.assertAll(
                () -> Assertions.assertEquals(firstName, person.getFirstName(),"first name이 검증됨"),
                () -> Assertions.assertNotEquals(lastName, person.getLastName(), "lastname이 잘못됨")
        );
    }
    @Test
    @DisplayName("인스턴스의 타입에 대한 검증을 수행하는 경우")
    void testAssertType(){
        // given: 테스트시 필요한 파라미터를 준비한다.
        String firstName = "길동";
        String lastName = "홍";

        // when: 테스트할 클래스를 준비한다.
        Person person = new Person(firstName,lastName);

        // then: 검증하는 로직
        Assertions.assertInstanceOf(Person.class, person);
        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(Person.class, person),
                () -> Assertions.assertEquals(firstName, person.getFirstName()),
                () -> Assertions.assertEquals(lastName, person.getLastName())
        );
    }

    /*
    assertDoseNotThrow(excution)메소드 호출히 아무런 예외가 발생하지 않는지 확인
     */
    @Test
    @DisplayName("void메소드의 경우 exception발생 없이 정상적으로 동작하는지 테스트")
    void testAssertDoesNotThrow(){
        // given
        int firstNum = 10;
        int secondNum = 3;
        //when+then
        PositiveNumberValidator validator = new PositiveNumberValidator();
        Assertions.assertDoesNotThrow(() -> validator.checkDividableNumbers(firstNum,secondNum));
    }

    @Test
    @DisplayName("void 메소드의 경우 exception발생하는지 테스트")
    void testAssertThrows(){
        //given
        int firstNum = 10;
        int secondNum = 1;
        String exceptedErrorMessage = "0으로 나눌 수 없습니다.";

        //when + then
//        PositiveNumberValidator validator = new PositiveNumberValidator();
//        Assertions.assertThrows(
//                IllegalAccessException.class,
//                () -> validator.checkDividableNumbers(firstNum,secondNum),
//                exceptedErrorMessage
//        );

        //when
        PositiveNumberValidator validator = new PositiveNumberValidator();
        Exception exception = Assertions.assertThrows(Exception.class,
                () -> validator.checkDividableNumbers(firstNum,secondNum)
                );
        System.out.println(exception);
        //then
        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(PositiveNumberValidator.class, validator), // 클래스비교
                ()-> Assertions.assertInstanceOf(IllegalArgumentException.class, exception), //예외 비교
                () -> Assertions.assertDoesNotThrow(() -> validator.checkDividableNumbers(secondNum, firstNum)), // 오류가 없는지 비교
                () -> Assertions.assertEquals(exceptedErrorMessage, exception.getMessage())


        );
    }

    @Test
    @DisplayName("예상 목록이 실제 목록과 일치하지 않는지 확인")
    void testAssertLineMatch(){
        List<String> expected = Arrays.asList("java", "database", "spring");

        //when
        List<String> actual = Arrays.asList("java", "database", "spring");

        //then
        Assertions.assertLinesMatch(expected, actual, () ->"두 리스트의 값이 일치하지 않음");
    }



}