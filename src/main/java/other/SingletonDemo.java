package other;


class ClassicSingleton {
    int i;

    private static ClassicSingleton instance = null;
    private ClassicSingleton() {
        // Exists only to defeat instantiation.
    }

    public void addI() {
        i += 1;
        System.out.println(String.format("now i is %s", i));
    }

    public static ClassicSingleton getInstance() {
        if(instance == null) {
            instance = new ClassicSingleton();
        }
        return instance;
    }
}


public class SingletonDemo {

    public static void main(String[] args) {
        ClassicSingleton singleton = ClassicSingleton.getInstance();
        singleton.addI();
        ClassicSingleton singleton2 = ClassicSingleton.getInstance();
        singleton2.addI();
    }

}

