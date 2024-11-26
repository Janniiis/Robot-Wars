package com.btcag.bootcamp.controllers;

import java.sql.*;
import java.util.Scanner;

public class dbConnector {
    private static final String URL = "jdbc:sqlite:C:/SQL/Bootcamp2024.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Verbindung zur SQLite-Datenbank hergestellt.");
        } catch (SQLException e) {
            System.out.println("Verbindung zur SQLite-Datenbank fehlgeschlagen.");
            e.printStackTrace();
        }
        return conn;
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS User (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "username TEXT NOT NULL, " + "password TEXT NOT NULL);";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabelle 'User' wurde erfolgreich erstellt.");
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Tabelle 'User'.");
            e.printStackTrace();
        }
    }

    public static void insertUser(String username, String password) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib einen Username & Passwort an: ");
        username = scanner.nextLine();
        password = scanner.nextLine();
        String sql = "INSERT INTO User(username, password) VALUES(?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("User erfolgreich eingefügt.");
        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen des Users.");
            e.printStackTrace();
        }
    }

    public static void selectAllUsers() {
        String sql = "SELECT * FROM User";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + "\t" +
                        "Username: " + rs.getString("username") + "\t" +
                        "Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Users.");
            e.printStackTrace();
        }
    }

    public static void logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib deine LogIn daten ein (Username & Passwort): ");
        String temp1 = scanner.nextLine();
        String temp2 = scanner.nextLine();
        String sql = "SELECT username, password FROM User WHERE username = '?' AND password '?'";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, temp1);
            pstmt.setString(2, temp2);
            ResultSet rs = pstmt.executeQuery();
            if (temp1 == rs.getString("username") && temp2 == rs.getString("password")) {
                System.out.println("HAT GEKAPPT!");
            } else System.out.println("Falsch!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args) {
        connect();
        //createTable();
        insertUser("User1","nichtsogeheim");
        logIn();
        selectAllUsers();
    }
    }
