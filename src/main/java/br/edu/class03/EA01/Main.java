package br.edu.class03.EA01;

import br.edu.class03.EA01.Dublador;
import br.edu.class03.EA01.Personagem;

public class Main {

    public static void main(String[] args) {
        //cria um personagem do desenho
        Personagem simpson = new Personagem("Homer Simpson", 45);

        //crio um dublador de personagem
        Dublador dublador = new Dublador("Carlos A. Vasconcellos", 555);

        //agora que há um personagem e um dublador, posso fazer a associação
        setCompositions(simpson, dublador);

        dublador.falar();
        dublador.falar("Ahhhhh!");

        //agora o objeto simpson tem uma referência para o objeto dubl e vice-versa

        //imprime o nome do dublador do objeto simpson: simpson -> dubl -> [atributo] nome
        System.out.println(simpson.nome);
        System.out.println(simpson.getDublador().getPersonagem().nome);

    }

    private static void setCompositions(Personagem simpson, Dublador dublador) {
        simpson.setDublador(dublador);
        dublador.setPersonagem(simpson);
    }
}
