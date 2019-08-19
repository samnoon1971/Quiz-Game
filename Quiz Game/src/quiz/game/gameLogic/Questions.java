/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.game.gameLogic;

/**
 *
 * @author SAMNOON
 */
public class Questions {
    public String prompt;
    public String answer;
  
    public Questions(String prompt, String answer)
    {
        this.prompt = prompt;
        this.answer = answer;
    }
    public String getPrompt()
    {
        return prompt;
    }
    public String getAnswer()
    {
        return answer;
    }
    public boolean isValidAnswer(String answer)
    {
        if(this.answer.equals(answer))
            return true;
        return false;
    }
    
       
}
