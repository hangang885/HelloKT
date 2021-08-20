package com.gill.but.hellokt


/*
* 동시성 프로그래밍
*   동기적(synchronous) 수행
*       순서대로 작업을 수행하며 하나의 루틴을 완료한 후 다른 루틴을 실행하는 방식
*       다양한 기능이 한꺼번에 일어나는 다중 실행 환경에서는 성능상의 제약 발생
*           예) UI, 데이터 다운로드를 동시에 대응해야 하는 경우
*
*   비동기적(asynchronous) 수행
*       다양한 기능을 동시에 수행할 수 있는 방식
*       전통적인 스레드를 이용하거나 RxJava, Reactive 와 같은 서드파티(third-party)
*       코틀린에서는 코루틴(coroutines) 을 기본으로 제공
*
*   코루틴(coroutines)
*       먼저 하나의 개별적인 작업을 루틴(routine)이라고 부르는데 여러 개의 루틴들이 협력
*       (co) 한다는 의미로 만들어진 합성어
*       코틀린의 코루틴을 사용하면 넌블로킹(non-blocking) 또는 비동기 코드를 마치 일반적인
*       동기 코드처럼 쉽게 작성하면서도 비동기 효과를 낼 수 있다.
*
* 프로세스와 스레드
*   태스크(Task) 개념
*       - 보통 태스크는 큰 실행 단위인 프로세스(process)나 좀 더 작은 실행 단위인 스레드(thread)로 생각할 수 있다.
*       - 프로세스는 실행되는 메모리, 스택, 열린 파일 등을 모두 포함하기 때문에 프로세스간
*         문맥 교환(context-switching)을 하는데 비용이 큼
*       - 스레드는 자신의 스택만 독립적으로 가지고 나머지는 대부분 공유하므로 문맥 교환 비용이 낮아
*         프로그래밍에서 많이 사용
*       - 다만 여러 개의 스레드를 구성하면 코드가 복잡
*
* 문맥교환
*   문맥 교환(context-switching)
*       하나의 프로세스나 스레드가 CPU 를 사용하고 있는 상태에서 다른 프로세스나 스레드가
*       CPU 를 사용하도록 하기 위해, 이전의 프로세스의 상태(문맥)를 보관하고 새로운 프로세스의
*       상태를 적재하는 과정
*
*
*
* *//*

// 클래스
class SimpleThread: Thread(){
    override fun run() {
        println("Class Thread ${Thread.currentThread() }")
    }
}

//인터페이스
class SimplerRunnable: Runnable{
    override fun run() {
        println("Interface Thread ${Thread.currentThread() }")
    }
}


fun main() {
    val thread = SimpleThread()

    thread.start()

    val runnable = SimplerRunnable()
    val thread2 = Thread(runnable)
    thread2.start()

    //익명객체
    object: Thread(){
        override fun run() {
            println("object Thread: ${Thread.currentThread()}")
        }
    }.start()

    //람다식
    Thread{
        println("Lambda Thread: ${Thread.currentThread()}")
    }.start()


}*/

//스래드로 손쉽게 사용하는 함수 만들기
//람다식 추가 함수를 만들어 실행
/*
public fun thread(start: Boolean = true, isDaemon: Boolean = false,
                  contextClassLoader: ClassLoader? = null, name: String? =null,
                    priority: Int = -1, block: () -> Unit): Thread{
    val thread = object: Thread(){
        public override fun run() {
            block()
        }
    }

    if(isDaemon)// 백그라운드 실행 여부
        thread.isDaemon = true

    if(priority > 0 )//우선순위(1: 낮음 ~5: 보통 ~10: 높음)
        thread.priority = priority

    if(name != null) // 이름
        thread.name = name

    if(contextClassLoader != null)
        thread.contextClassLoader = contextClassLoader

    if(start)
        thread.start()
    return thread
}

fun main() {
    //스레드의 옵션 변수를 손쉽게 설정할 수 있다.
    thread (start = true){
        println("Current Threads(Custom function): ${Thread.currentThread()}")
        println("Priority: ${Thread.currentThread().priority}") // 기본값은 5
        println("Name: ${Thread.currentThread().name}")
        println("Name: ${Thread.currentThread().isDaemon}")
    }
}*/

