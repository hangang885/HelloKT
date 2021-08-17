package com.gill.but.hellokt


/*
* 내부 클래스 기법들
*   코틀린의 내부 클래스 종류
*       중첩(Nested) 클래스
*       이너(inner) 클래스
*
*   자바의 내부클래스 종류
*       종류                          역할
*       정적 클래스(static class)        static 키워드를 가지며 외부 클래스를 인스턴스화 하지 않고 바로 사용 가능한 클래스(주로 빌더 클래스에 이용)
*       멤버 클래스(member class)        인스턴스 클래스로도 불리며 외부 클래스의 필드나 메서드와 연동하는 내부 클래스
*       지역 클래스(local class)         초기화 블록이나 메서드 내의 블록에서만 유효한 클래스
*       익명 클래스(anonymous class)     이름이 없고 주로 일회용 객체를 인스턴스화 하면서 오버라이드 메서드를 구현하는
*                                      내부 클래스. 가독성이 떨어지는 단점이 있다.
*
*   자바와 코틀린의 내부 클래스 비교
*       자바                          코틀린
*       정적 클래스(static class)        중첩 클래스(nested class): 객체 생선 없이 사용 가능
*       멤버 클래스(member class)        이너 클래스(inner class): 필드나 메서드와 연동하는 내부 클래스로 inner 키워드가 필요하다
*       지역 클래스(local class)         지역 클래스(local class): 클래스의 선언이 블록에 있다면 지역 클래스이다.
*       익명 클래스(anonymous class)     익명 객체(anonymous object): 이름이 없고 주로 일회용 객체를 사용하기 위해 object 키워드를 통해 선언된다.
*
*
* 코틀린의 이너 클래스
*   class A{
*       ...
*       inner class B{ // 자바와 달리 inner 키워드 필요
*           ... // 외부 클래스 A의 필드에 접근 가능
*       }
*  }
*
*   //정적 클래스처럼 사용한 코틀린의 중첩 클래스
*       class A{
*           class B{
*           // 코틀린에서는 아무 키워드가 없는 클래스는 중첩 클래스이며 정적 클래스처럼 사용
*           // 외부 클래스 A의 프로퍼티, 메서드에 접근할 수 없음
*           }
*       }
*
* 중첩 클래스
*   중첩 클래스(Nested class)
*       코틀린에서 중첩 클래스는 기본적으로 정적(static) 클래스처럼 다뤄진다.
* *//*
class Outer{
    val ov = 5
    class Nested{
        val nv = 10
        fun greeting() ="[Nested] Hello ! $nv" // 외부의 ov 에는 접근 불가
    }
    fun outside(){
        val msg = Nested().greeting() // Outer 객체 생성 없이 중첩 클래스의 메서드 접근
        println("[Outer]: $msg, ${Nested().nv}") // 중첩 클래스의 프로퍼티 접근
    }
}

fun main() {
    //static 처럼 Outer 의 객체 생성 없이 Nested 객체를 생성 사용할 수 있음
    val output = Outer.Nested().greeting()
    println(output)

    //Outer.outside() // 에러 Outer 객체 생성 필요
    val outer = Outer()
    outer.outside()
}*/
/*
* [Nested] Hello ! 10
* [Outer]: [Nested] Hello ! 10, 10
* */

/*
*
* 코틀린 중첩 클래스에서 바깥 클래스 접근
*   바깥 클래스에 접근할 수 있는 방법
*       Outer 클래스가 컴패니언 객체를 가지고 있을 때 접근 가능
*           class Outer{
*               class Nested{
*               ...
*               fun accessOuter() { //컴패니언 객체는 접근할 수 있음
*                   println(country)
*                   getSomething()
*               }
*          }
*
*       companion object{ // 컴패니언 객체는 static 처럼 접근 가능
*           const val country = "Korea"
*           fun getSomething() = println("Get something...")
*           }
*       }
*
*
*  */

