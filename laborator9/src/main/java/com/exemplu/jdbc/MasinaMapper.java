package com.exemplu.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class MasinaMapper implements RowMapper<Masina>{
    @Override
    public Masina mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Masina(rs.getString("numar_inmatriculare"), rs.getString("marca"),
                rs.getInt("anul"),rs.getString("culoarea"), rs.getInt("nr_km"));
    }
}