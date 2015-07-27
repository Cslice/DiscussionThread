/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author cameronthomas
 */
public class WriteOpenShiftUserFile {
    public void writeFileToOpenshift(String fileName)
    {
        String data = "{'users':[{'username':'cameron', 'password':'thomas'},{'username':'sburton', 'password':'securepassword'}]}";
        data = data.replaceAll("'", "\"");
        
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                  new FileOutputStream(System.getenv("OPENSHIFT_DATA_DIR") + fileName), "utf-8"));
            writer.write(data);
        } catch (IOException ex) {
          ex.printStackTrace();
        } finally {
           try {writer.close();} catch (Exception ex) {/*ignore*/}
        }   
    }
    
}
