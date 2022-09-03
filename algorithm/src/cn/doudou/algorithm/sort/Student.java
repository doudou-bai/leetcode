package cn.doudou.algorithm.sort;

/**
 * Create By 王嘉浩
 * Time 2022-09-03 15:51
 */

public class Student implements Comparable<Student> {
    private String userName;
    private int age;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student s) {
        return this.getAge() - s.getAge();
    }
}
