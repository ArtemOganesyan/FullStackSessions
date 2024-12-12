package Session3;

public class SwitchExample {
    public static void main(String[] args) {
        int numberToString = 4;

        switch (numberToString) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            default:
                System.out.println("Number not found");
        }

        String wordToNumber = "Six";
        switch (wordToNumber) {
            case "One":
                System.out.println(1);
                break;
            case "Two":
                System.out.println(2);
                break;
            case "Three":
                System.out.println(3);
                break;
            case "Four":
                System.out.println(4);
                break;
            case "Five":
                System.out.println(5);
                break;
            default:
                System.out.println("Word not found");
        }
    }
}
