package com.gill.but.hellokt

/*
*
* 람다식(Lambda Expression)
*   구성
*       { 매개변수 [,...] -> 람다식 본문 }
*
*   사용 예
*       val sum: (Int, Int) -> Int = { x, y -> x+ y}
*       val mul = { x: Int, y: Int -> x * y}
*
*       val add: (Int) -> Int = {it + 1}
*
*
*   여러 개의 식이 있는 경우
*       val isPositive: (Int) -> Boolean ={
*           val isPositive = it > 0
*           is Positive // 마지막 표현식이 반환 됨
*       }
*
*       val isPositiveLabel: (Int) -> Boolean = number@{
*           val isPositive = it > 0
*           return@number isPositive // 라벨을 사용해 반환됨
*       }
*
* 고차 함수(Higher-Order Function)
*   개념
*       함수의 매개변수로 함수를 받거나 함수 자체를 반환할 수 있는 함수
*           fun high(name: String, body: (Int) -> Int): Int{
*               println("name: $name")
*               val x = 0
*               return body(x)
*           }
*
*   다양한 표현법
*       //함수를 이용한 람다식
*           val result = high("Sean", { x -> inc(x + 3)} )
*
*       //소괄호 바깥으로 뺴내고 생략
*           val result2 = high("Sean") { inc(it + 3)}
*
*       // 매개 변수 없이 함수의 이름만 사용할 때
*           val result3 = high("Kim", ::inc)
*
*       // 람다식 자체를 넘겨준 형태
*           val result4 = high("Sean") { x -> x + 3}
*
*       // 매개 변수가 한 개인 경우 생략
*           val result5 = high("Sean") { it + 3 }
*
*       // 만일 일반 매개 변수가 없고 람다식이 유일한 인자라면 다음과 같이 표현 간으
*           val result6 = highNoArg { it + 3 }
*
*
*
*
* */

