package com.gill.but.hellokt

/*
*
* for 문
*
*   for 문의 선언
*       for(요소 변수 in 컬렉션 혹은 범위){
*               반복할 본문
*           }
*   for (x in 1..5) { // 코틀린의 in과 범위 지정을 활용한 루프
*          println(x) // 본문
*       }
*
*   for (x in 1..5) println(x) // 한줄에 표현하는 경우
*
*   for(int i=1; i<= 5; i++){...} // 에러!
*       코틀린에서는 자바와 같은 세미콜론 표현식을 사용하지 않음
*
* */
/*
fun main() {
    var sum =0

    for( x in 1..10) sum += x

    println("sum: $sum")
}
*/

/*
* 하행, 상행 및 다양한 반복 방법
*
* 하행 반복 - downTo
*   5, 4, 3, 2, 1
*       for( i in 5 downTo 1) print(i)
*       for( i in 5..1) print(i) // 잘못된 사용 ! 아무것도 출력되지않는다
*
* 필요한 단계 증가 - step
*       1, 3, 5
*       for( i in 1..5 step 2 ) print(i)
*
* 혼합 사용
*       5, 3, 1
*       for(i in 5 downTo 1 step 2) print(i)
*       */

/*fun main() {
    var total = 0
    for(num in 1..100 step 2) total += num // 1부터 100까지 더하는데 홀수합

    println("total: $total")


}*/

/*
* while 문
*   선언 사용
*       while(조건식) { // 조건식이 true 인 동안 본문의 무한 반복
*           본문
*           ....
*       }
*
*       var i = 1
*       while (i<= 5){
*           println("$i")
*           ++i // 계속 반복하다 보면 조건식이 5 이상으로 넘어갈 때 false 가 되어 탈출
*           }
*
*   데몬 프로그램의 사용 예{
*       while(true){
*       temp = 온도 검사
*       if( temp > 한계 온도) { 경고 발생}
*       ...
*       }*/

/*fun main() {
    print("Enter the number:")
    var number = readLine()!!.toInt() // 낫 널 로 했다
    var factorial: Long = 1

    while(number > 0 ) { // n x ... x 4 x 3 x 2 x 1
        factorial *= number
        --number
    }

    println("Factorial: $factorial")
}*/

/*
* do ~ while 문
*
* 선언
*   do{
*       본문
*   }while(조건식)
*
*
* */

/*
fun main() {


    do{
        println("Enter the number: ")
        val input = readLine()!!.toInt()

        for(i in 0 until input){
            for(j in 0 until input){

                print((i+j)% input +1)
            }
            println()
        }

    }while (input != 0)


}*/
