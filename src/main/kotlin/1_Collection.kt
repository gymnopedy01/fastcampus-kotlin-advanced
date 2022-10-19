import java.util.*
import java.util.stream.Collectors

fun main() {

    // immutable
    val currencyList = listOf("달러", "유로", "원")
    //currencyList.add("위안");불가능

    // mutable
    val mutableCurrencyList = mutableListOf<String>()
    mutableCurrencyList.add("달러")
    mutableCurrencyList.add("유로")
    mutableCurrencyList.add("원")

    val mutableCurrencyList2 = mutableListOf<String>().apply {
        add("달러")
        add("유로")
        add("원")
    }

    //immutable set
    val numberSet = setOf(1, 2, 3, 4)

    //mutable set
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    //immutable Map
    //to 는 중위표현식 infix notation
    val numberMap = mapOf("one" to 1, "two" to 2)

    //mutable Map
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1
    //mutableNumberMap.put("two", 2)    //권장하지 않음
    mutableNumberMap["two"] = 1
    mutableNumberMap["three"] = 1

    //컬렉션 빌더
    //차이점 : 일반리스트 인데 내부에서는 add를 하고있음. buildList내부에서는 MutableList. 외부에서는 List로 반환함
    val numberList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
    }


    //linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    //arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    val iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }
    println("==============")

    for (currency in currencyList) {
        println(currency)
    }
    println("==============")

    //인라인 함수
    currencyList.forEach {
        println(it)
    }

    // for loop -> map
    val lowerList = listOf("a", "b", "c")
    val upperList = mutableListOf<String>()

    for (lowerCase in lowerList) {
        upperList.add(lowerCase.uppercase())
    }
    println(upperList)

    val upperList2 = lowerList.map { it.uppercase() }
    println(upperList2)

    //특정조건이 만족하는 경우에만 담아서 리스트 리턴
    val filteredList = mutableListOf<String>()
    for (upperCase in upperList) {
        if (upperCase == "A" || upperCase == "C") {
            filteredList.add(upperCase)
        }
    }
    println(filteredList)

    val filteredList2 = upperList.filter { it == "A" || it == "C" }
    println(filteredList)

    //자바와의 차이점
    //자바 :터미널오퍼레이터가있어서 해당 연산자가 호출이 되어야 연산 되지만만
    //코틀린 : 시퀀스라는 api가 있어 터미널 오퍼레이터를 후출해야최종 동작
    val filteredList3 = upperList.stream().filter { it == "A" || it == "C" }
        .collect(Collectors.toList())

    //매번 인라인함수 조건에 따라 컬렉션들이 생성됨 그래서 자주 사용할경우 oom 이슈가 생길수있음.
    //터미널 오퍼레이터를 사용하게 되면 컬렉션이 한개만 생성되어 oom 이슈가 생기지 않음.

    val filteredList4 = upperList
        .asSequence()
        .filter { it == "A" || it == "C" }
        .toList()

    println(filteredList4)

}