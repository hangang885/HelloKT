package com.gill.but.hellokt

import android.os.Parcel
import android.os.Parcelable

/*
* 추상 클래스의 선언
*   추상 클래스(abstract class)
*       구현 클래스에서 가져야할 명세를 정의한 클래스( 프로퍼티 및 메서드 템플릿)
*       abstract 라는 키워드와 함께 선언하며 추상클래스는 객체 생성 안됨
*       '구체적이지 않은 것' 을 나타내기 때문에 하위 파생 클래스에서 구체적으로 구현
*           abstract class Vehicle
*       open 키워드를 사용하지 않고도 파생 클래스 작성 가능
* */
/*
abstract class Vehicle(var name: String, val color: String, val weight : Double){
    //추상 프로퍼티 -하위 클래스에서 오버라이딩
    abstract val maxSpeed: Double

    // 비추상 프로퍼티
    var year: String = "2008"

    //추상 메서드
    abstract fun start()

    abstract fun stop()

    //비추상 메서드
    fun displaySpec(){
        println("name: $name, color: $color, weight: $weight, year: $year, maxSpeed: $maxSpeed")
    }
}

class Car2(name: String,
          color: String,
          weight: Double,
          override val maxSpeed: Double) :
        Vehicle(name, color, weight) {

    override fun start() {
       println("Car Started")
    }

    override fun stop() {
        println("Car Stopped")
    }

    fun autoPilotOn(){
        println("Auto Pilot ON")
    }

}

class Motorbike(name: String,
           color: String,
           weight: Double,
           override val maxSpeed: Double) :
        Vehicle(name, color, weight) {

    override fun start() {
        println("Motorbike Started")
    }

    override fun stop() {
        println("Motorbike Stopped")
    }

}

fun main() {
    var car = Car2("Matiz", "red",1000.0, 100.0)
    var motor = Motorbike("Motor1", "blue",1000.0, 100.0)

    car.year = "2014"
    car.displaySpec()

    motor.displaySpec()
    car.start()
    motor.start()

    car.stop()
    motor.stop()

}*/
/*
*
* //추상 클래스, 주 생성자에는 비추상 프로퍼티 선언의 매개변수가 3개가 있음
* abstract class Vehicle(var name: String, val color: String, val weight : Double){

    * //추상 프로퍼티 (반드시 하위 클래스에서 재정의해 초기화 해야함)
    abstract val maxSpeed: Double

    // 일반 프로퍼티 (초기 값인 상태를 저장할 수 있음)
    var year: String = "2008"

    //추상 메서드 ( 반드시 하위 클래스에서 구현해야 함)
    abstract fun start()

    abstract fun stop()

    //일반메서드
    fun displaySpec(){
        println("name: $name, color: $color, weight: $weight, year: $year, maxSpeed: $maxSpeed")
    }
}*/

