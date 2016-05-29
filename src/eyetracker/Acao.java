/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyetracker;

/**
 *
 * @author samue
 */

public class Acao {

    private int rodadaDaAcao;
    private int tempoDeContatoNaAcao;
    private int tempoSemContato;

    public Acao(int rodadaDaAcao) {

        this.rodadaDaAcao = rodadaDaAcao;
    }

    public int getRodada() {
        return rodadaDaAcao;
    }

    public int getTempoDeContatoNaAcao() {
        return tempoDeContatoNaAcao;
    }

    public int getTempoSemContato() {
        return tempoSemContato;
    }

    public void setRodada(int rodadaDaAcao) {
        this.rodadaDaAcao = rodadaDaAcao;
    }

    public void setTempoDeContatoNaAcao(int tempoDeContatoNaAcao) {
        this.tempoDeContatoNaAcao = tempoDeContatoNaAcao;
    }

    public void setTempoSemContato(int tempoSemContato) {
        this.tempoSemContato = tempoSemContato;
    }

    public void incrementaContato() {
        this.tempoDeContatoNaAcao += 1;
    }

    public void incrementaNaoContato() {
        this.tempoSemContato += 1;
    }

}
