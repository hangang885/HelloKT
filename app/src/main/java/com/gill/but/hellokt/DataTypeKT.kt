package com.gill.but.hellokt


/*자료형과 변수
*   자료형
*       Int 정수  1, 2, 3
*       String  문자열 "Hello123"
*       Float   실수  1.2
*       ...
*
*   변수
*       val(value) - 불변형 (immutable) 값을 바꿀수 없음
*       var(variable) - 가변형 (mutable) 값을 바꿀수 있음
*   변수의 선언
*       val username: String = "Hangang"
*    선언키워드  변수이름    자료형 값
*
*
* */
/*fun main() {

    //val username: String = "Hangang"
    //username = "Dooly" 이부분은 에러가뜬다 불변형 변수이기에 초기화가 안된다
    var username: String = "Hangang"
    username = "Dooly"
    var username2: String
    username2 = "Test"
    var count: Int = 3
    //컴파일러가 알 수 있는 타입은 자료형을 명시하지 않아도 추론해서 실행된다



    println("username: $username, count: $count")

}*/
/*변수 선언
*   변수 선언 예
*       var username = "Kildong" // 자료형을 추론하여 String으로 결정
*       var username: // 자료형을 지정하지 않은 변수는 사용할 수 없다
*       var init: Int // 사용 전 혹은 생성자 시점에서 init변수를 초기화 해야함
*       var number = 10 // number 변수는 Int형으로 추론
*
* 변수 이름
*   변수 이름은 123abc와 같이 숫자로 시작하면 안된다
*   변수 이름에는 while, if와 같이 코틀린에서 사용되는 키워드는 사용할 수없다
*   변수 이름은 의미 있는 단어를 사용하여 만드는 것이 좋다
*   여러 단어를 사용하여 변수 이름을 지을 경우 카멜 표기법(Camel Expression)을 사용하세요
*
*  일반 변수, 함수명 등(단봉 낙타와 같은 카멜 표기법)
*       camelCase
*       numberOfBooks
*       myFirstNumber
*   클래스, 인터페이스 등 (쌍봉 낙타 혹은 파스칼 표기법)
*       AnimalCategory
*       CarEngine
*
* 자료형
*   기본형(Primitive data type)
*       가공되지 않은 순수한 자료형으로 프로그래밍 언어에 내장
*       int, long, float, double 등
*   참조형(Reference type)
*       동적 공간에 데이터를 둔 다음 이것을 참조하는 자료형
*       Int, Long, Float, Double 등
*
*   기본형과 참조형의 동작 원리 이해하기
*       자바의 기본형과 참조형의 원리
*           int a= 77; // 기본형
*           Person person = new Person(); // 객체 참조형으로 person 객체를 위해 참조 주소 (A12)를 가진다
*
* 정수형
*   음수가 사용되는 부호 있는 자료형
*       Long    8바이트(64비트)
*       Int     4바이트(32비트)
*       Short   2바이트(16비트)
*       Byte    1바이트(8비트)
*
*   부호 없는 정수형
*       ULong   8바이트(64비트)
*       UInt    4바이트(32비트)
*       UShort  2바이트(16비트)
*       UByte   1바이트(8비트)
*
* 자료형 생략
*   val num05 = 127 // Int 형으로 추론
*   val num06 = -32768 // Int 형으로 추론
*   val num07 = 2147483647  // Int 형으로 추론
*   val num08 = 9223372036854775807 // Long 형으로 추론
*
* 접미사 접두사 사용
*   val exp01 = 123 // Int 형으로 추론
*   val exp02 = 123L // 접미사 L을 사용해 Long 으로 추론
*   val exp03 = 0x0F // 접두사 0x를 사용해 16진 표기가 사용된 Int 형으로 추론
*   val exp04 = 0b00001011 // 접두사 0b를 사용해 2진 표기가 사용된 Int 형으로 추론
*
* 작은 값의 사용
*   val exp08: Byte = 127 // 명시적으로 자료형을 지정(Byte)
*   val exp09 = 32767 // 명시적으로 자료형을 지정하지 않으면 Short 형 범위의 값도 Int 형으로 추론
*   val exp10: Short = 32767 // 명시적으로 자료형을 지정(Short)
*
* 부호 없는 자료형
*   val uint: UInt = 153u
*   val ushort: UShort = 65535u
*   val ulong: ULong = 46322342uL
*   val ubyte: UByte = 255u
*
* 큰 수를 읽기 쉽게 하는 방법
*   읽기 쉽게 하기 위해 언더스코어(_)를 포함해 표현
*   val number = 1_000_000
*   val cardNum = 1234_1234_1234_1234L
*   val hexVal = 0xAB_CD_EF_12
*   val bytes = 0b1101_0010
*
* 실수 자료형
*   Double  8바이트(64비트)
*   Float   4바이트(32비트)
*
*   val exp01 = 3.14 // Double 형으로 추론(기본)
*   val exp02 = 3.14F // 식별자 F에 의해 Float 형으로 추론
*
*
** * */

