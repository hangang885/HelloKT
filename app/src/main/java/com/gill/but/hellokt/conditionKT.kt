package com.gill.but.hellokt

/*
* if 문과 if~else 문
*
*   if문, if~else 문
*
*   if(조건식) {
*       수행할 문장 // 조건식이 참인 경우에만 수행
*       ...
*      }
*
*   if(조건식) {
*       수행할 문장 // 조건식이 참인 경우에만 수행
*   }
*   else {
*       수행할 문장 // 조건식이 거짓인 경우에 수행
*       }
*   //if 문
*   var max = a
*   if( a < b)
*       max = b // 수행할 문장이 한 줄이면 중괄호를 생략할 수 있음
*
*   if~else 문의 간략화
*       var max: Int
*       if( a > b)
*           max = a
*       else
*           max = b
*       val max = if( a > b) a else b
*
*
* */

/*
//블록과 함께 사용하는 경우
fun main() {
    val a = 12
    val b = 7

    //블록과 함께 사용
    val max = if (a > b){
            println("a 선택")
            a // 마지막 식인 a가 반환되어 max에 할당
    }
    else{
        println("b 선택")
        b // 마지막 식인 b가 반환되 max에 할당
    }
    println(max)
}
*/
/*

fun main() {
    val a = 17
    val b = 7

    val max = if (a > b){
        println("a $a")
        a
    }else{
        println("b $b")
        b
    }
    println("max $max")

}
*/

/*
*
* else if 문으로 조건문 중첩하기
*
*   else if 는 필요한 만큼 조합할 수 있다
*       마지막은 else로 구성
*
*   val number = 0
*   val result = if (number > 0)
*           "양수 값"
*       else if(number <0)
*           "음수 값"
*       else
*           "0"
* */
/*fun main() {
    print("Enter ther score:")
    val score = readLine()!!.toDouble()

    var grade: Char = 'F'
    when {
        score >= 90.0 -> {
            grade = 'A'

        }
        score in 80.0..89.9 -> {
            grade = 'B'
        }
        score in 70.0..79.9 -> {
            grade = 'C'
        }
    }

    println("score: $score, grade: $grade")

}*/

/*
* in 연산자와 범위 연산자로 조건식 간략하게 만들기
*   비교 연산자와 논리 연산자의 복함
*       ...} else if (score >= 80.0 && score <= 89.9){...
*       비교 연산자 (>=, <=) 와 논리곱 연산자(&&)가 사용
*
*   범위(range) 연산자
*       변수명 in 시작값.. 마지막 값
*       score in 80..89이면 score 범위에 80부터 89까지 포함한다
*
*
* when 문으로 다양한 조건 처리
*   인자를 사용하는 when 문
*       when(인자) {
*           인자에 일치하는 값 혹은 표현식 -> 수행할 문장
*           인자에 일치하는 범위 -> 수행할 문장
*           ...
*           else -> 문장
*       }
*
*       when(x){
*           1 -> println("x == 1")
*           2 -> println("x == 2")
*           else -> { // 블록 구문 사용 가능
*               print("x는 1, 2가 아닙니다.")
*               }
*       }
*
*       인자를 사용하는 when 문 (Cont.)
*           일치되는 여러 조건
*           when(x) {
*               0, 1 -> print("x == 0 or x == 1")
*               else -> print("기타")
*               }
*
*           함수의 반환값 사용하기
*           when(x) {
*               parseInt(s) -> print("일치함!")
*               else -> print("기타")
*               }
*
*           in 연산자와 범위 지정자 사용
*           when(x) {
*               in 1..10 -> print("x는 1 이상 10 이하입니다.")
*               !in 10..20 -> print("x는 10 이상 20 이하의 범위에 포함되지 않습니다.")
*               else -> print("x는 어떤 범위에도 없습니다.")
*           }
*
*           is 키워드 함께 사용하기
*           val str = "안녕하세요."
*           val result = when(str){
*           is String -> "문자열 입니다."
*           else -> false
*       }
* }
*
*
*
*       */

/*fun main() {
    print("Enter ther score:")
    val score = readLine()!!.toDouble()

    var grade: Char = 'F'

    when(score){
        in 90.0 .. 100.0 -> grade = 'A'
        in 80.0 .. 89.9 -> grade = 'B'
        in 70.0 .. 79.9 -> grade = 'C'
        else -> grade = 'F'
    }

    println("score: $score, grade: $grade")

}*/

/*
*   인자가 없는 when
*       when {
*           조건[혹은 표현식] -> 실행문
*           ...
*       }
*       특정 인자에 제한하지 않고 다양한 조건을 구성
*  */