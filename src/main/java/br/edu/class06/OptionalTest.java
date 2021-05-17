package br.edu.class06;


import java.util.Objects;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Integer att = FakeDatabase.findOne(11)
                .filter(Objects::nonNull) // esse método filtra os elementos nulos, mas não é terminal, ou seja, a execução continua
                .map(Entity::getAttribute) // o método map só mapeia se não for nulo, mas não dispara Exception caso seja.
                //.get() // aqui está o problema, pois o get pode pegar um Optional.Empty resultante da filtragem de nulo e disparar NoSuchElement (o pau que deu na aula)
                .orElse(-1); // essa e as próximas soluções são melhores. Nesse caso, ou pega o valor real ou um valor padrão no caso de estar vazio
                //.orElseGet(() -> -1); // o mesmo aqui, só que nesse caso, pode fazer qualquer outra ação e depois retornar
                //.orElseThrow(() -> new NoSuchElementException("Entity not found!")); // ou você pode explicitamente optar por disparar uma exception (sua ou não).
        System.out.println(att);
    }
}

class FakeDatabase{
    private static Entity singleEntity = new Entity(10);

    public static Optional<Entity> findOne(int id){
        if(singleEntity.getAttribute() == id)
            return Optional.of(singleEntity);
        else
            return Optional.empty();
    }
}

final class Entity{
    private Integer attribute;

    public Entity(Integer attribute) {
        this.attribute = attribute;
    }

    public Integer getAttribute() {
        return attribute;
    }
}
