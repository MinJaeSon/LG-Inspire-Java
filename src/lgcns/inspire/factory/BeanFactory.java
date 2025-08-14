package lgcns.inspire.factory;

import lgcns.inspire.abstraction.LgTV;
import lgcns.inspire.abstraction.SamsungTV;
import lgcns.inspire.abstraction.inter.TV;

public class BeanFactory {
    private static BeanFactory instance = null; // static으로 선언
    private TV [] arr; // 참조 타입의 변수 선언

    private BeanFactory() { // 생성자를 private으로 선언 -> 외부에서 생성자를 호출할 수 없음
        arr = new TV[2]; // 배열 객체 먼저 생성
        // 배열 객체에 객체 할당
        arr[0] = new SamsungTV(); 
        arr[1] = new LgTV();
    }

    public static BeanFactory getInstance() { // 싱글톤 패턴 적용할 수 있도록 public static 메서드로 선언
        if (instance == null) {
            instance = new BeanFactory();
        }
        return instance;
    }
    
    public TV getBrand(String brand) {
        return brand.equals("samsung") ? arr[0] : arr[1]; // 문자열 비교 시에는 equals 메서드 사용
    }
}
