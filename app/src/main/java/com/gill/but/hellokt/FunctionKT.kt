package com.gill.but.hellokt


//함수
//함수의 선런
/*fun sum(a: Int, b: Int): Int{
    var sum = a+b
    return sum
}*/
/*fun 함수 이름 ([변수 이름: 자료형, 변수 이름: 자료형..]): [반환값의 자료형]{
*           표현식...
*       [return 반환값]
*       //코틀린에서 반환값이 없을경우 Unit을 나타낸다
*
* }
*
*
* 함수를 간략하게 표현하기
*
* 일반적인 함수의 모습
*   fun sum(a: Int, b: Int): Int{
*       return a+b
}
*
* 간략화 된 함수
*   fun sum(a: Int, b: Int): Int = a+b
*
* 반환 자료형 생략
*   fun sum(a: Int, b: Int) = a+b
*
*
* */

/*
fun sum(a: Int, b: Int):Int{ // 반환값이 안적혀 있을경우 하단 리턴문은 에러가 발생한다
    return a+b
}//최상위 함수

fun main(){ // 최상위 Top-level) 함수
    val result1 = sum(2,3)
    println(result1)

}
*/

/*
* 최상위 함수 특징
*   sum 이라는 이름은 main 의 위 호은 아래에 두더라도 해당 이름을 main
*   안에서 사용할 수 있다. */

/*
fun main(){ // 최상위 Top-level) 함수

    fun sum(a: Int = 2 , b: Int =5 ):Int{ //a의 값은 2로 디폴트 값 b의 값이 지정이 안되었다면 b는 5로 디폴트 값이다.
        return a+b
    }// 지역 함수
*//*
*   fun sum(a: Int, b: Int) = a+b 로 줄일 수 있따.
*//*


    val result1 = sum(2,3)

    val a = 3
    val b = 5

    val result2 = max(a, b)

    val result3 = sum(b = 2) // b의 값을 지정하고싶으면 이렇게 작성하면 된다.



    outfunc("hangang")
    println(result1)
    println(result2)
    println(result3)
}
fun max(a: Int, b: Int): Int{
    return if(a > b) a else b
    //a와 b를 비교하는 함수 a가 b보다 클 경우 a를 출력 / b가 클경우 b를 출력
}

*//*fun max(a: Int, b: Int) = if(a > b) a else b 로 줄일 수 있다.
*//*


fun outfunc(name: String): Unit{
    println("Name: $name")
    *//*return Unit 이 생략 되어있는 것 이다. 위에 :Unit을 생략해도 된다.*//*
}

*//*fun outfunc(name: String) = println("Name: $name") 로 줄일 수 있다.
}*/

/*//가변형 함수 작성
fun normalVarargs(vararg a: Int){//vararg 를 사용하면 인수가 여러개 가능하다
    for(num in a){
        print("$num ")
    }
}

fun main() {
    normalVarargs(1 )
    println()
    normalVarargs(1, 2, 3, 4 )
}*/

/*
* 함수와 스택 프레임 이해하기
*   힙
*       낮은주소에서 높은 주소로
*   스택
*       높은주소에서 낮은 주소로
*       스택에는 임시로 사용되는 것에 들어간다.
*       지역 변수들
*       항 스택
*
*
*   fun main() {
*   val num1 = 10
*   val num2 = 3
*   val result: Int
*
*   result = max(num1, num2)
*   println(result)
*  }
*
* fun max( a: Int, b: Int) = if(a>b) a else b
* */

