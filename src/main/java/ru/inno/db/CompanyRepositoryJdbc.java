package ru.inno.db;

import java.sql.*;

public class CompanyRepositoryJdbc implements CompanyRepository {
    private final static String INSERT = "insert into company(name, description) values(?, ?)";
    private final static String DELETE = "delete from company where id = ?";

    private Connection connection;

    public CompanyRepositoryJdbc(Connection connection) {
        this.connection = connection;
    }


    @Override
    public int create(String name, String description) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, description);
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        return generatedKeys.getInt(1);
    }

    @Override
    public void deleteById(int id) throws SQLException {
    PreparedStatement preparedStatement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setInt(1, id);
    preparedStatement.executeUpdate();

    }
}