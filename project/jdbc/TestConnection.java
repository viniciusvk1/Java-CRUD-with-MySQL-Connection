package br.com.project.jdbc;

import javax.swing.JOptionPane;

public class TestConnection {
    
    public static void main(String[] args) {
        
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null,"Successfully connected!");
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null,"An error has occurred\"!" + error);
        }

    } 
   
}