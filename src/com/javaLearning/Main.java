package com.javaLearning;

/* author : @sunilGupta  */

import java.util.*;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// concepts about classes and objects
class Box {
                                                              // private means accessible only within the box class
    private int length, breadth, height;                      // instance variable
                                                             // public means accessible outside the box class also
    public void setDimension(int l, int b, int h) {           // instance member function
        length = l; breadth = b; height = h;
    }
    public void showDimension() {                                     // instance member function
        System.out.println("length = " + length);
        System.out.println("breadth = " + breadth);
        System.out.println("height = " + height);
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// concepts about static members

class Example {                      // outer class
    int x;         // instance variable and it will be created as many times as object of this class will be created
    static int y;                           // static member variable and it will be created once for the whole class.
    public void fun1() { }                                          // instance member function
    public static void fun2() { }                                   // static member function
    static class test {                                             // static inner class
        public static String Country = "INDIA";
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// concepts about constructor

class CubeBox {
    private int l, b, h;                   // constuctor name is the same as the name of the class
    public CubeBox() {                      // this is a first constructor
        l = 1; b = 1; h = 1;
    }
    public CubeBox(int L, int B, int H) {    // this is a second constructor but arguments is different in both
        l = L; b = B; h = H;
    }

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// concepts about inheritance

class Person {
    private int age;
    private String name;
    public void setAge(int a) {
        age = a;
    }
    public void setName(String str) {
        name = str;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
}

class Student extends Person {
    private int rollno;
    public void setRollno(int r) {
        rollno = r;
    }
    public int getRollno() {
        return rollno;
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// concepts about instance initialization block

class Test {
    private int x;

    {
        System.out.println("value of x = " + x);                       // instance initialization block
        x = 5;
    }
    public Test() {                                                   // constructor
        System.out.println("value of x = " + x);
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// concepts about overloading

class A {
    public void f1(int x) {
        System.out.println("class A");
    }
}

class B extends A {
    public void f1(int x, int y) {
        System.out.println("class B");
    }
}

// function f1 is same in both child class and parent class but parameter is different.thus it is overloading.
// both f1 function can be in child class as well as in parent class.then also it will be termed as overloading.

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// concepts about overriding

class C {
    public void f(int x) {
        System.out.println("class C");
    }
}

class D extends C {
    @Override // this will give you compile time error if overriding is not done, but you wanted to override it
    public void f(int x) {
        System.out.println("class D");
    }
}

// signature of both function must be identical except implementation(content written inside the blocks) of functions.
// both function can't be in parent class and child class.one in child class and other one should be in parent class.
// function written in child class overrides the function written in  parent class.

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// concepts about final keyword

           //final instance variable && static final varialble && final local variable//

// final variable can be assigned only once and further cannot be changed.
class Example1 {
    //private final int x = 4;                          //it can be initailised this way also
     //private static final int y = 4;                 // static final variable can be initialised this way
     private static final int y;
     static
    {
        y = 5;              // static final variable can be initialised using static initialisation blocks.
    }
      /* private final int x;
                  {
                      x = 7;                     // can be initaialised using instance initialisation block also
                  }

       */
       private final int x;                      // can be initaialised using constructors also
       public Example1() {
           x = 17;
       }

       public void fun() {
           final int k;                        // final local variable as it is inside the method
       }
}
/*
               // final class//
  variable made as final are constants and cannot be changed later.

final class Dummy {
    // creating final class means we cannot make subclasses using this class i.e inheritance is restricted
}

              // final methods//
class A {
     public final void fun(int x) {            // method made as final.
     }
}
                              methods declared as final cannot be overriden.
class B extends A {
     public void fun(int x) {     // here it will throw an error as we are trying to override the methods made final
     }
}
 */

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// concepts about this keyword

class Box1 {
    private int l,b,h;
    public void setDimension(int l, int b, int h) {  // this keyword refers to the calling object
        this.l = l; this.b = b; this.h = h;          // this.l -> instance variable l ,  l -> local variable l
    }                                                // this resolves the name collision
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// concepts about super keyword

class A1 {
    int z;
    public void f1() {

    }
}

class B1 extends A1 {
    int z;
    public void f1() {
        super.f1();
        // incase of overriding if we want to make calls to super class member function ,use super keyword
        // otherwise it will be an recursive call.
    }

    public void f2() {
        int z;
        //x = 1; y = 2; z = 3; if names are different then it is esaily accessible
        z = 4;   // local varible gets the value
        this.z = 5;  // instance variable of same child class i.e. B1 gets the value.
        super.z = 6;   // instance variable of super class i.e. A1 gets the value.
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Stud {
    String name;
    int id;
    public void get(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void display() {
        System.out.println(name + "  " + id);
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                 /* concepts about varargs i.e variable arguments  */
class calc {
    public int add(int ... n) {
        int sum = 0;
        for(var i : n) sum += i;
        return sum;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               /* concepts about Encapsulation */
// binding the data with methods -> encapsulation
// means our variables should be private and we need to access the variables through methods(i.e. getters and setters)
// this is done to  avoid access of data to  unauthorised person i.e. for security purpose
class office {
    private int salary;
    private String name;
    // setters -> which  sets the value , getters -> which fetch the value
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getNmae() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            /*  concepts about wrapper class */
class demoWrapperClass {
    int x = 4;  // primitive data type
    Integer  y =  new Integer(x);  // assigning primitive data type variable to object -> boxing or wrapping
    int z = y.intValue();  // unboxing or unwrapping
    int xx =  y;           //  auto unboxing or auto unwrapping
    Integer  yy = x;       // auto boxing or auto wrapping

    // this wrapping class is used when things dont work with primitive data type, everything must be in classes and objects
    String str = "1234";
    int num = Integer.parseInt(str);  // converts string to integer.
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                /* Abstract keyword  */
abstract class human {   // we cant create object of humans i.e abstract class
    // note : it is not necessary to make methods as abstract if class is abstract
    // but if methods is abstract then it is compulsory to make class as abstract
    public abstract void eat();
    public abstract void walk();
}

class man extends human {
    public void eat() {
        // implementations
    }
    public void walk() {
        // implementations
    }
}

class demoabstract {
    /*public void print(Integer a) {
        System.out.println(a);      // it will print the int val
    }

    public void print(Double a) {
        System.out.println(a);     // it will print the double val
    }*/

    public void print(Number a) {
        System.out.println(a);     // it will print number of any types
    }
}

abstract class writer {
    public abstract void write();
}

class pen extends writer {
    public void write() {
        System.out.println("i am a pen");
    }
}

class pencil extends writer {
    public void write() {
        System.out.println("i am a pencil");
    }
}

class kit {
    public void doSomething(writer p) {
        p.write();
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                  /* concepts about interface */
// interface allows to inherit multiple classes
interface species {
    //public abstract void write();  // by default ,the methods inside the interface are abstract methods
    // unlike in abstract class here we can't implement a method body.
    void emotions();
}

class dummy {
    //
}

class humanBeings extends dummy implements species {   // multiple inheritance is being done through interface
    public void emotions () {
        System.out.println("humans do have emotions and they are capable of expressing");
    }
}

class animals implements species {
    public void emotions () {
        System.out.println("animals do have emotions but they are not capable of expressing which we can interpret");
    }
}

class  biotic {
    public void doSomething(species p) {
        p.emotions();
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            /* concepts about anonymous class,  anonymous class ith interface  */
class abc {
    public void show() {
        System.out.println("in abc show");
    }
}

interface demoInterfaceAnonymousClass {
    public void show();
}
// in order to override we need to create a  class implementor  but we can achieve this by creating an anonymous class
// in main method. check the main method to see how?
class implementor implements demoInterfaceAnonymousClass {
    public void show() {
        System.out.println("overriding abc show's");
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                     /* default methods in interface */
interface demoDeafaultMethod {  // since it has only one abstract method so it is a functional interface.
    void abc();
    default void show() {
        System.out.println("yes interface can have methods definition in it using default method");
    }
}

class demoImpl implements demoDeafaultMethod {
    public void abc() {
        //
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                         /* Multi threading */
// in java there is always one thread i.e main thread
// Thread -> unit of a process
/*
class Hi extends Thread {
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("Hi");
            try { Thread.sleep(1000);} catch(Exception e) { }  // threads will stope for 1000 milisec i.e. it will be paused
        }
    }
}

class Hello extends Thread {
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("Hello");
            try { Thread.sleep(1000);} catch(Exception e) { }

        }
    }
}
 */
// multithraed by interface -> here we can multiple inheritance also
// Runnable is a functional interface
class Hi implements Runnable {
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("Hi");
            try { Thread.sleep(1000);} catch(Exception e) { }  // threads will stope for 1000 milisec i.e. it will be paused
        }
    }
}

class sun {
    //
}

class Hello extends sun implements Runnable {  // multiple inheritance
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("Hello");
            try { Thread.sleep(1000);} catch(Exception e) { }

        }
    }
}




public class Main {

    public static void main(String[] args) throws Exception {
        Box b1 = new Box();                                         // b1 is an object of class Box
        b1.setDimension(12,10,3);
        b1.showDimension();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        Example ex1 = new Example();// here we have created object two times of class Example. so two times 'x' instance variable is also created but static member variable 'y' doesnot depends on the objects .so it will be created only once for the whole class
        Example ex2 = new Example();
        Example.y = 10;                   // syntax for assigning value in static member variable
        Example.fun2();                   // accessing static function using class name and dot operator
        // static function cannot access instance member variable ,it can only access static members.
        /*
           public void add() {  static int a,b;  }     //static variable is not allowed inside methods
        */
        System.out.println("country = " + Example.test.Country);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        CubeBox cb1 = new CubeBox();
        CubeBox cb2 = new CubeBox(4,4,4);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        Student s1 = new Student();
        s1.setName("sunil kumar gupta");
        s1.setAge(21);
        s1.setRollno(1911011);
        System.out.println("name = " + s1.getName());
        System.out.println("age = " + s1.getAge());
        System.out.println("rollno = " + s1.getRollno());
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        Test t1 = new Test();
        Test t2 = new Test();
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        B obj1 = new B();
        obj1.f1(10);
        obj1.f1(12,19);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        D obj2 = new D();
        obj2.f(13);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        Box1 B1 = new Box1();
        B1.setDimension(12,16,6);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        B1 obj3 = new B1();
        obj3.f1();
        obj3.f2();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*Stud s[] = new Stud[4];
        System.out.println("enter the name of students and their id");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 4; i++) {
            String name = sc.next();
            int id = sc.nextInt();
            s[i] = new Stud();
            s[i].get(name, id);
        }
        for(int i = 0; i < 4; i++) {
            s[i].display();
        }
        int arr[] = {1,2,3,4,5};
        for(var e : arr) System.out.println(e); */
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        calc c1 = new calc();
        System.out.println(c1.add(1,2,3,4,5,6,7));
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
                               /* dynamic method dispatch  */
        C obj = new D();  //object of d is created with reference of c ,it is linked during the runtime
        obj.f(1);      // it will show the methods which are in c class only as the obj having reference of c
        obj = new C();
        obj.f(2);   // everytime it  is calling diff method with same obj , termed as dynamic method dispatch.
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
              /*  Encapsulation */
        office e1 = new office();
        e1.setName("Bikash Singh");
        e1.setSalary(45000);
        System.out.println(e1.getNmae());
        System.out.println(e1.getSalary());
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
           /* abstract keyword */
        demoabstract num = new demoabstract();
        num.print(8.88f);
        // some more examples
        kit k = new kit();
        writer p = new pen();
        writer pc = new pencil();
        k.doSomething(p);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                               /* interface */
        biotic bi = new biotic();
        species hb = new humanBeings();
        species an = new animals();
        bi.doSomething(an);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Anonymous class
        abc ob1 = new abc();
        ob1.show();   // this will print the implementation of show method of abc but if we  want something else to print
        // then we need to create annother class and override the existing method. to avoid this , we can simply create an
        //anonymous class and implement the method there only .
        abc ob2 = new abc()    // anonymous class with no class name
        {
            public void show()  {
                System.out.println("I AM THE BEST");
            }
        };
        ob2.show();
        // Anonymous class with interface
        demoInterfaceAnonymousClass d1 = new implementor();
        d1.show();
        demoInterfaceAnonymousClass d2 = new demoInterfaceAnonymousClass()
        { // but this definition cannot be reused later unlike doing overriding by making class
            public void show() {
                System.out.println("overriding abc show's using anonymous class");
            }
        };
        d2.show();
        //--> note : we can create object of interface using anonymous class

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /* Types of interface
        1. normal interface -> interface wich can have more than one method inside it.
        ** 2. (single abstract method interface) or (functional interface)-> interface which can have only one abstract
               method inside it.
        3. marker interface -> interface which do not have any method inside it.
        ** if we know (functional interface) -> we can use lambda expression
         */
        // LAMBDA EXPRESSION -> can only be used with functional interface
        demoInterfaceAnonymousClass d3 = () -> {
            System.out.println("overriding abc class show's using lambda exp.");
        };
        d3.show();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                     /* default methods in interface */
        // --> note : we can define methods inside interface using default method
        demoDeafaultMethod d4 = new demoImpl();
        d4.show();
        // if we create variables inside interface, it will become final variable i.e constants
        // if we create static methods inside interface, it cannot be overriden
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                      /*  access modifiers */
        /* 1. private : specific class
           2. default : specific package
           3. public : any class or package
           4. protected : subsiding class

         */
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
            /* try ,catch and finally block  */
        try {  // we write all the critical statements having probability of throwing error inside the try block
            // if there is error then below lines will not execute and it directly jumps to catch block
            int a[] = new int[5];
            a[5] = 12;  // index out of bound exception
            int b[] = null;
            b[4] = 23;     // null pointer exception
            int i = 12;
            int j = 0;
            int k1 = i/j; // arithmetic exception
            System.out.println("output is " + k);
            System.out.println("bye !");
        }
        /* catch(ArithmeticException e) { // catch block will catch all the errors written in try block and our program will run till end
            System.out.println("cannot divide by zero!");
            // statemennts inside the catch block gets executed only if error occurs in try block
        }

        // multiple catch blocks
        catch (IndexOutOfBoundsException e) {
            System.out.println("out of bounds");
        }

        catch (NullPointerException e) {
            System.out.println("you are assigning to a null value");
        }

        catch(Exception e) {  // Exception can handle all types of exception
            System.out.println("something wrong !!");
        }
        // instead of writing different catch block for different exception , we can write in same catch block
        */
        catch (ArithmeticException | NullPointerException | IndexOutOfBoundsException e) {
            System.out.println("ERROR");
        }
        catch (Exception e) {
            System.out.println("something wrong !!");
        }

        finally {  // it wwill print the statement no matter error has occured  or not
            System.out.println("ok we have completed the task!");
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                   /* Multi threading  by extending class */
        /* Hi h1 = new Hi();
        Hello h2 = new Hello();
        //h1.show();   here firstly the main thread executing the hi class and after it finishes, executes the hello class
        //h2.show();
        // in case of multithreading, we can give separate threads to both the class so that they can get executed
        // simultaneously
        h1.start();
        try{Thread.sleep(10); } catch(Exception e) { }
        h2.start();
         */
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                       /* Multi threading  by interface */
        Runnable h1 = new Hi();     // Runnable is a functional interface
        Runnable h2 = new Hello();
        Thread tr1 = new Thread(h1);
        Thread tr2 = new Thread(h2);
        tr1.start();
        try { Thread.sleep(10);} catch(Exception e) {}
        tr2.start();
        //System.out.println("ok bye bye!!");         this line is executed by main thread
        tr1.join();
        tr2.join();
        // tr1 and tr2 thread joins with main thread after executing thier stuff and then main thread executes
        System.out.println("ok bye bye !!");

        //// we can do the above stuff using lamda expression also since Runnable is a functional interface

        Thread tr3 = new Thread(() -> {
                for(int i = 0; i < 2; i++) {
                    System.out.println("hi again!");
                    try{Thread.sleep(1000);} catch(Exception e) {}
                }
        });

        Thread tr4 = new Thread(()-> {
            for(int i = 0; i < 2; i++) {
                System.out.println("Hello again!");
                try{Thread.sleep(1000);} catch(Exception e) {}
            }
        });

        tr3.start();
        Thread.sleep(10);
        tr4.start();

        tr3.join();
        tr4.join();
        System.out.println("bye again!");
        // is alive to check whether the thread is finished or in running state
        System.out.println(tr3.isAlive());
        
    }

}
