package lgcns.inspire.function;

@FunctionalInterface // -> 컴파일 시 인터페이스가 추상 메소드를 하나만 가지고 있는지 확인해줌
public interface InspireFunction {
    public int max(int x, int y);
} 
