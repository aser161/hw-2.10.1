import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

//        Задание 1
        List<Integer> nums = new ArrayList<>();
        nums.add(45);
        nums.add(23);
        nums.add(10);
        nums.add(-25);
        nums.add(1);
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };

        Predicate<Integer> predicate1 = integer -> integer > 0;
        nums.removeIf(predicate);
        System.out.println(nums);

//        Задание 2
        String person1 = "Jack";
        String person2 = "John";
        Consumer <String> greet = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello, " + s + "!");
            }
        };

        Consumer <String> greet1 = s -> System.out.println("Hello, " + s + "!");

        greet.accept(person1);
        greet.accept(person2);

//        Задание 3

        double num1 = 25.255d;
        Function<Double, Long> rounding = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                long numLong = aDouble.longValue();
                return numLong;
            }
        };

        Function<Double, Long> rounding2 = Double::longValue;
        System.out.println(rounding.apply(num1));

        //        Задание 4

        Supplier <Integer> randomNum = new Supplier<Integer>() {
            @Override
            public Integer get() {
                java.util.Random random = new java.util.Random();
                return random.nextInt(100);
            }
        };

        Supplier <Integer> randomNum1 = () -> {
            java.util.Random random = new java.util.Random();
            return random.nextInt(100);
        };

        System.out.println(randomNum.get());

        //        Задание 5

        int i = 8;

        Predicate<Integer> integerPredicate = integer -> integer % 2 == 0;

        Function<Integer, Integer> funTrue = integer -> integer/2;

        Function<Integer, Integer> funFalse = integer -> integer;

        int s = ternaryOperator(integerPredicate,funTrue,funFalse).apply(i);
        System.out.println(s);
    }

    public static String ifTrue (){
        return "true";
    }

    public static String ifFalse (){
        return "false";
    }

    public static <T, U> Function<T,U> ternaryOperator(

            Predicate<T> condition,
            Function<T,U> ifTrue,
            Function<T,U> ifFalse) {

        return t -> (condition.test(t)) ? ifTrue.apply(t) : ifFalse.apply(t);

    }

}