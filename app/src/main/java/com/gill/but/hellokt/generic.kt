package com.gill.but.hellokt

/*
* 제네릭
*   제네릭(generic)이란
*       자료형의 객체들을 다루는 메서드나 클래스에서 컴파일 시간에 자료형을 검사해
*       적당한 자료형을 선택할 수 있도록 하기 위해
*   제네릭의 일반적인 사용
*       앵글 브래킷(<>)  사이에 형식 매개변수를 사용해 선언
*       형식 매개변수는 자료형을 대표하는 용어로 T와 같이 특정 영문의 대문자로 사용
* */
/*

class box<t>(a: t){
    var name = a

}

fun main() {
    val box1: box<int> = box<int>(1)
    val box2: box<string> = box<string>("kang")

    println(box1.name)
    println(box2.name)
}*/

/*
* 형식 매개변수의 이름
*   형식 매개변수의 이름
*       강제사항은 없으나 일종의 규칙처럼 사용됨
*           형식 매개변수 이름      의미
*           E                    요소(element)
*           K                    키(key)
*           N                    숫자(number)
*           T                    형식(type)
*           V                    값(value)
*           S, U, V etc.         두 번째, 세 번째, 네 번째 형식(2nd, 3rd, 4th types)
*
* 자료형의 추론
*   자료형이 추론 가능한 경우 앵글 브라켓 표현 생략
*       val box3 = Box(1) // 1은 Int 형이므로 Box<Int>로 유추함
*       val box4 = Box("Hello") // "Hello" 은 String 형이므로 Box<String>로 유추함
*
* 제네릭 클래스
*   형식 매개변수를 한 개 이상 받는 클래스
*       인스턴스를 생성하는 시점에서 클래스의 자료형을 정하게 된다.
*       제네릭 클래스 내에 메서드에도 다음과 같이 형식 매개변수를 사용
*           class MyClass<T> { // 한 개의 형식 매개변수를 가지는 클래스
*               fun myMethod(a: T) { // 메서드의 매개변수 자료형에 사용됨
*           }
*       }
*
*   프로퍼티에 지정하는 경우
*       주 생성자나 부 생성자에 형식 매개변수를 지정해 사용
*
* 주 생성자의 형식 매개변수
*   class MyClass<T>(val myProp: T) { } // 주 생성자의 프로퍼티
*
* 부 생성자의 형식 매개변수
*   class MyClass<T> {
*       val myProp: T // 프로퍼티
*       constructor(myProp: T) { // 부 생성자 이용
*           this.myProp = myProp
*       }
*   }
*       정수형이 사용되 객체 초기화
*           var a = MyClass<Int>(12) // 주 생성자 myProp 에는 12가 할당되며 정수형으로 결정됨
*           println(a.myProp) // 12
*           println(a.javaClass) // MyClass
*
* */
/*

open class Parent

class Child: Parent()

class Cup<T>

fun main(){
//    val obj1: Child = Parent() //에러! 하위 형식인 Child 의 객체 obj1 는 Parent 로 변환되지 않음
    val obj2: Parent = Child() // Parent 형식의 obj2 는 Child 로 형 변환될 수 있음
//    val obj3: Cup<Child> = Cup<Parent>() // 에러! 자료형 형식이 일치하지 않음
//    val obj4: Cup<Parent> = Cup<Child>() // 에러! 자료형 형식이 일치하지 않음
    val obj5 = Cup<Child>() // obj5는 Cup<Child> 형식이 됨
    val obj6: Cup<Child> = obj5 // 형식이 일치하므로 OK!

    // 가변성을 주기위해 in, out 등을 설정해야 한다.

}*/

