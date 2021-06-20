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

/*
*
* 코틀린의 표쥰 라이브러리
*
*   코틀린 제공 표준 라이브러리 함수
*       람다식을 사용하는 코틀린의 표준 라이브러리에서 let(), apply(), with(),
*       also(), run() 등 여러 가지 표준 함수를 제공하고 있다.
*       표준 함수들은 대략 확장 함수 형태의 람다식으로 구성되어 있다.
*
*       함수명     람다식의 접근 방법  반환 방법
*       T.let       it                  block 결과
*       T.also      it                  T caller(it)
*       T.apply     this                T caller(this)
*       T.run 또는 run this             block 결과
*       with        this                Unit
*
*       T. < 형식 매개 변수 어떠한 데이터 타입이라도 될 수 있는거 제네릭 같은거
*       it 은 복사하는 방법
*       this 참조형으로 하는 방식
*
* let()활용
*       let 동작
*           함수를 호출하는 객체 T를 이어지는 block 의 인자로 넘기고 block 의 결과값 R을 반환
*               public inline fun <T, R> T.let(block: (T) -> R): R {... return block(this)}
*           매개변수 block 은 T를 매개변수로 받아 R을 반환
*           let() 함수 역시 R을 반환
*           본문의 this 는 객체 T 를 가르키는데 람다식 결과 부분을 그대로 반환한다는 뜨
*           다른 메서드를 실행하거나 연산을 수행해야 하는 경우 사용
*
*
*
* *//*
fun main() {
    val score: Int? = 32
    //var score = null

    //일반적인 null 검사
        fun checkScore(){
            if(score != null){
                println("Score: $score") //Score: 32
            }
    }

    //let 을 사용해 null 검사를 제거
    fun checkScoreLet(){
        score?.let { println("Score: $it")} // Score: 32
        val str = score.let { it.toString()} // 32
        println(str)
    }
    checkScore()
    checkScoreLet()
}*/
//let 함수의 체이닝(chaining)
/*
fun main() {
    var a = 1
    var b = 2

    a = a.let{it + 2 }.let {
        println("a = $a")
        val i = it + b
        i
    }
    println(a)
}*/


//중첩 사용

/*fun main() {
    var x = "Kotlin!"
        x.let { outer ->
            outer.let { inner ->
                print("Inner is $inner and outer is $outer")
                // 이때는 it을 사용하지 않고 명시적이름을 사용

            }
        }
}*/

//반환값을 바깥쪽의 람다식에만 적용

/*

fun main() {
    var x = "Kotlin!"
    x = x.let { outer ->
        outer.let { inner ->
            print("Inner is $inner and outer is $outer")
            "Inner String"
            // 이것은 반환되지 않음
        }
        "Outer String"
        // 이 문자열이 반환되 x 에 할당
    }
    print(x)
}
*/

/*
* 커스텀 뷰에서 let() 활용하기
*   안드로이드의 커스텀 뷰에서 Padding 값을 지정
*       val padding = TypedValue.applyDimension(
*               TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics).toInt()
*           setPadding(padding, 0, padding, 0) // 왼쪽 오른쪽 padding 설정
*
*       val padding = TypedValue.applyDimension(
*               TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics).toInt().let{
*           setPadding(padding, 0, padding, 0) //계산된 값을 padding 이라는 이름의 인자로 받음
*           }
*       val padding = TypedValue.applyDimension(
*               TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics).toInt().let{
*           setPadding(it, 0, it, 0) // padding 대신 it 사용
*           }
*
* null 가능성 있는 객체에서 let() 활용하기
*   null 검사
*       let 을 세이프 콜(?.)과 함께 사용하면 if (null != obj)와 같은 null 검사 부분을 대체
*           var obj: String? //null 일 수 있는 변수 obj
*           if(null != obj){ // obj 가 null 이 아닐 경우 작업 수행(기존 방식)
*               Toast.makeText(applicationContext, obj, Toast.LENGTH_LONG).show()
*           }
*
*           obj?.let{ //obj 가 null 이 아닐 경우 작업 수행(Safe calls + let 사용)
*               Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
*           }
*
*   else 문이 포함된 문장 대체
*           val firstName: String?
*           val lastName: String
*           //if 문을 사용한 경우
*           if(null != firstName{
*               print("$firstName $lastName")
*           }   else{
*               print("$lastName")
*           }
*
*           //let 을 사용한 경우
*           firstName?.let { print("$it $lastName)} ?: print("$lastName")
*
*
* also() 활용하기
*   동작
*       also()는 함수를 호출하는 객체 T를 이어지는 block 에 전달하고 객체 T 자체를 반환
*           //표준 함수의 정의 let 과 비교
*           public inline fun <T, R> T.let(block: (T) -> R): R = block(this)
*           public inline fun <T> T.also(block: (T) -> Unit): T {block(this); return this}
*
*       also()는 블록 안의 코드 수행 결과와 상관없이 T인 바로 객체 this 를 반환
*           var m = 1
*           m = m.also { it + 3 }
*           println(m) // 원본값 1
*
*  */

