package com.example.testmq.test;

public class Test {
    public static void main(String[] args) {
//        Test2 t=() -> {
//            System.out.println("wow");
//        };
//        t.eat();
//
//
//        Test2 t1=new Test2() {
//            @Override
//            public void eat() {
//
//            }
//        }
//    }

        Test3 function=(int num ) -> {
            int a=num+10;
            System.out.println(a);
        return  a;};

        function.apply(100);

        test((num)-> num);

    }

   static void test(Test3 t3){
    System.out.println("t33333333");
}


}
