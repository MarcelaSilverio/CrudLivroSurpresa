/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Livro;

/**
 *
 * @author marcelapsilverio
 */
public class LivroTableModel  extends AbstractTableModel{
      
    public static final int COL_ID_LIVRO = 0;
    public static final int COL_NOME_LIVRO = 1;
    public static final int COL_ANO_LIVRO = 2;
    public static final int COL_EDITORA_LIVRO = 3;
    public static final int COL_AUTOR_LIVRO = 4;
    public static final int COL_NUM_PAGINAS_LIVRO = 5;
    public static final int COL_GENERO_LIVRO = 6;
    public ArrayList<Livro> lista;
    
    public LivroTableModel(ArrayList<Livro> l){
        
        lista = new ArrayList<>(l);
        
    }
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
       return 7;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        
        Livro livro = lista.get(linhas);
        
        if(colunas == COL_ID_LIVRO) return livro.getId();
        if(colunas == COL_NOME_LIVRO) return livro.getNome();
        if(colunas == COL_ANO_LIVRO) return livro.getAno();
        if(colunas == COL_EDITORA_LIVRO) return livro.getEditora();
        if(colunas == COL_AUTOR_LIVRO) return livro.getAutor();
        if(colunas == COL_NUM_PAGINAS_LIVRO) return livro.getNum_paginas();
        if(colunas == COL_GENERO_LIVRO) return livro.getGenero();
        return "";
    }
    
    @Override
    public String getColumnName(int colunas){
        if(colunas == COL_ID_LIVRO) return "Id";
        if(colunas == COL_NOME_LIVRO) return "Nome";
        if(colunas == COL_ANO_LIVRO) return "Ano";
        if(colunas == COL_EDITORA_LIVRO) return "Editora";
        if(colunas == COL_AUTOR_LIVRO) return "Autor";
        if(colunas == COL_NUM_PAGINAS_LIVRO) return "Número de páginas";
        if(colunas == COL_GENERO_LIVRO) return "Gênero";
        return "";
    }
}
