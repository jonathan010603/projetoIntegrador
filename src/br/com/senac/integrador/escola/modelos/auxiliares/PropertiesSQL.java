package br.com.senac.integrador.escola.modelos.auxiliares;

/**
 * Definição da classe auxiliar PropertiesSQL
 * @author Felipe Godinho Dal Molin
 * "jdbc:mysql://" + serverName + "/" + myDatabase
 */
public class PropertiesSQL {
    private String url;
    private String database;
    private String username;
    private String password;
    private String serverName;
    
    public PropertiesSQL(String serverName, String database, String username, String password) {
        this.url = "jdbc:mysql://"+ serverName+ "/" + database;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        String message = String.format(
        "[Database: %s, Username: %s, Password: %s",
        this.database, this.username, this.password);
        return message;
    }
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatabase() {
        return database;
    }
    public void setDatabase(String database) {
        this.database = database;
        this.url = "jdbc:mysql://" + this.serverName + "/" + database;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getServerName() {
        return this.serverName;
    }
    public void setServerName(String serverName) {
        this.serverName = serverName;
        this.url = "jdbc:mysql//" + this.serverName + "/" + this.database;
    }
}