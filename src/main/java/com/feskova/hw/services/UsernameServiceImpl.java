package com.feskova.hw.services;

import com.feskova.hw.dao.UsernameDAO;
import com.feskova.hw.models.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsernameServiceImpl implements UsernameService {
    private UsernameDAO usernameDAO;

    public UsernameServiceImpl(UsernameDAO usernameDAO) {
        this.usernameDAO = usernameDAO;
    }

    @Autowired
    public void setUsernameDAO(UsernameDAO usernameDAO) {
        this.usernameDAO = usernameDAO;
    }

    public List<Username> getAll() {
        return usernameDAO.index();
    }

    public Username getUsernameById(int id) {
        return usernameDAO.show(id);
    }

    public void createUsername(Username username) {
        usernameDAO.save(username);
    }

    public void updateUsername(int id, Username username) {
        usernameDAO.update(id, username);
    }

    public void deleteUsername(int id) {
        usernameDAO.delete(id);
    }
}
