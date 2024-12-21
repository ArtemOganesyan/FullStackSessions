package Session8;

public class StaticExample {

    static class Config {
        public int defatultValue = 100;

//        static {
//            defatultValue = 100;
//        }

        public int getDefatultValue() {
            return defatultValue;
        }
        public void setDefatultValue(int value) {
            defatultValue = value;
        }
    }

    public static void main(String[] args) {
        Config config1 = new Config();
        Config config2 = new Config();
        System.out.println(config1.getDefatultValue());
        config2.setDefatultValue(200);
        System.out.println(config1.getDefatultValue());
    }
}


