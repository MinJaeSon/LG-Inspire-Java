public class StringApp {
    public static void main(String[] args) {
        // String str1 = "자바";
        // String str2 = "자바";
        String str1 = new String("자바");
        String str2 = new String("자바");

        if (str1 == str2) {
            System.out.println("str1 == str2");
        } else {
            System.out.println("str1 != str2");
        }

        if (str1.equals(str2)) {
            System.out.println("str1.equals(str2)");
        } else {
            System.out.println("!str1.equals(str2)");
        }
    }
}
