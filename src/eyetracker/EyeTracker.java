/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyetracker;

import java.util.ArrayList;


/**
 *
 * @author samue
 */
public class EyeTracker {
    
    ArrayList<Usuario> users = new ArrayList<Usuario>();
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /**O método busca, na lista de usuários cadastrados, determinado login e senha
     * que coincidam e aceitem a conexão do usuário no sistema, independente de ser
     * responsável ou jogador.
     *
     * @param nick refere-se ao login do usuário
     * @param senha refere-se à senha do usuário
     * @return o sucesso ou não do login do usuário
     */
    public boolean login(String nick, String senha){
        for (Usuario p1 : users){ // buscando a conexao entre login e senha do usuario
            if(p1.nick.equals(nick) && p1.senha.equals(senha))
                return true;
        }
        return false;
    }
    
}
