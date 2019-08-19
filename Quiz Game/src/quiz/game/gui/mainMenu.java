/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.game.gui;
import javafx.scene.image.Image;
import quiz.game.gameLogic.*;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author SAMNOON
 */
public class mainMenu extends Application{
    public Stage mainWindow;
    public static int total;
    AskQuiz newSession;
    boolean flag;
    ArrayList <Questions> arr;
    private Random randomQuiz;
    public Scene mainScene, gameScene, settingScene, scoreScene, playScene, aboutScene;
    
    public Button gameButton, exitButton, scoreButton, settingButton, aboutButton;
    
    public static void initGUI()
    {
        launch();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
       
       
       mainWindow = primaryStage;
       newSession = new AskQuiz(); 
       total = newSession.totalQuiz;   
        arr = newSession.getDataFromDB();
       String mainTitle = "Quiz game";
       mainWindow.setTitle(mainTitle);
       Image image = new Image(getClass().getResourceAsStream("quiz.png"));
       mainWindow.getIcons().add(image);
       mainWindow.setOnCloseRequest(e -> {
           e.consume();
           exitProgram();
       });
       
       
       Label welcome = new Label("Welcome to quiz game");
       welcome.setFont(Font.font("Verdana", 18));
      
       
       
       
      /*
       bellow code setups all the buttons and their behaviour when clicked by the user
       */ 
       gameButton = new Button();
       gameButton.setText("New game");
       gameButton.setOnAction(e -> {
           
           invokeGameMenu();
                   });
       
       
       exitButton = new Button();
       exitButton.setText("Exit");
       exitButton.setOnAction(e -> exitProgram());
       
       scoreButton = new Button();
       scoreButton.setText("High Scores");
       scoreButton.setOnAction(e -> {
            invokeScoreMenu();
       });
       
      
       
       settingButton = new Button();
       settingButton.setText("Settings");
       settingButton.setOnAction(e -> {
            invokeSettingMenu();
               });
       
       aboutButton = new Button();
       aboutButton.setText("About");
       aboutButton.setOnAction(e -> {
           invokeAboutMenu();
       });
       /*
       creates a layout for the main menu
       */
       VBox welcomeLayout = new VBox(50);
       /*
       calls method to setupt button dimensions
       */
       buttonSetup(welcomeLayout);
       
       
       welcomeLayout.getChildren().addAll(welcome, gameButton, scoreButton, settingButton, aboutButton, exitButton);
       welcomeLayout.setAlignment(Pos.TOP_CENTER);
       welcomeLayout.setBackground(Background.EMPTY);
       welcomeLayout.setFillWidth(true);
       mainScene = new Scene(welcomeLayout, 1000, 500);
       
       mainWindow.setScene(mainScene);
       mainWindow.show();
       
       
       
    }
    /*
    buttonSetup method will set the font values for mainMenu buttons
    */
    public void buttonSetup(VBox welcomeLayout)
    {
        gameButton.setMinWidth(welcomeLayout.getPrefWidth());
        gameButton.setFont(Font.font("Verdana", 20));
        
        settingButton.setMinWidth(welcomeLayout.getPrefWidth());
        settingButton.setFont(Font.font("Verdana", 20));
        
        scoreButton.setMinWidth(welcomeLayout.getPrefWidth());
        scoreButton.setFont(Font.font("Verdana", 20));
        
        exitButton.setMinWidth(welcomeLayout.getPrefWidth());
        exitButton.setFont(Font.font("Verdana", 20));
        
        aboutButton.setMinWidth(welcomeLayout.getPrefWidth());
        aboutButton.setFont(Font.font("Verdana", 20));
        
        
    }
    
