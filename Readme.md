```kotlin
introduce {
  name("오태현")
  company("엔씨소프트")
  skills {
    soft("A passion for poblem solving")
    soft("Good commnuication skills")
    hard("Kotlin")
  }
  language {
    "Korean" level 5
    "English" level 3
  }
}
```


1. 컬렉션타입
- 코틀린 표준 라이브러리는 기본 컬렉션 타입인 List, Set Map을 제공한다
- 컬렉션은 두가지 종류로 나뉜다
  - 불변 컬렉션 : 읽기 전용 컬렉션
  - 가변 컬렉션(Mutable) : 삽입 수정, 삭제 쓰기와 작업이 가능한 컬렉션
- 컬렉션 계층 다이어 그램


2. 데이터클래스
필요한이유: 데이터를 저장하는 목적으로 하는 클래스. 필수적인함수 tostring equals hashcode 이것을 직접 재정의해 주게됩니다.
  - equals : 동등성비교
  - hashcode : equals를 재정의할때 hashcode도 반드시 재정의해야함 (hash구조 재정의안하면 hash 기반 자료구조에서는 동작이 이상하게됨)
  - tostring : 문자열 출력

가변객체인경우 멀티스레드 환경에서 문제가 발생할수 있음. 일반적으로 객체의 동기화를 유지하는

- copy
  데이터 불변성을 쉽게 유지할수 있음.
  원하는 프로퍼티만 변경하면서 새로운 불변객체를 생성가능함

- componentn
- 

1. 싱글톤과 동반객체
- 싱글톤 패턴은 클래스의 인스턴스를 하나의 `단일` 인스턴스로 제한하는 디자인 패턴이다.
- 싱글톤 패턴을 구현할때는 몇가지 제약사항을 통해 구현한다
  - 직접 인스턴스화 하지 못하도록 생성자를 `private` 으로 숨긴다.
  - `getInstance()` 라는 클래스의 단일 인스턴스를 반환하는 static 메서드를 제공한다.
  - 멀티-스레드 환경에서도 `안전하게` 유일한 인스턴스를 반환해야한다
- 다양한 구현 방법들
  - DCL(Double Check Locking)
    - JVM 환경에선 거의 사용 안함
  - ENUM 싱글톤
    - 이펙티브 자바에서 소개
  - 이른초기화(Eager)
  - 지연 초기화(Lazy)
- 자바에서 많이 쓰이는 구현방식
  - 이른초기화
```java
  public class Java_Singleton {
      private static final Java_Singleton INSTANCE = new Java_Singleton();
      private Java_Singleton(){
          /* do nothing */
      }
      public Java_Singleton getInstance() {
          return INSTANCE.INSTANCE;
      }
  }
```
  - 지연 초기화
```java
  public class Java_Singleton {
    private Java_Singleton() {
        /*do nothing*/
    }
    public Java_Singleton getInstance() {
        return LazyHolder.INSTANCE;   
    }
    private static class LazyHolder {
        private static final Java_Singleton INSTANCE = new Java_Singleton();
    }
  }
```


- [어디 가서 코프링 매우 알은 체하기! : 9월 우아한테크세미나]|(https://www.youtube.com/watch?v=ewBri47JWII&)
- [코틀린-Jackson]|(https://hyg4196.tistory.com/48)
