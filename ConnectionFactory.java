package tccbinario;

/*
 * @author Walter Dalla Torre Neto <wwddttnn@hotmail.com>
 */
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.logging.Level;
    import java.util.logging.Logger;

public class ConnectionFactory {
    
    final static String DRIVER = "com.mysql.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost/numeros";
    final static String USER = "root";
    final static String PASS = "wwddttnn1";
    
    
    public static Connection getConnection(){
    
        try{
            Class.forName(DRIVER);
            System.out.println("Conectando...");
            return DriverManager.getConnection(URL, USER, PASS);
            
        } 
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar");
            throw new RuntimeException("erro na conexao", ex);
        }
    }
    
    public static void closeConnection(Connection con){
        try {
            if(con != null){
                con.close();
                System.out.println("Fechando conexao");
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexao");       
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt ){
        closeConnection(con);
        try {
            if(stmt != null){
                stmt.close();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con,stmt);
        try {
            if(rs != null){
                rs.close();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
