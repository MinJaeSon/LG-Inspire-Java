package lgcns.inspire.abstraction;

import lgcns.inspire.abstraction.inter.TV;

public class LgTV implements TV {

    @Override
    public void powerOn() {
        System.out.println("LgTV is turning on");
    }

   
}