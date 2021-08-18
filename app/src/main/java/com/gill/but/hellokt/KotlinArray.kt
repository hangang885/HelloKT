package com.gill.but.hellokt

import java.util.Arrays

/*
* 배열 표현하기
*   배열(array)
*       데이터를 연속적으로 나열한 형태
*       arrayOf()나 Array() 생성자를 사용해 배열 생성
*       arrayOfNulls()은 빈 배열
*           val numbers = arrayOf(4, 5, 7, 3) // 정수형으로 초기화된 배열
*           val animals = arrayOf("Cat", "Dog", "Lion") // 문자열 형으로 초기화된 배열
*           ...
*           for(element in numbers) { // 정수형으로 초기화 된 배열 출력하기
*               println(element)
*           }
*
*       numbers 나  animal 는 이름표로 배열이 있는 힙공간을 가리키는 일종 포인터 역할
*       포인터 역할을 하는 두 변수는 스택에 위치
*       힙
*           사용자가 직접 관리할 수 있는 '그리고 해야만 하는' 메모리 영역
*
*       스택
*           함수의 호출과 관계되는 지역변수와 매개변수가 저장되는 영역
*
*   다차원 배열
*       val array1 = arrayOf(1, 2, 3)
*       val array2 = arrayOf(4, 5, 6)
*       val array3 = arrayOf(7, 8, 9)
*
*       val arr2d = arrayOf(array1, array2, array3)
*       val arr2d = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9))
*
*   for(e1 in arr2d){
*       for(e2 in e1){
*           print(e2)
*       }
*       println()
*      }
*
*
* 다양한 자료형
*   다양한 자료형의 혼합 가능
*       val mixArr = arrayOf(4, 5, 7,3 "Chike", false)// 정수, 문자열, Boolean 혼합
*
*   특정 자료형을 제한할 경우
*       arrayOf<자료형>() 혹은
*       자료형이름 + ArrayOf()
*          -charArrayOf(), booleanArrayOf(), longArrayOf(), shortArrayOf(),
*           byteArrayOf(), intArrayOf()
*          -ubyteArrayOf(), ushortArrayOf(), uintArrayOf(), ulongArray()
*           // u는 unsigned 로 부호없는 자료형 배열
*
* 배열 요소에 접근
*   선언부
*       //코틀린 표준 라이브러리의 Array.kt
*       public class Array<T>{
*           public inline constructor(size: Int, init: (Int) ->T)
*           public operator fun get(index: Int): T
*           public operator fun set(index: Int, value: T): Unit
*           public val size: Int
*           public operator fun iterator(): Iterator<T>
*            // Iterator = 컬렉션에 저장되어 있는 요소들을 읽어오는 방법을 표준화한 인터페이스
*
*           }
*   연선자를 통한 접근
*       arr.get(index) -> value = arr[index]
*       arr.set(index) -> arr[index] = value
*
*   읽기 접근의 예
*       val arr = intArrayOf(1, 2, ,3 ,4, 5)
*       println(arr.get(2)) // 게터를 통한 접근
*       println(arr[2]) // 연산자 오버로딩으로 대괄호를 통한 접근
*       val arr2d = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9))
*       println(arr2d[2][1]) // 8을 출력
*
*   쓰기 접근의 예
*       arr.set(2,7) // 인덱스 2번 요소를 값 7로 교체
*       arr[0] = 8 // 인덱스 0번 요소를 값 8로 교체
*       arr2d[2][1] = 2 // 다차원 배열의 요소를 교체
*       println("size: ${arr.size} arr[0]: ${arr[0]}, arr[2]: ${arr[2]}")
* */
/*

fun main() {
    val arr = arrayOf(1, 2, 3, 4, 5)

    println(arr.get(2))
    println(arr[2])

    println(arr.size)

    for(ele in arr){
        print(ele)
    }

    println(Arrays.toString(arr))
    println(arr.sum())

//    arr.set(1, 8)
    arr[1] = 8
    println(Arrays.toString(arr))
}*/
/*
* 배열의 생성
*   표현식을 통한 생성
*       val | var 변수명 = Array(요소 개수, 초기값)
*           초기값으로 람다식 함수로 init: (Int) -> T 와 같이 정의
*           예) 2씩 곱해지는 정수의 짝수 5개 (0, 2, 4, 6, 8) 의 요소
*       val arg3 = Array(5, { i -> i *2 })
*       println("arr3: ${Arrays.toString(arr3)}")
*
*   많은 양의 배열 생성
*       var a = arrayOfNulls <Int> (1000) // 1000개의 null 로 채워진 정수 배열
*       var a = Array(1000, { 0 }) // 0으로 채워진 배열
*
*   특정 클래스 객체로 배열 생성
*       var a = Array(1000, { i -> myClass(i) } )
*
* 배열에 요소 추가하고 잘라내기
*   새로 할당하는 방법으로 추가하거나 잘라낼 수 있음
*       val arr1 = intArrayOf(1, 2, 3, 4, 5) // 다섯개로 고정된 배열
*
*       //하나의 요소를 추가한 새 배열 생성
*       val arr2 = arr.plus(6)
*       println("arr2: ${Arrays.toString(arr2)}")
*
* */


