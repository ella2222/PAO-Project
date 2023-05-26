package Models.Cabinet;

import Database.JDBCdatabase;
import Services.AuditService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CabinetTable {
    private final JDBCdatabase con;

    public CabinetTable(JDBCdatabase databaseCon) {
        con = databaseCon;
    }
    //create
    public void createCabinetTable(){
        String query = "CREATE TABLE IF NOT EXISTS cabinet(nume varchar(50), id int, adresa varchar(50), nrtel varchar(50), email varchar(50), orar varchar(50), primary key(id))";
        try{
            Statement statement = con.getConnection().createStatement();
            statement.executeUpdate(query);
            AuditService.write("Created cabinet table");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void addCabinet(String nume, int id, String adresa, String nrtel, String email, String orar){
        String query = "INSERT INTO cabinet VALUES(?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setString(1, nume);
            ps.setInt(2, id);
            ps.setString(3, adresa);
            ps.setString(4, nrtel);
            ps.setString(5, email);
            ps.setString(6, orar);
            ps.executeUpdate();
            AuditService.write("Added cabinet");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addCabinet(Cabinet c){
        String query = "INSERT INTO cabinet VALUES(?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setString(1, c.getNume());
            ps.setInt(2, c.getId());
            ps.setString(3, c.getAdresa());
            ps.setString(4, c.getNrtel());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getOrar());
            ps.executeUpdate();
            AuditService.write("Added cabinet");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //read
    public void getCabinet(int id){
        String query = "SELECT * FROM cabinet WHERE id = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
            AuditService.write("Print cabinet");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //update
    public void updateCabinet(String nume, int id, String adresa, String nrtel, String email, String orar){
        String query = "UPDATE cabinet SET nume = ?, adresa = ?, nrtel = ?, email = ?, orar = ? WHERE id = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setString(1, nume);
            ps.setInt(2, id);
            ps.setString(3, adresa);
            ps.setString(4, nrtel);
            ps.setString(5, email);
            ps.setString(6, orar);
            ps.executeUpdate();
            AuditService.write("Updated cabinet");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //delete
    public void deleteCabinet(int id){
        String query = "DELETE FROM cabinet WHERE id = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            AuditService.write("Deleted cabinet");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
