package org.example.Day1;

class APITest_003_Bdd {
    public APITest_003_Bdd step1(){
        System.out.println("step1");
        return this;
    }
    public APITest_003_Bdd step2(){
        System.out.println("step2");
        return this;
    }
    public APITest_003_Bdd step3(String name){
        System.out.println("step3 "+name);
        return this;
    }

    public static void main(String[] args) {
        APITest_003_Bdd test = new APITest_003_Bdd();
        test.step1().step2().step3("Mallu");

    }
}
