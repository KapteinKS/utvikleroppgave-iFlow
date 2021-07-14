package com.example.utvikleroppgave_iflow_v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationRepository rep;

    @Autowired
    private HttpSession session;

    private Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @GetMapping("/getHours")
    public List<Hour> getHours(HttpServletResponse response) throws IOException{

        List<Hour> hours = rep.getHours();

        if (hours == null){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Something went wrong, please try again later");
        }
        return hours;
    }

    @GetMapping("/login")
    public boolean login(String username, String password) throws IOException{
        if (rep.login(username, password)){
            session.setAttribute("login", true);
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/save")
    public void save(Hour hour, HttpServletResponse response) throws IOException{
        if (!rep.save(hour)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong, could not save");
        }
    }

    @DeleteMapping("/delete")
    public void delete(Hour hour, HttpServletResponse response) throws IOException{
        if (!rep.delete(hour)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong, could not delete");
        }
    }
}
