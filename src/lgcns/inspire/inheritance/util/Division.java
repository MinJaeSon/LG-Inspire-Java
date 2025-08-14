package lgcns.inspire.inheritance.util;

public enum Division {
    // STU, TEA; // 상수의 집합

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
