/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Recebe;

/**
 *
 * @author marcelapsilverio
 */
public class RecebeTableModel  extends AbstractTableModel{
    public static final int COL_CPF_CLIENTE = 0;
    public static final int COL_ID_LIVRO = 1;
    
    public ArrayList<Recebe> lista;
    
    public RecebeTableModel(ArrayList<Recebe> l){
        
        lista = new ArrayList<>(l);
        
    }
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
       return 2;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        
        Recebe recebe = lista.get(linhas);
        
        if(colunas == COL_CPF_CLIENTE) return recebe.getR_cpf();
        if(colunas == COL_ID_LIVRO) return recebe.getR_id();
       
        return "";
    }
    
    @Override
    public String getColumnName(int colunas){
        if(colunas == COL_CPF_CLIENTE) return "CPF";
        if(colunas == COL_ID_LIVRO) return "Id";
        
        return "";
    }
}
