package javatutorial.generics.type_erasure;

/**
 * Created by jingsz on 4/18/17.
 */

public class EffectsOfTypeErasureAndBridgeMethods {
    class Node<T> {

        public T data;

        public Node(T data) { this.data = data; }

        public T getData() {
            return this.data;
        }

        public void setData(T data) {
            System.out.println("Node.setData");
            this.data = data;
        }
    }

    class MyNode extends Node<Integer> {
        public MyNode(Integer data) { super(data); }

        public void setData(Integer data) {
            System.out.println("MyNode.setData");
            super.setData(data);
        }
    }

    // 观察 n.setData(5) 和 n.getData() 的调用栈可知:
    // 是先调用到compiler 生成的 bridge method, 再调用到MyNode 的 setData
    void test1() {
        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
        n.setData(5);
        n.getData();
        Integer x = mn.data;
    }

    // 和tutorial 文档里说的不一致，ClassCastException 是在 n.setData("Hello") 里触发的
    // 是在调用 bridge method 时触发的
    void test2() {
        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
        n.setData("Hello");     // Causes a ClassCastException to be thrown.
        Integer x = mn.data;
    }

    public static void main(String[] args) {
        EffectsOfTypeErasureAndBridgeMethods test = new EffectsOfTypeErasureAndBridgeMethods();
        test.test1();
        // test.test2();
    }
}
