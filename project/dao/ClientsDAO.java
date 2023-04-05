package br.com.project.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Clients;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClientsDAO {
    
    private Connection con;
    
    public ClientsDAO(){
       this.con = new ConnectionFactory().getConnection();
    }
    
        public void registerCustomer(Clients obj){
            
            try {
                
                String sql = "INSERT INTO tb_clients (name, rg, cpf, email, phone, mobile, zip_code, address, number, complement, neighborhood, city, state)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                 
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, obj.getName());
                stmt.setString(2, obj.getRg());
                stmt.setString(3, obj.getCpf());
                stmt.setString(4, obj.getEmail());
                stmt.setString(5, obj.getPhone());
                stmt.setString(6, obj.getMobile());
                stmt.setString(7, obj.getZip_code());
                stmt.setString(8, obj.getAddress());
                stmt.setInt(9, obj.getNumber());
                stmt.setString(10, obj.getComplement());
                stmt.setString(11, obj.getNeighborhood());
                stmt.setString(12, obj.getCity());
                stmt.setString(13, obj.getState());

                stmt.execute();
                stmt.close();
                
                JOptionPane.showMessageDialog(null,"Registered successfully!");
                
            } catch (SQLException error) {
                
                JOptionPane.showMessageDialog(null,"Error:!" + error);
                
            }
            
        }
        
        public void modifyCustomer(){
            
        }
        
        public void deleteCustomer(){
            
        }
}