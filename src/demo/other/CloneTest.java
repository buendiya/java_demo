package demo.other;


class CloneTest implements Cloneable{
    int rollno;
    String name;

    CloneTest(int rollno, String name){
        this.rollno=rollno;
        this.name=name;
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String args[]){
        try{
            CloneTest s1=new CloneTest(101,"amit");

            CloneTest s2=(CloneTest)s1.clone();

            System.out.println(s1.rollno+" "+s1.name);
            System.out.println(s2.rollno+" "+s2.name);

        }catch(CloneNotSupportedException c){}

    }
}  
