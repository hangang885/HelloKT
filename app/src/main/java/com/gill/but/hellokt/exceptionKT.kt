package com.gill.but.hellokt

import java.lang.Exception

/*
*
* 예외 처리
*   예외 (exception)
*       실행 도중의 잠재적인 오류까지 검사할 수 없기 때문에
*       정상적으로 실행이 되다가 비정상 적으로 프로그램이
*       종료되는 경우
*           - 운영체제의 문제 (잘못된 시스템 호출의 문제)
*           - 입력값의 문제 (존재하지 않는 파일 혹은, 숫자 입력란에 문자 입력 등)
*           - 받아들일 수 없는 연산 (0으로 나누기 등)
*           - 메모리의 할당 실패 및 부족
*           - 컴퓨터 기계 자체의 문제 (전원 문제, 망가진 기억 장치 등)
*
*   예외를 대비하기 위한 구문
*       try{
*           예외 발생 가능성 있는 문장
*       } catch (e: 예외처리 클래스명){
*           예외를 처리하기 위한 문장
*       } finally{
*           반드시 실행되어야 하는 문장
*       }
*           반드시 실행해야 할 작업이 없다면 finally 블록은 생략하고 try~catch 블록만으로
*           코드를 구성할 수 있다.
*
*
* */

/*
fun main() {
    val a = 6
    val b = 0
    val c: Int

    try{
        c = a / b
        println("After")
    }catch (e: Exception){
        println("Exception")
    }finally {
        println("Finally")
    }
}
*/

/*
* 특정 예외 처리
*   산술 연산에 대한 예외를 따로 특정해서 잡을 때
*       }catch( e: ArithmeticException){
*           println("Exception is handled. ${e.message}")
*       }
*           Exception is handled. / by zero
*           finally 블록은 반드시 항상 실행됨
*               스택의 추적
*        }catch( e: Exception){
*           e.printStackTrace()
*       }
*       ...
*           finally 블록은 반드시 항상 실행 됨
*           java.lang
*
* //예외 발생 시키기
*   특정 조건에 따른 예외 발생
*       throw Exception(message: String)
*
*
*
*
* */

fun main() {

    var amount = 600

    try{
        amount -= 100
        checkAmount(amount)
    }catch (e: Exception){
        println(e.message)
    }
    println("amount: $amount")
}
fun checkAmount( amount: Int){
    if(amount < 1000)
        throw Exception("잔고가 $amount 으로 1000 이하입니다.")
}