    /*
    exitProgram method will prompt the user to exit if clicked the exitButton
    */
     private void exitProgram()
    {
        CheckBox.display("Quiz Game", "", mainWindow);
       
    }
    
     
     public void invokeGameMenu()
     {
         /*
         this function will call gameMenu  when gamebutton is clicked
         */
         VBox gameLayout = new VBox(50);
         Label gameLabel = new Label();
         gameLabel.setText("New Game");
         gameLabel.setFont(Font.font("Verdana", 20));
        
         Button startGame = new Button();
         startGame.setText("Start game");
         startGame.setFont(Font.font("Verdana", 28));
        
         
         Button backButton = new Button();
         backButton.setFont(Font.font("Verdana", 24));
        
         backButton.setText("Back to main menu");
         backButton.setOnAction(e -> mainWindow.setScene(mainScene));
         
         gameLayout.getChildren().addAll(gameLabel, startGame, backButton);
         gameScene = new Scene(gameLayout, 1000, 500);
         gameLayout.setAlignment(Pos.TOP_CENTER);
         mainWindow.setScene(gameScene);
          mainWindow.show();
          
          startGame.setOnAction(e -> {
             
             newSession.currentScore=0;
             playGame(total);
            
         });
     }
     
     public void invokeAboutMenu()
     {
         VBox aboutLayout = new VBox(50);
         Label aboutLabel = new Label();
         aboutLabel.setText("About project");
         aboutLabel.setFont(Font.font("Verdana", 24));
         Label devOne = new Label();
         Label devTwo = new Label();
         Label CourseInfo = new Label();
         Label CourseTeacher = new Label();
         
         devOne.setText("S M Samnoon Abrar (id: 1106004)");
         devOne.setFont(Font.font("Verdana", 20));
         devTwo.setText("Md. Omar Faruque Fahad (id: 1106017)");
         devTwo.setFont(Font.font("Verdana", 20));
         CourseInfo.setText("Course: Object Oriented Programming Language II (Java)");
         CourseInfo.setFont(Font.font("Verdana", 20));
         CourseTeacher.setText("Course Teacher: Md. Musfiqur Rahman Milton, Lecturer, dept of CSE, BAIUST");
         CourseTeacher.setFont(Font.font("Verdana", 20));
         Button backButton = new Button();
         backButton.setFont(Font.font("Verdana", 20));
        
         backButton.setText("Back to main menu");
         backButton.setOnAction(e -> mainWindow.setScene(mainScene));
         
         aboutLayout.getChildren().addAll(aboutLabel, devOne, devTwo, CourseInfo, CourseTeacher, backButton);
         Scene aboutScene = new Scene(aboutLayout, 1000, 500);
         aboutLayout.setAlignment(Pos.CENTER);
         mainWindow.setScene(aboutScene);
         mainWindow.show();
         
     }
     public void invokeScoreMenu()
     {
         /*
         this function will call scoreMenu  when scorebutton is clicked
         */
         VBox scoreLayout = new VBox(50);
         Label scoreLabel = new Label();
         scoreLabel.setText("Last Score");
         scoreLabel.setFont(Font.font("Verdana", 24));
        
         
         /*
         more codes will be added here
         */
         Label Hscore = new Label();
         Hscore.setText(Integer.toString(newSession.HighScore()));
         Hscore.setFont(Font.font("Verdana", 46));
        
         Button backButton = new Button();
         backButton.setFont(Font.font("Verdana", 20));
        
         backButton.setText("Back to main menu");
         backButton.setOnAction(e -> mainWindow.setScene(mainScene));
         
         scoreLayout.getChildren().addAll(scoreLabel, Hscore, backButton);
         scoreScene = new Scene(scoreLayout, 1000, 500);
         scoreLayout.setAlignment(Pos.TOP_CENTER);
         mainWindow.setScene(scoreScene);
         mainWindow.show();
         
     }
     
     /*
     invokeSettingMenu method will be called after clicking settings button
     */
     
