package lgcns.inspire.inheritance.sub;

import lgcns.inspire.inheritance.PersonDTO;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@SuperBuilder
@Getter
@ToString
public class TeacherDTO extends PersonDTO {
    private String subject;

    // public TeacherDTO(String name, int age, String address, String subject) {
    //     // // super() : 부모의 생성자를 호출
    //     super.setName(name); // super.name과 같이 직접 접근은 불가 -> name은 private으로 선언되었기 때문
    //     super.getAge(age);
    //     super.getAddress(address);

    //     this.subject = subject;
    // }

    public String teacherInfo() {
        return super.perInfo() + ", 과목 : " + this.subject;
    }
}