/*
단일 인스턴스로 객체를 생성
    object 를 사용한 생성
        추상 클래스로부터 하위 클래스를 생성하지 않고 단일 인스턴스로 객체 생성 가능

    //추상 클래스의 선언
    abstract class Printer{
        abstract fun print() // 추상 메서드
    }

    val myPrinter = object: Printer() {  // 객체 인스턴스
            override fun print(){ // 추상메서드의 구현
                println("출력합니다.")
            }

    }

    fun main() {
        myPrinter.print()
    }

인터페이스
    현실 세계의 계약서
        계약서에는 무엇 무엇을 하라는 추상적인 활동들이 적혀 있다.
        이것을 어떤 '작업자'가 받아들였다면 계약서에 있는 활동에 구체적인 내용을 반드시 실행해야 함
        계약서 자체로는 실행될 수 없음
        클래스 상속은 하나만 되지만 인터페이스는 여러개 구현 가능

    추상 클래스와 다른 점
        클래스가 아니므로 다양한 인터페이스로부터 클래스 구현 가능(다중 상속)
        추상 클래스와 다르게 강한 연관을 가지지 않는다

    코틀린의 인터페이스
        다른 언어와는 다르게 기본적인 구현 내용이 포함될 수 있다.
            자바에서는 버전 8에서 default 키워드를 사용해야만 구현 내용 포함
        선언하려면 interface 키워드를 사용해 정의
        상속한 하위 클래스에서는 override 를 사용해 해당 메서드를 구현

        interface 인터페이스명 [: 인터페이스명...] {
            추상 프로퍼티 선언
            추상 메서드 선언

            [일반 메서드 선언{...}]
        }


* *//*
interface Pet{
    var category: String // abstract 키워드가 없어도 기본은 추상 프로퍼티
    val msgTags:String // val 선언시 게터의 구현이 가능
        get() = "I'm your lovely pet!"

    fun feeding() // 마찬가지로 추상 메서드
    fun patting() { // 일반 메서드: 구현부를 포함하면 일반적인 메서드로 기본이 됨
        println("Keep patting!")// 구현 부

    }
}

class Cat(override var category: String) : Pet{
    override fun feeding() {
        println("Feed the cat a tuna can!")
    }
}

fun main() {
    val obj = Cat("small")
    println("Pet Category: ${obj.category}")
    obj.feeding() // 구현된 메서드
    obj.patting() // 기본 메서드
    println("Pet Message Tags: ${obj.msgTags }")

}*/
/*

interface Pet{
    open var species: String
    var category: String // abstract 키워드가 없어도 기본은 추상 프로퍼티
    val msgTags:String // val 선언시 게터의 구현이 가능
        get() = "I'm your lovely pet!"

    fun feeding() // 마찬가지로 추상 메서드
    fun patting() { // 일반 메서드: 구현부를 포함하면 일반적인 메서드로 기본이 됨
        println("Keep patting!")// 구현 부

    }
}
open class Animal(val name: String)

// 1. feeding 의 구현을 위해 인터페이스 Pet 지정
class Dog(name: String, override var category: String): Animal(name), Pet{

    override var species: String = "dog"

    override fun feeding() {
        println("Feed the dog a bone")
    }
}
class Cat(name: String, override var category: String): Animal(name), Pet{

    override var species: String = "Cat"

    override fun feeding() {
        println("Feed the dog a bone")
    }
}

class Master{
    //인터페이스를 객체로 매개변수를 지정함
    fun playWithPet(pet: Pet){ //2. 각 애완동물 종류에 따라 오버로딩됨
        println("Enjoy with my ${pet.species}")
    }
}

fun main() {
    val master = Master()
    val dog = Dog("Toto", "Small")
    val cat = Cat("Coco", "BigFat")
    master.playWithPet(dog)
    master.playWithPet(cat)

}*/

/*
* 여러 인터페이스의 구현
*   다중 상속
*       클래스는 기본적으로 다중 상속을 지원하지 않는다
*       인터페이스를 여러 개를 하나의 클래스에서 구현하는 것이 가능하므로
*       다중 상속과 같은 효과를 가진다.
*
*
*
* */
/*

interface Bird{
    val wings: Int
    fun fly()
    fun jump() = println("bird jump!")
}

interface Horse{
    val maxSpeed: Int
    fun run()
    fun jump()= println("jump!, max speed: $maxSpeed")
}

class Pegasus: Bird,Horse{
    override val wings: Int = 2
    override val maxSpeed: Int =100
    override fun fly() = println("Fly!")
    override fun run() = println("Run!")
    override fun jump(){
        super<Horse>.jump()
        println("and jump!")
    }
}

fun main() {
    val pegasus = Pegasus()
    pegasus.fly()
    pegasus.jump()
    pegasus.run()
}

*/
/*
* 인터페이스의 위임
*   인터페이스의 위임 사용
* *//*

interface A1{
    fun functionA(){}
}
interface B1{
    fun functionB(){}
}
class C1(val a: A1, val b: B1){
    fun functionC(){
            a.functionA()
            b.functionB()
    }
}

class DelegatedC(a: A1, b: B1): A1 by a, B1 by b{
    fun functionC(){
        functionA() //A의 위임
        functionB() //B의 위임
    }
}
*/
/*

//위임을 이용한 멤버 접근

interface Nameable{
    var name: String
}
class StaffName: Nameable{
    override var name: String = "Sean"
}
class Work: Runnable{ //스레스 실행을 위한 인터페이스
    override fun run() {
        println("work...")
    }
 }
//1. 각 매개변수에 해당하는 인터페이스를 위임한다
class Person(name: Nameable, work:Runnable): Nameable by name, Runnable by work

fun main() {
    val person = Person(StaffName(), Work()) //2. 생성자를 사용해 객체 바로 전달
    println(person.name) // 3. 여기서 StaffName 클래스의 name 접근
    person.run() // 4. 여기서 Work 클래스의 run 접근
}*/

