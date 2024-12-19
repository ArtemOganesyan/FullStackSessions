package Session7;

public class MethodOverloading {
    public static void main(String[] args) {
        message(2,4);
        Test t = new Test();
        System.out.println(t.toString());
    }

    public static void message(String message) {
        System.out.println(message);
    }

    public static void message(int a, int b) {
        System.out.println(a + b);
    }
}

class Test {
    public String text = "Text";
    public int x = 0;

    @Override
    public String toString() {
        return text + " " + x;
    }
}
