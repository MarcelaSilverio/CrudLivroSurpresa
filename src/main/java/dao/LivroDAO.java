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
import model.Livro;

/**
 *
 * @author marcelapsilverio
 */
public class LivroDAO {
    private Connection conexao;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Livro> lista = new ArrayList<Livro>();
    
    public LivroDAO(){
        conexao = new ConnectionFactory().getConnection();
    }
    
    public void inserir(Livro livro){
        String sql = "INSERT INTO livro (nome, ano, editora, autor, num_paginas,"
                + " genero) VALUES (?, ?, ?, ?, ?, ?)";
        try{
            stmt = conexao.prepareStatement(sql);
            
            stmt.setString(2, livro.getNome());
            stmt.setInt(3, livro.getAno());
            stmt.setString(4, livro.getEditora());
            stmt.setString(5, livro.getAutor());
            stmt.setInt(6, livro.getNum_paginas());
            stmt.setString(7, livro.getGenero());
            
            stmt.execute();
            stmt.close();
            
        }catch(Exception erro){
            throw new RuntimeException("Erro 2: " + erro + "\n");
        }
    }
    
    public void alterar(Livro livro){
        String sql = "UPDATE livro SET nome = ?, ano = ?, editora = ?,"
                + " autor = ?, num_paginas = ?, genero = ? WHERE id = ?";
        try{
            
            stmt.setString(2, livro.getNome());
            stmt.setInt(3, livro.getAno());
            stmt.setString(4, livro.getEditora());
            stmt.setString(5, livro.getAutor());
            stmt.setInt(6, livro.getNum_paginas());
            stmt.setString(7, livro.getGenero());
            
            stmt.setInt(8, livro.getId());
            
            stmt.execute();
            stmt.close();
           
        }catch(Exception erro){
            throw new RuntimeException("Erro 3: " + erro + "\n");
        }
    }
    
    public void excluir(Integer id){
        String sql = "DELETE FROM livro WHERE id = " + id;
        try{
            st = conexao.createStatement();
            st.execute(sql);
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 4: " + erro + "\n");
        }
    }
    
    public ArrayList<Livro> listarTodos(){
        String sql = "SELECT * FROM livro";
        try{
            st = conexao.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Livro livro = new Livro();
                livro.setNome(rs.getString("nome"));
                livro.setAno(rs.getInt("ano"));
                livro.setEditora(rs.getString("editora"));
                livro.setAutor(rs.getString("autor"));
                livro.setNum_paginas(rs.getInt("num_paginas"));
                livro.setGenero(rs.getString("genero"));
  
            }
        }catch(Exception erro){
            throw new RuntimeException("Erro 5: " + erro + "\n");
        }
        
        return lista;
    } 
}