/*
* 데이터 전달을 위한 데이터 클래스
*   데이터 전달을 위한 객체 DTO(Data Transfer Object)
*       자바에서는 POJO(Plain Old Java Object) 라고 불리기도함
*       구현 로직을 가지고 있지 않고 순수한 데이터 객체를 표현
*       데이터를 접근하는 게터/세터를 포함
*       toString(), equals() 등과 같은 데이터 표현 및 비교 메서드 포함
*
*   자바로 DTO 를 표현하면
*       데이터 필드들, 게터/세터들, 데이터 표현 및 비교 메서드들을 모두 작성해야 함
*
*   코틀린으로 DTO 를 표현하면
*       프로퍼티만 신경 써서 작성하면 나머지는 내부적으로 자동 생성됨
*
* 코틀린 데이터 클래스
*   코틀린의 데이터 클래스(data class)
*       DTO 를 표현하기 적합한 클래스 표현으로 data class 키워드를 사용해 정의
*           코틀린의 프로퍼티 = 필드(변수) + 게터와 세터
*
*   자동 생성되는 메서드들
*       프로퍼티를 위한 게터/세터
*       비교를 위한 equals()과 키 사용을 위한 hashCode()
*       프로퍼티를 문자열로 반환해 순서대로 보여주는 toString()
*       객체 복사를 위한 copy()
*       프로퍼티에 상응하는 component1(), component2() 등
*
* 데이터 클래스 선언
*   선언 예
*       data class Customer(var name: String, var email: String)
*
*   데이터 클래스의 조건
*       주 생성자는 최소한 하나의 매개변수를 가져야 한다.
*       주 생성자의 모든 매개변수는 val, var 로 지정된 프로퍼티여야 한다.
*       데이터 클래스는 abstract, open, sealed, inner 키워드를 사용할 수 없다.
*
*   간단한 로직을 포함 하려면
*       부 생성자나 init 블록을 넣어 데이터를 위한 간단한 로직을 포함할 수 있따
*
*   data class Customer(var name: String, var email: String){
*       var job: String = "Unknown"
*       constructor(name: String, email: String, _job: String): this(name, email){
*           job = _job
*       }
*       init{
*           //간단한 로직은 여기에
*       }
*
*       }
*
* 데이터 클래스의 제공 메서드
*   자동 생성되는 메서드들
*       제공된 메서드     기능
*       equals()        두 객체의 내용이 같은지 비교하는 연산자로 ==와 동일
*       hashCode()      객체를 구별하기 위한 고유한 정수값 생성, 데이터 셋이나 해시 테이블을
*                       사용하기 위한 하나의 생성된 인덱스
*       copy()          빌더 없이 특정 프로퍼티만 변경해서 객체 복사하기
*       toString()      데이터 객체를 읽기 편한 문자열로 반환하기
*       componentN()    객체의 선언부 구조를 분해하기 위해 프로퍼티에 상응하는 메서드
*
*
*   equals() 와 hashCode() 예
*       val cus1 = Customer("Sean", "sean@mail.com")
*       val cus2 = Customer("Sean", "sean@mail.com")
*       ...
*       println(cus1 == cus2) // 동등성 비교 true
*       println(cus1.equals(cus2)) // 위와 동일 true
*       println("${cus1.hashCode()}, ${cus2.hashCode()}") // 고유값도 동일
*
*   copy()의 사용 예
*       var cus3 = cus1.copy(name = "Alice") // name 만 변경하고자 할 때
*       println(cus1.toString())
*       println(cus3.toString())
*
*       Customer(name=Sean, email=Sean@mail.com)
*       Customer(name=Alice, email=Sean@mail.com)
*
* 객체 디스트럭처링
*   디스트럭처링(destructuring) 하는 것
*       객체가 가지고 있는 프로퍼티를 개별 변수들로 분해
*           val (name, email) = cus1
*           println("name = $name, email = $email")
*       특정 프로퍼티를 가져올 필요 없는 경우
*           val(_, email) = cus1 // 첫 번째 프로퍼티 제외
*
*   componentN() 메서드 이용
*       val name2 = cus1.component1()
*       val email2 = cus1.component2()
*       println("name = $name2, email = $email2")
*
*   객체 데이터가 많은 경우 for 문 활용
*       val cus1 = Customer("Sean", "sean@mail.com")
*       val cus2 = Customer("Sean", "sean@mail.com")
*       val bob = Customer("Bob", "bob@mail.com")
*       val erica = Customer("Erica", "erica@mail.com")
*
*       val customer = listOf(cus1, cus2, bob, erica) // 모든 객체를 컬렉션 List 목록으로 구성
*       ...
*       for((name, email) in customers) { // 반복문을 이용해 모든 객체의 프로퍼티 분해
*           println("name = $name, email = $email")
*       }
*
*   함수로부터 객체가 반환될 경우
*       fun myFunc(): Customer{
*           return Customer("Mickey","mic@abc.com")
*       }
*       ...
*       val (myName, my Email) = my Func()
*
*   람다식에서 사용하는 경우
*       //람다식 함수로 Destructuring 된 변수 출력해 보기
*       val myLambda = {
*           (nameLa, emailLa): Customer ->
*           println(nameLa)
*           println(emailLa)
*       }
*       myLambda(cus1)
*
*
*
*
* */

