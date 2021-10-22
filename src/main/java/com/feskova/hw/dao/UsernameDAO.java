package com.feskova.hw.dao;

import com.feskova.hw.models.Username;

import java.util.List;


public interface UsernameDAO {
    List<Username> index();

    Username show(int id);

    void save(Username username);

    void update(int id, Username username);

    void delete(int id);

}
