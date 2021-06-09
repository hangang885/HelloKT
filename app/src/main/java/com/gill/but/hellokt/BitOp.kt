package com.gill.but.hellokt


/*
* 비트 연산자
*   비트 연산을 위한 비트 메서드
*       4.shl(bits) 4를 표현하는 비트를 bits 만큼 왼쪽으로 이동(부호 있음)
*       7.shr(bits) 7을 표현하는 비트를 bits 만큼 오른쪽으로 이동(부호 있음)
*       12.ushr(bits) 12를 표현하는 비트를 bits 만큼 오른쪽 이동(부호 없음)
*       9.and(bits) 9을 표현하는 비트와 bits 를 표현하는 비트로 논리곱 연산
*       4.or(bits)  4를 표현하는 비트와 bits 를 표현하는 비트로 논리합 연산
*       24.xor(bits)    24를 표현하는 bits 를 표현하는 비트의 배타적 연산
*       78.inv()    78을 표현하는 비트를 모두 뒤집음
* */

fun main() {
    val x = 4 // 0100(2)    4(10)
    val y = 0b000_1010 // 5(10)
    val z = 0x0f // 0b0000_1111(2)  15(10)

    println("x shl 2-> ${x.shl(2)}") // 16(10) 0001_0000(2)
    println("x int -> ${x.inv()}") // 111....1011(2)

}