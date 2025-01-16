package exercitiul1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class functii {
    public static void adaugare_persoane(Connection connection, String nume, int varsta) throws SQLException
    {
        String sql = "insert into persoane(nume, varsta) values (?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nume);
            ps.setInt(2, varsta);
            int nr_randuri = ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare=" + nr_randuri);
    }

    public static void afisare_persoane_excursii(Connection connection) throws SQLException {
        String sqlAfisarePersoane = "SELECT p.nume ,e.destinatia, e.anul FROM persoane p, excursii e " +
                                    "WHERE p.id = e.idpersoana";
        PreparedStatement psAfisare = connection.prepareStatement(sqlAfisarePersoane);
        ResultSet rsAfisarePersoane = psAfisare.executeQuery();
        while (rsAfisarePersoane.next())
        {
            System.out.println("Numele: " + rsAfisarePersoane.getString("nume")
                    + ", Destinatia: " + rsAfisarePersoane.getString("destinatia") + ", Anul: "
                    + rsAfisarePersoane.getInt("anul"));
        }

    }

    public static void afisare_excursii_dupa_nume(Connection connection, String nume) throws SQLException {
        String sql = "SELECT e.destinatia, e.anul " +
                "FROM excursii e " +
                "WHERE e.idpersoana = (SELECT p.id FROM persoane p WHERE p.nume = ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nume);
            ResultSet rs = ps.executeQuery();
                System.out.println("Excursiile pentru persoana cu numele: " + nume);
                while (rs.next()) {
                    System.out.println("Destintatie: " + rs.getString("destinatia"));
                }

    }

    public static void afisare_persoane_dupa_destinatie(Connection connection, String destinatie) throws SQLException {
        String sql = "Select p.nume FROM persoane p " +
                "WHERE p.id IN (SELECT e.idPersoana from excursii e WHERE e.destinatia = ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, destinatie);
        ResultSet rs = ps.executeQuery();
        System.out.println("In excursia in " + destinatie + " au fost: ");
        while (rs.next()) {
            System.out.println(rs.getString("nume"));
        }
    }

    public static void stergere_excursie(Connection connection, int idexcursie) throws SQLException {
        String sql = "Delete from excursii where idexcursie = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idexcursie);
        int nr_randuri = ps.executeUpdate();
        System.out.println("\nNumar randuri afectate de stergere="+nr_randuri);
    }

    public static void stergere_persoana_si_excursie(Connection connection, int idPers) throws SQLException {
        String sql = "Delete from persoane where id = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idPers);
        int nr_randuri = ps.executeUpdate();
        System.out.println("\nNumar randuri afectate de stergere="+nr_randuri);
    }

    public static void afisare_persoane_dupa_an(Connection connection, int an) throws SQLException {
        String sql = "Select p.nume FROM persoane p " +
                "WHERE p.id = (SELECT e.idPersoana from excursii e WHERE e.anul = ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, an);
        ResultSet rs = ps.executeQuery();
        System.out.println("In anul: " + an + " au mers in excursie urmatorii:");
        while (rs.next()) {
            System.out.println(rs.getString("nume"));
        }
    }


    public static void adaugare_excursii(Connection connection, int idPers, String destinatia, int anul) throws SQLException {


        String sqlVerificare = "SELECT * FROM persoane WHERE id = ?";
        PreparedStatement psVerificare = connection.prepareStatement(sqlVerificare);
        psVerificare.setInt(1, idPers);
        ResultSet rsVerificare = psVerificare.executeQuery();
        if (rsVerificare.next()) {
            System.out.println("Persoana cu ID-ul " + idPers + " exista.");
            String sqlInserare = "INSERT INTO excursii (idPersoana, destinatia, anul) VALUES (?, ?, ?)";
            PreparedStatement psInserare = connection.prepareStatement(sqlInserare);
            psInserare.setInt(1, idPers);
            psInserare.setString(2, destinatia);
            psInserare.setInt(3, anul);
            int nrRanduri = psInserare.executeUpdate();
            System.out.println("Numar randuri afectate de adaugare: " + nrRanduri);
        } else {
            System.out.println("Persoana cu ID-ul " + idPers + " nu exista.");
            System.out.println("Introduceti un ID valid");
        }
    }
}


