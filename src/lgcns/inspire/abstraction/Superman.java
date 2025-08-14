package lgcns.inspire.abstraction;

import lgcns.inspire.abstraction.inter.Flyer;

public class Superman extends Animal implements Flyer {

    @Override
    public void fly() {
        System.out.println("Superman is flying");
    }
    
    @Override
    public void takeOff() {
        System.out.println("Superman is taking off");
    }
    
    @Override
    public void landing() {
        System.out.println("Superman is landing");
    }
}
