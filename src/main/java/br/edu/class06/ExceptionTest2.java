package br.edu.class06;

public class ExceptionTest2 {

    public static void main(String[] args)  {
        try(var reSource = new ReSource()){
            reSource.feedTheCats();
            System.out.println("olá dentro");
        }catch (Exception e){
            System.out.println("Tratou no main");
            System.exit(1);
        }finally {
            System.out.println("Entrou no finally 2");
        }
        System.out.println("olá fora");
    }
}

class ReSource implements AutoCloseable{

    public void feedTheCats(){
        try{
            throw new RuntimeException();
        }catch (NullPointerException e){
            System.out.println(e);
        }finally {
            System.out.println("Entrou no finally");
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("ReSource is closed");
    }
}

class MyException extends RuntimeException{
    public MyException(String message) {
        super(message);
    }
}

class MySubClassException extends MyException{
    public MySubClassException(String message) {
        super(message);
    }
}
