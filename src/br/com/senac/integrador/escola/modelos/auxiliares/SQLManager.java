package br.com.senac.integrador.escola.modelos.auxiliares;

import br.com.senac.integrador.escola.modelos.Login;
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
        connection = SQLManager.createConnection();
        Statement statement = connection.createStatement();
        
        String sqlStatement = String.format(
            "INSERT INTO endereco " + 
            "(endereco, estado, bairro, cidade, numero) VALUES" +
            "('%s','%s','%s','%s',%d)",
            endereco.getEndereco(), endereco.getEstado(), endereco.getBairro(),
            endereco.getCidade(), endereco.getNumero());
        
        statement.execute(sqlStatement);
    }
    public static void cadastrarPessoa(Pessoa p) throws SQLException {
        SQLManager.cadastrarEndereco(p.getEndereco());
        
        connection = SQLManager.createConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT idEndereco FROM endereco");
        
        int idEndereco = -1;
        
        while(result.next()) {
            idEndereco = result.getInt(Tags.idEndereco.name());
        }
        if(idEndereco == -1) {
            throw new RuntimeException("idEndereco = -1");
        }
        
        String sqlstate = String.format(
                "INSERT INTO pessoa " +
                "(idEndereco, nome, cpf, rg, telefone, email, deficiencia, nacionalidade, genero, estadoCivil, cor) VALUES " +
                "(%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                idEndereco, p.getNome(), p.getCpf(), p.getRg(), p.getTelefone(), p.getEmail(), p.getDeficiencia(),
                p.getNacionalidade(),
                p.getGenero().name(), p.getEstadoCivil().name(), p.getCorRaca().name()
        );
        statement.execute(sqlstate);
        System.out.println("Pessoa cadastrada.");
    }
    public static void cadastrarLogin(Login login) throws SQLException {
        connection = SQLManager.createConnection();
        Statement statement = connection.createStatement();
        
        String sqlState = String.format(
                "INSERT INTO login " +
                "(tipoLogin, usuario, senha) VALUES " +
                "('%s', '%s', '%s')",
                login.getTipo(), login.getUsuario(), login.getSenha()
        );
        statement.execute(sqlState);
    }
    public static void cadastrarProfessor(Professor professor) throws SQLException {
        SQLManager.cadastrarPessoa(professor);
        connection = SQLManager.createConnection();
        Statement statement = connection.createStatement();
        
        int idPessoa = -1, idLogin = -1;
        
        ResultSet resultPessoa = statement.executeQuery("SELECT idPessoa FROM pessoa");
        while(resultPessoa.next()){
            idPessoa = resultPessoa.getInt(Tags.idPessoa.name());
        }
        ResultSet resultLogin = statement.executeQuery("SELECT idLogin FROM login WHERE tipoLogin='PROFESSOR'");
        while(resultLogin.next()) {
            idLogin = resultLogin.getInt(Tags.idLogin.name());
        }
        
        try {
            if(idLogin == -1) {
                throw new RuntimeException("Nenhum login cadastrado.");
            }  
            if(idPessoa == -1) {
                throw new RuntimeException("Nenhuma pessoa cadastrada.");
            }
        } catch(RuntimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
        
        
        String sqlState = String.format(
                "INSERT INTO professor " +
                "(idLogin, idPessoa, formacao, historicoProfissional) VALUES " +
                "(%d, %d, '%s', '%s')",
                idLogin, idPessoa, professor.getFormacao(), professor.getHistoricoProfisional());
        statement.execute(sqlState);
    }
    private static Connection createConnection() throws SQLException {
        if(isSQLSet) {
            return connection;
        }
        //String username = JOptionPane.showInputDialog("Insira o usuário do banco de dados.");
        //String password = JOptionPane.showInputDialog("Insira a senha do banco de dados.");
        
        String username = "root";
        String password = "inserida";
        
        String url = "jdbc:mysql://localhost/appescola";
        isSQLSet = true;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    
}