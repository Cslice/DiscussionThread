/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger; 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author cameronthomas
 */
public class ValidateLogin {
    public boolean validate(String username, String password) 
    {
        boolean validLogin = false;
        new WriteOpenShiftUserFile().writeFileToOpenshift("userData.json");
        
        JSONParser parser = new JSONParser();

        try 
        {
            Object obj = parser.parse(new FileReader(System.getenv("OPENSHIFT_DATA_DIR") + "userData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray userArray = (JSONArray)jsonObject.get("users");
            JSONObject jsonUser;
                       
            for(Object user: userArray)
            {
                jsonUser = (JSONObject)user;
    
                if(jsonUser.get("username").toString().equals(username) 
                   && jsonUser.get("password").toString().equals(password))
                {
                    validLogin = true;
                    break;
                }
            }
            
        }
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(ValidateLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex)
        {
            Logger.getLogger(ValidateLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ParseException ex) 
        {
            Logger.getLogger(ValidateLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
        return validLogin;
    }   
}
