/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyetracker;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Reinaldo
 */
public class Jogador {

    private String personagem;
    private String tipoAcao;
    private final ArrayList<Acao> action;
    private int nivel;
    private int idRodadaJogo;
    private int rodadaJogo;
    private int tempoDeRecompensa;
    private int sequenciaOtima;

    Random rand;
    int r;

    public Jogador(String personagem, String tipoAcao, int rodadaJogo) {
        this.personagem = personagem;
        this.tipoAcao = tipoAcao;
        this.action = new ArrayList();
        this.nivel = 0;
        this.idRodadaJogo = rodadaJogo;
        this.rodadaJogo = 0;
        this.tempoDeRecompensa = 12;
        this.sequenciaOtima = 0;

        rand = new Random();
        r = 0;
    }

    public Acao getAction(int i) {
        return action.get(i);
    }

    public void adicionaAcao(Acao nova) {

        if (nova.getTempoDeContatoNaAcao() > tempoDeRecompensa) {
            sequenciaOtima++;
        } else {
            sequenciaOtima = 0;
        }

        this.action.add(nova);
        if (rodadaJogo % 3 == 0) {
            AtualizaStatus();
        }
        this.rodadaJogo += 1;

    }

    public int getNivel() {
        return nivel;
    }

    public String getPersonagem() {
        return personagem;
    }

    public String getTipoAcao() {
        return tipoAcao;
    }

    public int getIdRodadaJogo() {
        return idRodadaJogo;
    }

