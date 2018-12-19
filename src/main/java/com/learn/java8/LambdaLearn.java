package com.learn.java8;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaLearn {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("程序旺旺", 18, "男", 10, 1.0));
        list.add(new Student("小芳", 18, "女", 1000, 1.2));
        list.add(new Student("小红", 16, "女", 20, 1.3));
        list.add(new Student("小雅", 16, "女", 19000, 1.5));

        Map<String, Student> studentMap = new HashMap<String, Student>();
        studentMap.put("001", new Student("程序旺旺", 18, "男", 10, 1.0));
        studentMap.put("002", new Student("小芳", 18, "女", 1000, 1.2));

        //取集合的某个字段集合
        List<String> d = list.stream().map(s -> s.getName()).collect(Collectors.toList());
        System.out.println("sss");

        //过滤集合
        List<Student> fil = list.stream().filter(f -> "女".equals(f.getSex())).map(s -> s).collect(Collectors.toList());
        System.out.println("ddd");

        //过滤返回复杂自定义类型
        List<Map> filMuti = list.stream().filter(f -> f.getMoney() > 500).map(s -> {
            Map map = new HashMap();
            map.put(s.getName(), s);
            return map;
        }).collect(Collectors.toList());
        System.out.println("aaa");

        //map转list
        List<Student> convert = studentMap.entrySet().stream().map(e ->{
            Student student = e.getValue();
            student.setName(e.getKey());
            return student;
        }).collect(Collectors.toList());
        System.out.println(convert);

        //集合遍历查找(findAny(全部中的取一个) findFirst(找到第一个就返回))
       Optional<Student> result =  list.stream().filter(f->f.getLegLength()>1.2&&"女".equals(f.getSex())).findFirst();
       Optional<Student> result1 =  list.stream().filter(f->f.getLegLength()>1.2&&"女".equals(f.getSex())).findAny();
        System.out.println(result);
        System.out.println(result1);
    }
}

class Student {
    String name;//姓名
    int age;//年龄
    String sex;//性别
    int money;//存款
    double legLength;//大长腿

    public Student() {
    }

    public Student(String name, int age, String sex, int money, double legLength) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.money = money;
        this.legLength = legLength;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Student setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public int getMoney() {
        return money;
    }

    public Student setMoney(int money) {
        this.money = money;
        return this;
    }

    public double getLegLength() {
        return legLength;
    }

    public Student setLegLength(double legLength) {
        this.legLength = legLength;
        return this;
    }
}