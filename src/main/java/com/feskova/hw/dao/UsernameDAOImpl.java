package com.feskova.hw.dao;

import com.feskova.hw.models.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;


@Component
public class UsernameDAOImpl implements UsernameDAO {
    private static final RowMapper<Username> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Username(
                Integer.parseInt(resultSet.getString("id")),
                resultSet.getString("firstname"),
                resultSet.getString("lastname"));
    };
    private static int USERNAME_COUNT = 0;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Username> index() {
        return jdbcTemplate.query("select * from username", ROW_MAPPER);
    }

    @Override
    public Username show(int id) {
        return jdbcTemplate.queryForObject("select * from username where id=?1", new Object[]{id}, ROW_MAPPER);
    }

    @Override
    public void save(Username username) {
        username.setId(++USERNAME_COUNT);
        jdbcTemplate.update("insert into username (id, firstname, lastname) values (?1, ?2, ?3)",
                new Object[]{username.getId(), username.getFirstname(), username.getLastname()}, ROW_MAPPER);
    }

    @Override
    public void update(int id, Username username) {
        jdbcTemplate.update("update username set id=?1, firstname=?2, lastname=?3 where id=?4",
                new Object[]{username.getId(), username.getFirstname(), username.getLastname(), id}, ROW_MAPPER);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from username where id=?", new Object[]{id}, ROW_MAPPER);
    }
}
//    private static int USERNAME_COUNT = 0;
//
//    private static Connection connection;
//
//static {
//        try {
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//        } catch (ClassNotFoundException e) {
//        e.printStackTrace();
//        }
//
//        try {
//        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException e) {
//        e.printStackTrace();
//        }
//        }
//
//public UsernameDAOImpl() {
//        }
//
//public List<Username> index() {
//        List<Username> person = new ArrayList<>();
//
//        try {
//        Statement statement = connection.createStatement();
//        String SQL = "SELECT * FROM Username";
//        ResultSet resultSet = statement.executeQuery(SQL);
//
//        while(resultSet.next()) {
//        Username username = new Username();
//
//        username.setId(resultSet.getInt("id"));
//        username.setFirstname(resultSet.getString("firstname"));
//        username.setLastname(resultSet.getString("lastname"));
//
//        person.add(username);
//        }
//
//        } catch (SQLException e) {
//        e.printStackTrace();
//        }
//
//        return person;
//        }
//
//public Username show(int id) {
//        Username username = new Username();
//        try {
//        Statement statement = connection.createStatement();
//        String SQL = "select * from username where id = " + id + ";";
//
//        ResultSet resultSet = statement.executeQuery(SQL);
//
//        if (!resultSet.wasNull()) {
//        username.setId(resultSet.getInt("id"));
//        username.setFirstname(resultSet.getString("firstname"));
//        username.setLastname(resultSet.getString("lastname"));
//        }
//        } catch (SQLException throwables) {
//        throwables.printStackTrace();
//        }
//        return username;
//        }
//
//public void save(Username username) {
//        try {
//        username.setId(++USERNAME_COUNT);
//        Statement statement = connection.createStatement();
//        String SQL = "insert into username (id, firstname, lastname) values (" + username.getId() + ", "
//        + username.getFirstname() + ", " + username.getLastname() + ");";
//
//        statement.executeUpdate(SQL);
//        } catch (SQLException throwables) {
//        throwables.printStackTrace();
//        }
//        }
//
//public void update(int id, Username username) {
//        Username usernameOld = show(username.getId());
//
//        try {
//        Statement statement = connection.createStatement();
//
//        if (!usernameOld.getFirstname().equals(username.getFirstname())) {
//        String SQL = "update username set firstname = " + username.getFirstname() + ") where id = " + username.getId() +";";
//        statement.executeUpdate(SQL);
//        }
//
//        if (!usernameOld.getLastname().equals(username.getLastname())) {
//        String SQL = "update username set lastname = " + username.getLastname() + ") where id = " + username.getId() +";";
//        statement.executeUpdate(SQL);
//        }
//
//        } catch (SQLException throwables) {
//        throwables.printStackTrace();
//        }
//        }
//
//public void delete(int id) {
//        try {
//        Statement statement = connection.createStatement();
//        String SQL = "delete from username where id =" + id + ";";
//        statement.executeUpdate(SQL);
//        } catch (SQLException throwables) {
//        throwables.printStackTrace();
//        }
//        }
