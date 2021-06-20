package com.gill.but.hellokt

var x: Int =0
var y: Int =0

fun main() {

    var board = Array<CharArray>(3){ CharArray(3) }//__(1) 3 x 3 의 Array 배열 정의 __
     //CharArray 한 줄로 늘어선 캐릭터 배열
    initBoard(board)

    val names = arrayOf("Player1","Player 2")
    //names 변수에 Player1, Player2 로 이루어진 배열을 넣어준다
    val makes = arrayOf('O','X')
    //makes 변수에 O, X 로 이루어진 배열을 넣어준다

    play(board, names, makes)
}
// 격자판을 공백으로 초기화
fun initBoard(board: Array<CharArray>){

    for(i in 0..2){
        for (j in 0..2 )
            board[i][j] = ' '
    }
    //__(2) 반복문을 이용해 3 x 3 배열을 공백('')으로 채우기__

}

fun printBoard(board: Array<CharArray>){

    // 첫 번째 줄
    print("  ")
    for (i in 0..2) print("$i ")
    println()
    // 두 번째 줄 밑 플레이어 보드
    for (y in board.indices) {
        print("$y ")
        for (x in board.indices) {
            print("${board[y][x]}")
            if (x!=2) print("|")
        }
        // 위치표시줄
        println()
        print("  ")
        if(y!=2) {
            for (i in board.indices) {
                print("-")
                if (i != 2) print("+")
            }
            println()
        }
    }
}
//격자 범위에 있는지 검사
val isInRange = {x: Int, y: Int -> x in 0..2 && y in 0..2}//__(3) x와 y 가 격자 범위에 있는지 판별 (람다식 이용)

//격자의 칸이 빈 곳인지 검사
fun isValid(board: Array<CharArray>, x:Int, y:Int):Boolean{
    return isInRange(x,y) && board[y][x] == ' '

}
fun playerInput(name: String, board: Array<CharArray>): Boolean{
    print("$name 입력(줄,칸): ")
    val input: String? = readLine()
    //__(4) 입력 받은 값을 split()함수를 이용해 x와 y로 분리 저장
    val arr = input!!.split(',')
    y = arr[0].toInt()
    x = arr[1].toInt()
    if(!isValid(board, x, y)) return false
    //값이 없으면 false 로 반환
    return true
    //값이 있을경우 true 로 반환

}
// 해당 칸이 승리할 수 있는지 검사
fun isWin(board: Array<CharArray>, x: Int, y: Int):Boolean{
    //가로, 세로, 우하 대각선, 우상 대각선 방향에 대한 x, y 변화량
    val dx = arrayOf(-1, 1, 0, 0, -1, 1, 1, -1)
    val dy = arrayOf(0, 0, -1, 1, -1, 1, -1, 1)

    for(d in 0..3){
        var count = 1
        for(b in 0..1){
            val index = 2 * d + b
            var cx = x + dx[index]
            var cy = y + dy[index]

            while(isInRange(cx, cy)){
                if(board[cy][cx] == board[y][x]) count++
                cx += dx[index]
                cy += dy[index]
            }
        }
        if(count == 3) return true
    }
    return false
}
//플레이 진행하기
fun play(board: Array<CharArray>, name: Array<String>, marks:Array<Char>){

    var round = 0
    var turn = 0

    while(true){
        println("\n ${turn + 1} 번째 턴 \n")
        printBoard(board)
        if(!playerInput(name[turn],board))
            continue
        board[y][x] = marks[turn]
        round++


        //__(5) 승리 혹은 무승부 조건을 검사, 이 두 조건은 while 루프를 끝낸다__

        //무승부 시 게임 종료
        if(round == 9){
            println("무승부")
            break
        }
        //승리 조건 달성 시 게임 종료
        if(isWin(board, x, y)){
            println("player ${name[turn + 1]} Win!")
            break
        }
        turn =  (turn +1 ) % 2// __(6) turn 이 0이며 1로, 1이면 0으로 바꿔서 플레아어를 바꿔서 판단
    }

}
