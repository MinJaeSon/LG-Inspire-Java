import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import lgcns.inspire.function.InspireFunction;

/**
 * Collection - Java Stream과 연계해서 사용 (코드의 가독성, 병렬 처리, 유지보수 향상)
 * Stream - Java 8 이후 추가됨 (컬렉션 데이터를 처리하는 표준 방법)
 * 
 * Stream API란? 
 * - 원본 데이터의 소스를 변경하지 않고 데이터를 처리하는 방법
 * - 일회용 (한 번 사용하면 재사용 x)
 * - 병렬 처리(thread)로 실행 속도가 빠르다
 * - 작업을 내부 반복으로 처리 (람다식 사용 필요)
 * 
 * 함수형 인터페이스
 * - stream에서 메소드들이 함수형 인터페이스를 사용하여 람다식으로 처리
 * - 가질 수 있는 메소드가 하나
 * - Supplier : 매개변수 없이 반환값만 가지고 있는 것
 *   Function : 매개변수를 받아서 반환값이 있는 것
 *   Consumer : 매개변수를 받아서 반환값이 없는 것
 *   Predicate : 매개변수를 받아서 반환값이 boolean인 것
 *   이런 애들을 메소드가 인자로 받음
 * 
 * 람다식
 * - 하나의 메소드를 식으로 표현하는 것
 * - 메소드 이름이 없이 익명 형태를 가짐
 */
public class StreamApp {
    public static void main(String[] args) {
        InspireFunction lambdaFunc = (x, y) -> x > y ? x : y;
        System.out.println(lambdaFunc.max(100, 200));

        InspireFunction lambdaSumFunc = (x, y) -> x + y;
        System.out.println(lambdaSumFunc.max(100, 200));

        // Supplier
        Supplier<String> supplier = () -> "Hello, World!";
        System.out.println(supplier.get());

        // Consumer
        Consumer<String> consumer = (str) -> System.out.println(str.split(" ")[1]); // 반환값이 없으므로 출력만 실행하도록
        consumer.andThen(System.out::println) // 매
            .accept("Hello, World!");
            // World! 출력
            // Hello, World! 출력

        // Function
        Function<String, Integer> function = (str) -> str.length();
        int len = function.apply("Hello, World!");
        System.out.println(len);

        // Predicate
        Predicate<String> predicate = (str) -> str.equals("Hello, World!");
        boolean result = predicate.test("Hello World");
        System.out.print(result);

        List<String> brands = Arrays.asList("Samsung", "LG");
        brands.stream()
            .forEach(System.out::println);

        /*
         * Optional
         * - 어떤 메소드가 null을 반환할 수 있거나
         * - null 처리를 놓쳐서 발생하는 에외를 방지하기 위해 사용
         * 주의사항 : 메소드 반환타입으로 사용, 메소드 체이닝 사용 불가
         */
        Optional<String> op1 = Optional.of("Hello, World!");
        if (op1.isPresent()) {
            System.out.println(op1.get());
        }

        Optional<PostResponseDTO> op2 = Optional.empty();
        System.out.println(op2.get().getTitle());
    }
}