/*
fun main(args: Array<String>) {
    val arr = intArrayOf(1, 2, 3, 4, 5)

    println("arr: ${Arrays.toString(arr)}") // Arrays.toString()은 배열의 내용을 문자열로 변환함
    println("size: ${arr.size}") // size 는 배열의 크기를 나타냄
    println("sum(): ${arr.sum()}") // sum() 메서드는 배열의 합을 계산해 줌

    //게터에 의한 접근과 대괄호 연산자 표기법
    println(arr.get(2))
    println(arr[2])

    //세터에 의한 값 설정
    arr.set(2,7)
    arr[0] = 8
    println("size: ${arr.size} arr[0]: ${arr[0]}, arr[2]: ${arr[2]}")

    //루프를 통한 배열 요소의 접근
    for(i in 0..arr.size -1){
        println("arr[$i] = ${arr[i]}")
    }
}*/

/*
* 배열의 내용 한꺼번에 출력하기
*   toString()을 사용하면 배열의 내용을 출력
*       val arr= intArrayOf(1, 2, 3, 4, 5)
*       println(Arrays.toString(arr)) // [1, 2, 3, 4, 5]
*
*   다차원 배열에서는 deepToString() 사용
*       val array = arrayOf(intArrayOf(1, 2), // 다차원 배열일 때
*               intArrayOf(3, 4),
*               intArrayOf(5, 6, 7))
*       println(Arrays.deepToString(array)) // [[1, 2], [3, 4], [5, 6, 7]]
* */

/*fun main() {
    val arr1 = intArrayOf(1, 2, 3, 4, 5)
    val arr2 = arr1.plus(6)
    println({Arrays.toString(arr2)})
}*/

/*
* 잘라내기의 예
*   필요한 범위를 잘라내 새 배열 생성
*   val arr3 = arr.sliceArray(0..2) // 인자에 잘라낼 인덱스의 범위를 지정
*   println("arr3: ${Arrays.toString(arr3)}")
*
*
* */

//기타 배열 관련 API API 사용 예
/*
* // 첫 번째와 마지막 요소 확인
*   println(arr.first())
*   println(arr.last())
*
* // 요소 3의 인덱스 출력
*   println("indexOf(3): ${arr.indexOf(3))}")
*
* // 배열의 평균 값 출력
*   println("average: ${arr.average()}")
*
* // count 에 의한 요소 개수
*   println("count: ${arr.count()}")
*
* 존재 여부 확인
*   operator fun<T> Array<out T>.contains(element: T): Boolean
*
*   println(arr.contains(4)) // arr 배열에 요소 4가 포함되었는지 확인하고 true 반환
*   println(4 in arr)
*
* *//*

fun main() {
    val b = Array<Any>(10,{0})
    b[0] = "Hello World"
    b[1] = 1.1
    println(Arrays.toString(b))

}*/
/*
* 배열의 순환
*   순환 메서드의 사용
*       //forEach 에 의한 요소 순환
*       arr.forEach { element -> print("$element")}
*
*       //forEachIndexed 에 의한 요소 순환
*       arr.forEachIndexed({i, e -> println("arr[$i] = $e")})
*           forEachIndexed
*               인덱스는 i로, 요소는 e로 받아 화살표 표현식 오른쪽의 구문 처리
*
*   Iterator 의 이용
*       //Iterator 를 사용한 요소 순환
*       val iter: Iterator<Int> = arr.iterator()
*       while(iter.hasNext()){
*           val e = iter.next()
*           print("$e ")
*       }
*
* */

