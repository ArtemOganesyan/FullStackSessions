package Session14;

public class StringExamples {
    public static void main(String[] args) {
        String s = "Portnov Computer School";
        String[] splitted =  s.split("Computer");
        for (String string : splitted) {
            System.out.println(string);
        }
    }
}