     public void invokeSettingMenu()
     {
         /*
         this function will call settingMenu  when settingbutton is clicked
         */
         VBox settingLayout = new VBox(50);
         
         Label settingLabel = new Label();
         settingLabel.setText("Settings");
         settingLabel.setFont(Font.font("Verdana", 20));
        
         settingLabel.setAlignment(Pos.TOP_CENTER);
         settingLabel.setFont(Font.font("Courier", 14));
         
         /*
         more codes will be added here
         */
         Label select = new Label();
         select.setText("Select Number of Quiz: ");
         select.setFont(Font.font("Verdana", 20));
        
         Button ten = new Button();
         ten.setText("10");
         ten.setFont(Font.font("Verdana", 20));
        
         Button fifteen = new Button();
         fifteen.setText("15");
         fifteen.setFont(Font.font("Verdana", 20));
        
         Button twenty = new Button();
         twenty.setText("20");
         twenty.setFont(Font.font("Verdana", 20));
        
         Button backButton = new Button();
         backButton.setText("Back to main menu");
         backButton.setFont(Font.font("Verdana", 24));
        
         backButton.setOnAction(e -> mainWindow.setScene(mainScene));
         settingLayout.getChildren().addAll(settingLabel, select, ten, fifteen, twenty, backButton);
         ten.setOnAction(e -> {
       
             total = 10;
           
             mainWindow.setScene(mainScene);
             mainWindow.show();
         });
         fifteen.setOnAction(e -> {
       
             total = 15;
             
             mainWindow.setScene(mainScene);
             mainWindow.show();
         });
         twenty.setOnAction(e -> {
  
             total = 20;
            
             mainWindow.setScene(mainScene);
             mainWindow.show();
         });
         settingScene = new Scene(settingLayout, 1000, 500);
         settingLayout.setAlignment(Pos.CENTER);
         mainWindow.setScene(settingScene);
         mainWindow.show();
         
         
     }
     /*
     ShowHighScore method will be called after the game is over and it will show final score
     */
     public void ShowHighScore()
     {
         VBox showScore = new VBox(50);
         Scene showScene = new Scene(showScore, 1000, 500);
         mainWindow.setScene(showScene);
         mainWindow.show();
         Label yourScore = new Label();
         yourScore.setText("Your Score is: " + Integer.toString(newSession.currentScore));
         yourScore.setAlignment(Pos.CENTER);
         yourScore.setFont(Font.font("Verdana", 20));
        
         total=10;
         Button save = new Button();
         save.setText("Save");
         save.setMaxWidth(Double.MAX_VALUE);
         save.setFont(Font.font("Verdana", 20));
        
         save.setOnAction(e->{
            
             newSession.Hscore=newSession.currentScore;
         });
         Button back = new Button();
         back.setText("Back");
         back.setFont(Font.font("Verdana", 20));
        
         back.setMaxWidth(Double.MAX_VALUE);
         back.setOnAction(e->mainWindow.setScene(mainScene));
         showScore.getChildren().addAll(yourScore, save, back);
     }
     
