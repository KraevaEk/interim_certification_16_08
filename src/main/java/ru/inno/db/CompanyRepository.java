package ru.inno.db;

import java.sql.SQLException;

public interface CompanyRepository {

    int create(String name, String description) throws SQLException;

    void deleteById(int id) throws SQLException;
}