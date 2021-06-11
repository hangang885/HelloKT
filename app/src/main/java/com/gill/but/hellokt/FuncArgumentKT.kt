package com.gill.but.hellokt

/*fun sum(a: Int, b: Int) = a + b
fun mul(a: Int, b: Int): Int{
    return a * b
}

fun funcFunc(a: Int, b: Int) = sum(a, b)


fun main() {

    val result = sum(10, 10)
    val result2 = mul(sum(10, 5), 10)
    val result3 = funcFunc(2, 3)

    println("result: $result, result2: $result2, result3: $result3")

}*/

/*
*
* 값에 의한 호출
*   함수가 인자로 전달될 경우
*       람다식 함수는 값으로 처리되어 그 즉시 함수가 수행된 후 값을 전달
*
* */

/*fun main(){
    val result = callByValue(lambda()) // 람다식 함수를 호출
    println(result)
}

fun callByValue(b: Boolean): Boolean{//일반 변수 자료형으로 선언된 매개 변수
    println("callByValue function")
    return b
}

val lambda: () -> Boolean = { //람다 표현식이 두 줄이다
    println("lambda function")
    true

}*/
/*
*   1. 람다식 함수의 즉시 실행
*   2. true 의 반환
*   3. b에 true 의 값 복사
*   4. b에 true 의 값 반환
*   5. 반환된 true 의 값 할당
* */

fun main(){
    val result = callByName(otherLambda) // 람다식 이름으로 호출
    println(result)
}

fun callByName (b: () -> Boolean): Boolean { // 람다식 함수 자료형으로 선언된 매개변수
    println("callByName function")
    return b()
}

val otherLambda: () -> Boolean = {
    println("otherLambda function")
    true
}
/*
*   1. 람다식 자체가 매개변수에 복사됨
*   2. 람다식 함수가 호출되 실행
    3. true 반환
    4. b() 결과인 true 반환
*
*
*
* 다른 함수의 참조에 의한 호출
*
*   fun sum(x: Int, y: Int) = x + y
*   funcParam(3, 2, sum) // 오류 sum 은 람다식이 아님
*   ...
*   fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int{
*       return c(a,b)
*   }
*
*   func Param(3, 2, ::sum)
*
*
 */