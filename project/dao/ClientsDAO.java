package br.com.project.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.model.Clients;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ClientsDAO {

    private Connection con;

    public ClientsDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void registerCustomer(Clients obj) {

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

            JOptionPane.showMessageDialog(null, "Registered successfully!");

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Error:!" + error);

        }

    }

    public void modifyCustomer(Clients obj) {
        try {

            String sql = "UPDATE tb_clients SET name=?, rg=?, cpf=?, email=?, phone=?, mobile=?, zip_code=?,"
                    + "address=?, number=?, complement=?, neighborhood=?, city=?, state=? WHERE id =?";

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
            stmt.setInt(14, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Successfully changed!");

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Error:!" + error);

        }
    }

    public void deleteCustomer(Clients obj) {
        try {

            String sql = "DELETE FROM tb_clients where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Successfully excluded!");

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Error:!" + error);

        }
    }

    public List<Clients> listClients() {
        try {

            List<Clients> list = new ArrayList<>();

            String sql = "SELECT * FROM tb_clients";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clients obj = new Clients();

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setPhone(rs.getString("phone"));
                obj.setMobile(rs.getString("mobile"));
                obj.setZip_code(rs.getString("zip_code"));
                obj.setAddress(rs.getString("address"));
                obj.setNumber(rs.getInt("number"));
                obj.setComplement(rs.getString("complement"));
                obj.setNeighborhood(rs.getString("neighborhood"));
                obj.setCity(rs.getString("city"));
                obj.setState(rs.getString("state"));

                list.add(obj);

            }

            return list;

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error" + error);
            return null;
        }
    }
    
    public List<Clients> searchClients(String name) {
        try {

            List<Clients> list = new ArrayList<>();

            String sql = "SELECT * FROM tb_clients WHERE name LIKE ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clients obj = new Clients();

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setPhone(rs.getString("phone"));
                obj.setMobile(rs.getString("mobile"));
                obj.setZip_code(rs.getString("zip_code"));
                obj.setAddress(rs.getString("address"));
                obj.setNumber(rs.getInt("number"));
                obj.setComplement(rs.getString("complement"));
                obj.setNeighborhood(rs.getString("neighborhood"));
                obj.setCity(rs.getString("city"));
                obj.setState(rs.getString("state"));

                list.add(obj);

            }

            return list;

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error" + error);
            return null;
        }
    }

}
