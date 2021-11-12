package br.com.senac.integrador.escola.modelos.auxiliares;

import br.com.senac.integrador.escola.modelos.Aluno;
import br.com.senac.integrador.escola.modelos.Endereco;
import br.com.senac.integrador.escola.modelos.Pessoa;
import br.com.senac.integrador.escola.modelos.Professor;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * Definição da classe auxiliar abstrata SQLManager para manuseamentos no banco de dados.
 * @author Felipe Godinho Dal Molin
 */
public abstract class SQLManager {
    private static boolean isSQLSet = false;
    private static Connection connection;
    public static void cadastrarAluno(Aluno aluno) throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        
        String sqlStatement = String.format(
                "INSERT INTO alunos " +
                "(nome, cpf, periodo) VALUES " +
                "('%s', '%s', '%s')",
                aluno.getNome(), aluno.getCpf(), aluno.getPeriodo());
        
        statement.execute(sqlStatement);
    };
    public static void cadastrarEndereco(Endereco endereco) throws SQLException {
        Connection connection = SQLManager.createConnection();
        Statement statement = connection.createStatement();
        
        String sqlStatement = String.format(
            "INSERT INTO endereco " + 
            "(endereco, estado, bairro, cidade, numero) VALUES" +
            "('%s','%s','%s','%s',%d)",
            endereco.getEndereco(), endereco.getEstado(), endereco.getBairro(),
            endereco.getCidade(), endereco.getNumero());
        
        statement.execute(sqlStatement);
    }
    public static void cadastrarPessoa(Pessoa pessoa) throws SQLException {
        SQLManager.cadastrarEndereco(pessoa.getEndereco());
        
        connection = SQLManager.createConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM endereco");
        
        int idEndereco = -1;
        
        while(result.next()) {
            idEndereco = result.getInt("idEndereco");
        }
        if(idEndereco == -1) {
            throw new RuntimeException("idEndereco = -1");
        }
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public static void cadastrarProfessor(Professor professor) throws SQLException {
        SQLManager.cadastrarPessoa(professor);
        connection = SQLManager.createConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
            "SELECT MAX(idPessoa) FROM pessoa");
        
        int idPessoaProfessor = -1;
        while(result.next()){
            idPessoaProfessor = result.getInt(Tags.idPessoa.name());
        }
        
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private static Connection createConnection() throws SQLException {
        if(isSQLSet) {
            return connection;
        }
        String username = JOptionPane.showInputDialog("Insira o usuário do banco de dados.");
        String password = JOptionPane.showInputDialog("Insira a senha do banco de dados.");
        
        String url = "jdbc:mysql://localhost/appescola";
        isSQLSet = true;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}