/*
* 형식 매개변수의 null 제어
*   제네릭의 형식 매개변수는 기본적으로 null 가능한 형태로 선언
*       class GenericNull<T> { // 기본적으로 null 이 허용되는 형식 매개변수
*           fun EqualityFunc(arg1: T, arg2: T) {
*               println(arg1?.equals(arg2))
*           }
*       }
*
* fun main(args: Array<String>){
*       val obj = GenericNull<String>() // non-null 로 선언됨
*       obj.EqualityFunc("Hello","World") // null 이 허용되지 않음
*
*       val obj2 = GenericNull<Int?>() // null 이 가능한 형식으로 선언됨
*       obj2.EqualityFunc(null, 10) // null 사용
* }
*   null 을 허용하지 않으려면?
*       특정 자료형으로 제핞나다. -> <T: Any>
*
*
* 제네릭 함수 혹은 메서드
*   제네릭 함수 혹은 메서드
*       해당 함수나 메서드 앞쪽에 <T> 와 같이 지정
*       자료형의 결정은 함수가 호출될 때 컴파일러가 자료형 추론
*       이 자료형은 반환 자료형과 매개변수 자료형에 사용할 수 있다.
*           fun <형식 매개변수[,...]> 함수형(매개변수: <매개변수 자료형>[, ...]): <반환 자료형>
*       fun <T> genericFunc(arg: T): T? {...} // 매개 변수와 반환 자료형에 형식 매개변수 T가 사용됨
*       fun <K, V> put(key: K, value: V): Unit {...} // 형식 매개변수가 여러 개인경우
*
*
* */
/*

fun <T> find(a: Array<T>, Target: T): Int{
    for( i in a.indices){
        if(a[i] == Target)  return i
    }
    return  -1

}
fun main() {
    val arr1: Array<String> = arrayOf("Apple", "Banana", "Cherry", "Durian")
    val arr2: Array<Int> = arrayOf(1, 2, 3, 4)

    println("arr.indices ${arr1.indices}") // indices 는 배열의 유효 범위 반환
    println(find<String>(arr1, "Cherry")) // 요소 C의 인덱스 찾아내기
    println(find(arr2, 2)) // 요소 2의 인덱스 찾아내기

}*/

/*
* 제네릭과 람다식
*   형식 매개변수로 선언된 함수의 매개변수를 연산할 경우
*       fun<T> add(a: T, b: T): T{
*           return a + b // 오류 자료형을 아직 결정할 수 없음
*       }
*       람다식을 사용하는 방법으로 연산식을 작성할 수 있다.
*       fun<T> add(a: T, b: T, op: (T, T) -> T): T{
*           return op(a,b)
*       }
*
*       fun main(){
*           val result = add(2,3, { a, b -> a + b})
*           // val result = add(2,3) {a, b -> a + b} 와 같이 표현 가능
*           println(result)
*       }
*
* 자료형 제한하기
*   형식 매개변수를 특정한 자료형으로 제한
*       자료형의 사용범위를 좁히기 위해 자료형을 제한한다.
*       자바에서는 extends 나 super 를 사용해 자료혀을 제한
*       코틀린은 콜론(:) 과 자료형을 기입하면 형식 매개변수 T 의 자료형이 기입한 자료형으로 제한됨
* */
/*

class Calc<T: Number> { //클래스의 형식 매개변수 제한
        fun plus(arg1: T, arg2: T): Double{
            return arg1.toDouble() + arg2.toDouble()
        }
}

fun main(args: Array<String>) {
    val calc = Calc<Int>()
    println(calc.plus(10, 20))

    val calc2 = Calc<Double>()
    val calc3 = Calc<Long>()
//    val calc4 = Calc<String>() // 제한된 자료형으로 인해 오류 발생

    println(calc2.plus(2.5, 3.5))
    println(calc3.plus(5L, 10L))

}*/

