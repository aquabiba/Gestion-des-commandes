package MainTest;

import ClassManager.ClientManager;
import Model.Client;

public class Test_1 {
    public static void main(String[] args) {

        // creer client :
        Client cl = ClientManager.createClient("barahal","ayoub","salam appart5 imm 3","0677876668");

        // afficher client :
        ClientManager.readClient();

        // modifier client
        ClientManager.updateClient(cl.getNumCl(),"moumid","simo","salam appart5 imm 3","0677876668");

        // supprimer le client :
        ClientManager.deleteClient(cl);





    }
}