/*
* 배열의 정렬
*   정렬(Sort)
*       오름차순(ascending)으로 정렬하거나 내림차순(descending) 정렬
*       Array 는 기본적인 정렬 알고리즘을 제공
*   정렬된 배열을 반환
*       sortedArray()
*       sortedArrayDescending()
*   원본 배열에 대한 정렬을 진행
*       sort()
*       sortDescending()
*
* */
/*

fun main() {
    val arr = arrayOf(8, 4, 3, 2, 5, 9, 1)
*/
/*

    //오름차순
    val sortedArr = arr.sortedArray()
    println(Arrays.toString(sortedArr))
    //내림차순
    val sortedArrayDesc = arr.sortedArrayDescending()
    println(Arrays.toString(sortedArrayDesc))

    arr.sort(1,3)
    println(Arrays.toString(arr))
*//*


    //1. 오름차순, 내림차순으로 정렬된 일반 배열로 반환
    val sortedNums = arr.sortedArray()
    println("ASC: " + Arrays.toString(sortedNums))

    val sortedNumsDesc = arr.sortedArrayDescending()
    println("DEC: " + Arrays.toString(sortedNumsDesc))

    //2. 원본 배열에 대한 정렬
    arr.sort(1, 3)  //sort(fromIndex, toIndex)
    println("ORI: " + Arrays.toString(arr))
    arr.sortDescending()
    println("ORi: " + Arrays.toString(arr))

    //3. List 으로 반환
    val listSorted: List<Int> = arr.sorted()
    val listDesc: List<Int> = arr.sortedDescending()
    println("LST: " + listSorted)
    println("LST: " + listDesc)

    //4. SortBy를 이용한 특정 표현식에 따른 정렬
    val items = arrayOf<String>("Dog", "Cat", "Lion", "Kangaroo", "Po")
    items.sortBy { item -> item.length }
    println(Arrays.toString(items))
}*/
/*

data class Product(val name: String, val price: Double)

fun main() {
    val product = arrayOf(
        Product("Snow Ball", 870.00 ),
        Product("Smart Phone", 999.00 ),
        Product("Drone", 240.00 ),
        Product("Mouse", 333.55 ),
        Product("Keyboard", 125.99 ),
        Product("Monitor",1500.99 ),
        Product("Tablet", 512.99 )
    )

    product.sortBy { it.price }
    product.forEach { println(it) }
}*/
/*
* 배열 필터링 하기
*   filter() 메서드를 활용하면 원하는 데이터를 골라낼 수 있다.
*       // 0보다 큰 수 골라내기
*       val arr = arrayOf(1, -2, 3, 4, -5, 0)
*       arr. filter { e -> e > 0}.forEach{ e-> print("$e")}
*
*   체이닝을 통한 필터링 예
* */
/*

fun main() {
    val fruits = arrayOf("banana", "avocado", "apple", "kiwi")
    fruits.filter { it.startsWith("b")}
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}*/

/*
* when 문을 사용한 요소 확인
*   when{
*       "apple" in fruits -> println("apple!")
*       ...
*       }
*
* 큰 값 작은 값 골라내기
*   // 지정된 필드의 가장 작은/큰 값 골라내기
*   println(products.minBy{ it.price})
*   println(products.maxBy{ it.price})
*
* 배열 편탄화 하기
*   flatten() - 다차원 배열을 단일 배열 생성
*
* *//*
fun main() {
    val numbers = arrayOf(1, 2, 3)
    val str = arrayOf("one", "two", "three")
    val simpleArray = arrayOf(numbers, str) // 2차원 배열
    simpleArray.forEach { println(it) }

    val flattenSimpleArray = simpleArray.flatten() // 단일 배열로 변환하기
    println(flattenSimpleArray)
}*/