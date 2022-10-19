//실드클래스(SealedClass) 하나의 상위클래스 또는 인터페이스에서 하위클래스에대한 정의를 제한할수 있는 방법
//하위클래스를 제한조건에 정의해야하고 컴파일러가 판단할수 있게됨.
//when 식에서 컴파일 오류가 발생하게되어 유용하게 사용할수있음

sealed class Developer {
    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 백엔드 개발자입니다. ${language}를 사용합니다")
    }
}

data class FrontendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 프론트엔드 개발자입니다. ${language}를 사용합니다")
    }
}

object OtherDeveloper : Developer() {
    override val name: String = "익명"

    override fun code(language: String) {
        TODO("Not Yet implement")
    }

}


data class AndroidDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 안드로이드 개발자입니다. ${language}를 사용합니다")
    }
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when (developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
//sealed class로 두면 해결됨
//        else -> {
//            println("지원하지 않는 개발자입니다.")
//        }
        is AndroidDeveloper -> pool[developer.name] = developer
        is OtherDeveloper -> println("지원하지 않는 개발자종류 입니다")
    }

    fun get(name: String) = pool[name]
}

fun main() {

    val backendDeveloper = BackendDeveloper(name = "토니")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper(name = "카즈야")
    DeveloperPool.add(frontendDeveloper)

    val androidDeveloper = AndroidDeveloper(name="안드로")
    DeveloperPool.add(androidDeveloper)

    println(DeveloperPool.get("토니"))
    println(DeveloperPool.get("카즈야"))
    println(DeveloperPool.get("안드로"))


}
