package lgcns.inspire.abstraction;

import lgcns.inspire.abstraction.inter.Flyer;

public class Bird extends Animal implements Flyer {

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }

    @Override
    public void takeOff() {
        System.out.println("Bird is taking off");
    }

    @Override
    public void landing() {
        System.out.println("Bird is landing");
    }
    
}
