package br.edu.class04;

public class Principal {

    private UserAccount[] users = new UserAccount[10];

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.createUserSamples();
        principal.linkUsersAndFollowers();
        principal.createPostSamples();
        principal.clapAndBooPosts();
        principal.printResult();
    }

    private void createUserSamples() {
        users[0] = new UserAccount("renata@ifsp.edu.br", "Renata");
        users[1] = new UserAccount("alexandre@ifsp.edu.br", "Alexandre");
        users[2] = new UserAccount("valente@ifsp.edu.br", "Julia, a Valente");
    }

    private void linkUsersAndFollowers() {
        users[0].acceptFollower(users[1]); // julia segue renata
        users[0].acceptFollower(users[2]); // alexandre segue renata
        users[1].acceptFollower(users[2]); // julia segue alexandre
        users[2].acceptFollower(users[0]); // renata segue julia
    }

    private void createPostSamples() {
        users[2].publish("Faca acontecer");
        users[0].publish("Tem louca para lavar");
        users[0].publish("Tem lista de exercício para entregar");
        users[1].publish("O sucesso é o pai do fracasso");

        for (int i = 0; i < 8; i++) {
             users[1].publish("Teste " + (i+1));
        }
    }

    private void clapAndBooPosts() {
        users[0].booPost(0);
        users[0].booPost(0);
        users[0].booPost(0);
        users[2].booPost(1);
        users[2].clapPost(0);
    }

    private void printResult() {
        System.out.println("Infos da Julia");
        System.out.println(users[2].getMyPostsInfo());
        System.out.println(users[2].getFollowersInfo());
        System.out.println(users[2].getTimelineInfo());
    }


}
