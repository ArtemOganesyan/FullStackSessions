package Session5;

public class ReverseArray {
    public static void main(String[] args) {
        int[] num = {10,20,30,40,50};

        int reversed[] = new int[num.length];

        for (int i = 0; i < num.length; i++) {
            reversed[i] = num[num.length - 1 - i];
        }

        for (int i = 0; i < reversed.length; i++) {
            System.out.println(reversed[i]);
        }
    }
}
