package org.example.Day1;

public class APITest_002_Non_Bdd {
    public void step1(){
        System.out.println("Step1");
    }
    public void step2(){
        System.out.println("Step2");
    }
    public void step3(String name){
        System.out.println("Step3");
    }
    public static void main(String[] args) {
        APITest_002_Non_Bdd test = new APITest_002_Non_Bdd();
        test.step1();
        test.step2();
        test.step3("Mallu");
      //  test.step1().step2().step3();//it's not supported

    }
}