/*

class Outer{
    val ov = 5
    class Nested{
        val nv = 10
        fun greeting() ="[Nested] Hello ! $nv" // 외부의 ov 에는 접근 불가
        fun accessOuter(){
            println(country)
            getSomething()
        }

    }
    fun outside(){
        val msg = Nested().greeting() // Outer 객체 생성 없이 중첩 클래스의 메서드 접근
        println("[Outer]: $msg, ${Nested().nv}") // 중첩 클래스의 프로퍼티 접근
    }

    companion object{
        const val country = "Korea"
        fun getSomething() = println("Get something..")
    }
}

fun main() {
    //static 처럼 Outer 의 객체 생성 없이 Nested 객체를 생성 사용할 수 있음
    val output = Outer.Nested().greeting()
    println(output)
    Outer.Nested().accessOuter()

    //Outer.outside() // 에러 Outer 객체 생성 필요
    val outer = Outer()
    outer.outside()
}*/

/*
* 이너 클래스
*   코틀린의 이너 클래스
*       특별한 키워드인 inner 를 사용해 선언된 내부 클래스
*       이너 클래스는 바깥 클래스의 멤버들에 접근 가능
*       바깥 클래스의 private 멤버도 접근이 가능
*
* *//*

class SmartPhone(val model: String){
    private val cpu = "Exynos"

    inner class ExternalStorage(val size: Int){
        fun getInto() = "${model}: Installed on $cpu with ${size}Gb" // 바깥 클래스의 프로퍼티 접근
    }
}

fun main() {
    val mySdcard = SmartPhone("S7").ExternalStorage(32)
    println(mySdcard.getInto())
}*/

/*
* 지역 클래스
*   지역 클래스(Local class)
*       특정 메서드의 블록이나 init 블록과 같이 블록 범위에서만 유효한 클래스
*       블록 범위를 벗어나면 더 이상 사용되지 않음
* */
/*

class Smartphone(val model: String){
    private val cpu = "Exynos"

    fun powerOn(): String{
        class Led(val color: String){ // 지역 클래스선언
            fun blink(): String = "Blinking $color on $model" // 외부의 프로퍼티는 접근 가능

         }
        val powerStatus = Led("Red") // 여기에서 지역 클래스가 사용됨
        return powerStatus.blink()
        //powerOn() 블록 끝
    }

}

fun main() {


    val myphone = Smartphone("Note10")
    println(myphone.powerOn())
}*/

/*
* 익명 객체
*   익명(Anonymous) 객체
*       자바에서는 익명 이너 클래스라는 것을 제공해 일회성으로 객체를 생성해 사용
*       코틀린에서는 object 키워드를 사용하는 익명 객체로 같은 기능을 수행
*
* */
/*

interface Switcher { // 1. 인터페이스의 선언
    fun on(): String
}
class Smartphone(val model: String){
    private val cpu = "Exynos"

    fun powerOn(): String{
        class Led(val color: String){ // 지역 클래스선언
            fun blink(): String = "Blinking $color on $model" // 외부의 프로퍼티는 접근 가능

        }
        val powerStatus = Led("Red") // 여기에서 지역 클래스가 사용됨
        val powerSwitch = object : Switcher{ // 2. 익명 객체를 사용해 Switcher 의 on()을 구현
            override fun on(): String{
                return powerStatus.blink()
            }
        } // 익명 (object) 객체 블록의 끝
        return powerSwitch.on() // 익명 객체의 메서드 사용
    }

}*/


/*
* 실드 클래스
*   실드(Sealed) 클래스
*       실드란 '봉인된' 이라는 의미로 무언가 안전하게 보관하기 위해 묶어 두는 것
*       sealed 키워드를 class 와 함께 사용
*       실드 클래스 그 자체로는 추상 클래스와 같기 때문에 객체를 만들 수는 없다.
*       생성자도 기본적으로 private 이며 private 이 아닌 생성자는 허용하지 않음
*       실드 클래스는 같은 파일 안에서는 상속이 가능( 다른 파일에서 상속이 불가)
*       블록 안에 선언되는 클래스는 상속이 필요한 경우 open 키워드로 선언
*
* */

