package cn.doudou.firstRealization;

public class Main {
    public static void main(String[] args) {
        ArrayList<Persion> persions = new ArrayList();
        persions.add(new Persion(12, "Tom"));
        persions.add(new Persion(20, "LiLi"));
        persions.add(1,new Persion(14,"ll"));
        System.out.println(persions);

    }



}