/*
* 함수형 프로그래밍
*
*   코틀린은 다중 패러다임 언어
*       함수형 프로그래밍(FP: Functional Programming)
*       객체 지향 프로그래밍(OOP: Object-Oriented Programming)
*
*   함수형 프로그래밍
*       코드 간략, 테스트나 재사용성 증가
*       람다식, 고차 함수를 사용해 구성
*       순수 함수
*
* 순수함수
*   순수 함수(pure function) 이해
*       부작용(side-effect) 이 없는 함수
*           동일한 입력 인자에 대해서는 항상 같은 결과를 출력 혹은 반환 한다.
*           값이 예측이 가능해 결정적(deterministic) 이다.
*       순수 함수 예
*           fun sum(a: Int, b: Int): Int{
*               return a + b // 동일한 인자인 a,b 를 입력 받아 항상 a+b 를 출력(부작용이 없음)
*       }
*
*   순수 함수의 조건
*       같은 인자에 대하여 항상 같은 값을 반환
*       함수 외부의 어떤 상태도 바꾸지 않는다.
*
*   순수 함수가 아닌 것은?
*       fun check(){
*           val test = User.grade() // check() 함수에 없는 외부 User 객체를 사용
*           if(test != null) process(test) // 변수 test 는 User.grade() 의 실행 결과에 따라 달라짐
*       }

//순수함수 예제
const val global = 10

fun main(){
    val num1 = 10
    val num2 = 3
    val result = noPureFunction(num1, num2)
    println(result)
}

fun noPureFunction(a: Int, b: Int): Int{
    return a + b + global // 입력값과 무관하게 외부의 변수 사용
}
*
*   순수 함수를 왜?
*       입력과 내용을 분리하고 모듈화 하므로 재사용성이 높아진다.
*           여러가지 함수들과 조합해도 부작용이 없다
*       특정 상태에 영향을 주지 않으므로 병행 작업 시 안전하다
*       함수의 값을 추적하고 예측 할 수 있기 때문에 테스트, 디버깅 등이 유리하다
*
*   함수형 프로그래밍에 적용
*       함수를 매개변수, 인자에 혹은 반환값에 적용(고차 함수)
*       함수를 변수나 데이터 구조에 저장
*       유연성 증가
*
* 람다식
*   람다식(Lambda Expression) 이란?
*       익명 함수의 하나의 형태로 이름 없이 사용 및 실행이 가능
*       람다 대수(Lambda calculus) 로 부터 유래
*       { x, y -> x + y} // 람다식의 예 (이름이 없는 함수 형태)
*
*   람다식의 이용
*       람다식은 고차 함수에서 인자로 넘기거나 결과값으로 반환 등을 할 수 있다.
*
*
* 일급 객체
*   일급 객체(First Class Citizen)란?
*       일급 객체는 함수의 인자로 전달할 수 있다.
*       일급 객체는 함수의 반환값에 사용할 수 있다.
*       일급 객체는 변수에 담을 수 있다.
*
*   코틀린에서 함수는 1급 객체로 다룸
*
*
* 고차 함수의 이해
*   고차 함수(high-order function)란?
*       fun main() {
*           println(highFunc({ x, y -> x + y}, 10, 20)) // 람다식 함수를 인자로 넘김
*       }
*       fun highFunc(sum : (Int, Int) -> Int, a: Int, b: Int): Int = sum(a,b)// sum 매개변수는 함수
*       highFunc == 고차 함수/ sum == 람다식 매개 변수
*       (Int, Int) -> Int == 자료형이 람다식으로 선언되 {x,y -> x+y} 형태로 인자를 받는 것이 가능
*       a: Int, b: Int == 정수형 매개변수
*       Int == 반환 자료형
*
*
*
* */


fun highFunc(a: Int, b: Int, sum: (Int, Int) -> Int): Int{
    return sum(a, b)
}

fun main() {

    val result =  highFunc(1, 3){ x, y ->
        x + y
    }
    println(result)

}

/*
* 함수형 프로그래밍 왜?
*   왜 사용해야 하나요?
*       프로그램을 모듈화 해 디버깅 하거나 테스트가 쉬움
*       간략한 표현식을 사용해 생산성이 높음
*       람다식과 고차 함수를 사용하면서 다양한 함수 조합을 사용할 수 있다.
*
*   정리
*       함수형 프로그래밍은 순수 함수를 조합해 상태 데이터 변경이나 부작용이
*       없는 루틴을 만들어 내며 이름 없는 함수 형태의 하나인 람다식을 이용해
*       함수를 변수처럼 매개 변수, 인자, 반환값 등에 활용하는 고차 함수를 구성해
*       생산성을 높인 프로그래밍 방법
*
* */