/*fun main() {
    data class Person(var name: String, var skills : String)
    var person = Person("Gang", "Kotlin")

    val a = person.let {
        it.skills = "Android"
        "success" // 마지막 문장을 결과로 반환

    }

    println(person)
    println("a: $a") // String

    val b = person.also {
        it.skills = "Java"
        "success" // 마지막 문장은 사용되지 않음
    }
    println(person)
    println("b: $b") // Person 의 객체 b
}z*/

/*
*
* 특정 단위의 동작 분리
*   디렉터리 생성 활용
*       //기존의 디렉터리 생성 함수
*       fun makeDir (path: String): File{
*           val result = File(path)
*           result.mkdirs()
*           return result
*
*       }
*
*       //let 과 also 를 통한 개선된 함수
*       fun makeDir(path: string) = path.let{File(it)}.also{it.mkdirs()}
*           let 은 식의 결과를 반환하고 그결과를 다시 also 를 통해 넘겨짐.
*           이때 중간 결과가 아닌 넘어온 결과만 반환
*
*
* apply() 활용 하기
*   동작
*       apply() 함수는 also() 함수와 마찬가지로 호출하는 객체 T 를 이어지는 block 으로
*       전달하고 객체 자체인 this 를 반환
*           public inline fun <T, R> T.let(block: (T) ->R): R = block(this)
*           public inline fun <T> T.also(block: (T) -> Unit): T {block(this); return this}
*           public inline fun <T> T.apply(block: T.() -> Unit): T{ block(); return this}
*               T.() 와 같은 표현에서 람다식이 확장 함수로서 처리
* */

/*
fun main() {
    data class Person(var name: String, var skills : String)
    var person = Person("Gang", "Kotlin")

    //여기서 this 는 person 객체를 가르킴
    person.apply { this.skills = "Swift"}
    println(person)

    val returnObj = person.apply {
        name = "Sean" // this 는 생략할 수 있음
        skills = "Java" // this 없이 객체의 멤버에 여러 번 접근
        //person.also { it.skills = "Java"} it 으로 받고 생략할 수 없음
        //person.apply { skills = "Swift"} // this 로 받고 생략
    }

    println(person)
    println(returnObj)
}*/


/*
*
* 레이아웃을 초기화할 때 apply() 활용하기
*   레이아웃 초기 시 기존 코드
*       //기존의 코드
*       val param = LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT)
*       param.gravity = Gravity.CENTER_HORIZONTAL
*       param.weight = 1f
*       param.topMargin = 100
*       param.bottomMargin = 100
*
*        val param = LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT).apply{
*
*       gravity = Gravity.CENTER_HORIZONTAL
*       weight = 1f // param 을 사용하지 않고 직접 값을 지정할 수 있다.
*       topMargin = 100
*       bottomMargin = 100
*
* 디렉터리 생성 시 apply() 활용하기
*   //기존 코드
*       fun makeDir(path: String): File{
*           val result = File(path)
*           result.mkdirs()
*           return result
*           }
*
*       File(path).apply{mkdirs()}
*
*
* run() 활용하기
*   동작
*       run() 함수는 인자가 없는 익명 함수처럼 동작하는 형태와
*       객체에서 호출하는 형태 두 가지로 사용
*           public inline fun<R> run(block: () -> R): R = return block()
*           public inline fun<T, R> T.run(block: T.() -> R): R = return block()
*
*   간단한 예
*       var skills = "Kotlin"
*       println(skills)// Kotlin
*
*       val a = 10
*       skills = run {
*           val level = "Kotlin Level:" + a
*           level // 마지막 표현식이 반환됨
*       }
*       println(skills) // Kotlin Level: 10
*
*
* *//*
fun main() {
    data class Person(var name: String, var skills : String)
    var person = Person("Gang", "Kotlin")

    val returnObj = person.apply {
        name = "Sean"
        skills = "Java"
        "success" // 사용되지 않음
    }
    println(person)
    println("returnObj: $returnObj")

    val returnObj2 = person.run {
        name = "Dooly"
        skills = "C#"
        "success"
    }
    println(person)
    println("returnObj2: $returnObj2")

}
*/


