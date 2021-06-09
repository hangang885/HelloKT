package com.gill.but.hellokt


/*자료형과 변수
*   자료형
*       Int 정수  1, 2, 3
*       String  문자열 "Hello123"
*       Float   실수  1.2
*       ...
*
*   변수
*       val(value) - 불변형 (immutable) 값을 바꿀수 없음
*       var(variable) - 가변형 (mutable) 값을 바꿀수 있음
*   변수의 선언
*       val username: String = "Hangang"
*    선언키워드  변수이름    자료형 값
*
*
* */
fun main() {

    //val username: String = "Hangang"
    //username = "Dooly" 이부분은 에러가뜬다 불변형 변수이기에 초기화가 안된다
    var username: String = "Hangang"
    username = "Dooly"
    var username2: String
    username2 = "Test"
    var count: Int = 3
    //컴파일러가 알 수 있는 타입은 자료형을 명시하지 않아도 추론해서 실행된다



    println("username: $username, count: $count")

}
/*변수 선언
*   변수 선언 예
*       var username = "Kildong" // 자료형을 추론하여 String으로 결정
*       var username: // 자료형을 지정하지 않은 변수는 사용할 수 없다
*       var init: Int // 사용 전 혹은 생성자 시점에서 init변수를 초기화 해야함
*       var number = 10 // number 변수는 Int형으로 추론
*
* 변수 이름
*   변수 이름은 123abc와 같이 숫자로 시작하면 안된다
*   변수 이름에는 while, if와 같이 코틀린에서 사용되는 키워드는 사용할 수없다
*   변수 이름은 의미 있는 단어를 사용하여 만드는 것이 좋다
*   여러 단어를 사용하여 변수 이름을 지을 경우 카멜 표기법(Camel Expression)을 사용하세요
*
*  일반 변수, 함수명 등(단봉 낙타와 같은 카멜 표기법)
*       camelCase
*       numberOfBooks
*       myFirstNumber
*   클래스, 인터페이스 등 (쌍봉 낙타 혹은 파스칼 표기법)
*       AnimalCategory
*       CarEngine
*
* 자료형
*   기본형(Primitive data type)
*       가공되지 않은 순수한 자료형으로 프로그래밍 언어에 내장
*       int, long, float, double 등
*   참조형(Reference type)
*       동적 공간에 데이터를 둔 다음 이것을 참조하는 자료형
*       Int, Long, Float, Double 등
*
*   기본형과 참조형의 동작 원리 이해하기
*       자바의 기본형과 참조형의 원리
*           int a= 77; // 기본형
*           Person person = new Person(); // 객체 참조형으로 person 객체를 위해 참조 주소 (A12)를 가진다
*
*
* * */