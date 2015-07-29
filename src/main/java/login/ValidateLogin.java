/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author cameronthomas
 */
public class ValidateLogin {
    public boolean validate(String username, String password) 
    {
        boolean validLogin = false;
 
        Object obj = new FileIO().readFile("userData.json");
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
            
        return validLogin;
    }   
}
