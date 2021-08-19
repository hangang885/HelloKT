package com.gill.but.hellokt

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

/*
* Map
*   Map 의 개념
*       키(key) 와 값(value) 으로 구성된 요소를 저장
*           키와 값은 모두 객체
*       키는 중복될 수 없지만 값은 중복 저장될 수 있다.
*           만약 기존에 저장된 키와 동일하면 기존의 값은 없어지고 새로운 값으로 대체
*
*   Map 의 생성
*       불변형 : mapOf()
*       가변형 : mutableMapOf()
*
* 불변형 Map 의 생성
*   mapOf() 함수
*       val map: Map<키자료형, 값자료형> = mapOf(키 to 값[,...])
*           키와 쌍은 '키 to 값' 형태로 나타낸다
* */
/*
fun main() {
    // 불변형 Map 의 선언 및 초기화
    val langMap: Map<Int, String> = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")
    for((key, value) in langMap) { // 키와 값으로 쌍을 출력
        println("key= $key, value=$value")
    }
    println("langMap[22] = ${langMap[22]}") // 키 22에 대한 요소 출력
    println("langMap.get(22) = ${langMap.get(22)}") // 위와 동일한 표현
    println("langMap.keys = ${langMap.keys}") // 맵의 모든 키 출력
}
*/

/*
* Map 의 멤버
*   멤버                      설명
*   size                        맵 컬렉션의 크기를 반환한다.
*   keys                        이 프로퍼티는 Set 의 모든 키를 반환한다.
*   values                      이 프로퍼티는 Set 의 모든 값을 반환한다.
*   isEmpty()                   맵이 비어 있는지 확인하고 비어 있으면 true, 아니면 false 반환
*   containsKey(key: K)         인자에 해당하는 키가 있다면 true, 아니면 false
*   containsValue(value: V)     인자에 해당하는 값이 있다면 true, 아니면 false
*   get(key: K)                 키에 해당하는 값을 반환하며, 없으면 null 을 반환
*
* MutableMap 의 추가 멤버
*   추가, 삭제가 가능한 메서드 제공
*       멤버                          설명
*       put(key: K, value: V)           키와 값을 쌍을 맵에 추가한다.
*       remove(key: K)                  키에 해당하는 요소를 맵에서 제거한다.
*       putAll(from: Map<out K, V>)     인자로 주어진 Map 데이터를 갱신하거나 추가한다.
*       clear()                         모든 요소를 지운다.
* */
/*
fun main() {
    // 가변형 Map 의 선언 및 초기화
    val capitalCityMap: MutableMap<String, String> // 선언 시 키와 값의 자료형을 명시 가능
    = mutableMapOf("Korea" to "Seoul", "China" to "Beijing", "Japen" to "Tokyo")
    println(capitalCityMap.values) // 값만 출력
    println(capitalCityMap.keys) // 키만 출력
    capitalCityMap.put("UK", "London") // 요소의 추가
    capitalCityMap.remove("China") // 요소의 삭제
    println(capitalCityMap)
}*/

/*
* putAll() 을 사용해 맵 객체 통합
*   기존 요소에 추가된 요소를 병합할 수 있다.
*   //putAll()을 사용한 맵의 추가
*   val addData = mutableMapOf("USA" to "Washington")
*   capitalCityMap.putAll(addData)
*   println(capitalCityMap)
*
* Map 을 위한 기타 자료구조
*   특정 자료구조 이용
*       Map 에서도 자바의 HashMap, SortedMap 과 LinkedHashMap 을 사용할 수 있다.
*       hashMapOf(), sortedMapOf(), linkedMapOf() 로 각각 초기화
*       SortedMap 의 경우 기본적으로 키에 대해 오름차순 정렬된 형태로 사용
*       내부 구조는 앞서 설명했던 Set 의 구조와 비슷하게 해시, 트리, 링크드 리스트의 자료구조로 구현
* */
fun main() {
    //java.util.HashMap 의 사용
    val hashMap: HashMap<Int, String> = hashMapOf(1 to "Hello", 2 to "World")
    println("hashMap = $hashMap")

    //java.util.SortedMap 사용
    val sortedMap: SortedMap<Int, String> = sortedMapOf(1 to "Apple", 2 to "Banana")
    println("sortedMap = $sortedMap")

    //java.util.LinkedHashMap 의 사용
    val linkedHash: LinkedHashMap<Int, String> = linkedMapOf(1 to "Computer", 2 to "Mouse")
    println("likedHash = $linkedHash")




}