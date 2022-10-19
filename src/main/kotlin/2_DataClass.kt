data class Person(val name: String, val age: Int) {

}

data class MPerson(var name: String, val age: Int)

fun main() {

    println("변경불가 Person으로 테스트")
    //변경불가한 Person 테스트
    val person1 = Person(name = "tony", age = 12)
    val person2 = Person(name = "tony", age = 12)

    println(person1 == person2)

    val set = hashSetOf(person1)
    println(set.contains(person2))

    println(person1.toString())


    //변경가능한 Mperson으로 테스트
    println("==변경가능한 Mperson으로 테스트==")
    val mperson1 = MPerson(name = "tony", age = 12)
    val mset = hashSetOf(mperson1)
    println(mset.contains(mperson1))

    mperson1.name = "strange"
    println(mset.contains(mperson1))

    //copy 테스트
    println("==copy테스트==")
    val mperson2 = mperson1.copy(name="strange")
    println(mperson2)

    //componentn 테스트
    println("이름=${person1.component1()}, 나이=${person1.component2()}")

    val (name, age) = person1       //구조분해할당

    //내부적으로 컴포넌트n함수를 사용해서 순서대로 변수를 매핑해주는기능
    println("이름=${name}, 나이=${age}")


}