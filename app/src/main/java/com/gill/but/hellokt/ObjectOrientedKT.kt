package com.gill.but.hellokt


/*
* 객체지향형(Object Oriented)
*   절차식 - > 구조적 프로그래밍
*       구조식 -> 클래스 및 객체
*           실세계를 모방한 기법!
*
*
* 객체 지향 프로그래밍
*   OOP; (Object-Oriented Programming)
*       프로그램의 구조를 객체 간 상호작용으로서 표현한느 프로그래밍 방식
*       절차적 프로그래밍의 한계를 극복하고자 나온 언어의 한 가지 방법론
*       객체와 관계를 표현하고 이를 통해 확장과 재사용이 용이
*   자바, 코틀린에서는 OOP 를 지원
*
* 객체지향의 기본 용어
*   객체지향 개념상의 용어들
*       추상화(abstraction)
*       인스턴스(instance)
*       상속(inheritance)
*       다형성(polymorphism)
*       캡슐화(encapsulation)
*       메시지 전송(message sending)
*       연관(association)
*
* 클래스와 추상화
*   클래스(Class)란
*       분류, 계층, 등급 등의 우리말 뜻
*       특정 대상을 분류하고 특징(속성)과 동작 활동(함수) 내용을 기록
*
*   추상화(Abstraction)
*       목표를 하는 것에 대해 필요한 속성과 동작을 정의하는 과정
*
* 객체지향 개념의 동의어들
*   객체지향 개념상의 용어가 언어마다 약간씩 다르다
*       코틀린에서 사용하는 언어   그밖에 용어
*       클래스(Class)              분류, 범주
*       프로퍼티(Property)         속성, 변수, 필드, 데이터
*       메서드(Method)             함수, 동작, 행동
*       객체(Object)               인스턴스
*
*   자바에서 사용하는 필드는 코틀린에서 프로퍼티로 부른다
*
* 클래스
*   클래스 다이어그램
*       클래스를 시각적으로 나타내 분석과 개념 구현에 용이
*               Bird        클래스명
*
*           name:String
*           wing:Int =2     속성(필드, 프로퍼티)
*           beak:String
*           color:String
*
*           fly():Unit          함수(메서드,오퍼레이션)
*           sing(vol: Int):Unit
*
* */
/*

class Car{
    val wheel: Int =4

    fun start(){
        println("Engine Start!")
    }

}

class Bird{

}

fun main() {
    val sonata = Car()

    println(sonata.wheel)

    sonata.start()
}*/
/*
class Bird { // 클래스의 정의
    // 프로퍼티들(속성)
    var name: String = "mybird"
    var wing: Int = 2
    var beak: String = "short"
    var color: String = "blue"

    // 메서드들(함수)
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

fun main() {

    val coco = Bird()  // 클래스의 생성자를 통한 객체의 생성
    coco.color = "blue"  // 객체의 프로퍼티에 값 할당

    println("coco.color: ${coco.color}") // 객체의 멤버 프로퍼티 읽기
    coco.fly() // 객체의 멤버 메서드의 사용
    coco.sing(3)
}*/
