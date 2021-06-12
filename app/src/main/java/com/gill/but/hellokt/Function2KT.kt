package com.gill.but.hellokt

import java.lang.System.out

/*
* 익명 함수
*   익명 함수(anonymous functions)
*       함수가 이름이 없는 것
*           fun(x: Int, y: Int): Int = x + y // 함수 이름이 생략된 익명 함수
*           val add: (Int, Int) -> Int = fun(x, y) = x + y // 익명 함수를 사용한 add 선언
*           val result = add(10, 2) // add 의 사용
*           val add = fun(x: Int, y: Int) = x + y
*           val add = {x: Int, y: Int -> x + y} // 람다식과 매우 흡사
*       일반 익명 함수에서는 return, break continue 가 사용 가능하지만
*       람다식에서는 사용하기가 어렵다.(라벨 표기법과 같이 사용해야 함)
*
* 인라인 함수
*       인라인(inline) 함수
*           함수가 호출되는 곳에 내용을 모두 복사
*           함수의 분기 없이 처리 -> 성능 증가
*           fun main() {
*           sub() // 본문 abc 로 복사됨
*           sub() // 본문 abc 로 복사됨
*
*       }
*           inline fun sub(...) {
*               abc
*           }
*
* */
/*
inline fun shortFunc(a: Int, crossinline out: (Int) -> Unit) {
    println("Hello")
    out(a)
    println("Goodbye")
}


fun main() {
    shortFunc(3) {
        println("a: $it")
          *//*return*//*
    }
}*/

/*
* 인라인 함수의 제한과 인라인 금지
*
*   인라인 함수의 단점
*       코드가 복사되므로 내용이 많은 함수에 사용하면 코드가 늘어남
*   noinline 키워드
*       일부 람다식 함수를 인라인 되지 않게 하기 위해
*           inline fun sub(out1: () -> Unit, noinline out2: () -> Unit){
*
*
* 확장 함수
*   확장 함수(extension function)
*       클래스의 멤버 함수를 외부에서 더 추가할 수 있다.
*           fun 확장대상, 함수명(매개변수, ...): 반환값{
*                   ...
*               return 값
*              }
*
*   fun main(){
*           val source = "Hello World!"
*           val target = "Kotlin"
*           println(source.getLongString(target))
*           }
*   //String 을 확장해 getLongString 추가
*       fun String.getLongString(target: String): String =
*               if (this.length > target.length) this else target
*           //this 는 확장 대상에 있던 자리의 문자열인 source 객체를 나타냄
*           //기존의 표준 라이브러리를 수정하지 않고도 확장
*
* 중위 함수
*   중위 표현법(infix notation)
*       클래스의 멤버 호출 시 사용하는 점(.)을 생략하고 함수 이름 뒤에
*       소괄호를 생략해 직관적인 이름을 사용할 수 있는 표현 법
*           중위함수의 조건
*               멤버 메서드 또는 확장 함수여야 합니다.
*               하나의 매개변수를 가져야 합니다.
*               infix 키워드를 사용하여 정의합니다.
*
*
*
*
*
*
* */
/*fun main() {
    //일반 표현법
    //val multi = 3.multiply(10)

    //중위 표현법
    val multi = 3 multiply 10
    println("multi: $multi")
}

//Int 를 확장해서 multiply() 함수가 하나 더 추가되었음
infix fun Int.multiply(x:Int): Int { //infix 로 선언되었으므로 중위 함수
        return this * x

}*/

/*
fun main() {
    val num = 3
//    val str = num.strPlus("Kotlin")
    val str = num strPlus "Kotlin" // 중위 표현법
    println(str)
}

infix fun Int.strPlus(x: String): String{
    return "$x version $this"
}



*/

/*
* 꼬리 재귀 함수
*   재귀(recursion)란
*       자기 자신을 다시 참조
*       재기 함수는 자기 자신을 계속 호출하는 특징
*
*   재기 함수의 필수 조건
*       무한 호출에 빠지지 않도록 탈출 조건을 만들어 준다
*       스택 영역을 이용하므로 호출 횟수를 무리하게 많이 지정해 연산하지 않는다
*       코드를 복잡하지 않게 한다.
*
* 꼬리 재귀 함수(tail recursive function)
*       스택에 계속 쌓이는 방식이 함수가 계속 씌워지는 꼬리를 무는 형태
*       코틀린 고유의 tailrec 키워드를 사용해 선언
*
* */
/*fun main() {
    val number = 4
    val result: Long

    result = factorial(number)
    println("Factorial: $number -> $result")
}

fun factorial(n: Int): Long{
    return if(n==1) n.toLong() else n * factorial(n-1)
    *//*
    * factorial(4)
    * 4 * factorial(3)
    * 4 * (3 * factorial(2))
    * 4 * (3 * (2 * factorial(1)))
    * 4 * (3 * (2 * 1))
    * 24*//*
}*/

/*
fun main(){
    val number = 4
    println("Factorial: $number -> ${factorial(number)}")
}

tailrec fun factorial(n: Int, run: Int = 1 ): Long{
    return if (n == 1) run.toLong() else factorial(n-1, run * n )
}
*/


/*
* 함수의 실행 블록
*   함수의 블록 ({})
*       블록내에서 사용하는 변수 - 지역 변수(Local variable)
*   함수의 범위(Scope)
*       최상위 함수와 지역 함수
*
*   fun main() { // 최상위 레벨의 함수
*       ...
*           fun secondFunc(a: Int) { //지역 함수 선언
*               ...
*       }
*       userFunc(4) // 사용자 함수 사용 - 선언부 위치에 상관 없이 사용
*       secondFunc(2) // 지역 함수 사용 - 선언부가 먼저 나와야 사용 가능
*   }
*
*   fun userFunc(counts: Int) { //사용자가 만든 최상위 레벨의 함수 선언
*       ...
*       }
*
*
* 최상위 및 지역함수의 사용 범위
*   최상위 함수는 main() 함수 전, 후 어디든 선언하고 코드 내에서 호출 가능
*   지역 함수는 먼저 선언되어야 그 함수를 호출할 수 있음
*
* */

/*
fun a() = b() // 최상위 함수이므로 b() 함수 선언 위치에 상관 없이 사용 가능
fun b() = println("b")// b() 함수의 선언

fun c() {
//    fun d() = e() // 오류 ! d()는 지역함수이며 e()의 이름을 모름
    fun e() = println("e")
}
fun main() {
    a() // 최상위 함수는 어디서든 사용할 수 있따.
    */
/*e() // 오류 ! c 함수에 정의된 e() 는 c의 블록 ({})을 벗어난 곳에서 사용할 수 없음*//*

}*/


var global = 10

fun main(){

fun localFunc1(){
    println("localFunc1")
}

    localFunc1()

    global = 15
    val local1 = 15
    println("global: $global")
    userFunc()
    println("final - global: $global, local1: $local1")
}

fun userFunc(){
    global = 20
    val local1 = 20
    println("userFunc - global: $global, local1: $local1")
}

/*변수의 범위
*
*   전역 변수
*       최상위에 있는 변수로 프로그램이 실행되는 동안 삭제되지 않고 메모리에 유지
*       여러 요소가 동시에 접근하는 경우에 잘못된 동작을 유발할 수 있음
*       자주 사용되지 않는 전역 변수는 메모리 자원 낭비
*
*   지역 변수
*       특정 코드 블록 내에서만 사용
*       블록 시작 시 임시로 사용되며 주로 스택 메모리를 사용
*
* */