package com.gill.but.hellokt

fun avgFunc(initial: Float, vararg numbers:Float): Double{
    var result = 0f
    for (num in numbers){
        result += num
    }
    println("result: $result, numbers.size: ${numbers.size}")
    val avg = (result+initial) / (numbers.size+1)
            return avg.toDouble()
}

fun main() {
    val result = avgFunc(5f, 100f, 90f, 80f)  // 첫번째 인자: 초기값, 이후 인자는 가변인자
    println("avg result: $result")
}
/* 풀이 방법
1. Float 위에서 초기값을 위한 인자는 Float형 라는 지문이 있기에

2. vararg 두 번째부터 나열된 인자의 라는 말을 보면 인자가 여러개 일 수 있기에 vararg로 선언

3. result += num 평균을 내기위해서는 총합이 있어야 하기때문에

4. (result + initial) / (numbers.size+1)

(result + initial) == 모든 실수의 평균을 구하는 프로그램이기에 처음에 받은 initial 을 총합에 포함을 시켜야 할 것 같다.

평균을 구하기 위해선 총합 / 갯수 이기에 numbers.size == numbers의 크기 와 initial 갯수 1개까지 더해야 하기에 +1을 해주었다.

5. avg.toDouble()
*/