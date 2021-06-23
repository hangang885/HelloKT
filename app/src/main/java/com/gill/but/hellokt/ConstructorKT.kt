package com.gill.but.hellokt

/*
* 생성자
*   생성자(Constructor)란
*       클래스를 통해 객체가 만들어 질 때 기본적으로 호출되는 함수
*       객체 생성 시 필요한 값을 인자로 설정할 수 있게 한다.
*       생성자를 위해 특별한 함수인 constructor() 를 정의
*
*       class 클래스명 constructor(필요한 매개변수들..){ // 주 생성자의 위치
*           ...
*       constructor(필요한 매개 변수들..){ // 부 생성자의 위치
*               //프로퍼티 초기화
*       }
*       [constructor(필요한 매개변수들..){ .. } ] // 추가 부 생성자
*       }
*
*
* 생성자의 정의
*   주 생성자(Primary Constructor)
*       클래스명과 함께 기술되며 보통의 경우 constructor 키워드를 생략할 수 있다.
*
*   부 생성자(Secondary Constructor)
*       클래스 본문에 기술되며 하나 이상의 부 생성자를 정의할 수 있다.
*
* */
/*

class Bird{
    //프로퍼티
    var name: String
    val wing: Int
    var beak: String

    constructor(_name: String, _wing: Int, _beak: String){
        name = _name
        wing = _wing
        beak = _beak

    }
    constructor(_name: String,  _beak: String){
        name = _name
        wing = 2
        beak = _beak

    }


    */
/*   init{  초기화 블록
           println("--------- init start -----------")
           name = name.capitalize()
           println("name: $name, wing: $wing, beak: $beak")
           println("---------- init end------------")

       }*//*



    //메서드

    fun fly(){
        println("Fly")
    }

}

fun main() {
    val coco = Bird("coco",2,"long")
    val coco2 = Bird("coco","long")
    coco.fly()
    println(coco.name)
    println(coco.wing)
    println(coco.beak)
    println("coco2: name: ${coco2.name}, wing: ${coco2.wing}, beak: ${coco2.beak} ")
}*/