// 실드 클래스 선언 방법 첫번째 스타일
/*sealed class Result {
    open class Success(val message: String): Result()
    class Error(val code: Int, val message: String): Result()
}

class Status: Result() // 실드 클래스 상속은 같은 파일에서만 가능
class Inside: Result.Success("Status") // 내부 클래스 상속*/
/*

//실드 크래스 선언 방법 두 번째 스타일
sealed class Result

open class Success(val message: String): Result()
class Error(val code: Int, val message: String): Result()

class Status: Result()
class Inside: Success("Status")
*/
/*

fun main() {
    //Success 에 대한 객체 생성
    val result = Result.Success("Good!")
    val msg = eval(result)
    println(msg)
}
// 상태를 검사하기 위한 함수
fun eval(result: Result): String = when(result){
    is Status -> "in Progress"
    is Result.Success -> result.message
    is Result.Error -> result.message
    //모든 조건을 가지므로 else가 필요 없음
}*/

/*
* 열거형 클래스
*   열거형 클래스
*       여러 개의 상수를 선언하고 열거된 값을 조건에 따라 선택할 수 있는 특수한 클래스
*       자료형이 동일한 상수를 나열할 수 있다.
*           - 실드 클래스처럼 다양한 자료형을 다루지 못한다
*       enum class 클래스 이름 [(생성자)] {
*           상수1[(값)], 상수2[(값)], 상수3[(값)],  ....
*           [; 프로퍼티 혹은 메서드]
*       }
*
* */
//열거형 클래스의 예
/*
enum class Direction{
    NORTH, SOUTH, WEST, EAST
    //각 상수는 Direction 클래스의 객체로 취급되고 콤마(,) 로 구분

}

enum class DayOfWeek(val num: Int) {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4),
    FRIDAY(5), SATURDAY(6), SUNDAY(7)
}

fun main() {
    val day = DayOfWeek.SATURDAY // SATURDAY 의 값을 읽기
    when(day.num){
        1, 2, 3, 4, 5 -> println("Weekday")
        6, 7 -> println("Weekend!")
    }

}
*//*
enum class Color(val r:Int, val g: Int, val b: Int){
    RED(255,0,0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238); // 여기에 세미콜론으로 끝을 알리고

    fun rgb() = (r * 256 + g) * 256 + b // 메서드를 포함할 수 있음
}
fun main(args: Array) {
    println(Color.BLUE.rgb())
}*//*

interface Score{
    fun getScore(): Int
}
enum class MemberType(var prio: String) : Score{ // Score를 구현할 열거형 클래스
    NORMAL("Thrid"){
        override fun getScore(): Int = 100 // 구현된 메서드
    },
    SILVER("Second"){
        override fun getScore(): Int = 500
    },
    GOLD("First"){
        override fun getScore(): Int = 1500
    }

}

fun main() {
    println(MemberType.NORMAL.getScore())
    println(MemberType.GOLD)
    println(MemberType.valueOf("SILVER"))
    println(MemberType.SILVER.prio)

    for(grade in MemberType.values()){ // 모든 값을 가져오기 위한 반복문
        println("grade.name = ${grade.name}, prio = ${grade.prio}" +
                "  score: ${grade.getScore()}")

    }
}*/

/*
* 애노테이션 클래스
*   애노테이션(annotation)은 ?
*       코드에 부가 정보를 추가하는 기능 역할
*       @ 기호와 함께 나타내는 표기법으로 주로 컴파일러나 프로그램 실행 시간에서 사전 처리를 위해 사용
*           @Test       유닛 테스트
*           @JvmStatic  자바 코드에서 컴패니언 객체를 접근
*
*   선언
*       annotation class 애노테이션명
*
*   애노테이션의 속성
*       @Target: 애노테이션이 지정되어 사용할 종류(클래스, 함수, 프로퍼티 등) 를 정의
*       @Retention: 애노테이션을 컴파일된 클래스 파일에 저장할 것인지 실행 시간에 반영할 것인지 결정
*       @Repeatable: 애노테이션을 같은 요소에 여러 번 사용 가능하게 할지를 결정
*       @MustBeDocumented: 애노테이션이 API 의 일부분으로 문서화 하기 위해 사용
*
*   속성과 함께 정의된 애노테이션 클래스의 예
*       @Target(AnnotationTarget.Class, AnnotationTarget.FUNCTION,
*               AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
*       @Retention(AnnotationRetention.SOURCE) // 애노테이션의 처리 방법 - SOURCE: 컴파일 시간에 제거됨
*       @MustBeDocumented
*       annotation class Fancy
*
*
*
* */