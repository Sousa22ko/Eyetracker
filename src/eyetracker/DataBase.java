package eyetracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

            statement.executeUpdate("");//"create table jogador (rodadaJogo int, rodadaAcao int, tempodecontato int, temposemcontato int, personagem String, tipoDeAcao String, nivel int)");

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
               // System.out.println("oi");

        //ResultSet rs = statement.executeQuery("SELECT * FROM jogador ordered by rodadaJogo desc");
        //rs.next();
          //      System.out.println("oi2");

        //rodadaDoJogo = rs.getInt("rodadaJogo") + 1;
          //      System.out.println("oi3");

    }

    public void incrementaRodada() throws SQLException {
        //ResultSet rs = statement.executeQuery("SELECT * FROM jogador ordered by rodadaJogo desc");
        //rodadaDoJogo = rs.getInt("rodadaJogo") + 1;
    }

    public String getIdJogada() {
        return "" + atual.getIdRodadaJogo();
    }

    public String getRodada() {
        return "" + rodadaDoJogo;
    }

    public void saveAction(int i) throws SQLException {
        Acao salva = atual.getAction(i);
        statement.executeUpdate("insert into jogador values(" + atual.getIdRodadaJogo() + ", " + salva.getRodada() + ", " + salva.getTempoDeContatoNaAcao() + ", " + salva.getTempoSemContato() + ", " + atual.getPersonagem() + ", " + atual.getTipoAcao() + ", " + atual.getNivel() + ")");

    }

    public void setJogadorPersonagem(String personagem) {
        atual = new Jogador(personagem, null, 0);
    }

    public void setCategoriaAcao(String categoria) {
        atual.setTipoAcao(categoria);
    }

    public int getSequenciaOtima() {
        return atual.getSequenciaOtima();
    }

    public int getAcaoRodada() {
        return this.atual.getAction(atual.getIdRodadaJogo()).getRodada();
    }

    public int getAcaoTempoContato() {
        return this.atual.getAction(atual.getIdRodadaJogo()).getTempoDeContatoNaAcao();
    }

    public int getAcaoTempoSContato() {
        return this.atual.getAction(atual.getIdRodadaJogo()).getTempoSemContato();
    }

    public String jogar(int contactTime) throws SQLException {
        statement.executeUpdate("insert into jogador values(" + atual.getIdRodadaJogo() + ", " + getAcaoRodada() + ", " + contactTime + ", " + getAcaoTempoSContato() + ", " + atual.getPersonagem() + ", " + atual.getTipoAcao() + ", " + atual.getNivel() + ")");
        System.out.println("oi");
        return atual.selectImage();

    }

    public ArrayList preencheValoresPersonagen() throws SQLException {

        ArrayList valores = new ArrayList();

        valores.add(0);
        valores.add(0);
        valores.add(0);
        valores.add(0);

        //ResultSet rs = statement.executeQuery("SELECT * FROM jogador");

        /*while (rs.next()) {

            rs.getString("personagem");

            if ("gato".equals(rs.getString("personagem")));
            valores.set(0, (int) valores.get(0) + 1);

            if ("cachorro".equals(rs.getString("personagem")));
            valores.set(1, (int) valores.get(1) + 1);

            if ("menino".equals(rs.getString("personagem")));
            valores.set(2, (int) valores.get(2) + 1);

            if ("menina".equals(rs.getString("personagem")));
            valores.set(3, (int) valores.get(3) + 1);

        }*/

        return valores;
    }

    ArrayList preencheValoresTipo() throws SQLException {

        ArrayList valores = new ArrayList();

        valores.add(0);
        valores.add(0);
        valores.add(0);

        /*
        ResultSet rs = statement.executeQuery("SELECT * FROM jogador");

        while (rs.next()) {

            rs.getString("tipoDeAcao");

            if ("ação".equals(rs.getString("personagem")));
            valores.set(0, (int) valores.get(0) + 1);

            if ("brincadeiras".equals(rs.getString("personagem")));
            valores.set(1, (int) valores.get(1) + 1);

            if ("tragedias".equals(rs.getString("personagem")));
            valores.set(2, (int) valores.get(2) + 1);

        }*/

        return valores;
    }

}
