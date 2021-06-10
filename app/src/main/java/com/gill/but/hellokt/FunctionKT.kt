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


fun main(){ // 최상위 Top-level) 함수

    fun sum(a: Int, b: Int):Int{
        return a+b
    }// 지역 함수

    val result1 = sum(2,3)
    println(result1)



}
