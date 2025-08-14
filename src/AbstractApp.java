import lgcns.inspire.abstraction.Animal;
import lgcns.inspire.abstraction.Bird;
import lgcns.inspire.abstraction.Superman;
import lgcns.inspire.abstraction.inter.Flyer;

public class AbstractApp {
    public static void main(String[] args) {
        // Animal animal = new Animal(); // ❌ : Cannot instantiate the type Animal (추상 클래스는 인스턴스화 할 수 없음)

        Flyer [] animalArr = new Flyer[2]; // 배열 객체 생성
        animalArr[0] = new Bird(); // 캐스팅 발생 (Animal 타입의 배열에 Bird 객체를 할당)
        animalArr[1] = new Superman(); // 캐스팅 발생 (Animal 타입의 배열에 Superman 객체를 할당)

        for (Flyer element : animalArr) { 
            element.fly();
        }

    }
}
