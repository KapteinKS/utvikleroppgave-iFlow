package com.example.utvikleroppgave_iflow_v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
        String sql = "SELECT * FROM Hours";
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
        return false;
    }

    public boolean delete(Hour hour) {
        return false;
    }
}
