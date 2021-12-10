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
import model.Cliente;

/**
 *
 * @author marcelapsilverio e tassylalima
 */
public class ClienteDAO {
    
    private Connection conexao;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Cliente> lista = new ArrayList<Cliente>();
    
    public ClienteDAO(){
        conexao = new ConnectionFactory().getConnection();
    }
    
    public void inserir(Cliente cliente){
        String sql = "INSERT INTO cliente (cpf, nome, cep, numero, rua, cidade,"
                + " uf, email, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCep());
            stmt.setInt(4, cliente.getNumero());
            stmt.setString(5, cliente.getRua());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getUf());
            stmt.setString(8, cliente.getEmail());
            stmt.setString(9, cliente.getTelefone());
            
            stmt.execute();
            stmt.close();
            
        }catch(Exception erro){
            throw new RuntimeException("Erro 2: " + erro + "\n");
        }
    }
    
    public void alterar(Cliente cliente){
        String sql = "UPDATE cliente SET cpf = ?, nome = ?, cep = ?, numero = ?,"
                + " rua = ?, cidade = ?, uf = ?, email = ?, telefone = ? WHERE"
                + "cpf = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCep());
            stmt.setInt(4, cliente.getNumero());
            stmt.setString(5, cliente.getRua());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getUf());
            stmt.setString(8, cliente.getEmail());
            stmt.setString(9, cliente.getTelefone());
            
            stmt.setString(10, cliente.getCpf());
            
            stmt.execute();
            stmt.close();
           
        }catch(Exception erro){
            throw new RuntimeException("Erro 3: " + erro + "\n");
        }
    }
    
    public void excluir(String cpf){
        String sql = "DELETE FROM cliente WHERE cpf = '" + cpf + "'";
        try{
            st = conexao.createStatement();
            st.execute(sql);
            st.close();
            
        }catch(Exception erro){
            throw new RuntimeException("Erro 4: " + erro + "\n");
        }
    }
    
    public ArrayList<Cliente> listarTodos(){
        String sql = "SELECT * FROM cliente";
        try{
            st = conexao.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCep(rs.getString("cep"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setRua(rs.getString("rua"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                
                lista.add(cliente);
                
            }
        }catch(Exception erro){
            throw new RuntimeException("Erro 5: " + erro + "\n");
        }
        
        return lista;
    } 
}
