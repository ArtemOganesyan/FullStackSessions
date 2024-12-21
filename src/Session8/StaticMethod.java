package Session8;

public class StaticMethod {
    static class MathUtil {
        public static int calcSquare(int number) {
            return number * number;
        }
    }

    public static void main(String[] args) {
        System.out.println(MathUtil.calcSquare(100));
    }
}
