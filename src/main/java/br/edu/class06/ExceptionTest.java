package br.edu.class06;

import java.util.InputMismatchException;

public class ExceptionTest{
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();

        try {
            //...
            exceptionTest.doSomething();
            //...

            System.out.println("No way!");
        } catch (InputMismatchException e) {
            System.err.println("Ouch Mismatch!");
        } catch (Exception e) {
            System.err.println("Ouch General!");
        }
        //...
        System.out.println("Nahh!");
    }

    public void doSomething() {
        throw new NullPointerException("Aeeee!");
    }

}