/*
* 스레드 풀 사용하기
*   newFixedThreadPool()
*       자주 재사용되는 스레드를 이용하기 위해 미리 생성된 스레드풀에서 스레드 이용
*       예) 8개의 스레드로 특정 백그라운드 서비스를 하도록 만든다고 했을 때
*
*   val myService:ExecutorService = Executors.newFixedThreadPool(8)
*   var i = 0
*
*   while(i < items.size) { // 아주 큰 데이터를 처리할 때
*       val item = items[i]
*       myService.submit {
*           processItem(item) // 여기서 아주 긴 시간 동안 처리 하는 경우
*       }
*
*       i += 1
*   }
*
*
* */

/*
* 코틀린의 코루틴
*   개념
*       - 스레드와 달리 코틀린은 코루틴을 통해 복잡성을 줄이고도 손쉽게 일시 중단하거나 다시
*         시작하는 루틴을 만들어 낼 수 있다.
*       - 멀티태스킹을 실현하면서 가벼운 스레드라고도 불림
*       - 코루틴은 문맥 교환 없이 해당 루틴을 일시 중단(suspended)을 통해 제어
*
* 코틀린의 주요 패키지
*   kotlinx.coroutines 의 common 패키지
*       기능                          설명
*       launch / async                  코루틴 빌더
*       Job / Deferred                  cancellation 지원을 위한 기능
*       Dispatchers                     Default 는 백그라운드 코루틴을 위한 것이고 Main 은
*                                       Android 나 Swing, JavaFx 를 위해 사용
*       delay / yield                   상위 레벨 지연(suspending) 함수
*       Channel / Mutex                 통신과 동기화를 위한 기능
*       coroutineScope / supervisorScope 범위 빌더
*       select                          표현식 지원
*
*   core 패키지
*       기능                      설명
*       CommonPool                  코루틴 컨텍스트
*       produce / actor             코루틴 빌더
*
* 코루틴 빌더
*   launch
*       - 일단 실행하고 잊어버리는(fire-and-forget) 형태의 코루틴으로 메인 프로그램과 독립되
*         실행할 수 있다.
*       - 기본적으로 즉시 실행하며 블록 내의 실행 결과는 반환하지 않는다.
*       - 상위 코드를 블록 시키지 않고(넌블로킹) 관리를 위한 Job 객체를 즉시 반환한다.
*       - join 을 통해 상위 코드가 종료되지 않고 완료를 기다리게 할 수 있다.
*
*   async
*       - 비동기 호출을 위해 만든 코루틴으로 예외를 반환한다.
*       - 실행 결과는 Deffered<T> 를 통해 반환하며 await 을 통해 받을 수 있다.
*       - await 은 작업이 완료될 때까지 기다린다.
*
* launch 와 async
*   기본적인 launch 빌더의 사용
*       import kotlinx.coroutines.*
*
*       fun main() { // 메인 스레드의 문맥
*           GlobalScope.launch { // 새로운 코루틴을 백그라운드에 실행
*               delay(1000L) // 1초의 넌블로킹 지연(시간의 기본 단위는 ms)
*               println("World!") // 지연 후 출력
*       }
*       println("Hello,") // main 스레드가 코루틴이 지연되는 동안 계속 실행
*       Thread.sleep(2000L)) // main 스레드가 JVM 에서 바로 종료되지 않게 2초 기다림
*       }
*   일시 중단(suspended) 함수
*       delay() 의 경우 일시 중단될 수 있으며 필요한 경우 재개(resume) 된다.
*           이 소스의 경우 약 1초후
*
*       delay()
*           '아무런 일을 하지 않는 일' 을 한다는 것은 일시 중단 되어 있는
*           사이에 다른 루틴을 블로킹 하지 않으므로 다른일을 할 수 있게 하는 것입니다.
*
*   delay()의 선언 부
*       //kotlinx-coroutines-core 의 DelayKt.class 의 일부
*       public suspend fun delay(timeMillis: kotlin.Long): kotlin.Unit {/ compiled code /}
*           suspend 함수를 코루틴 블록 외에 사용하면 오류가 남
*   사용자 함수에 suspend 적용
*       suspend fun doSomething() {
*           println("Do something!")
*       }
*           컴파일러는 suspend 가 붙은 함수를 자동적으로 추출해 Continuation 클래스로부터 분리된 루틴을 만든다.
*           이러한 함수를 사용하기 위해 코루틴 빌더인 launch 와 async 에서 이용할 수 있다.
*
*/

fun main() {
}


