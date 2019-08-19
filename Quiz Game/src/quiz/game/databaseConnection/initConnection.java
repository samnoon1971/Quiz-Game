/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.game.databaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import quiz.game.gameLogic.Questions;

/**
 *
 * @author SAMNOON
 */
public class initConnection {
    public static ArrayList <Questions> questionSet;
    public initConnection()
    {
        questionSet = new ArrayList<>();
    }
    public static ArrayList setupDB()
    {
        String address = "jdbc:derby://localhost:1527/QuizDB";
        String userName = "samnoon";
        String password = "12345";
        Connection connect = null;
        Statement state = null;
        ResultSet newSet = null;
        
        
        
        /*
          this query will fetch all data from the sports table from the database
        */
        String query = "SELECT * FROM SAMNOON.SPORTS";
        try{
            connect = DriverManager.getConnection(address, userName, password);
            state = connect.createStatement();
            newSet = state.executeQuery(query);
            
            
            
          /*
            Bellow while loop will add the questions and their answers into the arrayList
            */
            
        while(newSet.next())
        {
            String prompt = newSet.getString("QUESTION");
            String answer = newSet.getString("ANSWER");
            Questions newQuestion = new Questions(prompt, answer);
            questionSet.add(newQuestion);
        }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        
       /*
        This will return the arrayList of questions and answers to it's caller 
        */
        return questionSet;
        
    }
    
    
    
}
