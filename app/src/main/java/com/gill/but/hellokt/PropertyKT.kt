package com.gill.but.hellokt

import java.lang.AssertionError

/*
* 프로퍼티(Property)
*   프로그래밍에서는 데이터 혹은 상태를 가질 수 있는 변수
*
* 프로퍼티의 접근
*   자바의 필드(Fields)
*       단순한 변수 선언만 가지기 때문에 접근을 위한 메서드를 따로 만들어야 함
*
*   코틀린의 프로퍼티(Properties)
*       변수 선언과 기본적인 접근 메서드를 모두 가지고 있음
*       따로 접근 메서드를 만들지 않아도 내부적으로 생성하게 됨
*
*
* 자바에서 필드를 사용할 때
*   게터(Getter)와 세터(Setter)의 구성
*       게터와 세터를 합쳐 접근 메서드(Access methods)라고 함
*       자바에서는 모든 필드에 대한 접근 메서드를 만들어야하는 수고를 해야함.
*
* 코틀린에서 게터와 세터가 작동하는 방식
*   접근 메서드는 생략(내부적으로 생성됨)
*       //주 생성자에 3개의 매개변수 정의
*       class User(_id: Int, _name: String, _age: Int){
*           //프로퍼티 들
*           val id: Int = _id // 불변(읽기 전용)
*           var name: String = _name // 변경 가능
*           var age: Int = _age  // 변경 가능
*           }
*
*   좀 더 간략화 하면
*       class User(val id: Int, var name: String, var age: Int)
*
*   게터와 세터의 동작
*       fun main(){
*           val user = User(1, "Sean", 30)
*           //게터에 의한 값 획득
*           val name = user.name
*           //세터에 의한 값 지정
*           user.age = 41
*           println("name: $name, ${user.age}")
*           }
* */

/*

class Person(var id: Int, var name:String, var age: Int)

fun main() {
    val person = Person(1, "Gang", 30)

    person.id = 2 // setter
    println(person.id)// getter
}
*/
/*

기본 게터와 세터 직접 지정
        게터와 세터가 포함되는 프로퍼티 선언 구조
            var 프로퍼티 이름[: 프로퍼티 자료형] [= 프로퍼티 초기화]
                [get() {게터 본문}]
                [set(value) {세터 본문}]
            val 프로퍼티 이름[: 프로퍼티 자료형] [= 프로퍼티 초기화]
                [get() {게터 본문}]
        불변형인 val 은 게터만 설정 가능

        */
/*
class User(_id: Int, _name: String, _age:Int){

    //프로퍼티
    val id: Int = _id
        get() = field

    var name: String = _name
        get() = field
    set(value){
        field = value
    }
    var age: Int = _age
    get()= field
    set(value) {
        field = value + 10
    }
}

fun main() {
    val user1 = User(1,"Gang",30)
    //user1.id=2 // 에러 ! val 프로퍼티는 값 변경 불가
    user1.age = 35 // 세터 동작
    println("user1.age= ${user1.age}")// 게터 동자
}*/
/*
* 게터 세터에서 사용하는 특수 변수
*   value : 세터의 매개변수로 외부로부터 값을 가져옴
*       외부의 값을 받을 변수가 되므로 value 대신에 어떤 이름이든지 상관 업승ㅁ
*   field : 프로퍼티를 참조하는 변수로 보조 필드(backing field) 로 불림
*       프로퍼티를 대신할 임시 필드로 만일 프로퍼티를 직접 사용하면 게터나
*       세터가 무한 호출되는 재귀에 빠짐
*
*   만일 프로퍼티의 이름을 그대로 사용하낟면?
*       무한 재귀에 빠져 스택오버플로우가 발생할 수 있습니다.
* */
/*
//커스텀 게터와 세터의 사용
    class User(_id: Int, _name: String, _age: Int){
    val id: Int = _id
    var name: String = _name
    set(value) {
        println("The name was changed")
        field = value.toUpperCase()// 받은 인자를 대문자로 변경해 프로퍼티에 할당
    }
    var age: Int =_age

}

fun main() {
    val user1 = User(1,"Gang",35)
    user1.name = "coco" // 여기서 사용자 고유의 출력 코드가 실행된다
    println("user1.name = ${user1.name}")
}*/
/*

class User(_id: Int, _name: String, _age: Int){
    val id: Int = _id
    private var tempName : String? =null
    var name: String = _name
       get() {
           if (tempName == null) tempName = "NONAME"
           return tempName ?: throw AssertionError("Asserted by others")
       }
    var age: Int =_age

}

fun main() {
    val user1 = User(1,"Gang",35)
    user1.name = "ABC"
    println("user1.name = ${user1.name}")
}*/

open class First {
    open val x: Int = 0 // 오버라이딩 가능
    get() {
        println("First x")
        return field
    }
    val y: Int = 0 // open 키워드가 없으면 final 프로퍼티임
}
class Second : First(){
    override var x: Int = 0 // 부모와 구현이 다름
    get() {
        println("Second x")
        return field + 3
    }
    set(value) {
        field = value + 10
    }
        //override val y: Int = 0 // 에러! 오버라이딩 불가
}

fun main() {
    val second = Second()
    println(second.x) // 오버라이딩 된 두번째 클래스 객체의 x
    second.x = 10
    println(second.x)
    println(second.y)

}