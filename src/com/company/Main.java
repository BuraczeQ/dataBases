package com.company;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava2.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\mati\\Desktop\\DataBasesPart1\\"+DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {


        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

           // statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
          statement.execute("CREATE TABLE IF NOT EXISTS " +TABLE_CONTACTS+ " ("+COLUMN_NAME+ " TEXT,"
                   +COLUMN_PHONE + " INTEGER,"+ COLUMN_EMAIL+ " TEXT)");

            insertValues(statement,"fafas",5422131,"uobuz@gmail.com");
            insertValues(statement,"puszek",99992131,"dosa@gmail.com");
            insertValues(statement,"misza",21311111,"cat@gmail.com");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                            " (" + COLUMN_NAME+ ", " +
                            COLUMN_PHONE + ", " +
                            COLUMN_EMAIL+ " )" +
                            "VALUES('matyja', 141421, 'matu@gmial.com')") ;

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME+ ", " +
                    COLUMN_PHONE + ", " +
                    COLUMN_EMAIL+ " )" +
                    "VALUES('kakauko', 141421, 'mreru@gmial.com')") ;

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME+ ", " +
                    COLUMN_PHONE + ", " +
                    COLUMN_EMAIL+ " )" +
                    "VALUES('abecadlo', 141421, 'm1231u@gmial.com')") ;



           // statement.execute("INSERT INTO contacts (name, phone, email) VALUES('monika', 1214411231, 'moniai@gmail.com')");
           // statement.execute("UPDATE contacts SET phone=9999999999 WHERE name='monika'");
           // statement.execute("DELETE FROM contacts WHERE name='monika'");
            statement.execute("SELECT * FROM "+TABLE_CONTACTS);
            ResultSet results = statement.getResultSet();
            while (results.next()){
                System.out.println(results.getString(COLUMN_NAME)+ " " +
                results.getInt(COLUMN_PHONE)+ " " +
                results.getString(COLUMN_EMAIL));
            }

            statement.close();
            conn.close();




        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }


    }
    public static void insertValues(Statement statement, String name, int phone, String email)throws SQLException{
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME+ ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL+ " )" +
                "VALUES('" +name +"', " +phone +", '"+email +"')") ;
        }

    }