//공간 제약에 따른 부동 소주점 연산의 단점
/*
fun main() {
    var num: Double = 0.1

    for(x in 0..999){
        num += 0.1
    }
    println(num) // 100.09999999999859
}*/

//최대자리 확인
/*fun main() {
    println("Byte: ${Byte.MIN_VALUE}~${Byte.MAX_VALUE}")
    println("Int: ${Int.MIN_VALUE}~${Int.MAX_VALUE}")
    println("Short: ${Short.MIN_VALUE}~${Short.MAX_VALUE}")
    println("Long: ${Long.MIN_VALUE}~${Long.MAX_VALUE}")
    println("Float: ${Float.MIN_VALUE}~${Float.MAX_VALUE}")
    println("Double: ${Double.MIN_VALUE}~${Double.MAX_VALUE}")
}*/
/*
Byte: -128~127
Int: -2147483648~2147483647
Short: -32768~32767
Long: -9223372036854775808~9223372036854775807
Float: 1.4E-45~3.4028235E38
Double: 4.9E-324~1.7976931348623157E308
*/


/*2의 보수란
*
* 자료형의 최소 최대
*   음수는 2의 보수 표현을 사용해 연산됨
*       절대값의 이진수의 값을 뒤집고 1을 더함
*
*   왜? 제한된 자료형을 음수/양수로 나누어 최대한 사용하며 2의 보수는
*   가산 회로만으로 뺄셈을 표현할 수 있기 때문
*
* 논리 자료형
*   Boolean 1비트 true,false
*
*   val isOpen = true // isOpen 은 Boolean 으로 추론
*   val isUploaded: Boolean // 선언만 한 경우 자료형(Boolean) 반드시 명시
*
* 문자 자료형
*   Char    2바이트(16비트)
*
*   val ch = 'c' // ch는 Char 로 추론
*   val ch2: Char // 선언만 한 경우 자료형(Char) 반드시 명시
*
* 문자열
*   String 으로 선언되며 String Pool이라는 공간에 구성
*
*
* */
/*

fun main(){
    val str1: String = "Hello"
    val str2 = "World"
    var str3 = "Hello"

    // == 는 값만 비교, ===는 참조까지 비교
    // (자바는 ==으로 참조까지 비교할 수 있고 === 연산자는 없다)

    println("str1 === str2: ${str1 === str2}")
    println("str1 === str3: ${str1 === str3}")
}
*/

/*
* 표현식에서 문자열
*
*   표현식과 $ 기호 사용하여 문자열 출력하기
*       var a = 1
*       val s1 = "a is $a" // String 자료형의 s1을 선언하고 초기화. 변수 a가 사용됨
*   */

fun main() {
    var a = 1
    val str1 = "a = $a"
    val str2 = "a = ${a +2}" // 문자열에 표현식 사용

    println("str1: \"$str1\", str2: \"$str2\"")

}
//str1: "a = 1", str2: "a = 3"