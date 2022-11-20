package cn.doudou;

/**
 * Create By 王嘉浩
 * Time 2022-11-13 13:39
 */
public class Person implements Comparable<Person> {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Person e) {
        return age - e.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
