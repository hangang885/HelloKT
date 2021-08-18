package com.gill.but.hellokt

/*
* 문자열의 기본 처리
*   문자열은 불변(immutable) 값으로 생성
*       참조되고 있는 메모리가 변경될 수 없다
*       val hello: String = "Hello World!"
*       println(hello[0]) // [H]
*       hello[0] = 'K' // 오류!
*       var s = "abcdef"
*       s = "xyz" // 새로운 메모리 공간이 생성된다
*       기존의 문자열은 GC에 의해 제거됨
*
* 문자열 추출하고 병합하기
*   문자열에서 특정 범위의 문자열을 추출
*       substring(), subsequence()
*       String.substring(인덱스 범위 지정): String
*       CharSequence.subSequence(인덱스 범위 지정): CharSequence
*       s = "abcdef"
*       println(s.substring(0..2)) // 인덱스 0~2 범위의 abc 반환
*   추출 후 문자열 새로 할당하기
*       var s = "abcdef"
*       s = s.substring(0..1) + "x" + s.substring(3..s.length-1)
*       //ab를 추출하고 x를 덧붙이고 다시 def 를 추출
*
* 문자열 비교
*   a.compareTo(b) 를 사용한 비교
*       a와 b가 같다면 0을 반환하고, a가 b보다 작으면 양수, 그렇지 않으면 음수
*           var s1 = "Hello Kotlin"
*           var s2 = "Hello KOTLIN"
*           //같으면 0, s1 < s2 이면 양수, 반대면 음수를 반환
*           println(s1.compareTo((s2)))
*           println(s1.compareTo(s2, true)) // 대소문자 무시
*
* StringBuilder 의 이용
*   문자열이 사용할 공간을 좀 더 크게 잡아 사용함
*       간단한 요소 변경이 있을 경우 용이
*       단, 기존의 문자열보다는 처리가 좀 느리고, 만일 단어를 변경하지 않는 경우
*       불필요한 메모리 낭비
*       문자열이 자주 변경되는 경우에 사용
*       var s = StringBuilder("Hello")
*       s[2] = 'x' // 허용되지 않았던 요소의 변경이 가능하다. 결과는 Hexlo
*
* StringBuilder 의  기타 관련 메서드
*   포함(append), 추가(insert), 삭제(delete) 등
*   s.append("World") // 문자열이 추가되어 HexloWorld
*   s.insert(10, "Added") // 인덱스 10부터 추가되어 HexloWorldAdded
*   s.delete(5, 10) // 인덱스 5에서부터 10 전까지 삭제되어 HexloAdded
*
* 기타 문자열 처리
*   소문자/ 대문자 변경
*       toLowerCase(), toUpperCase()
*   특정 문자 단위로 잘라내기
*       split("분리문자") - 분리된 내용은 List 로 반환
*       var deli = "Welcome to Kotlin"
*       val sp = deli.split(" ")
*       println(sp)
*   앞뒤 공백 제거
*       trim()
*
* 리터럴 문자열
*   이스케이프(Escape) 문자
*       종류
*       \t 탭(tab)               \' 작은따옴표(single quote)
*       \b 백스페이스(backspace)   \" 큰따옴표(double quote)
*       \n 개행(newline)          \\ 슬래시(slash)
*       \r 리턴(carriage return)  \& 달러기호(dollar)
*       \uHHHH 유니코드(Unicode)문자
*       val str = "\tYou're just too \"good\" to be true\n\tI can't take my eyes off you."
*       val uni = "\uAC00" // 한글 코드의 범위 AC00-D7AF
*
*
* 원본 문자열 그대로 나타내기
*   3중 따옴표 부호(""")의 이용
*   val text ="""
*       |Tell me and I forget.
*       |Teach me and I remember.
*       |Involve me and I learn.
*       |(Benjamin Franklin)
*       """.trimMargin() //trim default 는 |
*
* 형식 문자 사용
*   format()를 사용한 형식 문자
*       inline fun String.format(vararg args:Any?): String (source)
*           종류
*           %b 참과 거짓의 Boolean 유형       %c 문자
*           %d 부호 있는 정수                 %e E 표기법의 실수
*           %f 10진 실수                    %g 10진 혹은 E 표기법의 실수
*           %h 해시코드                     %n 줄 구분
*           %o 8진 정수                    %s 문자열
*           %t 날짜나 시간                 %x 16진 정수
*       val pi = 3.1415926
*       val dec = 10
*       val s = "hello"
*       println("pi = %.2f, %3d, %s".format(pi, dec, s))
*
*
*
*
* */