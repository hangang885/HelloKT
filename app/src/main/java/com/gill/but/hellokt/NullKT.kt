package com.gill.but.hellokt

/*
*
* null 을 허용한 변수 검사
*
* 코틀린의 변수 선언은 기본적으로 null 을 허용하지 않는다
*   val a: Int = 30
*   val b: String = "Hello"
*
* null 가능한 선언
*   val a: Int? = null
*   var b: String? =null
*
* ?를 붙여 널을 가능하게 만들어준다
*
* NPE (NPE, NullPointerException)
*   사용할 수 없는 null 인 변수에 접근하면서 발생하는 예외
* */

/*
fun main() {*/
/*
    //null을 허용하기 위해선 ? 으로 null을 가능하게 선언하여야 한다
    var str1: String?
    str1 = null

    println("str1: $str1, length: ${str1?.length}")
    // null 은 길이를 안되기에 에러가 뜬다 not null 을 호출하거나 세이프콜 ?. 를 사용해야 한다*//*

    //str1: null, length: null

 */
/*   var str1: String?
//    str1 = "Hello"
    str1 = null
    println("str1: $str1, length: ${str1!!.length}")
    // !! 넌널 단정 기호 널이 아닐꺼라고 단정해서 컴파일러가 오류를 무시하게된다
    // str1 값이 null 일경우 에러가 발생한다.*//*


    var str1: String?
    str1 = null
    val len = str1?.length ?: -1
    println("str1: $str1, length: $len")
    //str1: null, length: -1
    //str1 이 Hello 일경우 length 는 5가 나온다

}
*/

/*
* null 처리 방법
*
* Kotlin 의 처리 방법 비교
*   kotlin 에서는 기본적으로 NotNull 이고 Nullable 표현에만 '?' 가 사용된다
* */

/*fun set(a: String, b: String?){
    //Do noting
}

fun main() {
    var temp: String? = null
    var size = -1
    if(temp != null){
        size = temp.length
    }

    //or

    var temp1: String? = null
    val size1 = if(temp1!= null) temp1.length else -1

}*/

/*
fun main() {
    var str1: String? ="Hello Kotlin"
    str1 = null
    println("str1: $str1 length: ${str1.length}") // null 을 허용하면 length 가 실행될 수 없음

    //세이프 콜(Safe-call)
        str1?.length
    //non-null 단정 기호
        str1!!.length
}*/

//조건문을 활용해 null 을 허용한 변수 검사하기
//  if 와 else 의 활용
/*
fun main() {
    var str1: String? = "Hello Kotlin"
    str1 = null
    // 조건식을 통해 null 상태 검사
    val len = if(str1 != null) str1.length else -1
    println("str1: $str1 length: ${len}")
}
*/

/*
* 세이프 콜과 엘비스 연산자를 활용해 null 허용
* 더 안전하게 사용하는 방법
*   str1?.length ?: -1
* */
fun main() {
    var str1: String? = "Hello Kotlin"
    str1 = null
    println("str1: $str1 length: ${str1?.length ?: -1}")
    //세이프 콜과 엘비스 연산자 활용
    //str1: null length: -1
}