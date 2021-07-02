package com.gill.but.hellokt

/*
* 정적 변수와 컴페니언 객체
*
*   사용 범위에 따라 분류
*       지역(local), 전역(global)
*
*   보통 클래스는 동적으로 객체를 생성하는데 정적으로 고정하는 방법은?
*       동적인 초기화 없이 사용할 수 있는 개념으로 자바에서는 static 변수 또는 객체
*       코틀린에서는 이것을 컴페니언 객체(Companion object) 로 사용
*       프로그램 실행 시 고정적으로 가지는 메모리로 객체 생성 없이 사용
*       단, 자주 사용되지 않는 변수나 객체를 만들면 메모리 낭비
*
* 동반객체(Companion Object)
*   기본적인 클래스에 무언가 미리 고정된 것을 들고간다고 생가
*   실제로 내부적으로 클래스 내부에 고정(static) 클래스를 가지게 된다.
* */
/*

class Person{
    var id: Int = 0
    var name: String = "Hangang"
    companion object{
        var language: String = "Korean"
        fun work(){
            println("working...")
        }
    }
}
// 컴패니언 객체는 실제 객체의 싱글톤(singleton) 으로 정의됨
// 싱글톤, 오직 하나의 값만 허용하는 객체. 따라서 Person
// 객체를 여러 개 생성해도 내부 동간 객체는 오직 한개로 유지 된다.
fun main() {
    val person = Person()


    println(Person.language)// 인스턴스를 생성하지 않고 기본값 사용
    Person.language = "English" // 기본값 변경 가능
    println(Person.language) // 변경된 내용 출력
    Person.work() // 메서드 실행
    //println(Person.name) // name 은 companion object 가 아니므로 오류
}
*/

/*
* 코틀린에서 자바의 static 멤버의 사용
* //자바의 Customer 클래스
*   public class Customer{
*       public static final String LEVEL = "BASIC"; // static 필드
*       public static void login() { // static 메서드
*               System.out.println("Login...");
*       }
*   }
*
*   //코틀린에서 자바의 static 접근
*       fun main() {
*           println(Customer.LEVEL)
*           Customer.login()
*       }
*
* 자바에서 코틀린 컴패니언 객체 사용
*   @JvmStatic
*       자바에서는 코틀린의 컴패니언 객체를 접근하기 위해 @JvmStatic 애노테이션
*       (annotation) 표기법을 사용
*
*       //코틀린코드
*       class KCustomer{
*           companion object{
*               const val LEVEL = "INTERMEDIATE"
*               @JvmStatic fun login() = println("Login...") // 애노테이션 표기 사용
*       }
*       }
*       const 에 대해
*           보통 val 만 사용하면 실행 시간에 할당 값이 결정되고 변경 불가죠
*           const 와 val 을 함께 사용한 상수 표현은 컴파일 시간에 값이 결정되며
*           const 사용은 오직 String 이나 원시 자료형에 해당하는 타입만 가능합니다.
*           따라서 val 만 사용할 때 함수와 같은 할당은 불가능 합니다.
*
*       // 자바 코드
*       public class KCustomerAccess{
*           public static void main(String[] args){
*               //코틀린 클래스의 컴패니언 객체를 접근
*               System.out.println(KCustomer.LEVEL);
*               KCustomer.login(); // 애노테이션을 사용할 때 접근 방법
*               KCustomer.Companion.login(); // 위와 동일한 결과로 애노테이션을 사용하지 않을 때 접근 방법
*           }
*       }
*
* 최상위 함수 정리
*   최상위 함수(top-level function)
*       클래스 없이 만들었던 최상위 함수들은 객체 생성 없이도 어디에서든 실행
*       패키지 레벨 함수(package-level function) 라고도 함
*       최상위 함수는 결국 자바에서 static final 로 선언된 함수임
*
*   자바에서 코틀린의 최상위 함수 접근
*       코틀린의 최상위 함수는 클래스가 없으나 자바와 연동시
*       내부적으로 파일명에 Kt 접미사가 붙은 클래스를 자동 생성하게 된다.
*
*       자동 변환되는 클래스명을 명시적으로 지정하고자 하는 경우
*       @file:JvmName("ClassName")을 코드 상단에 명시한다.
*
* 자바에서 코틀린의 최상위 함수 접근
*
*       //코틀린 코드
*       //패키지 레벨 함수 혹은 최상위 함수
*       //파일명 PackageLevelFunction.kt
*
*       @file:JvmName("PKLevel")
*
*       fun packageLevelFunc(){
*           println("Package-Level Function")
*       }
*       fun main(){
*           packageLevelFunc()
*       }
*
*       //자바 코드
*       public class PackageLevelAccess{
*           public static void main(String[] args){
*               PackageLevelFunctionKt.packageLevelFunc();
*
*               PKLevel.packageLevelFunc();
*           }
*       }
*
* object 와 싱글톤
*   상속할 수 없는 클래스에서 내용이 변경된 객체를 생성할 때
*       자바의 경우 익명 내부 클래스를 사용해 새로운 클래스 선언
*       코틀린에서는 object 표현식이나 object 선언으로 이 경우를 좀 더 쉽게 처리
*
*   object 선언 방식은 접근 시정에 객체가 생성.
*   그렇기 때문에 생성자 호출을 하지 않으므로 object 선언에는 주/부 생성자를
*   사용할 수 없다.
*   자바에서는 OCustomer.INSTANCE.getName();와 같이 접근해야 한다.
*
* object 표현식
*   object 표현식을 사용할 때
*       object 선언과 달리 이름이 없으며 싱글턴이 아님
*       따라서 object 표현식이 사용될 때마다 새로운 인스턴스가 생성
*       이름이 없는 익명 내부 클래스로 불리는 형태를 object 표현식으로 만들 수 있다.
*  */

open class Superman(){
    fun work() = println("Taking photos")
    fun talk() = println("Talking with people")
    open fun fly() = println("Flying in the air.")

}

fun main() {
    val pretendedMan = object: Superman() { // 1. object 표현식으로 fly() 구현의 재정의
        override fun fly() = println("I'm not a real superman. I can't fly!")
        //하위클래스를 만들지 않고도 새로운 구현인 fly()를 포함할 수 있음
        //어떤 클래스에 메서드를 오버라이딩(override)하기 위해
        //하위 클래스를 정의하고 해당 메서드를 재정의 한 뒤 객체를 생성하는 과정을
        //거쳐야만 object 표현식은 이러한 과정 없이 간단하게 할 수 있죠!
    }


    pretendedMan.work()
    pretendedMan.talk()
    pretendedMan.fly()


}
