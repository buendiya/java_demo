package snippet.VariableArgument;

public class Demo {
    static int sum(int i, int... marks) {
        System.out.println("sum variable argument is called");
        int total = i;
        for (int mark : marks) {
            total = total + mark;
        }
        return total;
    }


    static int sum(int i, int mark) {
        System.out.println("normal sum is called");
        return i + mark;
    }

    public static void main(String[] args) {

        //invoking with variable arguments
        System.out.println(sum(1, 2, 3));

        //same invocation using an array
        int arr[] = {2,3};
        System.out.println(sum(1, arr));

        System.out.println(sum(1, 2));
    }
}
