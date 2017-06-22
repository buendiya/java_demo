package demo.other;


public class CallTest {
    int data=50;

    void change(int data){
        data=data+100;//changes will be in the local variable only
    }

    void change(Integer data){
        System.out.println("I am called");
        data=data+100;//changes will be in the local variable only
    }

    public static void main(String args[]){
        for (String arg: args) {
            System.out.println(arg);
        }

        CallTest op=new CallTest();

        System.out.println("before change "+op.data);
        op.change(500);
        System.out.println("after change "+op.data);

        System.out.println("\n");

        Integer data2 = 50;
        System.out.println("before change "+data2);
        op.change(data2);
        System.out.println("after change "+data2);
    }
}
