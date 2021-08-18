package com.gill.but.hellokt

/*
* 컬렉션이란
*   Collection
*       자주 사용되는 기초적인 자료구조를 모아놓은 일종의 프레임워크로 표준 라이브러리로 제공
*   코틀린의 컬렉션
*       컬렉션의 종류로는 List, Set, Map 등이 있으며 자바와는 다르게 불변형(immutable)과
*       가변형(mutable) 으로 나뉘어 컬렉션을 다룰 수 있다.
*   컬렉션     불변형(읽기 전용)          가변형
*   List        listOf                  mutableListOf, arrayListOf
*   Set         setOf                   mutableSetOf, hashSetOf, linkedSetOf, sortedSetOf
*   Map         mapOf                   mutableMapOf, hashMapOf, linkedMapOf, sortedMapOf
*
* 컬렉션 인터페이스
*   코틀린 컬렉션
*       다이어그램의 가장 상위의 Iterable 인터페이스는 컬렉션이 연속적인 요소를 표현할 수 있게 한다.
*
* Collection 인터페이스
*   Collection 인터페이스의 특징
*       Iterable 로부터 확장
*       불변형이므로 Collection 으로 부터 확장된 Set 과 List 는 읽기 전용의 컬렉션 됨
*   Collection 인터페이스의 멤버
*       멤버                                  설명
*       size                                컬렉션의 크기를 나타낸다
*       isEmpty()                           컬렉션이 비어 있는 경우 true 를 반환한다.
*       contains(element: E)                특정 요소가 있다면 true 를 반환한다
*       containsAll(element: Collection<E>) 인자로 받아들인 Collection 이 있다면 true 를 반환한다.
*
* MutableIterable 과 MutableCollection 인터페이스
*   특징
*       가변형 컬렉션을 지원하기 위해 준비된 인터페이스
*       요소를 추가하거나 제거하는 등의 기능을 수행할 수 있다.
*
* MutableCollection 의 멤버
*   멤버 메서드                              설명
*   add(element:E)                          인자로 전달받은 요소를 추가하고 true 를 반환하며, 이미 요소가 있거나
*                                           중복이 허용되지 않으면 false 를 반환한다.
*   remove(element:E)                       인자로 받은 요소를 삭제하고 true 를 반환하며,
*                                           삭제하려는 요소가 없다면 false 를 반환한다.
*   addAll(elements:Collection<E>)          컬렉션을 인자로 전달받아 모든 요소를 추가하고 true 를 반환하며,
*                                           실패 시 false 를 반환한다.
*   removeAll(elements:Collection<E>)       컬렉션을 인자로 전달받아 모든 요소를 삭제하고 true 를 반환하며,
*                                           실패 시 false 를 반환한다.
*   retainAll(elements:Collection<E>)       인자로 전달받은 컬렉션의 요소만 보유한다. 성공 시 true 를 반환하고,
*                                           실패 시 false 를 반환한다.
*   clear()                                 컬렉션의 모든 요소를 삭제한다.
*
*
* List
*   개념
*       순서에 따라 정렬된 요소를 가지는 컬렉션 ( 가장 많이 사용되는 컬렉션 중에 하나)
*       값을 변경할 수 없는 불변형 List 를 만들기 위해 헬퍼 함수닌 listOf()를 사용
*       값을 변경할 수 있는 가변형을 표현하기 위해서는 mutableListOf()를 사용
*       인자는 원하는 만큼의 가변 인자를 가지도록 vararg 로 선언 가능
*   헬퍼 함수?
*       객체 생성 시 요소를 직접 선언하기 보다 특정 함수의 도움을 통해 생성
*
* 불변형 List 생성하기
*   헬퍼 함수 listOf()의 원형
*       public fun <T> listOf(vararg elements: T): List<T>
*           vararg 는 가변 인자를 받을 수 있기 때문에 원하는 만큼 요소를 지정
*           값을 반환할 때는 List<T>를 사용
*           형식 매개변수<T> 는 필요에 따라 원하는 자료형을 지정해 선언
*               사용하지 않으면 <Any>가 기본값이며 어떤 자료형이든 혼합 사용 가능
*
* *//*
fun main() {
    //불변형 List의 사용
    var numbers: List<Int> = listOf(1, 2, 3, 4, 5)
    var names: List<String> = listOf("one", "two", "three")

    for(name in names)  {
        println(name)
    }
    for (num in numbers) print(num) //한 줄에서 처리하기
    println() //내용일 없을 때는 한 줄 내리는 개행

}*/

//형식 매개변수 생략 예
//var mixedTypes = listOf("Hello", 1, 2.445, 's')

