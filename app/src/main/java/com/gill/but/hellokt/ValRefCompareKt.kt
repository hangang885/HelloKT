package com.gill.but.hellokt

/*
* 자료형 비교, 검사, 변환
*
* 코틀린의 자료형 변환
*   기본형을 사용하지 않고 참조형만 사용
*   서로 다른 자료형은 변환 과정을 거친 후 비교
*
*   val a: Int = 1 // 정수형 변수 a 를 선언하고 1을 할당
*   val b: Double = a // 자료형 불일치 오류 발생
*   val c: Int = 1.1 // 자료형 불일치 오류 발생
*  변환 메서드의 이용
*   val b: Double = a.toDouble() // 변환 메서드 사용
*  표현식에서 자료형의 자동 변환
*   val result = 1L +3 // Long + Int -> result 는 Long
*
* 변환 메서드의 종류
*   toByte: Byte
*   toLong: Long
*   toShort: Short
*   toFloat: Float
*   toInt: Int
*   toDouble: Double
*   toChar: Char
*
* 이중 등호(==)와 삼중 등호(===)의 사용
*   == 값만 비교하는 경우
*   === 값과 참조 주소를 비교할 때
*   val a: Int = 128
*   val b: Int = 128
*   println(a == b) // true
*   println(a === b) // true
* 자바에서는 == 에서 값과 참조 주소를 비교하므로 주의해야한다.
*
* 참조 주소가 달라지는 경우
*   val a: Int = 128
*   val b: Int? = 128
*   println(a == b) // true
*   println(a === b) // false
* */
/*fun main() {
    val a: Int = 128
    val b = a

    val c: Int? = a
    val d: Int? = a
    val e: Int? = c

    println(c == d)
    println(c === d)
    //true
    //false
    // 값은 같지만 주소 공간이 다르다

    println(c === e)
    //true
}*/
/*
* 스마트 캐스트
*
* 구체적으로 명시되지 않은 자료형을 자동 변환
*   값에 따라 자료형을 결정 // 추론이 불가능 할 경우 꼭 자료형 명시
*   Number 형은 숫자를 저장하기 위한 특수한 자료형으로 스마마트캐스됨 */
//스마트 캐스트 사용해보기
/*
fun main() {
    var test: Number = 12.2 // 12.2에 의해 test 는 Float 형으로 스마트 캐스트
    println("$test")

    test = 12 // Int 형으로 스마트 캐스트
    println("$test")

    test = 120L // Long 형으로 스마트 캐스트
    println("$test")

    test += 12.0f // Float 형으로 스마트 캐스트
    println("$test")
    //12.2
    //12
    //120
    //132.0
}*/


//is 키워드를 사용한 검사

/*fun main() {
    val num = 256

    if(num is Int){//num 이 Int 형일 때
        print(num)
    }
    else if(num !is Int){ // num 이 Int 형이 아닐 때, !(num is Int) 와 동일
        print("Not a Int")

    }
}*/

/*
* 묵시적 변환
*
* Any
*   자료형이 정해지지 않은 경우
*   모든 클래스의 뿌리 - Int 나 String 은 Any 형의 자식 클래스 이다.
*   Any 는 언제는 필요한 자료형으로 자동 변환 (스마트 캐스트)
* */
/*
fun main() {
    var a: Any = 1 // Any 형 a 는 1로 초기화 될 때 Int 형이 됨
    a = 20L // Int 형이였던 a 는 변경된 값 20L에 의해 Long 이 됨
    println("a: $a type: ${a.javaClass}")
    //a: 20 type: long
}*/

//Any 형으로 인자를 받는 함수 만들기
fun main() {
    checkArg("Hello") // 문자열을 인자로 넣음
    checkArg(5) // 숫자를 인자로 넣음
}
fun checkArg(x: Any){ // 인자를 Any 형으로 받음

    if(x is String){
        println("x is String: $x")
    }
    if(x is Int){
        println("x is Int: $x")
    }

    //x is String: Hello
    //x is Int: 5
 }