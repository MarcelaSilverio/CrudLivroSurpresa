/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Recebe;

/**
 *
 * @author marcelapsilverio
 */
public class RecebeDAO {
    private Connection conexao;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Recebe> lista = new ArrayList<Recebe>();
    
    public RecebeDAO(){
        conexao = new ConnectionFactory().getConnection();
    }
    
    public void inserir(Recebe recebe){
        String sql = "INSERT INTO recebe (r_cpf, r_id) VALUES (?, ?)";
        try{
            stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, recebe.getR_cpf());
            stmt.setInt(2, recebe.getR_id());
            
            stmt.execute();
            stmt.close();
            
        }catch(Exception erro){
            throw new RuntimeException("Erro 2: " + erro + "\n");
        }
    }
    
    
    public void excluir(){
        String sql = "DELETE * FROM recebe";
        try{
            st = conexao.createStatement();
            st.execute(sql);
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 4: " + erro + "\n");
        }
    }
    
    public ArrayList<Recebe> listarTodos(){
        String sql = "SELECT * FROM recebe";
        try{
            st = conexao.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Recebe recebe = new Recebe();
                recebe.setR_cpf(rs.getString("cpf"));
                recebe.setR_id(rs.getInt("id"));
                
                lista.add(recebe);
            }
        }catch(Exception erro){
            throw new RuntimeException("Erro 5: " + erro + "\n");
        }
        
        return lista;
    } 
}
