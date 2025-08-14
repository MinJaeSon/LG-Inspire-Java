package lgcns.inspire.exception;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 예외처리
 * - 컴파일 시점의 예외 (IOException을 상속받는 예외들)
 * - 런타임 시점의 예외 (RuntimeException을 상속받는 예외들)
 * 
 * try {
 *     // 예외가 발생할 수 있는 코드
 * } catch (Exception e) { // 발생된 예외 객체 정의
 *     // 예외가 발생했을 때 실행할 코드
 * } finally {
 *     // 예외 발생 여부와 상관없이 실행할 코드
 * }
 * 
 */
public class ExceptionDemo {
    public void printArr(String [] arr) {
        System.out.println(">>>> arr print start");

        try {
            for (int i = 0; i <= arr.length; i++) {
                System.out.println(arr[i]); // 배열 인덱스 초과 예외 발생
            }
            System.out.println(">>>> inner try");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(); // 백트래킹을 통해 예외 발생 원인 출력
        }
        
        System.out.println(">>>> arr print end"); // 예외 발생 후 실행되지 않음
    }

    public String readConsole() throws IOException {
        // 컨파일 예외는 예외가 터지지 앟으니까 컴파일 시점에 미리
        InpuStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("input : ");
        // try {
        //     data = br.readLine();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // } 
        // return data;
        String data = br.readLine();
        return data;
    }
}
