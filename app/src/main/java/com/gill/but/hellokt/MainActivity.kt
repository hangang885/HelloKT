// HelloKotlin.kt
/*
fun main() { // 프로그램의 진입점
    println("HelloKotlin") // 출력문
    println("Hello~!")

}*/

fun main(args: Array<String>){
    println("args[0] = ${args[0]}")
    println(args[1])
    println(args[2])
    println(args[2])
    println(args[3])//핼로하이
    println(args[3])
    /*인자 없이 실행할 경우 에러가 난다*/
    /*Edit configuration 의 arguments 에 넣어주면 실행 된다*/
}
//main을 타이핑 하고 tab키를 누르면 main 함수가 코드 어시스트에 의해 자동 완성 된다

//Hello Kotlin 분석
/*분석
*   class가 없는데 main 메서드 하나로 println을 콘솔에 실행하고 있다.
*   실제로는 main 메서드는 파일명을 기준으로 자동으로 클래스가 생성된다.
*       Tools > Kotlin > Show Kotlin Bytecode 에서 Decompile을 해본다*/

//main()에서 매개변수를 사용하는 경우
/*코드 보조에서 main으로 사용하는 경우
*   main(args: Array<String>)
*   프로그램 외부에서 인자를 받아들인다.*/