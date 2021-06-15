package com.gill.but.hellokt

/*
*
* 흐름 제어
*
*   흐름 제어 관련 요약
*       흐름 제어 문
*           return : 함수에서 결괏값을 반환하거나 지정된 라벨로 이동
*           break : for 나 while 의 조건식에 상관 없이 반복문을 끝냄
*           continue : for 나 while 의 반복문의 본문을 모두 수행하지 않고 다시 조건으로 넘어감
*       예외 처리 문
*           try { ... } catch { ... } : try 블록의 본문을 수행하는 도중 예외가 발생하면 catch 블록의 본문을 실행
*           try { ... } catch { ... } finally { ... } : 예외가 발생해도 finally 블록 본문은 항상 실행
*
* return 의 사용
*   return 으로 값 반환하기
*       fun add(a: Int, b: Int): Int{
*           return a + b
*           println("이 코든느 실행되지 않습니다.") // 여기에 도달하지 않음
*       }
*
*   return 으로 Unit 반환하기
*       //1. Unit 을 명시적으로 반환
*       fun hello(name: String): Unit{
*           println(name)
*           return Unit
*       }
*       //2. Unit 이름을 생략한 반환
*       fun hello(name: String): Unit{
*           println(name)
*           return
*       }
*       //3. return 문 자체를 생략
*       fun hello(name: String){
*           println(name)
*       }
*
*
*  */

//람다식에서 return 사용하기
/*fun main() {
    retFunc()
}

inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit){
    out(a, b)
}

fun retFunc(){
    println("start of retFunc")
    inlineLambda(12, 3) lit@{ a, b ->
            val result = a + b
            if(result > 10) return@lit // 10보다 크면 이 함수를 빠져 나감
            println("result: $result") // 10보다 크면 이 문장에 도달하지 못함
    }
        println("end of retFunc")
}*/

/*
* 람다식에서 라벨 사용
*   람다식 함수명 라벨이름@{
*       ...
*       return@라벨이름
*       }
*
* inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit){
    out(a, b)
}

fun retFunc(){
    println("start of retFunc")
    inlineLambda(13, 3) lit@ { a, b -> // 람다식 블록의 시작 부분에 라벨을 지정함
            val result = a + b
            if(result > 10) return@lit // 라벨을 사용한 블록의 끝 부분으로 반환
            println("result: $result")
    }
        println("end of retFunc")
}
* */

/*
* 암묵적 라벨
* fun retFunc(){
    println("start of retFunc")
    inlineLambda(13, 3)  { a, b -> // 람다식 블록의 시작 부분에 라벨을 지정함
            val result = a + b
            if(result > 10) return@inlineLambda // 라벨을 사용한 블록의 끝 부분으로 반환
            println("result: $result")
    }
        println("end of retFunc")
}
*
*
* 익명 함수를 사용한 반환
*   익명 함수의 사용
*       fun retFunc(){
            println("start of retFunc")
            inlineLambda(13, 3, fun (a,b){
            val result = a + b
            if(result > 10) return
            println("result: $result")
    }) // inlineLambda() 함수의 끝
        println("end of retFunc")
}
*
* 람다식 방법
*   val getMessage = lambda@ { num: Int ->
*           if(num !in 1..100){
*               return@lambda "Error" // 레이블을 통한 반환
*           }
*           "Success" // 마지막 식이 반환
*       }
* ...
*
* 익명 함수 방법
*   val getMessage = fun(num: Int): String{
*           if(num !in 1..100){
*               return "Error"
*           }
*           return "Success"
* }
*
*
* break 와 continue
*   break 와 continue 의 사용
*       for 나 while, do...while 문 루프를 빠져 나옴
*
*
* */
/*
//break 예제
fun main() {
    for (i in 1..5){
        if( i == 3)break
        print(i)
    }
    println()//개행 문자
    println("outside")
}*/



/*
* break 와 라벨 함께 사용하기
*
* 라벨 없는 break 와 라벨을 사용한 break
*   fun labelBreak(){
*       println("labelBreak")
*       for(i in 1..5){
*           second@ for(j in i..5){
*               if( j == 3) break
*               println("i: $i, j: $j")
*               }
*              println("after for j")
*           }
*       println("after for i")
*       }
*
*  fun labelBreak(){
*       println("labelBreak")
*       first@ for(i in 1..5){
*           second@ for(j in i..5){
*               if( j == 3) break@first
*               println("i: $i, j: $j")
*               }
*              println("after for j")
*           }
*       println("after for i")
*       }
* */