/*
* 함수의 자료형 제한하기
*   fun<T: Number> addLimit(a: T, b: T, op: (T, T) -> T): T{
*           return op(a,b)
*   }
*
*   val result = addLimit("abc", "def", {a, b -> a + b }) // 제한된 자료형으로 인해 오류 발생
*
* 상, 하위 형식의 가변성
*   가변성(variance)이란?
*       형식 매개변수가 클래스 계층에 어떤 영향을 미치는지 정의
*          -형식 A의 값이 필요한 모든 장소에 형식 B의 값을 넣어도 아무 문제가 없다면
*           B는 A의 하위 형식(subtype)
*          -Int 는 Number 의 하위 클래스
*
*   클래스와 자료형
*       형태          클래스인가?          자료형인가?
*       String          네                   네
*       String?         아니오                네
*       List            네                   네
*       List<String>    아니오                 네
*
* 하위클래스는 상위클래스가 수용
*   하위 자료형은 상위 자료형으로 자연스럽게 형 변환이 이루어짐
*       val integer: Int = 1
*       val number: Number = integer // 하위 자료형 Int 를 Number가 수용함
*
*       val integer: Int = 1;
*       val nullableInteger: Int? = integer;
*
* 가변성의 3가지 유형
*   3가지 유형
*       용어                          의미
*       공변성(covariance)             T'가 T의 하위 자료형이면, C<T'>는 C<T>의 하위 자료형이다 생산자 입장의 out 성질
*       반공변성(contravariance)        T'가 T의 하위 자료형이면, C<T>는 C<T'>의 하위 자료형이다.
*       무변성(invariance)             C<T>와 C<T'>는 아무 관계 없다. 생산자 + 소비자
*
* 무변성(invariance)
*   자료형 사이의 하위 자료형 관계가 성립하지 않음
*   코틀린에서는 따로 지정해 주지 않으면 기본적으로 무변성
*       // 무변성(Invariance) 선언
*       class Box<T>(val size: Int)
*
*       fun main(args: Array<String>) {
*           val anys: Box<Any> = Box<Int>(10) // 자료형 불일치 오류!
*           val nothings: Box<Nothing> = Box<Int>(20) // 자료형 불일치 오류!
*       }
* 공변성(covariance)
*   형식 매개변수 사이의 하위 자료형 관계가 성릭
*   하위 자료형 관계가 그대로 인스턴스 자료형 사이의 관계로 이어지는 경우
*   out 키워드를 사용해 정의
*       // 공변성(Covariance) 선언
*   class Box<out T>(val size: Int)
*
*   fun main(args: Array<String>){
*       val anys: Box<Any> = Box<Int>(10) // 관계 성립으로 객체 생성 가능
*       val nothings: Box<Nothing> = Box<Int>(20)// 오류 ! 자료형 불일치
*       println(anys.size)
*   }
*
* 반공변성(Contravariance)
*   자료형의 상하 관계가 반대
*   하위 클래스의 자료형을 상위 클래스의 자료형이 허용
*   // 반 공변성(Contravariance) 선언
*   class Box<in T>(val size: Int)
*
*   fun main(args: Array<String>){
*       //val anys: Box<Any> = Box<Int>(10) // 오류 자료형 불일치
*       val nothings: Box<Nothing> = Box<Int>(20) // 관계 성립으로 객체 생성 가능
*       println(nothings.size)
*   }
* */
//
//open class Animal(val size: Int){
//    fun feed() = println("Feeding..")
//}
//class Cat(val jump: Int): Animal(50)
//
//class Spider(val poison: Boolean): Animal(1)*/
//
////1. 형식 매개변수를 Animal 로 제한
//class Box<out T: Animal>(val element: T) { // 주 생성자에서 val 만 허용
//    fun getAnimal(): T = element // 2. out은 반환자료형에만 사용할 수 있음
////    fun set(new: T){ 3. 오류 ! T는 in 위치에 사용할 수 없음
////    element = new
////    }
//}
//
//class Box<out T: Animal>(val element: T){
//    fun getAnimal(): T = element
//
//}
//
//fun main() {
//
//    //일반적인 객체 선언
//    val c1 = Cat(10)
//    val s1 = Spider(true)
//
//    //클래스의 상위 자료형 변환은 아무런 문제 없음
//    var a1: Animal = c1
//    a1 = s1 // a1은 Spider의 객체가 됨
//    println("s1 ${a1.size} ${a1.poison}")
//    val b1: Box<Cat> = Box<Animal>()
//    val b2: Box<Animal>  = Box<Cat>()
//    val b3 = Box<Spider>()
////    val b4: Box<Number> = Box<Int>()*//*
//
//    // 공변성 - Cat 은 Animal 의 하위 자료형
//    val c2: Box<Animal> = Box<Cat>(Cat(10))
//    println("c2.element.size = ${c2.element.size}")
//
//    // 반대의 경우는 가능하지 않음
//    // val c3: Box<Cat> = Box<Animal>(10) 오류
//
//    // 자료형이 제한되 Animal 과 하위 클래스 이외에는 사용할 수 없음
//    // val c4: Box<Any> = Box<Int>(10) 오류
//
//
//}

