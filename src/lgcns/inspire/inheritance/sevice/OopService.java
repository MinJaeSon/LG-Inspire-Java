package lgcns.inspire.inheritance.sevice;

import lgcns.inspire.inheritance.PersonDTO;

public interface OopService {
    public void makePerson();
    public PersonDTO getFindPerson(String name);
    public PersonDTO [] getArrPerson();
    public void setPerson(PersonDTO person);
}