    public void setIdRodadaJogo(int rodadaJogo) {
        this.idRodadaJogo = rodadaJogo;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    public void setTipoAcao(String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public void AtualizaStatus() {
        int total = calculaTotal();
        this.nivel = total / rodadaJogo;

        if (this.nivel >= 3 && this.nivel < 6) {
            this.tempoDeRecompensa = 16;
        }
        if (this.nivel >= 6 && this.nivel < 10) {
            this.tempoDeRecompensa = 22;
        }
        if (this.nivel >= 10) {
            this.tempoDeRecompensa = 25;
        }

    }

    public int calculaTotal() {
        int total = 0;
        total = action.stream().map((ite) -> ite.getTempoDeContatoNaAcao()).reduce(total, Integer::sum);
        return total;
    }

    public int getSequenciaOtima() {
        return this.sequenciaOtima;
    }

    public boolean checaRecompensa(int tempoJogado) {
        return (tempoJogado >= tempoDeRecompensa);
    }

    public String selectImage() {

        
        if (rodadaJogo % 3 == 0) {
            r = rand.nextInt() % 3;
        }

        if ("gato".equals(personagem)) {
            if ("artes".equals(tipoAcao)) {
                if ((rodadaJogo + r) % 3 == 0) {
                    return "/imagens/gato-artes-pintar.jpg";
                }
                if ((rodadaJogo + r) % 3 == 1) {
                    return "/imagens/gato-artes-desenhar.jpg";
                }
                if ((rodadaJogo + r) % 3 == 2) {
                    return "/imagens/gato-artes-cantar.jpg";
                }
            }
            if ("brincadeiras".equals(tipoAcao)) {
                if ((rodadaJogo + r) % 3 == 0) {
                    return "/imagens/gato-brincadeiras-bolhas.jpg";
                }
                if ((rodadaJogo + r) % 3 == 1) {
                    return "/imagens/gato-brincadeiras-susto.jpg";
                }
                if ((rodadaJogo + r) % 3 == 2) {
                    return "/imagens/gato-brincadeiras-careta.jpg";
                }
            }
            if ("tragedias".equals(tipoAcao)) {
                if ((rodadaJogo + r) % 3 == 0) {
                    return "/imagens/gato-tragedias-cair.jpg";
                }
                if ((rodadaJogo + r) % 3 == 1) {
                    return "/imagens/gato-tragedias-batercabeça.jpg";
                }
                if ((rodadaJogo + r) % 3 == 2) {
                    return "/imagens/gato-tragedias-levarsusto.jpg";
                }
            }

        }

        if ("cachorro".equals(personagem)) {
            if ("artes".equals(tipoAcao)) {
                if ((rodadaJogo + r) % 3 == 0) {
                    return "/imagens/cachorro-artes-pintar.jpg";
                }
                if ((rodadaJogo + r) % 3 == 1) {
                    return "/imagens/cachorro-artes-desenhar.jpg";
                }
                if ((rodadaJogo + r) % 3 == 2) {
                    return "/imagens/cachorro-artes-cantar.jpg";
                }
            }
            if ("brincadeiras".equals(tipoAcao)) {
                if ((rodadaJogo + r) % 3 == 0) {
                    return "/imagens/cachorro-brincadeiras-bolhas.jpg";
                }
                if ((rodadaJogo + r) % 3 == 1) {
                    return "/imagens/cachorro-brincadeiras-susto.jpg";
                }
                if ((rodadaJogo + r) % 3 == 2) {
                    return "/imagens/cachorro-brincadeiras-careta.jpg";
                }
            }
            if ("tragedias".equals(tipoAcao)) {
                if ((rodadaJogo + r) % 3 == 0) {
                    return "/imagens/cachorro-tragedias-cair.jpg";
                }
                if ((rodadaJogo + r) % 3 == 1) {
                    return "/imagens/cachorro-tragedias-batercabeça.jpg";
                }
                if ((rodadaJogo + r) % 3 == 2) {
                    return "/imagens/cachorro-tragedias-levarsusto.jpg";
                }
            }

        }

        if ("menino".equals(personagem)) {
            if ("artes".equals(tipoAcao)) {
                if ((rodadaJogo + r) % 3 == 0) {
                    return "/imagens/menino-artes-pintar.jpg";
                }
                if ((rodadaJogo + r) % 3 == 1) {
                    return "/imagens/menino-artes-desenhar.jpg";
                }
                if ((rodadaJogo + r) % 3 == 2) {
                    return "/imagens/menino-artes-cantar.jpg";
                }
            }
            if ("brincadeiras".equals(tipoAcao)) {
                if ((rodadaJogo + r) % 3 == 0) {
                    return "/imagens/menino-brincadeiras-bolhas.jpg";
                }
                if ((rodadaJogo + r) % 3 == 1) {
                    return "/imagens/menino-brincadeiras-susto.jpg";
                }
                if ((rodadaJogo + r) % 3 == 2) {
                    return "/imagens/menino-brincadeiras-careta.jpg";
                }
            }
            if ("tragedias".equals(tipoAcao)) {
                if ((rodadaJogo + r) % 3 == 0) {
                    return "/imagens/menino-tragedias-cair.jpg";
                }
                if ((rodadaJogo + r) % 3 == 1) {
                    return "/imagens/menino-tragedias-batercabeça.jpg";
                }
                if ((rodadaJogo + r) % 3 == 2) {
                    return "/imagens/menino-tragedias-levarsusto.jpg";
                }
            }

        }

        if ("menina".equals(personagem)) {
            if ("artes".equals(tipoAcao)) {
                if ((rodadaJogo + r) % 3 == 0) {
                    return "/imagens/menina-artes-pintar.jpg";
                }
                if ((rodadaJogo + r) % 3 == 1) {
                    return "/imagens/menina-artes-desenhar.jpg";
                }
                if ((rodadaJogo + r) % 3 == 2) {
                    return "/imagens/menina-artes-cantar.jpg";
                }
            }
            if ("brincadeiras".equals(tipoAcao)) {
                if ((rodadaJogo + r) % 3 == 0) {
                    return "/imagens/menina-brincadeiras-bolhas.jpg";
                }
                if ((rodadaJogo + r) % 3 == 1) {
                    return "/imagens/menina-brincadeiras-susto.jpg";
                }
                if ((rodadaJogo + r) % 3 == 2) {
                    return "/imagens/menina-brincadeiras-careta.jpg";
                }
            }
            if ("tragedias".equals(tipoAcao)) {
                if ((rodadaJogo + r) % 3 == 0) {
                    return "/imagens/menina-tragedias-cair.jpg";
                }
                if ((rodadaJogo + r) % 3 == 1) {
                    return "/imagens/menina-tragedias-batercabeça.jpg";
                }
                if ((rodadaJogo + r) % 3 == 2) {
                    return "/imagens/menina-tragedias-levarsusto.jpg";
                }
            }

        }
        return null;
    }

}
