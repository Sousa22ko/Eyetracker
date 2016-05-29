package eyetracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    private Connection connection;
    private Statement statement;
    private Jogador atual;
    private int rodadaDoJogo;

    DataBase() throws SQLException, ClassNotFoundException {
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        this.statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        try {

            Class.forName("org.sqlite.JDBC");

            statement.executeUpdate("create table jogador (rodadaJogo int, rodadaAcao int, tempodecontato int, temposemcontato int, personagem String, tipoDeAcao String, nivel int)");

        } catch (SQLException e) {
            // if the error message is "out of memory", 
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }

        }
        ResultSet rs = statement.executeQuery("SELECT * FROM jogador ordered by rodadaJogo desc"); 
        rodadaDoJogo = rs.getInt("rodadaJogo") + 1;
    }
    
    public void incrementaRodada() throws SQLException{
        ResultSet rs = statement.executeQuery("SELECT * FROM jogador ordered by rodadaJogo desc"); 
        rodadaDoJogo = rs.getInt("rodadaJogo") + 1;
    }
    
    public String getIdJogada(){
        return "" + atual.getIdRodadaJogo();
    }
    
    public String getRodada(){
        return "" + rodadaDoJogo;
    }
    

    public void saveAction(int i) throws SQLException {
        Acao salva = atual.getAction(i);
        statement.executeUpdate("insert into jogador values("+atual.getIdRodadaJogo()+", "+ salva.getRodada()+", "+salva.getTempoDeContatoNaAcao()+", "+salva.getTempoSemContato()+", "+ atual.getPersonagem() +", " + atual.getTipoAcao()+", "+ atual.getNivel()+ ")");
        
    }
    
    public void setJogadorPersonagem(String personagem){
        atual.setPersonagem(personagem);
    }
    
    public void setCategoriaAcao(String categoria){
        atual.setTipoAcao(categoria);
    }
    
    public int getSequenciaOtima(){
        return atual.getSequenciaOtima();
    }
    
    public int getAcaoRodada(){
        return this.atual.getAction(atual.getIdRodadaJogo()).getRodada();
    }
    public int getAcaoTempoContato(){
        return this.atual.getAction(atual.getIdRodadaJogo()).getTempoDeContatoNaAcao();
    }
    public int getAcaoTempoSContato(){
        return this.atual.getAction(atual.getIdRodadaJogo()).getTempoSemContato();
    }
    
    
    public String jogar() throws SQLException{
        statement.executeUpdate("insert into jogador values("+atual.getIdRodadaJogo()+", "+ getAcaoRodada()+", "+getAcaoTempoContato()+", "+getAcaoTempoSContato()+", "+ atual.getPersonagem() +", " + atual.getTipoAcao()+", "+ atual.getNivel()+ ")");
        return atual.jogar();
    
    }

    

}
