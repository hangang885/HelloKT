package com.gill.but.hellokt

/*
* 지연초기화가 필요한 이유
*   변수나 객체의 값은 생성시 초기화 필요
*       클래스에서는 기본적으로 선언하는 프로퍼티 자료형들은 null 을 가질 수 없음
*       하지만, 객체의 정보가 나중에 나타나는 경우 나중에 초기화 할 수 잇는 방법 필요
*       지연 초기화를 위해 lateinit 과 lazy 키워드 사용
*
* lateinit 를 사용한 지연 초기화
*   의존성이 있는 초기화나 unit 테스트를 위한 코드를 작성 시
*       예) Car 클래스의 초기화 부분에 Engine 클래스와 의존성을 가지는 경우
*           Engine 객체가 생성되지 않으면 완전하게 초기화 할 수 없는 경우
*       예) 단위(Unit) 테스트를 위해 임시적으로 객체를 생성 시켜야 하는 경우
*
*   프로퍼티 지연 초기화
*       클래스를 선언할 때 프로퍼티 선언은 null 을 허용하지 않는다
*       하지만, 지연 초기화를 위한 lateinit 키워드를 사용하면 프로퍼티에
*       값이 바로 할당되지 않아도 됨
*
*   lateinit의 제한
*       var 로 선언된 프로퍼티만 가능
*       프로퍼티에 대한 게터와 세터를 사용할 수 없음
*
* *//*
class Person {
        lateinit var name: String // 늦은 초기화를 위한 선언
        fun test(){
            if(!:: name.isInitialized) { // 프로퍼티의 초기화 여부 판단
                println("not initialized")
            }
            else{
                println("initialized")
            }
        }
}

fun main() {
    val gang = Person()
    gang.test()
    gang.name = "Gang" // 이 시점에서 초기화됨(지연 초기화)
    gang.test()
    println("name = ${gang.name}")
}*/

/*
* 객체 지연 초기화
*   객체 생성시 lateinit 을 통한 지연 초기화 가능
* */
/*

data class Person(var name: String, var age: Int)

lateinit var person1: Person // 객체 생성의 지연 초기화

fun main() {
    person1 = Person("Gang", 30) // 생성자 호출 시점에서 초기화됨
    print(person1.name + " is " + person1.age.toString())
}*/


/*
* lazy 를 사용한 지연 초가화
*   lazy 를 통한 지연 초기화 특징
*       호출 시점에 by lazy {...} 정의에 의해 블록 부분의 초기화를 진행한다.
*       불변의 변수 선언인 val 에서만 사용 가능하다. ( 읽기 전용)
*       val 이므로 값을 다시 변경할 수 없다.
*
* *//*

class LazyTest{
    init {
        println("init block") //(2)
    }
    val subject by lazy {
        println("lazy initialized") //(6)
        "Kotlin Programming" // (7) lazy 반환값
    }
    fun flow(){
        println("not initialized") // (4)
        println("subject one: $subject") // (5) 최초 초기화 시점
        println("subject two: $subject") // (8) 이미 초기화 된 값 사용
    }

}

fun main() {
    val test = LazyTest()//(1)
    test.flow()// (3)
}*/

class Person(val name: String, val age: Int)

fun main(){
    var isPersonInstantiated: Boolean = false // 1. 초기화 확인 용도

    val person: Person by lazy { // 2. lazy 를 사용한 person 객체의 지연 최고하
        isPersonInstantiated = true
        Person("Han", 23) // 3. 이 부분이 Lazy 객체로 반환 됨
    }
    val personDelegate = lazy{ Person("Gang", 40)} // 4. 위임 변수를 사용한 초기화

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init : ${personDelegate.isInitialized()}")

    println("person.name = ${person.name}") // 5. 이 시점에서 초기화
    println("personDelegate.value.name = ${personDelegate.value.name}") // 이 시점에서 초기화

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init : ${personDelegate.isInitialized()}")

}

/*
* by lazy 의 모드
*   3 가지 모드 지정 가능
*       SYNCHRONIZED  락을 사용해 단일 스레드만이 사용하는 것을 보장(기본값)
*       PUBLICATION   여러 군데서 호출될 수 있으나 처름 초기화 된 후 반환 값을 사용
*       NONE          락을 사용하지 않기 때문에 빠르지만 다중 스레드가 접근할 수 있음
*       (값의 일관성을 보장할 수 없음)
*
*   private val model by lazy(mode = LazyThreadSafetyMode.NONE){
*       Injector.app().transactionsModel() // 이 코드는 단일 스레드의 사용이 보장될 때
*       }
*
* */