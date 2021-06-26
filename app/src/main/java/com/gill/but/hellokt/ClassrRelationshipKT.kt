package com.gill.but.hellokt

/*
*
* 클래스와 관계
*   일반적인 실세계의 관계
*       서로 관계를 맺고 서로 메시지를 주고받으며, 필요한 경우 서로의 관계를 이용
*       자동차와 엔진처럼 종속적인 관계
*       아버지와 아들처럼 상속의 관계
*
* 클래스 혹은 객체 간의 관계
*   관계(relationship)
*       연관(association)
*       의존(dependency)
*       집합(aggregation)
*       구성(composition)
*
*       다중성(Multiplicity)
*           다중성은 클래스의 관계의 수를 나타낸다.
*           예) 0..1 하나도 없거나 하나의 관계
*               1..* 최소한 하나의 관계 혹은 다수
*               0..* 하나도 없거나 다수의 관계
*
*       화살표 표기법
*           화살표 표기를 통해 관계를 알 수 있따.
*           그냥 실선   양방향의 관계를 가진다
*           실선 ->     특정 한 방향의 관계를 가진다.
*
*
*   */
/*

class Patient(val name: String){
    fun doctorList(d: Doctor){ //인자로 참조
        println("Patient: $name, Doctor: ${d.name}")
    }
}
class Doctor(val name: String){
    fun patientList(p: Patient){//인자로 참조
        println("Doctor: $name, Patient: ${p.name}")
    }
}

fun main() {
    val doc1 = Doctor("KimSabu")// 객체가 따로 생성된다
    val patient1 = Patient("Gang")
    doc1.patientList(patient1)
    patient1.doctorList(doc1)
}*/
/*

class Patient(val name: String, var id: Int){
    fun doctorList(d: Doctor){ //인자로 참조
        println("Patient: $name, Doctor: ${d.name}")
    }
}
class Doctor(val name: String, val p: Patient){

    val customerId: Int = p.id

    fun patientList(){//인자로 참조
        println("Doctor: $name, Patient: ${p.name}")
        println("Patient Id: $customerId")
    }
}

fun main() {
    val patient1 = Patient("Gang", 1234)
    val doc1 = Doctor("KimSabu", patient1)// 객체가 따로 생성된다
    doc1.patientList()
}*/
/*

// 연못의 오리들로 집합 관계

// 여러 마리의 오리를 위한 List 매개변수
class Pond(_name: String, _members: MutableList<Duck>){
    val name: String = _name
    val members: MutableList<Duck> = _members
    constructor(_name: String) : this(_name, mutableListOf<Duck>())
}

class Duck(val name: String)

fun main() {
    //두 개체는 서로 생명주기에 영향을 주지 않는다.
    val pond = Pond("myFavorite")
    val duck1 = Duck("Duck1")
    val duck2 = Duck("Duck2")
    //연못에 오리를 추가 - 연못에 오리가 집합한다.
    pond.members.add(duck1)
    pond.members.add(duck2)
    //연못에 있는 오리들
    for (duck in pond.members){
        println(duck.name)
    }

}*/

//구성 관계 나타내기
class Car(val name: String, val power: String){
    private var engine = Engine(power)//Engine 클래스 객체는 Car에 의존적

    fun startEngine() = engine.start()
    fun stopEngine() = engine.stop()

}
class Engine(power: String){
    fun start() = println("Engine has bean started")
    fun stop() = println("Engine has bean stopped")
}

fun main() {
    val car = Car("tico", "100hp")
    car.startEngine()
    car.stopEngine()
}