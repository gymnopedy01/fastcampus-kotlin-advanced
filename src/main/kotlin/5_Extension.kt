
fun String.first(): Char {
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}

class MyExample {
    fun printMessage() = println("클래스출력")
}

fun MyExample.printMessage() = println("확장 출력")

fun MyExample.printMessage(message: String) = println(message)

fun MyExample?.printNullOrNotNull() {
    if (this == null) println("널인 경우에만 출력")
    else println("널이 아닌 경우에만 출력")
}

fun main() {

    println("ABCD".first())
    println("ABCD".addFirst('Z'))

    MyExample().printMessage()  //클래스가 우선됨
    MyExample().printMessage("message !! ")

    var myExaple: MyExample? =null
    myExaple.printNullOrNotNull()       //안전연산자를 쓰지 않았음에도 컴파일 오류가 나지 않음

    myExaple = MyExample()
    myExaple.printNullOrNotNull()

}