/*
*
* with() 활용하기
*   동작
*       인자로 받는 객체를 이어지는 block 의 receiver 로 전달하며 결과값을 반환
*           run() 함수와 기능이 거의 동일한데, run 의 경우 receiver 가 없지만 with() 에서는
*           receiver 로 전달할 객체 를 처리
*               // 표준 함수의 정의
*                   public inline fun <T, R> with(receiver: T, block: T.()-> R): R = receiver.block()
*           with 는 세이프콜(?.) 은 지원하지 않기 때문에 다음과 같이 let 과 같이 사용
*               supportActionBar?.let{
*                   with(it){
*                       setDisplayHomeAsUpEnabled(true)
*                       setHomeAsUpIndicator(R.drawable.ic_clear_white)
*                       }
*                   }
*   let 과 with 표현 병합
*       run 과 동일
*            supportActionBar?.run{
*                       setDisplayHomeAsUpEnabled(true)
*                       setHomeAsUpIndicator(R.drawable.ic_clear_white)
*                   }
* */
/*

fun main() {
    data class User(val name: String, var skills: String, var email: String? = null)

    val user = User("Gang", "default")

    var result = with(user){
        skills = "Kotlin"
        email = "hangang@naver.com"
        "success"
    }
    println(user)
    println("result: $result")
    //기본적으로 Unit 반환, 필요하면 다음과 같이 "success"를 추가해주면 마지막 표현식 반환
}*/

/*
*
* use() 활용하기
*   동작
*       use() 를 사용하면 객체를 사용한 후 close() 등을 자동적으로 호출해 닫아준다
*           //표준 함수의 정의
*           public inline fun <T: Closeable?, R> T.use(block: (T) -> R): R 또는
*           public inline fun <T: AutoCloseable?, R> T.use(block: (T) -> R): R
*           T의 제한된 자료형을 보면 Closeable? 로 block 은 닫힐 수 있는 객체를 지정해야 함
*           Java 7 이후로는 AutoCloseable? 로 사용됨
*
* 파일관련 처리의 예
*   파일로부터 읽기 위한 자바 코드의 예
*       private String readFirstLine() throws FileNotFoundException{
*           BufferedReader reader = new BufferedReader(new FileReader("test.file"));
*           try{
*               return reader.readLine();
*              } catch(IOException e) {
*               e.printStackTrace();
*               } finally{
*                   try{
*                       reader.close();
*               } catch(IOException e) {
*                   e.printStackTrace();
*               }
*           }
*               return null
*           }
*   코틀린으로 변경한 코드
*       private fun readFirstLine(): String{
*           BufferedReader(FileReader("test.file")).use { return it.readLIne()}
*       }
*
*
* */

/*
fun main() {

    PrintWriter(FileOutputStream("C:\\TEMP\\output.txt")).use {
        it.println("hello")
    }
    }
    */


/*
*
* 기타 함수의 활용
*   takeIf() 와 takeUnless()의 활용
*       takeIf() 함수는 람다식이 true 이면 객체 T 를 반환하고 그렇지 않은 경우 null 반환,
*       takeUnless() 함순느 람다식이 false 이면 T를 반환하고 그렇지 않은 경우 null 반환
*           //표준 함수의 정의
*           public inline fun <T> T.takeIf(predicate: (T) -> Boolean):T?
*               = if(predicate(this)) this else null
*   예
*       //기존 코드
*       if(someObject != null && someObject.status){
*           doThis()
*       }
*
*       //개선한 코드
*       if(someObject?.status == true){
*           doThis()
*       }
*
*       //takeIf를 사용해 개선한 코드
*       someObject?.takeIf{ it.status}?. apply{ doThis()}
*
*   엘비스 연산자(?:) 를 함께 사용
*       val input = "Kotlin"
*       val keyword = "in"
*
*       //입력 문자열에 키워드가 있으면 인덱스를 반환하는 함수를 takeIf를 사용하여 구현
*       input.indexOf(keyword).takeIf{ it >= 0 } ?: error ("keyword not found")
*
*       //takeUnless 를 사용하여 구현
*       input.indexOf(keyword).takeUnless{ it < 0 } ?: error("keyword not found")
*
* 시간의 측정
*   kotlin.system 패키지에 있는 두 개의 측정 함수
*       measureTimeMillis()와 measureNanoTime()
*
*   선언 부
*       //코틀린 system 패키지의 Timing.kt 파일
*       public inline fun measureTimeMillis(block: () -> Unit): Long{
*           val start = System.currentTimeMillis()
*           block()
*           return System.currentTimeMillis() - start
*       }
*
*       //코틀린 system 패키지의 Timing.kt 파일
*       public inline fun measureNanoTime(block: () -> Unit): Long{
*           val start = System.nanoTime()
*           block()
*           return System.nanoTime() - start
*       }
*
* 시간의 측정
*   시간 측정 사용 방법
*       val executionTime = measureTimeMillis{
*           //측정할 작업 코드
*       }
*       println("Execution Time = $executionTime ms")
*
* 난수 생성하기
*   코틀린의 난수 생성
*       자바의 java.utilRandom 을 이용할 수도 있었지만 JVM 에만 특화된 난수를
*       생성하기 때문에 코틀린에서는 멀티플랫폼에서도 사용 가능한 kotlin.random.Random 를 제공
*
*   0부터 21사이의 난수를 제공 예
*
*   import kotlin.random.Random
*   ...
*   val number = Random.nextInt(21) // 숫자는 난수 발생 범위
*   println(number)
* */

