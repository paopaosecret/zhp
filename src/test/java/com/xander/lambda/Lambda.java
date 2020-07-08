package com.xander.lambda;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

/**
 * Created by zhaobing04 on 2018/5/8.
 * 1.函数式编程
 * 2.lambda使用
 * 3.方法引用中夹杂Java8内置的四大核心函数式接口
 * Consumer<T>: 消费型接口
 * void accept(T t);
 * <p>
 * Supplier<T>:供给型接口
 * T get();
 * <p>
 * Function<T, R>: 函数型接口
 * R apply(T t);
 * <p>
 * Predicate<T>: 断言型接口:
 * boolean test(T t);
 */
public class Lambda extends Handler {


    public static void main(String args[]) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        new Lambda().test7();
        test8();
    }

    /**
     * 初识Lambda表达式以及
     * 测试命令式编程 和 声明式编程
     */
    public static void test1() {
        //命令式的程序设计，习惯于创建对象或变量，通过一些指令，修改他们状态的值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("--------java 8之前------------------------------");
        for (Integer i : list) {
            ++i;
            System.out.println(i);
        }
        System.out.println(list);

        //声明式的函数式编程
        System.out.println("\n\n--------java 8之后------------------------------");
        list.stream().map((x) -> x = x + 1).forEach(n -> System.out.println(n));

        System.out.println("\n\n");


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("java8 之前的线程方式");
            }
        }).start();

        System.out.println("\n\n");
        new Thread(() -> {
            System.out.println("java8 之后的线程方式");
        }).start();

        Runnable run = () -> System.out.println("定义一个Runnable的Lambda函数");

        //函数式编程关心数据的映射，命令式编程关心解决问题的步骤
    }

    /**
     * 测试静态方法引用:
     * <p>
     * 对应的lambda表达式：(args) -> 类名.staticMethod(args)
     * 假设对一个班的30个{@link Person}排序{@link Comparator}
     */
    private static void test2() {
        //给班级学生初始化
        Random random = new Random();
        Person[] banji = new Person[30];
        for (int i = 0; i < banji.length; i++) {
            Person person = new Person();
            person.age = random.nextInt(30);
            person.name = "name" + i;
            banji[i] = person;
        }
        System.out.println(JSON.toJSONString(banji));
        System.out.println("\n");

        //不使用方法引用
        class PersonComparator implements Comparator<Person> {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.age.compareTo(p2.age);
            }
        }
        Arrays.sort(banji, new PersonComparator());
        System.out.println(JSON.toJSONString(banji));
        System.out.println("\n");

        //使用方法引用，由于Comparator接口为函数式接口，所以可以使用方法引用
        Arrays.sort(banji, Person::compareByAge);  //方法引用指，需要函数式接口实例时，可以传递一个方法的引用，此方法和接口方法需要同返回值和形参，此方法可以当做函数式接口的方法使用
        System.out.println(JSON.toJSONString(banji));
        System.out.println("\n");
    }

    /**
     * 测试实例方法引用
     * <p>
     * 对应的lambda表达式：(args) -> inst.instMethod(args)
     * {@link Supplier}:泛型函数式接口，传递的类型为无参get方法的返回值，
     * person::toString;  //传递方法引用，则supplier对象的get方法实现为person对象的toString方法
     * Supplier:供应商，供应者
     */
    private static void test3() {
        Person person = new Person(42, "段正淳");
        Supplier<String> supplier = person::toString;  //传递方法引用，则supplier对象的get方法实现为person对象的toString方法
        System.out.println(supplier.get());
    }

    /**
     * 对象方法引用测试
     * <p>
     * 对应labbda表达式：(inst,args) -> inst.instMethod(args)
     * <p>
     * {@link BiPredicate}
     * 若Lambda参数列表中的第一个参数是实例方法的参数调用者，而第二个参数是实例方法的参数时，可以使用对象方法引用。
     */
    private static void test4() {
        //test方法第一个参数为String x为实例方法x.equals(y)方法的调用者，第二个参数 String y为实例方法的参数，所以可以使用方法引用
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        BiPredicate<String, String> bp1 = String::equals;
        System.out.println(bp1.test("xx", "xy"));
        System.out.println(bp1.test("xx", "xx"));
    }

    /**
     * 构造方法引用测试
     * <p>
     * lambda表达式：(args) -> new 类名(args)
     */
    private static void test5() {
        //使用无参构造函数
        Supplier<Person> persoonSupplier = Person::new;
        System.out.println(persoonSupplier.get().toString());

        //使用有参构造函数
        PersonCreate personCreate = Person::new;  //该方法引用参数与有参构造方法参数相同
        System.out.println(personCreate.create(22, "石破天").toString());
    }

    /**
     * 数组构造方法引用
     * <p>
     * lambda表达式：(integer) -> new 类名[integer];
     * {@link Function}
     */
    private static void test6() {
        Function<Integer, String[]> fun1 = String[]::new;
        String[] strings = fun1.apply(5); //apply方法为new String[args]; 返回生成的string数组
        System.out.println(strings.length);
    }

    /**
     * 测试超类的实例方法引用
     * <p>
     * lambda表达式：(args) -> super.superMethod(args);
     */
    private void test7() {
        Function<String, Integer> function1 = (str) -> super.handler(str); //lambda方式

        Function<String, Integer> function = super::handler;             //方法引用方式
        System.out.println(function.apply("super handler"));
    }

    /**
     * 基于以上的知识可以看下代码是如何简化的
     *
     * 遍历数组并打印每个值
     */
    public static void test8(){
        int[] array = {1,3,4,2,7,5,9};
        //TODO 第一步：最原始初始方式
        for(int i : array){
            System.out.print(i);
        }

        System.out.println("\n----------分隔符---------------------------------");

        //TODO 第二步：使用Java流
        Arrays.stream(array).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        });

        System.out.println("\n----------分隔符---------------------------------");

        //TODO 貌似代码变多了 继续缩减
        //TODO 第三步：使用Lambda表达式
        Arrays.stream(array).forEach((final int x) ->{
            System.out.print(x);
        });

        System.out.println("\n----------分隔符---------------------------------");

        //TODO Lambda表达式参数格式固定 可省略
        //TODO 第四步：使用Lambda表达式
        Arrays.stream(array).forEach((x) ->{
            System.out.print(x);
        });

        System.out.println("\n----------分隔符---------------------------------");

        //TODO Lambda表达式一句表达式可省略花括号
        //TODO 第五步：使用Lambda表达式
        Arrays.stream(array).forEach((x) -> System.out.print(x));

        System.out.println("\n----------分隔符---------------------------------");

        //TODO 符合方法引用, 继续省略参数声明和传递
        //TODO 第六步：使用方法引用
        Arrays.stream(array).forEach(System.out::print);
    }
}
