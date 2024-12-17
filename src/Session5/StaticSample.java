package Session5;

public class StaticSample {
    public static void main(String[] args) {
//        String result = oddOrEven(12);
//        System.out.println(result);

        int[] valArray = {12,33,21,56,1,6,7};


// write a method that accept array of integers as an input and then for every int prints "odd" or "even"



        for (int i = 0; i < valArray.length; i++) {
            if (valArray[i] % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }
    }

    public static String oddOrEven(int inputNumber) {
        if (inputNumber % 2 == 0) {
            System.out.println("Result: " + inputNumber % 2);
            return "Even";
        } else {
            System.out.println("Result: " + inputNumber % 2);
            return "Odd";
        }
    }
}
