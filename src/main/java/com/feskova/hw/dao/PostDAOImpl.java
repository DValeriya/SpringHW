package com.feskova.hw.dao;

import com.feskova.hw.models.Post;
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
public class PostDAOImpl implements PostDAO {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Post> getAll() {
        String sql = "SELECT ID, TITLE, DESCRIPTION FROM POST";
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            List<Post> posts = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            Post post = null;
            while (rs.next()) {
                post = new Post(
                        rs.getInt("ID"),
                        rs.getString("TITLE"),
                        rs.getString("DESCRIPTION")
                );

                post.setComments(new ArrayList<>());
                posts.add(post);
            }
            rs.close();
            ps.close();

            return posts;
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
    public Post getById(int id) {
        String sql = "SELECT ID, TITLE, DESCRIPTION FROM POST WHERE ID = ?";
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            Post post = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                post = new Post(
                        rs.getInt("ID"),
                        rs.getString("TITLE"),
                        rs.getString("DESCRIPTION")
                );

                post.setComments(new ArrayList<>());
            }

            rs.close();
            ps.close();
            return post;
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
    public void save(Post post) {
        String sql = "INSERT INTO POST (ID, TITLE, DESCRIPTION) VALUES (?, ?, ?)";
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, post.getId());
            ps.setString(2, post.getTitle());
            ps.setString(3, post.getDescription());
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
