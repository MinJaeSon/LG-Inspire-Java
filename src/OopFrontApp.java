import lgcns.inspire.inheritance.PersonDTO;
import lgcns.inspire.inheritance.sevice.OopService;
import lgcns.inspire.inheritance.sevice.OopServiceImpl;

public class OopFrontApp {
    public static void main(String[] args) {
        OopService service = new OopServiceImpl();
        service.makePerson();

        PersonDTO [] arr = service.getArrPerson();
        for (PersonDTO data : arr) {
            if (data == null) {
                break;
            }
            System.out.println(data.personInfo());
        }

        PersonDTO findObj = service.findPerson("홍길동");
        if (findObj == null) {
            System.out.println("찾는 사람이 없습니다.");
        } else {
            System.out.println(findObj.personInfo());
        }
    }
}
