package com.example.utvikleroppgave_iflow_v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class RegistrationRepository {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(RegistrationRepository.class);

    public List<Hour> getHours() {
        String sql = "SELECT * FROM RegisteredHour";
        try {
            return db.query(sql, new BeanPropertyRowMapper(Hour.class));
        }
        catch (Exception e){
            logger.error("Error when getting hours" + e);
            return null;
        }
    }

    public boolean login(String username, String password) {
        String sql = "Select * FROM User WHERE username = ?";
        try {
            List<User> users = db.query(sql, new BeanPropertyRowMapper(User.class), username);

            if (users != null){
                if (password.equals(users.get(0).getPassword())){
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean save(Hour hour) {
        String sql = "INSERT INTO RegisteredHour (project, date, hours, comment) VALUES (?,?,?,?)";
        try {
            db.update(sql, hour.getProject(), hour.getDate(), hour.getHours(), hour.getComment());
            return true;
        }
        catch (Exception e){
            System.out.println("Did not save");
            logger.error("Error in saving hours" + e);
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM RegisteredHour WHERE id=?";
        try {
            db.update(sql, id);
            return true;
        }
        catch (Exception e){
            logger.error("Error when deleting hour" + e);
            return false;
        }
    }
}
