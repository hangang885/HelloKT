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


/*
* 상속과 클래스의 계층
*
*   상속(inheritance)
*       자식 클래스를 만들 때 상위 클래스(부모 클래스)의 속성과 기능을 물려 받아 계승
*       상위(부모) 클래스의 프로퍼티와 메서드가 자식에 적용됨
*
*   open 키워드를 통한 선언
*       open class 기반 클래스명{ // open 으로 파생 가능(다른 클래스가 상속 가능한 상태가 됨)
*       ...
*       }
*       class 파생 클래스명 : 기반 클래스명(){ // 기반 클래스로부터 상속, 최종 클래스로 파생 불가
*       ...
*       }
*           코틀린의 모든 클래스는 묵시적으로 Any 로부터 상속
*
* */

/*

open class Bird(var name: String, var wing: Int, var beak: String){



    fun fly(){
        println("Fly")
    }
}

class Lark(name: String, wing: Int, beak: String): Bird(name, wing, beak){

    fun singHitone(){
        println("sing Hitone")
    }
}
class Parrot: Bird {
    var language: String
    constructor(name: String, wing: Int, beak: String, language: String)
    : super(name, wing, beak)
    {
        this.language = language

    }

    fun speak(){
        println("Speak: $language")
    }


}

fun main() {
    val lark = Lark("mylack", 2, "Short")
    val parrot = Parrot("myparrot",2,"long","English")

    println("lark - name: ${lark.name}")
    println("parrot - name: ${parrot.name}, lang: ${parrot.language}")

    lark.singHitone()
    lark.fly()

    parrot.speak()
    parrot.fly()
}
*/

/*
*
* 다형성
*   다형성(polymorphism)이란
*       같은 이름을 사용하지만 구현 내용이 다르거나 매개변수가 달라서 하나의
*       이름으로 다양한 기능을 수행할 수 있는 개념
*
*   Static Polymorphism
*       컴파일 타임에 결정되는 다형성
*       단순하게 보면 메서드 오버로딩(overloading)을 사용할 때
*
*   Dynamic Polymorphism
*       런타임 다형성
*       동적으로 구성되는 오버라이딩(overriding)된 메서드를 사용할 때
*
*   오버라이딩(overriding)
*       기능을 완전히 다르게 바꾸어 재설계
*       누르다 -> 행위 -> push()
*       push()는 '확인' 혹은 '취소' 용도로 서로 다른 기능을 수행할 수 있음
*
*   오버로딩(overloading)
*       기능은 같지만 인자를 다르게 하여 여러 경우를 처리
*       출력한다 -> 행위 -> print()
*       print(123), print("Hello) 인자는 다르지만 출력의 기능은 동일함
*
* 오버로딩의 예
*   일반 함수에서의 오버로딩
*       fun add( x: Int, y: Int): Int { //정수 자료형 매개변수 2개를 더함
*           return x+y
*       }
*
*       fun add( x: Double, y: Double):Double{ // 실수 자료형 매개변수 2개를 더함
*           return x + y
*       }
*
*       fun add(x: Int, y: Int, z:Int): Int{ //정수 자료형 매개변수 3개를 더함
*           return x + y + z
*       }
*
*
* */
/*


open class Bird(var name: String, var wing: Int, var beak: String){



    open fun fly(){
        println("Fly")
    }
}

class Lark(name: String, wing: Int, beak: String): Bird(name, wing, beak){

    override fun fly(){
        println("Quick Fly")
    }

    fun singHitone(){
        println("sing Hitone")
    }
}
class Parrot: Bird {
    var language: String
    constructor(name: String, wing: Int, beak: String, language: String)
            : super(name, wing, beak)
    {
        this.language = language

    }

    override fun fly(){
        println("Slow Fly")
    }

    fun speak(){
        println("Speak: $language")
    }


}

fun main() {
    val lark: Bird= Lark("mylack", 2, "Short")
    val parrot: Bird = Parrot("myparrot",2,"long","English")

    println("lark - name: ${lark.name}")
//    println("parrot - name: ${parrot.name}, lang: ${parrot.language}")

//    lark.singHitone()
    lark.fly()

//    parrot.speak()
    parrot.fly()
}
*/
/*
* 오버라이딩의 예
*   메서드 오버라이딩의 예
*       open class Bird{ // 여기에 open 은 상속 가능을 나타냄
*
*       fun fly() {...} // 최종 메서드로 오버라이딩 불가
*       open fun sing() {...} // sing() 메서드는 하위 클래스에서 오버라이딩 가능
* }
*   class Lark():Bird() { // 하위 클래스
*       fun fly() { /* 재정의 */ } // 에러! 상위 메서드에 open 키워드가 없어 오버라이딩 불가
        override fun sing() { /* 구현부를 새롭게 재정의 */ } // 구현부를 새롭게 작성
        }

  오버라이딩 금지
    파생 클래스에서 오버라이딩 금지할 때
        open class Lark() : Bird{
            final override fun sing() { 구현부를 새롭게 재정의} // 하위 클래스에서 재정의 금지
             }

 */
