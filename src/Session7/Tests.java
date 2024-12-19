package Session7;

public class Tests {
    public class Comparison {
        public static void main(String[] args) {
            int[] input = {4, 3, 65, 76, 23, 110};
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < input.length; i++) {
                if (input[i] > max) {
                    max = input[i];
                }
            }

            System.out.println("The maximum value is: " + max);
        }
    }
}
