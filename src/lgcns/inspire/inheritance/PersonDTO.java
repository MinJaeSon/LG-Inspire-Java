package lgcns.inspire.inheritance;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder 
@Getter
@ToString
public class PersonDTO {
    // 공통의 요소
    private String name;
    private int age;
    private String address;

    public String getName() {
        return this.name;
    }
    // public int getAge() {
    //     return this.age;
    // }
    // public String getAddress() {
    //     return this.address;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }
    // public void setAge(int age) {
    //     this.age = age;
    // }
    // public void setAddress(String address) {
    //     this.address = address;
    // }

    public String perInfo() {
        return "PersonDTO 이름 : " + this.name + ", 나이 : " + this.age + ", 주소 : " + this.address ;
    }
}