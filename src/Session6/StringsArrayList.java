package Session6;

import java.util.ArrayList;

public class StringsArrayList {
    public static void main(String[] args) {
        ArrayList<String> strList  = new ArrayList<>();
        strList.add("Artem");
        strList.add("Vladyslav");
        strList.add("Eugen");
        strList.add("Elena");
        strList.add("Gegam");
        strList.add("Nastia");
        strList.add("Vitalii");

        System.out.println(strList);
        strList.remove(0);
        strList.remove("Gegam");
        System.out.println(strList);

        strList.remove("Anton");

        System.out.println(strList.size());
    }
}