     /*
     waitScene method will show the state of current quiz
     */
     public void waitScene(int total, boolean flag, String answer)
     {
         VBox delayout = new VBox(50);
         Scene deScene = new Scene(delayout, 1000, 500);
         mainWindow.setScene(deScene);
         
         mainWindow.show();
         Label showCorrect = new Label();
             
         Label showValidity = new Label();
         if(flag==true)
             showValidity.setText("Correct answer     +10 Points");
         else
         {
             showValidity.setText("Wrong answer      -10 points");
             showCorrect.setText("Correct answer is: " + answer);
             showCorrect.setAlignment(Pos.CENTER);
             showCorrect.setFont(Font.font("Verdana", 20));
         
         }
         showValidity.setFont(Font.font("Verdana", 20));
        
        Label remQuiz = new Label();
        remQuiz.setText(Integer.toString(total) + " quizes Remaining");
        remQuiz.setFont(Font.font("Verdana", 20));
         
         Button nextButton = new Button();
         nextButton.setText("Go To Next Quiz");
         nextButton.setMaxWidth(Double.MAX_VALUE);
         nextButton.setFont(Font.font("Verdana", 20));
        
         nextButton.setOnAction(e->{
             playGame(total);
         });
         if(flag==true)
            delayout.getChildren().addAll(showValidity, remQuiz, nextButton);
         else
            delayout.getChildren().addAll(showValidity, showCorrect, remQuiz, nextButton);
             
     }
     
     
     /*
     playGame is a recursive method that will run total number of quizes equal to the predefined value 
     of variable total
     */
     public void playGame(int total)
     {
         if(total==0)
         {
             dialogBox();
             return;
         }
         VBox playLayout = new VBox(50);
         
         gameScene = new Scene(playLayout, 1000, 500);
         mainWindow.setScene(gameScene);
         mainWindow.show();
        
            
            
             Random rd = new Random();
             Questions q = arr.get(rd.nextInt(arr.size()));
             Label newQuiz = new Label();
             newQuiz.setAlignment(Pos.CENTER);
             newQuiz.setText(q.getPrompt());
             newQuiz.setFont(Font.font("Verdana", 12));
        
             Button A = new Button();
             Button B = new Button();
             Button C = new Button();
             Button D = new Button();
             A.setText("a");    
             B.setText("b");
             C.setText("c");
             D.setText("d");
             A.setFont(Font.font("Verdana", 22));
             B.setFont(Font.font("Verdana", 22));
             C.setFont(Font.font("Verdana", 22));
             D.setFont(Font.font("Verdana", 22));
        
             A.setMaxWidth(Double.MAX_VALUE);
             
             B.setMaxWidth(Double.MAX_VALUE);
             
             C.setMaxWidth(Double.MAX_VALUE);
             
             D.setMaxWidth(Double.MAX_VALUE);
             flag=false;
             A.setOnAction(e->{
                 if(q.getAnswer().equals("A"))
                 {
                    flag=true;
                    newSession.currentScore+=10; 
                 }
                 else
                 {
                     newSession.currentScore-=10;
                 }
                 
                 waitScene(total-1, flag, q.getAnswer());
                
                 
             });
             
             
             
             B.setOnAction(e->{
                 if(q.getAnswer().equals("B"))
                 {
                     flag=true;
                    newSession.currentScore+=10; 
                 }
                 else
                 {
                     newSession.currentScore-=10;
                 }
                  
                  waitScene(total-1, flag, q.getAnswer());
                
             });
             
         
             
             C.setOnAction(e->{
                 if(q.getAnswer().equals("C"))
                 {
                     flag=true;
                    newSession.currentScore+=10; 
                 }
                 else
                 {
                     newSession.currentScore-=10;
                 }
                  
                waitScene(total-1, flag, q.getAnswer());
             });
             
             
             D.setOnAction(e->{
                 if(q.getAnswer().equals("D"))
                 {
                     flag=true;
                    newSession.currentScore+=10; 
                 }
                 else
                 {
                     newSession.currentScore-=10;
                 }
                  
                waitScene(total-1, flag, q.getAnswer());
             });
             
             
             playLayout.getChildren().addAll(newQuiz, A, B, C, D);
             
         
         
     }
    
     
     /*
     dialogBox method will save latest score after the quiz game is over
     */
    public void dialogBox()
    {
        Label savelabel = new Label();
        savelabel.setText("Game over");
        savelabel.setFont(Font.font("Verdana", 20));
        
        
        Button done = new Button("Show Score");
        done.setFont(Font.font("Verdana", 20));
        
        done.setMaxWidth(Double.MAX_VALUE);
        done.setOnAction(e -> 
        {
            
            ShowHighScore();
        });
        Button back = new Button();
        back.setText("Back");
        back.setFont(Font.font("Verdana", 20));
        back.setMaxWidth(Double.MAX_VALUE);
        back.setOnAction(e->{
            mainWindow.setScene(mainScene);
        });
        VBox scoreLayout = new VBox(50);
        scoreLayout.getChildren().addAll(savelabel, done, back);
        Scene scoreScene = new Scene(scoreLayout, 1000, 500);
        scoreLayout.setAlignment(Pos.CENTER);
        mainWindow.setScene(scoreScene);
        mainWindow.show();
    }
}
  

