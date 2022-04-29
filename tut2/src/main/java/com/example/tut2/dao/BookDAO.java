package com.example.tut2.dao;

import com.example.tut2.dbconnect.DBConnect;
import com.example.tut2.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection conn;

    public BookDAO() {
        conn = DBConnect.getConnection();
    }

    public void deleteId(int id) throws SQLException {
        String sql = "DELETE FROM book WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.close();
    }

    public List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM book";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                float price = rs.getFloat(4);
                bookList.add(new Book(id, title, author, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public void addBook(String title, String author, float price) throws SQLException {
        String sql = String.format("INSERT INTO book(title, author, price) VALUES(%s,%s,%f);", title, price, author);
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    }

    public void insertBook(Book book) throws SQLException {
        String sql = String.format("INSERT INTO book(title, author, price) VALUES(?, ?, ?);");

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setFloat(3,book.getPrice());

        ps.close();
    }

    public Book getBook(int id) throws SQLException {
        Book book = null;
        String sql = "SELECT * FROM book WHERE book_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");

            book = new Book(id, title, author, price);
        }
        resultSet.close();
        ps.close();
        return book;
    }

    public void updateBook(Book book) throws SQLException {
        String sql = "UPDATE book SET title = ?, author = ?, price = ?";
        sql += " WHERE book_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setFloat(3, book.getPrice());
        ps.setInt(4, book.getId());

        ps.close();
    }
}
