/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 *
 * @author marcelapsilverio
 */
public class ClienteTableModel extends AbstractTableModel{

    public static final int COL_CPF_CLIENTE = 0;
    public static final int COL_NOME_CLIENTE = 1;
    public static final int COL_CEP_CLIENTE = 2;
    public static final int COL_NUMERO_CLIENTE = 3;
    public static final int COL_RUA_CLIENTE = 4;
    public static final int COL_CIDADE_CLIENTE = 5;
    public static final int COL_UF_CLIENTE = 6;
    public static final int COL_EMAIL_CLIENTE = 7;
    public static final int COL_TELEFONE_CLIENTE = 8;
    public ArrayList<Cliente> lista;
    
    
    public ClienteTableModel(ArrayList<Cliente> l){
        
        lista = new ArrayList<>(l);
        
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        
        Cliente cliente = lista.get(linhas);
        
        if(colunas == COL_CPF_CLIENTE) return cliente.getCpf();
        if(colunas == COL_NOME_CLIENTE) return cliente.getNome();
        if(colunas == COL_CEP_CLIENTE) return cliente.getCep();
        if(colunas == COL_NUMERO_CLIENTE) return cliente.getNumero();
        if(colunas == COL_RUA_CLIENTE) return cliente.getRua();
        if(colunas == COL_CIDADE_CLIENTE) return cliente.getCidade();
        if(colunas == COL_UF_CLIENTE) return cliente.getUf();
        if(colunas == COL_EMAIL_CLIENTE) return cliente.getEmail();
        if(colunas == COL_TELEFONE_CLIENTE) return cliente.getTelefone();
        
        return "";
    }
    
    @Override
    public String getColumnName(int colunas){
        if(colunas == COL_CPF_CLIENTE) return "CPF";
        if(colunas == COL_NOME_CLIENTE) return "Nome";
        if(colunas == COL_CEP_CLIENTE) return "CEP";
        if(colunas == COL_NUMERO_CLIENTE) return "Número";
        if(colunas == COL_RUA_CLIENTE) return "Rua";
        if(colunas == COL_CIDADE_CLIENTE) return "Cidade";
        if(colunas == COL_UF_CLIENTE) return "UF";
        if(colunas == COL_EMAIL_CLIENTE) return "Email";
        if(colunas == COL_TELEFONE_CLIENTE) return "Telefone";
        
        return "";
    }
    
    
}
