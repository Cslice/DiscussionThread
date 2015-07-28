/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author cameronthomas
 */
public class FileIO {
    public void writeFile(String fileName, String data)
    {
        Writer writer = null;
                      
        //Test to see if we are in the openshift enviroment
        if(System.getenv("OPENSHIFT_DATA_DIR") != null)
        {
            fileName = System.getenv("OPENSHIFT_DATA_DIR") + "userData.json";
        }
                     
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                  new FileOutputStream(fileName), "utf-8"));
            writer.write(data);
        } catch (IOException ex) {
          ex.printStackTrace();
        } finally {
           try {writer.close();} catch (Exception ex) {/*ignore*/}
        }   
    }
    
    public Object readFile(String fileName)
    {
        Object objectFile = null;
        JSONParser parser = new JSONParser();
        
        //Test to see if we are in the openshift enviroment
        if(System.getenv("OPENSHIFT_DATA_DIR") != null)
        {
            fileName = System.getenv("OPENSHIFT_DATA_DIR") + "userData.json";
        }
        
        try {
            objectFile = parser.parse(new FileReader(fileName));
                  
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return objectFile;
    }   
}
