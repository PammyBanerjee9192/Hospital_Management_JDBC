package HospitalManagementSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
    private Connection connection;
    private Scanner scanner;
    public Patient(Connection connection,Scanner scanner){
        this.connection=connection;
        this.scanner=scanner;
    }
    public void addPatient(){
        System.out.print("enter patient name: ");
        String name=scanner.nextLine();
        System.out.print("enter patient's age: ");
        int age=scanner.nextInt();
        System.out.print("enter patient's gender: ");
        String gender=scanner.nextLine();

        try{
            String query="INSERT INTO patient(name,age,gender) VALUES(?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,gender);
            int affectedRows=preparedStatement.executeUpdate();
            if(affectedRows>0){
                System.out.println("Patient Inserted Successfully");
            }
            else{
                System.out.println("Failed to add patient");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void viewPatient(){
        String query="SELECT * FROM patient";
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            System.out.println("Patients Record: ");
            System.out.println("*---------*--------------------*-----------*----------*");
            System.out.println("|   ID    |        NAME        |    AGE    |  GENDER  |");
            System.out.println("*---------*--------------------*-----------*----------*");
            while(resultSet.next()){
               int  id=resultSet.getInt("id");
               String name=resultSet.getString("name");
               int age=resultSet.getInt("age");
               String gender=resultSet.getString("gender");
               System.out.printf("|%-9s|%-21s|%-11s|%-10s|\n",id,name,age,gender);
                System.out.println("*---------*--------------------*-----------*----------*");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public boolean getPatientById(int Id){
        String query="SELECT * FROM patient WHERE ID= ?";
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,Id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){return true;}
            else return false;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
