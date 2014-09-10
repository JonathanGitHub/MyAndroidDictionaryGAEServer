/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.jonathan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Administrator
 */
public class DictionaryModelUsingWS {
     private String word;
     private String wordURL;
     private String wordDefinition;
     private URL url;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordURL() {
        return wordURL;
    }

    public String setWordURL(String wordURL) {
        this.wordURL = wordURL;
        return wordURL;
    }

    public String getWordDefinition() {
        return wordDefinition;
    }

    public void setWordDefinition(String wordDefinition) {
        this.wordDefinition = wordDefinition;
    }
     
    public void doWordSearch(String search) {
         word = search.toLowerCase();
         String response = "";
         //note that we muse replace "space" with "%20"
         
        try {
            // Create a URL for the desired page            
            //URL url = new URL("http://www.flicker.com/photos/tags/"+search+"/interesting/");
            //search pattern for etcy.com
            url = new URL("http://www.dictionaryapi.com/api/v1/references/collegiate/xml/"+word+"?key=3c44978a-fe0d-49c2-a841-23d2e47625a0");
            // Create an HttpURLConnection.  This is useful for setting headers and for getting the
            // path of the resource that is returned (which may be different than the URL above if
            // redirected).
            //for debugg
            System.out.println("URL------>" + url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            while ((str = in.readLine()) != null) {
                // str is one line of text; readLine() strips the newline character(s)
                //System.out.println("Response...");
                response += str;
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        
        // find the picture URL to scrape
        //int startfarm = response.indexOf("src=\"http://farm"); 
        //get the header of image url
        try{
             int startfarm = response.indexOf("<dt>");
              System.out.println("startfarm: "+startfarm);
              //int endfarm = response.indexOf("\"", startfarm+5); // only start looking after the quote before http
              int endfarm = response.indexOf("</dt>"); // only start looking after the quote before http
              System.out.println("endfarm: "+ endfarm);
              wordDefinition = checkElement(response.substring(startfarm+4, endfarm)); // +1 to include the quote
              System.out.println("word----->" + word);
              System.out.println("wordDefinition----->" + wordDefinition);
       
        }
        catch(Exception e){
            System.out.println("Please enter a valid English word! Please!");
            wordDefinition = "You've entered an illegal English word! Please type A legal English Word!!!";
        }
              
      
        
        
    }
    public static String checkElement(String word){
        if(word.indexOf("<")==-1){
            return word;
        }
        else{
            int first = word.indexOf("<");
            int second = word.indexOf("</");
            return word.substring(first+4, second);
        }
    }

}
