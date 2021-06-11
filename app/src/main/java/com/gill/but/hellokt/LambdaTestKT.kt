package com.gill.but.hellokt

fun main() {

    val result: Int

    /*val multi = { a:Int , b: Int -> a * b }*/
    val multi: (a: Int, b: Int) -> Int = { a, b ->
        println("a: $a, b: $b")
        a * b }
    // { 람다 함수에 사용할 매개변수 - > 반환할 식}

    val nestedLambda: () -> () -> Unit = { { println("nestedLambda")}}

    result = multi(10, 20)
    println(result)

}

/*
* 람다식의 구성
*   fun main() {
*       var result: Int
*
*       //일반 변수에 람다식 할당
*       val multi = { x: Int, y: Int - > x * y}
*       //람다식이 할당된 변수는 함수처럼 사용 가능
*       result = multi(10, 20)
*       println(result)
*
*   }
*
*   변수에 지정된 람다식
*       val multi:
*           변수를 함수처럼 사용 가능
*       (Int, Int) -> Int
*           람다식의 선언 자료형은 람다식 매개 변수에 자료형이 명시된 경우 생략 가능
*       {x: Int, y: Int -> x * y}
*           선언 자료형이 명시되어 이씅면 생략 가능
*           함수의 내용과 결과 반환, 표현식이 여러 줄인 경우 마지막 표현식이 반환
*
*   표현식이 2줄 이상일 때
*       val multi2: (Int, Int) -> Int = { x: Int, y: Int, ->
*           println("x * y")
*           x * y // 마지막 표현식이 반환됨
*       }
*
*   자료형의 생략
*       val multi: (Int, Int) -> Int = {x: Int, y: Int, -> x * y}
*           // 생략되지 않은 전체 표현
*       val multi: = {x: Int, y: Int -> x * y}
*           //선언 자료형 생략
*       val multi: (Int, Int) -> Int = {x, y -> x * y}
*           //람다식 매개 변수 자료형의 생략
*       val multi: {x, y -> x * y}
*           //에러 ! 추론이 가능하지 않음
*
*   반환 자료형이 없거나 매개 변수가 하나 있을 때
*       val greet: () -> Unit = { println("Hello World")}
*       val square: (Int) -> Int = { x -> x * x}
*
*   람다식 안에 람다식이 있는 경우 ?
*       val nestedLambda: () -> () -> Unit = { { println("nested") }}
*
*   선언부의 자료형 생략
*       val greet = { println("Hello World") } // 추론 가능
*       val square = { x: Int -> x * x } // 선언 부분을 생략하려면 x 의 자료형을 명시해야 함
*       val nestedLambda = { { println("nested") } } // 추론 가능
*
*
* */

/*
* 람다식 함수의 매개 변수
*   매개 변수 개수에 따라 람다식을 구성하는 방법
*       매개변수가 없는 경우
*
*   fun main() {
*       //매개 변수 없는 람다식 함수
*       noParam({ "Hello World!" })
*       noParam { "Hello World!"} // 위와 동일 결과, 소괄호 생략 가능
*   }
*
*   //매개 변수가 없는 람다식 함수가 noParam 함수의 매개변수 out 으로 지정됨
*       fun noParam (out: () -> String) = println(out())
*
*
*       매개 변수가 한 개 인 경우
*       fun main() {
*               //매개 변수 없는 람다식 함수
*           ...
*               //매개 변수가 하나 있는 람다식 함수
*               oneParam( {a -> "Hello World! $a"})
*               oneParam { a -> "Hello World! $a"} // 위와 동일 결과, 소괄호 생략 가능
*               oneParam { "Hello World! $it"} // 위와 동일 결과, it 으로 대체 가능
*       }
*       ...
*
*           // 매개 변수가 하나 있는 람다식 함수가 oneParam 함수의 매개 변수 out 으로 지정 됨
*       fun oneParam(out: (String) -> String) {
*           println(out("OneParam"))
*       }
*
*       매개 변수가 두 개 이상일 경우
*
*        fun main() {
*           //매개 변수가 두 개 있는 람다식 함수
*           moreParam { a, b -> "Hello World!" $a $b"} // 매개변수 명 생략 불가
*
*       }
*           // 매개변수가 두 개 있는 람다식 함수가 moreParam 함수의 매개변수로 지정됨
*           fun moreParam (out : (String, String) -> String){
*               println(out("OneParam", "TwoParam"))
*           }
*
*       매개 변수를 생략하는 경우
*           moreParam{ _, b -> "Hello World! $b"} // 첫 번쨰 문자열은 사용하지 않고 생략
*           _(언더바)를 사용해서 인자를 생략 할 수 있다.
*
*   일반 매개변수와 람다식 매개변수를 같이 사용
*       fun main(){
*           //인자와 함께 사용하는 경우
*           withArgs("Arg1", "Arg2", { a, b -> "Hello World! $a $b" }) //
*           // withArgs()의 마지막 인자가 람다식 인 경우 소괄호 바깥으로 분리 가능
*           withArgs("Arg1", "Arg2") { a, b -> "Hello World! $a $b" }
*           }
*       //withArgs 함수는 일반 매개 변수 2개를 포함, 람다식 함수를 마지막 매개변수로 가짐
*       fun withArgs(a: String, b: String, out:( String, String) -> String{
*           println(out(a, b))
*       }
*
* 두 개의 람다식을 가진 함수의 사용
*   fun main(){
*       twoLambda({a, b -> "First $a $b"}, {"Second $it"})
*       twoLambda({a, b -> "First $a $b"}) {"Second $it"} // 위와 동일
*
*      }
*
*   fun twoLambda(first: (String, String) -> String, second: (String) -> String){
*       println(first("OutParam", "TwoParam"))
*       println(second("OneParam"))
*       }
*
*       ({첫 번쨰}, {두 번쨰})
*       ({첫 번쨰}) {두 번쨰}
*
*       ({첫 번쨰}, {두 번째}) {세 번째}
* */