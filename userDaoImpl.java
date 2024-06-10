package org.example.banksystem.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class userDaoImpl implements userdao {
    @Override
    public void signup() throws IOException {
        Connection con = DBconnection.getConnection();
        if (con == null) {
            return;
        }

        Scanner input = new Scanner(System.in);
        try {

            System.out.println("please enter your name: ");
            String Name = input.next();
            System.out.println("please enter your mail: ");
           String mail = input.next();
            System.out.println("please enter your password: ");
           String password = input.next();
            String query = "insert into employee(Name , mail , password) values (? , ? , ?) ";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                preparedStatement.setString(1, Name);
                preparedStatement.setString(2, mail);
                preparedStatement.setString(3, password);
                preparedStatement.executeUpdate();

                System.out.println("User signed up successfully!");


            } catch (SQLException se) {
                se.printStackTrace();

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }


        /*finally {
            input.close();
        }*/
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}


