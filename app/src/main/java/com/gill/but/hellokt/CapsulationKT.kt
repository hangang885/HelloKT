package com.gill.but.hellokt

/*
* 정보 은닉 캡슐화
*   캡슐화(encapsulation)
*       클래스를 작성할 때 외부에서 숨겨야 하는 속성이나 기능
*       가시성 지시자(visibility modifiers)를 통해 외부 접근 범위를 결정할 수 있음
*       private : 이 지시자가 붙은 요소는 외부에서 접근할 수 없음
*       public : 이 요소는 어디서든 접근이 가능(기본값)
*       protected :  외부에서 접근할 수 없으나 하위 상속 요소에서는 가능
*       internal : 같은 정의의 모듈(패키지) 내부에서는 접근이 가능
*
*   가시성 지시자의 선언 위치
*       [가시성 지시자] <val | var> 전역 변수명
*       [가시성 지시자] fun 함수명() {...}
*       [가시성 지시자] [특정 키워드] class 클래스명 [가시성 지시자] constructor(매개변수들){
*           [가시성 지시자] constructor(){...}
*           [가시성 지시자] 프로퍼티들
*           [가시성 지시자] 메서드들
*       }
* *//*
private class PrivateTest{
    private var i = 1
    private fun privateFunc(){
        i += 1
        println(i)
    }
    fun access(){
        privateFunc()
    }
}
class OtherClass{
//val pc = PrivateTest() // 공개 생성 불가
    fun test(){
    val pc = PrivateTest()
    pc.access()
    }
}

fun main() {
    val pc = PrivateTest()
    pc.access()

}
fun topFunction(){
    val pc = PrivateTest()
}*/
/*

open class Base{
    protected var i = 2
    protected fun protectedFunc(){
        i += 1
    }
    fun access(){
        protectedFunc()
    }
}

class Derived : Base(){

    var j = 1 + i
    fun derivedFunc(): Int{
        protectedFunc()
        return i
    }
}
class Other{
    fun other(){
        val base = Base()
    }
}

fun main() {
    val base = Base()
    base.access()
    val derived = Derived()
    derived.derivedFunc()
}*/

open class Base{
    // 이 클래스에서는 a, b, c, d, e 접근 가능
    private val a =1
    protected open val b = 2
    internal val c = 3
    val d = 4 // 가시성 지시자 기본 값은 public

    protected class Nested {
        // 이 클래스에서는 a, b, c, d, e, f 접근 가능
        public val e: Int = 5 // public 생략 가능
        private val f: Int = 6
    }
}

class Derived: Base(){
    // 이 클래스에서는 b, c, d, e 접근 가능
    // a 는 접근 불가
    override val b = 5 // Base 의 'b' 는 오버라이딩 됨 - 상위와 같은 protected 지시자
}

class Other(base: Base){
    //base.a , base.b 는 접근 불가
    //base.c 와 base.d 는 접근 가능( 같은 모듈 안에 있으므로)
    //Base.Nested 는 접근 불가 Nested::e 역시 접근 불가
}