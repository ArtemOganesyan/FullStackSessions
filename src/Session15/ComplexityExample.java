package Session15;

import java.util.ArrayList;
import java.util.List;

public class ComplexityExample {
    public static void main(String[] args) {
        System.out.println(getFullName("ArtemArtemArtem", "OganesyanArtemArtem"));

        List<String> fname = new ArrayList<>();
        fname.add("Tim");
        fname.add("John");
        fname.add("Pit");

        fname = concat(fname);
        for (String f : fname) {
            System.out.println(f);
        }
    }

    public static String getFullName(String fistName, String lastName) {
        return fistName + lastName;
    }

    public static List<String> concat(List<String> firsName) {
        List<String> concat = new ArrayList<>();
        for (String fname : firsName) {
            concat.add("Sr" + fname);
        }
        return concat;
    }
}
