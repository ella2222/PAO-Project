package Models.Medic;

import Database.JDBCdatabase;
import Services.AuditService;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MedicTable {
    private final JDBCdatabase con;

    public MedicTable(JDBCdatabase databaseCon) {
        con = databaseCon;
    }

    //create
    public void createMedicTable(){
        String query = "CREATE TABLE IF NOT EXISTS medic(cabinetid int, nume varchar(50), prenume varchar(50), nrtel varchar(50), email varchar(50), pret int, id int, primary key(id))";
        try{
            PreparedStatement statement = con.getConnection().prepareStatement(query);
            statement.executeUpdate();
            AuditService.write("Created medic table");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void addMedic(int cabinetid, String nume, String prenume, String nrtel, String email, int pret, int id){
        String query = "INSERT INTO medic VALUES(?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, cabinetid);
            ps.setString(2, nume);
            ps.setString(3, prenume);
            ps.setString(4, nrtel);
            ps.setString(5, email);
            ps.setInt(6, pret);
            ps.setInt(7, id);
            ps.executeUpdate();
            AuditService.write("Added medic");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addMedic(Medic m){
        String query = "INSERT INTO medic VALUES(?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, m.getCabinetid());
            ps.setString(2, m.getNume());
            ps.setString(3, m.getPrenume());
            ps.setString(4, m.getNrtel());
            ps.setString(5, m.getEmail());
            ps.setInt(6, m.getPret());
            ps.setInt(7, m.getId());
            ps.executeUpdate();
            AuditService.write("Added medic");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //read
    public void getMedicbyid(int id){
        String query = "SELECT * FROM medic WHERE id = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
            AuditService.write("Print medic");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getMedicieftin(){
        String query = "SELECT * FROM medic ORDER BY pret ASC";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.executeQuery();
            AuditService.write("Print medic");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getMedici(){
        String query = "SELECT * FROM medic";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.executeQuery();
            AuditService.write("Print medici");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getMedicibycabinet(int idCabinet) {
        String query = "SELECT * FROM medic WHERE cabinetid = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, idCabinet);
            ps.executeQuery();
            AuditService.write("Print medici");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //update
    public void updateMedic(int cabinetid, String nume, String prenume, String nrtel, String email, int pret, int id){
        String query = "UPDATE medic SET cabinetid = ?, nume = ?, prenume = ?, nrtel = ?, email = ?, pret = ? WHERE id = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, cabinetid);
            ps.setString(2, nume);
            ps.setString(3, prenume);
            ps.setString(4, nrtel);
            ps.setString(5, email);
            ps.setInt(6, pret);
            ps.setInt(7, id);
            ps.executeUpdate();
            AuditService.write("Updated medic");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //delete

    public void deleteMedic(int id){
        String query = "DELETE FROM medic WHERE id = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            AuditService.write("Deleted medic");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
