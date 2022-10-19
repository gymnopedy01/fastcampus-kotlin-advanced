import java.time.LocalDateTime

//코틀린에서는 객체선언이라는 문법을 통해서 싱글톤을 지원
//object 라는 키워드

object Singleton {

    val a = 1234

    fun printA() = println(a)

}

fun main() {
    println(Singleton.a)
    Singleton.printA()

    println(DateTimeUtils.now)
    println(DateTimeUtils.now)
    println(DateTimeUtils.now)

    println(DateTimeUtils.DEFAULT_FORMAT)

    val now = LocalDateTime.now()
    println(DateTimeUtils.same(now,now))

    println(MyClass.a)
    println(MyClass.newInstance())

    println(MyClass.MyCompanion.a)
    println(MyClass.MyCompanion.newInstance())


}

object DateTimeUtils {
    val now: LocalDateTime
        get() = LocalDateTime.now()

    const val DEFAULT_FORMAT = "YYYY-MM-DD"

    fun same(a: LocalDateTime, b: LocalDateTime): Boolean {
        return a == b
    }
}

class MyClass{

    private constructor()

    companion object MyCompanion {
        val a = 1234

        fun newInstance() = MyClass()

    }
}

//동반객체 : companion object 클래스 내부에서 생성되는 객체

