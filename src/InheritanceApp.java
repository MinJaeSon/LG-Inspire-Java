import lgcns.inspire.inheritance.PersonDTO;
import lgcns.inspire.inheritance.sub.TeacherDTO;
import lgcns.inspire.inheritance.sub.StudentDTO;

public class InheritanceApp {
    public static void main(String[] args) {
    //    // 강사 객체 생성
    //     PersonDTO teacher = PersonDTO.builder()
    //         .name("홍길동")
    //         .age(20)
    //         .address("서울")
    //         .subject("Java")
    //         .build();
    //         // 각 필드의 값을 할당하여 객체를 변경하지 말라는 의미를 담은 생성 패턴
    //     System.out.println(teacher);

    //    // 학생 객체 생성
    //    PersonDTO student = PersonDTO.builder()
    //         .name("이순신")
    //         .age(20)
    //         .address("서울")
    //         .studentId("2025123456")
    //         .build();
    //     System.out.println(student);

    //    // 기존 객체 생성 방식
    // TeacherDTO teacher = new TeacherDTO("홍길동", 20, "서울", "Java"); 
    // 빌더를 사용한 객체 생성 패턴
        TeacherDTO teacher = TeacherDTO.builder()
            .name("홍길동")
            .age(20)
            .address("서울")
            .subject("Java")
            .build();

        // StudentDTO student = new StudentDTO("이순신", 20, "서울", "2025123456");
        StudentDTO student = StudentDTO.builder()
            .name("이순신")
            .age(20)
            .address("서울")
            .studentId("2025123456")
            .build();

        // TeacherDTO [] teacherArr = new TeacherDTO[10];
        // teacherArr[0] = teacher;
        // // teacherArr[1] = student; // ❌ : 배열은 단일 타입만 담을 수 있음
        // // 이렇게 따로 student 배열 객체를 생성하여 담아야 함
        // StudentDTO [] studentArr = new StudentDTO[10];
        // studentArr[0] = student;
        //

        PersonDTO teacher = new TeacherDTO("홍길동", 20, "서울", "Java");
        PersonDTO student = new StudentDTO("이순신", 20, "서울", "2025123456");
        PersonDTO [] personArr = new PersonDTO[10]; // 배열을 생성하면서 배열의 요소를 Person 타입으로 지정한 것
        personArr[0] = teacher;
        personArr[1] = student;

        for (int idx = 0 ; idx < personArr.length ; idx++) {
            PersonDTO person = personArr[idx] ;
            if(person == null) { // 참조 타입의 경우 null 체크 필요
                break;
            } else if( person instanceof StudentDTO) {
                System.out.println(((StudentDTO)person).studentInfo() );
            } else if( person instanceof TeacherDTO) {
                System.out.println(((TeacherDTO)person).teacherInfo() );
            }
        }
    }
}