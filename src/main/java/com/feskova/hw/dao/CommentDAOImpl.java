package com.feskova.hw.dao;

import com.feskova.hw.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class CommentDAOImpl implements CommentDAO {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Comment> getAll(int postId) {
        String sql = "SELECT ID, MESSAGE FROM COMMENTS WHERE POST_ID = ?";
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, postId);
            List<Comment> comments = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comments.add(new Comment(
                        rs.getInt("ID"),
                        rs.getString("MESSAGE")
                ));
            }
            rs.close();
            ps.close();

            return comments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void save(Comment comment, int postId) {
        String sql = "INSERT INTO COMMENTS (ID, MESSAGE, POST_ID) VALUES (?, ?, ?)";
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, comment.getId());
            ps.setString(2, comment.getMessage());
            ps.setInt(3, postId);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}

