package com.exemplu.jdbc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class MasinaJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Masina> findAll() {
        String sql = "select * from masini";
        return jdbcTemplate.query(sql, new MasinaMapper());

    }

    public Masina findByNrMat(String nr_matricol)
    {
        String sql = "select * from masini where numar_inmatriculare = ?";
        return  jdbcTemplate.queryForObject(sql, new MasinaMapper(), nr_matricol);
    }

    public int deleteByNrMat(String nr_matricol)
    {
        String sql = "delete from masini where numar_inmatriculare = ?";
        return jdbcTemplate.update(sql, nr_matricol);
    }

    public int insert(Masina m)
    {
        String sql = "insert into masini values(?,?,?,?,?)";
        return jdbcTemplate.update(sql, m.getNumar_inmatriculare(),m.getMarca(),m.getAnul(),m.getCuloarea()
                ,m.getNr_km());
    }

    public int count(String marca) {
        String sql = "SELECT COUNT(*) FROM masini WHERE marca = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, marca);
    }

    public int countByKm()
    {
        String sql = "SELECT COUNT(*) FROM masini WHERE nr_km < 100000";
        return  jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public Masina findNewerCars()
    {
        String sql = "SELECT * from Masini WHERE anul = YEAR(CURDATE() - INTERVAL 5 YEAR)";
        return jdbcTemplate.queryForObject(sql, new MasinaMapper());
    }
}
