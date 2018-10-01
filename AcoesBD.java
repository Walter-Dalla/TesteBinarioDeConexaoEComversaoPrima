/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tccbinario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Walter Dalla Torre Neto <wwddttnn@hotmail.com>
 */
public class AcoesBD {
    
    public void create(int numdec,boolean[] bin){
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {

            String sql = "INSERT INTO binario (col) VALUES (ponto);";
            String col;
            String col3 = "NumDec, pos17, pos18, pos19, pos20, pos21, pos22, pos23, pos24";
            String col2 = "";
            String col1 = "";
            String ponto = "?, ?, ?, ?, ?, ?, ?, ?, ?";
            
            switch(bin.length){

                case 16:
                    col2 += " ,pos9, pos10, pos11, pos12, pos13, pos14, pos15, pos16";
                    ponto += ",?, ?, ?, ?, ?, ?, ?, ?"; 
                    break;

                case 24:
                    col2 += " ,pos9, pos10, pos11, pos12, pos13, pos14, pos15, pos16";
                    col1 += " ,pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8";
                    ponto += ",?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
                    break;
            }
            
            col = col3 + col2 + col1;
            System.out.println(""+col);
            sql = sql.replace("col", col);
            sql = sql.replace("ponto", ponto);
            System.out.println(""+sql);
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, numdec);
            
            for(int i = 1; i < bin.length +1; i++){
                    
                stmt.setBoolean(i+1, bin[i -1]);
                    
            }
            /*
                stmt = con.prepareStatement("INSERT INTO binario (NumDec) Values (?) ");
                stmt.setInt(1, 1);
            */
            stmt.executeUpdate();

            System.out.println("Salvo Com Sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(AcoesBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR");
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
   }
    
    public void getBD(){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM binario";
        
        try {
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("Dec :"+rs.getInt("NumDec"));
            }
        
        
        } catch (SQLException ex) {
            System.out.println("ERRO!!");
            Logger.getLogger(AcoesBD.class.getName()).log(Level.SEVERE, null, "MAN deu ERRO");
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    
    public void teste(int a, int b) throws SQLException{
    
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO binario  VALUES ";
        
        try{
            stmt = con.prepareStatement(sql);
        }
        catch(SQLException ex){
            System.out.println("ERRO!");
        }
        finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
}
