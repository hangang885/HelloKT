package com.gill.but.hellokt
/*


 클로저
   개념
       람다식으로 표현된 내부 함수에서 외부 범위에 선언된 변수에 접근할 수 있는 개념
       람다식 안에 있는 외부 변수는 값을 유지하기 위해 람다가 포획(capture) 한 변수
         */ /* fun main() {
                   val calc = Calc()
                   var result = 0 // 외부의 변수
                   calc.addNum(2,3) { x, y -> result = x + y } // 클로저
                   println(result) // 값을 유지하여 5가 출력
           }
           class Calc {
                   fun addNum(a: Int, b: Int, add: (Int, Int) -> Unit){ // 람다식 add 에는 반환값이 없음
                       add(a,b)
               }

          }

    함수의 매개 변수에 접근
        //길이가 일치하는 이름만 반환
            fun filteredNames(length: Int){
                val names = arrayListOf("Kim", "Hong", "Go", "Hwang", "Jeon")
                val filterResult = names.filter{
                        it.length == length // 바깥의 length에 접근
                }
                println(filterResult)
            }

    함수 자체를 같이 포획해 해당 매개변수에 접근함

           */

