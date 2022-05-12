package cn.doudou;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);//[11,22,33,44]


        list.add(0, 55);
        list.add(2, 66);
        list.add(list.size(), 77);

        list.remove(0);
        list.remove(2);
        list.remove(list.size() - 1);


        Assert.test(list.indexOf(44) == 3);
        Assert.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Assert.test(list.contains(33));
        Assert.test(list.get(0) == 11);
        Assert.test(list.get(1) == 66);
        Assert.test(list.get(list.size - 1) == 44);
        System.out.println(list);

    }


}
