package com.gill.but.hellokt

/*
* 기본 연산자
*
* 종류
*   산술, 대입, 증가, 감소, 비교, 논리 연산자 등
*
* 수식의 구조
*   val result = num1 + num2
*           대입 이항 연산자   덧셈 이항 연산자
*
* 산술 연산자
*   +   덧셈
*   -   뺄셈
*   *   곱셈
*   /   나눗셈
*   %   나머지
*
*   if((n % 2) ==1) { // 홀수
*   println(n is an Odd number")
*   }
*   if((n % 2) ==0) { // 짝수
*   println(n is an Even number")
*   }
*
* 대입 연산자
*   =   오른쪽 항의 내용을 왼쪽 항에 대입 num =2
*   +=  두 항을 더한 후 왼쪽항에 대입   num += 2
*   -=  왼쪽 항을 오른쪽 항으로 뺀 후 왼쪽 항에 대입  num -= 2
*   *=  두 항을 곱한 후 왼쪽 항에 대입  num *= 2
*   /=  왼쪽 항을 오른쪽 항으로 나눈 후 왼쪽 항에 대입 num /= 2
*   %=  왼쪽 항을 오른쪽 항으로 나머지 연산 후 왼쪽 항에 대입 num %= 2
*
*   num = num + 2 // 산술 연산자와 대입 연산자를 함께 사용하는 경우
*   num += 2 // 이렇게 간략하게 표현
*
* 증감 연산자와 감소 연산자
*   ++  항의 값에 1 증가  ++num 또는 num++
*   --  항의 값에 1 감소  --num 또는 num--
* */
/*
fun main() {
    var num1 = 10
    var num2 = 10
    val result1 = ++num1 // num 값 증가 후 대입
    val result2 = num2++ // 먼저 num 값 대입 후 증가

    println("result1: $result1")
    println("result2: $result2")
    println("num1: $num1")
    println("num2: $num2")
}*/

/*
* 비교 연산자
*   >   왼쪽이 크면 true, 작으면 false 반환 num > 2
*   <   왼쪽이 작으면 true, 크면 false 반환 num < 2
*   >=  왼쪽이 크거나 같으면 true, 아니면 false num >= 2
*   <=  왼쪽이 작거나 같으면 true, 아니면 false num <= 2
*   ==  두 개 항의 값이 같으면 true, 아니면 false num1 == num2
*   !=  두 개 항의 값이 다르면 true, 아니면 false num1 != num2
*   === 두 개 항의 참조가 같으면 true, 아니면 false num1 === num2
*   !== 두 개 항의 참조가 다르면 true, 아니면 false num1 !== num2
*
* 논리 연산자
*   &&  논리곱으로 두 항이 모두 true 일 때 true, 아니면 false exp1 && exp2
*   ||  논리합으로 두 항 중 하나의 항이 true 일 때 true, 아니면 false exp1 || exp2
*   !   부정 단항 연산자로 true 를 false 로, false 를 true 로 바꿈 !exp
*
*   var check = (5>3) && (5>2) // 2 개의 항 ((5>3), (5>2))이 모두 참이면 true
*   check = (5>3) || (2>5) // 2 개 중 1개의 항이 참이면 true
*   check = !(5>3)  //true 는 false 로, false 는 true 로 변경  */
