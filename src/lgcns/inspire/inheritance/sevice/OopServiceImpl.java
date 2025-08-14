package lgcns.inspire.inheritance.sevice;

import java.util.Arrays;

import lgcns.inspire.inheritance.PersonDTO;

public class OopServiceImpl implements OopService {
    private PersonDTO [] arr;
    private int idx;

    @Override
    public void makePerson() {
        
    }

    @Override
    public PersonDTO getFindPerson(String name) {
        // 1. 반복문을 사용하는 방법
        // for (PersonDTO data : arr) {
        //     if (data != null && data.getName().equals(name)) {
        //         return data;
        //     }
        // }
        // return null;

        // 2. 스트림을 사용한 방법
        return Arrays.stream(arr)
                .filter(data -> data != null && data.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public PersonDTO [] getArrPerson() {
        return arr;
    }

    public void setPerson(PersonDTO person) {
        arr[idx++] = person;
    }
}
