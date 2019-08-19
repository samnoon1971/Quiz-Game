/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.game.gameLogic;

import java.util.ArrayList;
import quiz.game.databaseConnection.*;
/**
 *
 * @author SAMNOON
 */
public class AskQuiz {
    public int currentScore;
    public int totalQuiz;
    public initConnection connection;
    public static ArrayList <Questions> questionSet;
    public int Hscore;
    public AskQuiz()
    {
        Hscore=0;
        currentScore = 0;
        totalQuiz=10;
        questionSet = new ArrayList<>();
    }
    public int getQuiz()
    {
        return totalQuiz;
    }
    
    /*
    getDataFromDB method will collect data from the database and then store the contents
    in a arraylist and then return it
    */
    public ArrayList getDataFromDB()
    {
         connection = new initConnection();
        
        questionSet = connection.setupDB();
        if(questionSet.isEmpty()==false)
        {
            System.out.println("Connection successfull");
            System.out.println("Data sucessfully fetched from the database...");
        }
        else
        {
            System.out.println("Connection failed.. empty database");
        }
        return questionSet;
    }
    
   
    public void setTotalQuiz(int totalQuiz)
    {
        this.totalQuiz = totalQuiz;
    }
    public int getScore()
    {
        return currentScore;
    }
    public int HighScore()
    {
        return Hscore;
    }
}
