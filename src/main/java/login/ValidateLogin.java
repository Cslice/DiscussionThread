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
        
        // Write user file to data directory on openshift
        String data = "{'users':[{'username':'cameron', 'password':'thomas'},{'username':'sburton', 'password':'securepassword'}]}";
        data = data.replaceAll("'", "\"");
   
        new FileIO().writeFile("userData.json", data);
 
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
