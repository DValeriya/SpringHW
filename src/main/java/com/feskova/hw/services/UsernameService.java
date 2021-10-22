package com.feskova.hw.services;

import com.feskova.hw.models.Username;

import java.util.List;


public interface UsernameService {
    List<Username> getAll();

    Username getUsernameById(int id);

    void createUsername(Username username);

    void updateUsername(int id, Username username);

    void deleteUsername(int id);
}
