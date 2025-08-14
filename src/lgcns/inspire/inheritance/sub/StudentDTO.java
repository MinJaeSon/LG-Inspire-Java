package lgcns.inspire.inheritance.sub;

import lgcns.inspire.inheritance.PersonDTO;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@SuperBuilder
@Getter
@ToString
public class StudentDTO extends PersonDTO {
    private String studentId;

    public String studentInfo() {
        return super.perInfo() + ", 학번 : " + this.studentId;
    }
}