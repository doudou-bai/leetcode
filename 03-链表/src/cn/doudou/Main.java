package cn.doudou;

public class Main {

    public static void main(String[] args) {
        ArrayList2<Object> list2 = new ArrayList2<>();
        for (int i = 0; i < 50; i++) {
            list2.add(i);
        }
        for (int i = 0; i < 50; i++) {
            list2.remove(0);
        }


    }


}
