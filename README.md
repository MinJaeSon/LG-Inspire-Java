## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).




*(이전 포스팅 마지막 예제와 이어집니다.)*

<br/><br/>

# 은닉화

TV가 삼성티빈지 엘지티빈지 객체 타입을 숨기는 것

→ 따라서 인터페이스는 표준화 용도 뿐 아니라 캡슐화의 용도로도 씀

고로 추상화와 은닉화 모두에서 인터페이스의 개념이 중요하다.

<br/><br/>

## Factory + Singleton

**• 싱글톤(Single) 패턴**

인스턴스를 하나로 유지 → 메모리를 효율적으로 사용

**• 팩토리(Factory) 패턴**

인스턴스를 생성하는 공장

<br/>

실제 런타임 시점에는 TV라는 타입만 전달할 수 있도록 은닉화를 시킬 것

우리는 TV라는 타입으로 SamsunTV와 LgTV를 만들 수 있다 (= 다형성)
```java
TV tv = new SamsunTV();
TV tv = new LgTV();
```

팩토리에 TV 타입으로 등록 → 클라이언트는 팩토리를 통해서 TV 타입으로 관리하는 배열에서, 넘어오는 값에 맞는 

TV 인터페이스에 있는 추상 메소드가 직접 호출되는 것이 아니라

TV를 implement한 S or L 에서 오버라이딩 한 메소드가 호출되는 것

- factory를 통해 각각의 인스턴스를 singleton으로 생성
- client → factory 로 요청
- factory → client 로 tv만 전달 (클라이언트는 tv가 삼성껀지 엘지껀지 모름)

![스크린샷 2025-08-12 오후 1.15.57.png](attachment:b3b86d00-90dc-42d1-87de-a33c93da22f2:스크린샷_2025-08-12_오후_1.15.57.png)

```java
public class BeanFactory {
    private BeanFactory() { 

    }
}
```

```java
 BeanFactory beanFactory = new BeanFactory() // ❌ : The constructor BeanFactory() is not visible
```

→ 외부에서 객체 생성 불가

```java
public class BeanFactory {
		private static BeanFactory instance = null; // static으로 선언
		
    private BeanFactory() { // 생성자를 private으로 선언 -> 외부에서 생성자를 호출할 수 없음

    }

    public static BeanFactory getInstance() { //  싱글톤 패턴 적용할 수 있도록 public static 메서드로 선언 (static -> 클래스 이름으로 접근 가능)
        if (instance == null) {
            instance = new BeanFactory();
        }
        return instance;
    }
}

```

```java
public static void main(String[] args) {
	BeanFactory factory01 = BeanFactory.getInstance();
	BeanFactory factory02 = BeanFactory.getInstance();

	System.out.println(factory01 == factory02); // true
}
```

같은 인스턴스를 참조 -> 몇 개를 만들어도 무관 (싱글톤 패턴)

new 연산자로 인스턴스를 만들었다면 factory01과 factory02의 주소값이 달랐을 것

```java
private TV [] arr; // 참조 타입의 변수 선언

    private BeanFactory() {
        arr = new TV[2]; // 배열 객체 먼저 생성
        // 배열 객체에 객체 할당
        arr[0] = new SamsungTV(); 
        arr[1] = new LgTV();
    }
```

```java
public TV getBrand(String brand) {
        return brand.equals("samsung") ? arr[0] : arr[1]; 
    }
```

- 문자열 비교 시에는 equals 메서드 사용
    
    ```java
    public class StringApp {
        public static void main(String[] args) {
            String str1 = "자바";
            String str2 = "자바";
    
            if (str1 == str2) {
                System.out.println("str1 == str2");
            } else {
                System.out.println("str1 != str2");
            }
    
            if (str1.equals(str2)) {
                System.out.println("str1.equals(str2)");
            } else {
                System.out.println("!str1.equals(str2)");
            }
        }
    }
    
    // str1 == str2 출력
    // str1.equals(str2) 출력
    ```
    
    이땐 문제없음.
    
    literal pool에서 key value로 문자열을 저장하는데
    
    value가 ‘자바’로 같은 경우에는 새로운 key로 저장하지 않음. 
    
    그러나
    
    ```java
    String str1 = new String("자바");
            String str2 = new String("자바");
    
            if (str1 == str2) {
                System.out.println("str1 == str2");
            } else {
                System.out.println("str1 != str2");
            }
    
            if (str1.equals(str2)) {
                System.out.println("str1.equals(str2)");
            } else {
                System.out.println("!str1.equals(str2)");
            }
            
    // str1 != str2 출력
    // str1.equals(str2) 출력
    ```
    
    이렇게 객체로 문자열을 생성하여 비교할 경우에는 달라짐.
    
    값이 같더라도 두 개의 객체가 각각 다른 주소 번지에 저장됨.
    
    따라서 str1, str2가 문자열 객체의 주소값을 갖게 되기 때문에 그냥 비교하면 false가 되는 것
    
    하지만 equals로 비교하면 그 주소에 들어 있는 값을 비교하니까 올바르게 비교가 가능하다
    
    - 상수
        
        final 키워드!
        
        보편적으로는 `public static final int STU = 1;` 와 같이 선언과 함께 정의
        
        → 값이 노출
        
        - **enum**
            
            ‘상수의 집합’
            
            → 타입 안정성, 가독성 증가
            
            - 심볼(상수)만 정의
                
                ```java
                public enum Division {
                    STU, TEA;
                }
                ```
                
                - `Division.STU` 자체가 그 상태 그대로의 의미를 가짐
            - 값(필드)을 바인딩
                
                ```java
                public enum Division {
                    // enum에 값을 줄 경우
                    STU("학생"),
                    TEA("교사");
                
                    private String name; // 필드를 바인딩할 수 있는 변수 선언
                
                    Division(String name) { // enum의 생성자는 무조건 private
                        this.name = name;
                    }
                
                    public String getName() { // 외부에서의 접근을 위해 public으로 열어둠
                        return name;
                    }
                }
                ```
                
                - 매핑 정보가 추가됨
                - 필드 초기화를 위한 생성자를 필요로 함
                
                이 경우 `Division.STU.getName()`으로 enum 값을 꺼내와 출력할 수 있음
                
            
    

매개변수 값에 따라 브랜드 반환

```java
public static void main(String[] args) {
        BeanFactory factory = BeanFactory.getInstance();
        TV tv = factory.getBrand("samsung");
        tv.powerOn();
    }
```

클라이언트에게는 티비만 전달되고 브랜드는 노출되지 않음. TV라는 인터페이스를 사용해서 표준화했기 때문에# LG-Inspire-Java
