package Session4;

import java.util.Scanner;

public class DiamondPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height of the diamond: ");
        int heightDiamond = scanner.nextInt();

        int i, j, space = 1;
        space = heightDiamond - 1;
        for (j = 1; j <= heightDiamond; j++) {
            for (i = 1; i <= space; i++) {
                System.out.print(" ");
            }
            space--;
            for (i = 1; i <= 2 * j - 1; i++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        space = 1;
        for (j = 1; j <= heightDiamond - 1; j++) {
            for (i = 1; i <= space; i++) {
                System.out.print(" ");
            }
            space++;
            for (i = 1; i <= 2 * (heightDiamond - j) - 1; i++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
