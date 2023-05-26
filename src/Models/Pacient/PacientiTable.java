package Models.Pacient;

import Database.JDBCdatabase;
import Services.AuditService;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PacientiTable {
    private final JDBCdatabase con;

    public PacientiTable(JDBCdatabase databaseCon) {
        con = databaseCon;
    }
    //create
    public void createPacientiTable(){
        String query = "CREATE TABLE IF NOT EXISTS pacienti(nume varchar(50), prenume varchar(50), nrtel varchar(50), CNP varchar(50), id int, primary key(id))";
        try{
            PreparedStatement statement = con.getConnection().prepareStatement(query);
            statement.executeUpdate();
            AuditService.write("Created pacienti table");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void addPacient(String nume, String prenume, String nrtel, String CNP, int id){
        String query = "INSERT INTO pacienti VALUES(?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setString(1, nume);
            ps.setString(2, prenume);
            ps.setString(3, nrtel);
            ps.setString(4, CNP);
            ps.setInt(5, id);
            ps.executeUpdate();
            AuditService.write("Added pacient");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addPacient(Pacient p){
        String query = "INSERT INTO pacienti VALUES(?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setString(1, p.getNume());
            ps.setString(2, p.getPrenume());
            ps.setString(3, p.getNrtel());
            ps.setString(4, p.getCNP());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
            AuditService.write("Added pacient");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //read
    public void getPacientbyid(int id){
        String query = "SELECT * FROM pacienti WHERE id = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
            AuditService.write("Print pacient");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getPacienti(){
        String query = "SELECT * FROM pacienti";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.executeQuery();
            AuditService.write("Print pacienti");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //update
    public void updatePacient(String nume, String prenume, String nrtel, String CNP, int id){
        String query = "UPDATE pacienti SET nume = ?, prenume = ?, nrtel = ?, CNP = ? WHERE id = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setString(1, nume);
            ps.setString(2, prenume);
            ps.setString(3, nrtel);
            ps.setString(4, CNP);
            ps.setInt(5, id);
            ps.executeUpdate();
            AuditService.write("Updated pacient");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //delete
    public void deletePacient(int id){
        String query = "DELETE FROM pacienti WHERE id = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            AuditService.write("Deleted pacient");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