/*
* 컬렉션에 접근할 때
*   for 와 .indices 멤버를 통한 접근
*   val fruits = listOf("apple", "banana", "kiwi")
*   // for 와 in 을 사용한 출력
*   for (item in fruits){
*       println(item)
*   }
*
*   //인덱스와 함께 출력
*   for(index in fruits.indices) { //인덱스 지정
*       println("fruits[$index] = ${fruits[index]}")
*   }
*
* 기타 List 생성 함수
*   emptyList() 함수
*       빈 리스트를 생성한다.
*       val emptyList: List<String> = emptyList<String>()
*
*   listOfNotNull() 함수
*       null 을 제외한 요소만 반환
*       //null 이 아닌 요소만 골라 컬렉션을 초기화
*       val nonNullsList: List<Int> = listOfNotNull(2, 45, 2, null, 5, null)
*       println(notNullsList)
*
* List 추가 멤버 메서드 사용
*   추가 멤버 메서드들
*       멤버 메서드                  설명
*       get(index: Int)             특정 인덱스를 인자로 받아 해당 요소를 반환한다.
*       indexOf(element: E)         인자로 받은 요소가 첫 번째로 나타나는 인덱스를 반환하며, 없으면 -1을 반환한다.
*       lastIndexOf(element: E)     인자로 받은 요소가 마지막으로 나타나는 인덱스를 반환하고, 없으면 -1을 반환한다.
*       listIterator()              목록에 있는 iterator 를 반환한다.
*       subList(fromIndex:Int,      특정 인덱스의 from 과 to 범위에 있는 요소 목록을 반환한다.
*       toIndex: Int)
* */
/*

fun main() {
    var numbers: List<Int> = listOf(1, 2, 3, 4, 5)
    var names: List<String> = listOf("one", "Two", "Three")
    var mixed = listOf("One", 1, 1.5, 'c')

    println("numbers $numbers")
    println("names $names")
    println("mixed $mixed")

    println(numbers.size)
    println(numbers.indexOf(3))
    println(numbers.get(0))
    println(numbers[0])
    println(numbers.contains(1))
}*/

/*
* 가변형 List 생성
*   arrayListOf() 함수
*       가변형 헬퍼 함수를 사용하면 손쉽게 요소를 추가하거나 삭제할 수 있다.
*       arrayListOf()는 가변형 List 를 생성하지만 반환자료형은 자바의 ArrayList
*           public fun <T> arrayListOf(vararg elements: T): ArrayList<T>
* *//*
fun main() {
    // 가변형 List 를 생성하고 자바의 ArrayList 로 반환
        val StringList: ArrayList<String> = arrayListOf<String>("Hello", "Kotlin", "Wow")
    StringList.add("Java") // 추가
    StringList.remove("Hello") // 삭제
    println(StringList)
}*/

/*
* MutableList 인터페이스를 이용하는 헬퍼 함수
*   가변형 mutableListOf() 함수
*       요소의 추가, 삭제 또는 교체를 위해 mutableListOf() 를 통해 생성
*       MutableList 형으로 반환
*       public fun <T> mutableListOf(vararg elements: T): MutableList<T>
* */
/*

fun main() {
    // 가변형 List 의 생성 및 추가, 삭제, 변경
    val mutableList: MutableList<String> = mutableListOf<String>("Kildong", "Dooly", "Chelsu")
    mutableList.add("Ben") // 추가
    mutableList.removeAt(1) // 인덱스 1 삭제
    mutableList[0] = "Sean"  // 인덱스 0을 변경, set( index: Int, element: E) 과 같은 역할
    println(mutableList)

    // 자료형의 혼합
    val mutableListMixed = mutableListOf("Android","Apple", 5, 6, 'X')
    println(mutableListMixed)
}

*/

//불변형 List 의 변경
//toMutableList()
/*
fun main() {
    val names: List<String> = listOf("one", "two", "three") // 불변형 List 초기화
    val mutableNames = names.toMutableList() // 새로운 가변형 List 가 만들어짐
    mutableNames.add("four") // 가변형 List 에 하나의 요소 추가
    println(mutableNames)
}*/


/*
* List 와 배열의 차이
*   차이점 비교
*       Array 클래스에 의해 생성되는 배열 객체는 내부 구조상 고정된 크기를 가짐
*       코틀린의 List<T> 와 MutableList<T> 는 인터페이스로 설계되어 있고 이것을 하위에서 특정한
*       자료구조로 구현
*           LinkedList<T>, ArrayList<T>
*           val list1: List<Int> = LinkedList<Int>()
*           val list2: List<Int> = ArrayList<Int>()
*               고정된 크기의 메모리가 아니기 때문에 자료 구조에 따라 늘리거나 줄이는 것이 가능
*       Array<T> 는 제네릭 관점에서 상/하위 자료형 관계가 성립하지 않는 무변성이다.
*       List<T> 는 공변성이기 때문에 하위인 List<Int> 가 List<Number> 에 지정될 수 있다.
*
* */