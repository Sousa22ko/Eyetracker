/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyetracker;

import java.util.Random;

/**
 *
 * @author samue
 */
public class Usuario {
    String nome;
    String nick;
    String senha;
    int idade;
    int tempoDeContatoNaAcao;
    int tempoSemContato;
    int nivel; // pode usar um extends pra jogador e diferenciar do responsavel
    
    public Usuario(String nome, int idade, String nick, String senha) {
        this.nome = nome;
        this.nick = nick;
        this.senha = senha;
        this.idade = idade;
        this.nivel = 0;
    }
    
    public void setTempoDeContato() {
        Random gerador = new Random();
        this.tempoDeContatoNaAcao = gerador.nextInt(30);
    }
    
    public void setTempoSemContato() { //gerando tempo aleatório sem contato do usuário
        Random gerador = new Random();
        if(gerador.nextBoolean()) // simulando o caso de às vezes o usuário nao perder o contato
        this.tempoSemContato = gerador.nextInt(50);
    }
    
}
