import lgcns.inspire.abstraction.inter.TV;
import lgcns.inspire.factory.BeanFactory;

public class TvApp {
    public static void main(String[] args) {
        // SamsungTV samsungTV = new SamsungTV();
        // samsungTV.powerOn();

        // LgTV lgTV = new LgTV();
        // lgTV.powerOn();

        // TV tv = new SamsungTV();
        // tv.powerOn();

        // BeanFactory factory01 = BeanFactory.getInstance();
        // BeanFactory factory02 = BeanFactory.getInstance();

        // System.out.println(factory01 == factory02); // 같은 인스턴스를 참조 -> 몇 개를 만들어도 무관 (싱글톤 패턴)

        BeanFactory factory = BeanFactory.getInstance();
        TV tv = factory.getBrand("samsung");
        tv.powerOn();
    }
}
