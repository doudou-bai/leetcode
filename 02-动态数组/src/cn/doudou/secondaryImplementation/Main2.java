package cn.doudou.secondaryImplementation;

public class Main2 {
    public static void main(String[] args) {
        ArrayList2<Persion> list2 = new ArrayList2<Persion>();
        list2.add(new Persion(1,"1111"));
        list2.add(new Persion(2,"2222"));
        list2.add(new Persion(2,"2222"));
        list2.add(new Persion(2,"2222"));
        list2.add(new Persion(2,"2222"));
        list2.add(new Persion(2,"2222"));
        list2.add(new Persion(2,"2222"));
        list2.add(new Persion(3,"3333"));
        System.out.println(list2.toString());
    }
}
