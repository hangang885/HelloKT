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
* 매핑 관련 연산
*   map()
*       주어진 컬렉션의 요소를 일괄적으로 모든 요소에 식을 적용해 새로운 컬렉션을 만듦
*       forEach 와는 다르게 주어진 컬렉션을 건드리지 않는다
* */
/*
* 매핑 관련 연산
*   flatMap()
*       각 요소에 식을 적용할 후 이것을 다시 하나로 합쳐 새로운 컬렉션을 반환
*       //flatMap: 각 요소에 식을 적용 후 다시 합쳐 새로운 컬렉션을 반환
*       println(list.flatMap { listOf(it, 'A')})
*       val result = listOf("abc", "12").flatMap{ it.toList()}
*       println(result)
*
*   groupBy()
*       주어진 식에 따라 요소를 그룹화 하고 이것을 다시 Map 으로 반환
*       //groupBy: 주어진 함수의 결과에 따라 그룹화 하여 map 으로 반환
*       val grpMap = list.groupBy{ if ( it % 2 == 0) "even" else "odd"}
*       println(grpMap) // { odd = [1, 3, 5], even =[2, 4, 6]
*
*
* 요소 처리와 검색 연산
*   element 관련 연산
*       보통 인덱스와 함께 해당 요소의 값을 반환
*       식에 따라 처리하거나 인덱스를 벗어나면 null 을 반환
* */


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
fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listPair = listOf(Pair("A", 300), Pair("B", 200), Pair("C", 100), Pair("D", 200))

    // elementAt: 인덱스에 해당하는 요소 반환
    println("elementAt: " + list.elementAt(1))

    // elementAtOrElse: 인덱스를 벗어나는 경우 식에 따라 결과 반환 아니면 요소 반환
    println("elementAtOrElse: " + list.elementAtOrElse(10, { 2 * it}))
    // elementAtOrElse(10) { 2 * it}) 표현식과 동일

    // elementAtOrNull: 인덱스를 벗어나는 경우 null 반환
    println("elementAtOrNull: " + list.elementAtOrNull(10))
}
*/

/*
* 순서와 정렬 연산
*   컬렉션에 대한 정렬 연산
*       reversed()
*       sorted() / sortedDescending()
*       sortedBy { it % 3 } / sortedByDescending { it % 3 }
*
* 시퀀스
*   sequence
*       순차적으로 요소의 크기를 특정하지 않고 추후에 결정하는 특수한 컬렉션
*       예를 들어 특정 파일에서 줄 단위로 읽어서 요소를 만들 때
*       시퀀스는 처리 중에는 계산하고 있지 않다가 toList()나 count() 같은 최종 연산에 의해 결정
*
* 요소 값 생성
*   generateSequence
*       시드(seed) 인수에 의해 시작 요소의 값이 결정
* */
/*fun main() {
    // 시드값 1을 시작으로 1씩 증가하는 시퀀스 정의
    val nums: Sequence<Int> = generateSequence(1) { it + 1}

    //take()를 사용해 원하는 요소 개수만큼 획득하고
    //toList()를 사용해 List 컬렉션으로 반환
    println(nums.take(10).toList())
}*/

/*
* map 이나 fold 같은 연산을 같이 사용
*   val squares = generateSequence(1) { it + 1 }.map { it * it }
*   println(squares.take(10).toList())
*
*   val oddSquares = squares.filter { it % 2 != 0 }
*   println(oddSquares.take(5).toList())
*
*   메서드 체이닝(chaining)해 연속해서 쓴다면 하나의 구문이 끝날 때마다 중간 결과로
*   새로운 List 를 계속해서 만들어 낸다.
*
*
* asSequence()
*   중간 연산 결과 없이 한 번에 끝까지 연산한 후 결과를 반환
*       filter 나 map 을 메서드 체이닝해서 사용할 경우 순차적 연산이기 때문에 시간이 많이 걸릴
*       수 있지만 asSequence()를 사용하면 병렬 처리되기 때문에 처리 성능이 좋아짐
*
* */

fun main() {
    //단순 메서드 체이닝을 사용할 때
    val list1 = listOf(1, 2, 3, 4, 5)
    val listDefault = list1
        .map { print("map($it)"); it * it } // 1번
        .filter { println("filter($it)"); it % 2 == 0 } // 2번
        .toList() // 3번
    println(listDefault)
/*
* 3번 과정에 의해 최종 결과를 List 목록으로 반환할 때, 모든연산이 수행되고 결과물이 새로운 리스트인
* ListSeq 에 지정
* 요소의 개수가 많을 때 속도나 메모리 측면에서 훨씬 좋은 성능을 낼 수 있다.*/
}