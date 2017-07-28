package javatutorial.class_and_objects.lamda;

import java.util.function.ToIntBiFunction;

public class LambdaTest {
    public static void main(String args[]){
        LambdaTest tester = new LambdaTest();

        //with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        //with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        //without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        // 使用java自带的interface
        ToIntBiFunction<Integer, Integer> addition2 = (a, b) -> a + b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        System.out.println("10 + 5 = " + tester.operate(10, 5, (a, b) -> a + b));
        System.out.println("10 + 5 = " + tester.operate2(10, 5, (a, b) -> a + b));
        System.out.println("10 + 5 = " + tester.operate2(10, 5, addition2));

        //with parenthesis
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //without parenthesis
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    private int operate2(int a, int b, ToIntBiFunction<Integer, Integer> mathOperation){
        return mathOperation.applyAsInt(a, b);
    }
}
