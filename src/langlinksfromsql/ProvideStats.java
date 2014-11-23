package langlinksfromsql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ProvideStats {
    
    private static BufferedReader br;
    private static Writer writer;

    public static void provideStats(String secondLang) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        // method outputs no. of sk->lang2 and lang2->sk matches
        String fileToBeOpened = ("../data/output_data_sk-");
        fileToBeOpened = fileToBeOpened.concat(secondLang).concat("-matches.txt");
        String fileToWrite = ("../data/output_stats_sk-");
        fileToWrite = fileToWrite.concat(secondLang).concat(".txt");
        br = FileReadManager.initReader(fileToBeOpened, br);
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileToWrite), "utf-8"));
        String line;
        int countLines = 0;
        
        while((line = br.readLine())!= null){
            if(line.contains(" -> ")) {                                         /// no. of matches 1st lang -> 2nd lang
                writer.write("No. of matches from 1st language to 2nd: "+countLines);
                writer.append('\n');
                countLines = 0;
                continue;
            }
            countLines++;                                                       /// counting 2nd lang -> 1st lang matches
        }
        writer.write("No. of matches from 2nd language to 1st: "+countLines);
        writer.append('\n');
        
        br.close();
        
    }

    public static void getDifferences(String secondLang) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        // method outputs (writes into the output file) matches that do not match reversely
        String fileToBeOpened = ("../data/output_data_sk-");
        fileToBeOpened = fileToBeOpened.concat(secondLang).concat("-matches.txt");
        br = FileReadManager.initReader(fileToBeOpened, br);
        List<String> Matches = new ArrayList<String>();                         // an arraylist to be checked with the other
        String line;                                                            // 'half' - to look for differences
        String NewLine;                                                         // convert the match output to make use of
                                                                                // string.equals
        ///constructing the arraylist with the 'half' of found matches (sk->lang2)        
        if(secondLang.equals("hu")){
            while(((line = br.readLine())!= null) && (!line.contains(" -> "))){
                // if statement significantly decreases the length of string
                if(!(line.contains("Wikipédia:") || line.contains("user:") || line.contains("User:") || line.contains("Sablon:") 
                        || line.contains("Szerkesztő:") || line.contains("Kategória:")|| line.contains("Portál:") 
                        || line.contains("Modul:") || line.contains("/"))) Matches.add(line);
            }
        }
        else if(secondLang.equals("en")){
            while(((line = br.readLine())!= null) && (!line.contains(" -> "))){
                // if statement significantly decreases the length of string
                if(!(line.contains("Wikipedia:") || line.contains("user:") || line.contains("User:") || line.contains("Template:") 
                        || line.contains("Category:")|| line.contains("Portal:") 
                        || line.contains("Module:") || line.contains("/"))) Matches.add(line);
            }            
        }
        else System.err.println("unsupported language");
        /// end of constructing the arraylist with the 'half' of found matches (sk->lang2)

        while((line = br.readLine())!= null){
            // checking if the lang2->sk match is contained in the array sk->lang2... if not, write into file
            NewLine = line.substring(line.indexOf(" matches ")+9, line.lastIndexOf(')')+1);
            NewLine = NewLine.concat(" matches ").concat(line.substring(0, line.indexOf(" matches ")));
            if(Matches.contains(NewLine)) Matches.remove(NewLine);
            else if(!(NewLine.contains("Wikipédia:") || NewLine.contains("Pomoc:") || NewLine.contains("Šablóna:") 
                    || NewLine.contains("Redaktor:") || NewLine.contains("Kategória:") || NewLine.contains("user:")
                    || NewLine.contains("User:") || NewLine.contains("Portál:") || NewLine.contains("Modul:")
                    || line.contains("/"))) {
                writer.write(NewLine);
                writer.append('\n');
            }
        }
        for(int i = 0; i < Matches.size(); ++i) {
            writer.write(Matches.get(i));
            writer.append('\n');
        }
        
        writer.close();
        br.close();
    }
}
