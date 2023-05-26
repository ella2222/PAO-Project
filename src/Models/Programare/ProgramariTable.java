package Models.Programare;

import Database.JDBCdatabase;
import Services.AuditService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ProgramariTable {
    private final JDBCdatabase con;

    public ProgramariTable(JDBCdatabase databaseCon) {
        con = databaseCon;
    }

    //create
    public void createProgramariTable(){
        String query = "CREATE TABLE IF NOT EXISTS programari(id int, medicid int, pacientid int, data date, ora varchar(50), PRIMARY KEY (id))";
        try{
            PreparedStatement statement = con.getConnection().prepareStatement(query);
            statement.executeUpdate();
            AuditService.write("Created programari table");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addProgramare(int id, int medicid, int pacientid, java.util.Date data, String ora){
        String query = "INSERT INTO programari VALUES(?, ?, ?, ?, ?)";
        try{
            Date datasql = new Date(data.getTime());
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, medicid);
            ps.setInt(3, pacientid);
            ps.setDate(4, datasql);
            ps.setString(5, ora);
            ps.executeUpdate();
            AuditService.write("Added programare");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addProgramare(Programare p){
        String query = "INSERT INTO programari VALUES(?, ?, ?, ?, ?)";
        try{
            Date datasql = new Date(p.getData().getTime());
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getMedicid());
            ps.setInt(3, p.getPacientid());
            ps.setDate(4, datasql);
            ps.setString(5, p.getOra());
            ps.executeUpdate();
            AuditService.write("Added programare");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //read
    public void getProgramarebyid(int id){
        String query = "SELECT * FROM programari WHERE id = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
            AuditService.write("Print programare");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getProgramari(){
        String query = "SELECT * FROM programari";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.executeQuery();
            AuditService.write("Print programari");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //update
    public void updateProgramare(int id, int medicid, int pacientid, Date data, String ora){
        String query = "UPDATE programari SET medicid = ?, pacientid = ?, data = ?, ora = ? WHERE id = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, medicid);
            ps.setInt(2, pacientid);
            ps.setDate(3, data);
            ps.setString(4, ora);
            ps.setInt(5, id);
            ps.executeUpdate();
            AuditService.write("Updated programare");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //delete
    public void deleteProgramare(int id){
        String query = "DELETE FROM programari WHERE id = ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            AuditService.write("Deleted programare");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteProgramareinaintededata(Date data){
        String query = "DELETE FROM programari WHERE data < ?";
        try{
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setDate(1, data);
            ps.executeUpdate();
            AuditService.write("Deleted programare");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
