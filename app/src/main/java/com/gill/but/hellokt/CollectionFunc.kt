package com.gill.but.hellokt

/*
* 컬렉션의 확장 함수
*   코틀린은 컬렉션을 위한 많은 확장 함수를 제공하고 있다.
*   확장 함수 범주
*       연산자(operators) 기능의 메서드: 더하고 빼는 등의 기능
*       집계(aggregators) 기능의 메서드 : 최대, 최소, 집합, 총합 등의 계산 기능
*       검사(checks) 기능의 메서드 : 요소를 검사하고 순환하기 위한 기능
*       필터(filtering) 기능의 메서드 : 원하는 요소를 골라내기 위한 기능
*       변환(transformers) 기능의 메서드 : 뒤집기, 정렬, 자르기 등의 변환 기능
* *//*
fun main() {
    val list1 = listOf("one", "two", "three")
    val list2 = listOf(1, 2, 3)

    println(list1 + "four")
    println(list2 + "hello")
    println(list2 - 1)
    println(list1 - "one")

    println(list1 + listOf("abc", "def "))

}*/
/*

fun main() {
    val list1: List<String> = listOf("one", "two", "three")
    val list2: List<Int> = listOf(1, 3, 4)
    val map1 = mapOf("hi" to 1, "hello" to 2, "Goodbye" to 3)

    println(list1 + "four") // + 연산자를 사용한 문자열 요소 추가
    println(list2 + 1) // + 연산자를 사용한 정수형 요소 추가
    println(list2 + listOf(5, 6, 7)) // 두 List 의 병합
    println(list2 - 1) // 요소의 제거
    println(list2 - listOf(3, 4, 5)) // 일치하는 요소 제거
    println(map1 + Pair("Bye", 4)) // Pair() 를 사용한 Map 의 요소 추가
    println(map1 - "hello") // 일치하는 값의 제거
    println(map1 + mapOf("Apple" to 4, "Orange" to 5)) // Map 의 병합
    println(map1 - listOf("hi", "hello")) // List 에 일치하는 값을 Map 에서 제거
}*/

/*
* 요소의 처리와 집계에 대한 연산
*   요소를 집계를 위한 확장 함수
*       forEach, forEachIndexed, onEach, count, max, min, maxBy, minBy, fold, reduce,
*       sumBy 등
*   요소의 순환
*       forEach: 각 요소를 람다식을 처리한 후 컬렉션을 반환하지 않음
*       onEach: 각 요소를 람다식으로 처리한 후 컬렉션을 반환 받음
*
* *//*
//요소의 순한 예
fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B",200), Pair("C", 100))
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")

    //forEach: 각 요소를 람다식으로 처리
    list.forEach{ print("$it")}
    println()
    list.forEachIndexed{ index, value -> println("index[$index]: $value")} //인덱스 포함

}*/


/*
* 각 요소의 정해진 식 적용
*   fold 와 reduce: 초기값과 정해진 식에 따라 요소에 처리하기 위해
*       fold 는 초기값과 정해진 식에 따라 처음 요소부터 끝 요소에 적용해 값 반환
*       reduce 는 fold 와 동일하지만 초기값을 사용하지 않는다
*   foldRight, reduceRight: 위의 개념과 동일하지만 요소의 마지막(오른쪽) 요소에서 처음 요소로 순서대로 적용한다.
* */

//fold 와 reduce 의 예
/*
fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    //fold: 초기값과 정해진 식에 따라 처음 요소부터 끝 요소에 적용하며 값을 생성
    println(list.fold(4) { total, next -> total + next})
    println(list.fold(1) { total, next -> total * next})

    //foldRight: fold 와 같고 마지막 요소에서 처음 요소로 반대로 적용
    println(list.foldRight(4) { total, next -> total + next})
    println(list.foldRight(1) { total, next -> total * next})

    //reduce: fold 와 동일하지만 초기값을 사용하지 않음
    println(list.reduce { total, next -> total + next})
    println(list.reduceRight { total, next -> total + next})


}*/

/*
* 매핑 관련 연산
*   map()
*       주어진 컬렉션의 요소를 일괄적으로 모든 요소에 식을 적용해 새로운 컬렉션을 만듦
*       forEach 와는 다르게 주어진 컬렉션을 건드리지 않는다
* */
/*
fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listWithNull = listOf(1, null, 3, null, 5, 6)

    //map: 컬렉션에 주어진 식을 적용해 새로운 컬렉션을 반환
    println(list.map {it * 2}) // 2, 4, 6, 8 ,10, 12

    //mapIndexed: 컬렉션에 인덱스를 포함해 주어진 식을 적용해 새로운 컬렉션 반환
    val mapIndexed = list.mapIndexed{ index, it -> index * it}
    println(mapIndexed) // 0, 2, 6, 12, 20, 30

    //mapNotNull: null 을 제외하고 식을 적용해 새로운 컬렉션 반환
    println(listWithNull.mapNotNull { it?.times(2) }) // 2, 6, 10 ,12
}*/

/*
* 매핑 관련 연산
*   flatMap()
*       각 요소에 식을 적용할 후 이것을 다시 하나로 합쳐 새로운 컬렉션을 반환
*       //flatMap: 각 요소에 식을 적용 후 다시 합쳐 새로운 컬렉션을 반환
*       println(list.flatMap { listOf(it, 'A')})
*       val result = listOf("abc", "12").flatMap{ it.toList()}
*       println(result)
* */