/*
* 자료형 프로젝션
*   선언 지점 변성(declaration-site variance)
*       클래스 자체에 가변성을 지정하는 방식으로 클래스에 in/out 을 지정할 수 있다.
*       선언하면서 지정하면 클래스의 공변성을 전체적으로 지정하는 것
*           -클래스를 사용하는 장소에서는 따로 자료형을 지정해 줄 필요가 없음
*       class Box<in T: Animal>(var item: T)
*
*   사용 지점 변성(use-site variance)
*       메서드 매개변수에서 또는 제네릭 클래스를 생성할 대와 같이
*       사용 위치에서 가변성을 지정하는 방식
*       예) class Box<T>(var item: T)
*           Box 의 사용시점에서 box 의 item 을 얻느냐(get) 설정하느냐(set) 에 따라 out / in 결정
*       fun <T> printObj(box: Box<out Animal>) {
*           val obj: Animal = box.item // item 의 값을 얻음(get)
*           println(obj)
*       }
*           자료형 프로젝션을 통해 자료의 안정성을 보장
*
* 스타 프로젝션
*   in/out 을 정하지 않고 추후에 결정
*       어떤 자료형이라도 들어올 수 있으나 구체적으로 자료형이 결정되고 난 후에는 그 자료형과
*       하위 자료형의 요소만 담을 수 있도록 제한
*
*       Foo<out T: TUpper>
*           Foo<*>는 Foo<out TUpper> 와 동일
*       Foo<in T>
            Foo<*>는 Foo<in Nothing> 와 동일
* */
/*

class InOutTest<in T, out U>(t: T, u: U){
//    val propT: T = t // 오류! T는 in 위치기 때문에, out 위치에 사용 불가
    val propU: U = u // U는 out 위치로 가능

//    fun func1(u: U)// 오류! U는 out 위치기 때문에 in 위치에 사용 불가
    fun fuc2(t: T){ // T는 in 위치에 사용됨
        print(t)
    }

}

fun starTestFunc(v: InOutTest<*,*>){
//    v.func2() // 오류: Nothing 으로 인자를 처리함
    print(v.propU)
    //in 으로 정의되어 있는 형식 매개변수를 *로 받으면 in Nothing 인 것으로 간주
    //out 으로 정의되어 있는 형식 매개변수를 *로 받으면 out Any? 인 것으로 간주
}
*/

/*
* 프로젝션 정리
*   종류          예               가변성                 제한
*   out 프로젝션   Box<out Cat>     공변성                 형식 매개변수는 세터를 통해 값을 설정하는 것이 제한됨
*   in 프로젝션    Box<in Cat>      반공변성                형식 매개변수는 게터를 통해 값을 읽거나 반환 가능
*   스타 프로젝션   Box<*>           모든 인스턴스는 하위타입   in 과 out 은 사용 방법에 따라 결정됨
*                                  될 수 있음
*
* reified 자료형
*   reified 자료형이 필요한 이유
*       fun<T> myGenericFun(c: Class<T>)
*           T 자료형은 실행 시간에 삭제
*           컴파일 시간에는 접근 가능하나 함수 내부에서 사용하려면 위의 코드에서 함수의 매개변수를 넣어
*           c: Class<T> 처럼 지정해야만 실행 시간에 사라지지 않고 접근
*
*       inline fun <reified T> myGenericFun()
*           reified 로 형식 매개변수 T를 지정하면 실행 시간에 접근 가능
*           reified 자료형은 inline 함수에서만 사용할 수 있다.
*               컴파일러가 복사해 넣을 때 실제 자료형을 알 수 있기 때문에 실행 시간에도 사용할 수 있게됨
*
* Class<T> 와 KClass
*   Class<T>
*       .class 형태로 반환받는 객체
*       Class 라는 클래스는 원본 클래스에 대한 많은 메타 데이터를 가짐
*           패키지 이름이나 메서드, 필드, 구현된 인터페이스, 각종 검사 변수 등
*
*   Object::class
*       코틀린의 표현 방법으로 KClass 를 나타냄
*
*   자바의 클래스를 가져오려면 .java 사용
*       Object::class // KClass
*       Object::class.java //Class
*
*
*
* */


fun main() {
    val result = getType<Int>(10)
    println("result = $result")
}
inline fun <reified T>getType(value: Int):T {
    println(T::class)//실행 시간에 삭제되지 않고 사용 가능
    println(T::class.java)

    return when(T::class){ // 받아들인 제네릭 자료형에 따라 반환
        Float::class -> value.toFloat() as T
        Int::class -> value as T
        else -> throw IllegalStateException("${T::class} is not supported!")


    }
}