package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import static com.sun.tools.javac.tree.TreeInfo.name;

public class ophen_klient {

    private static String INSERT_KLIENT = "INSERT INTO klient (name, balans) VALUES (?, ?);";
    private static String UPDATE_KLIENT = "UPDATE klient SET name = ? WHERE id = ? ";
    private static String DELETE_KLIENT = "DELETE FROM klient WHERE id = ?";

    public ophen_klient(Klient klient) {
    }

    public static List<Klient> getKlientData(String query) {
        List<Klient> klientList = new ArrayList<>();

        try (Connection connection = DBU.getConnection();

             //Statement  не изменяемый
             //PreparedStatement  можно добавить параметры
             //CallableStatement  можно получить значения из обратных процедур

             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int balans = rs.getInt("balans");

                klientList.add(new Klient(id, name, balans));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return klientList;

    }

    public static List<Klient> saveKlient(Klient Klient) {

        List<Klient> klientList = new ArrayList<>();

        try (Connection connection = DBU.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_KLIENT)) {
            preparedStatement.setString(1, Klient.getName());
            preparedStatement.setInt(2, Klient.getBalans());
            preparedStatement.executeUpdate();
            connection.commit();
            PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM klient");
            ResultSet rs = allStudents.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int balans = rs.getInt("balans");

                klientList.add(new Klient(id, name, balans));
            }


//            ResultSet rs = preparedStatement.executeQuery();

//            while (rs.next()){
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String surnme = rs.getString("surnme");
//
//                Student.add(new student(id, name, surnme));
//            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return klientList;
    }

    public static List<Klient> updateKlient(int Klientid, String name, int balans) {
        List<Klient> updateKlient = new ArrayList<>();

        try (Connection connection = DBU.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_KLIENT)) {

            preparedStatement.setInt(1, Klientid);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, balans);
            preparedStatement.executeUpdate();

            PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM student");
            ResultSet rs = allStudents.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String Name = rs.getString("name");
                int Balans = rs.getInt("balans");

                updateKlient.add(new Klient(id, Name, Balans));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updateKlient;
    }
    public static List<Klient> deleteKlient(int Klientid) {
        List<Klient> updateKlient = new ArrayList<>();

        try (Connection connection = DBU.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_KLIENT)) {

            preparedStatement.setInt(1, Klientid);
            preparedStatement.executeUpdate();

            PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM Klient");
            ResultSet rs = allStudents.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int Balans = rs.getInt("Blans");

                updateKlient.add(new Klient(id, name, Balans));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updateKlient;
    }



}
