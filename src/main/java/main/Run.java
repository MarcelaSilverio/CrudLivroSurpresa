/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Tela;

/**
 *
 * @author marcelapsilverio
 */
public class Run {
    public static void main(String[]args){
        try {
            
            new Tela().setVisible(true);
            
        } catch (ParseException ex) {
            
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
