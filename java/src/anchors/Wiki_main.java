package src;

import java.io.*;
import java.util.*;
import javax.swing.JTextArea;

/**
 *  Wiki_main.java
 *
 *  Entry point of the program. 
 *  Launching this class will start execution of program.
 *
 *@author	$Author: Filip Blanarik $
 */
public class Wiki_main 
{
    public static void main (String[] args) throws Exception
    {
	String file_input = "../data/sample_input_enwiki-pages-articles-123.xml";
	//String file_input = "../data/enwiki-latest-pages-articles.xml";
	String file_output = "../data/program_anchor_output.txt";
	List<Page> record_list = new ArrayList<Page>();
	JTextArea jTextArea1 = new javax.swing.JTextArea();
        

	//Extract Anchor -----------------------------------------------------
            BufferedWriter bw =	new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_output, true),"UTF-8"));
            BufferedReader br =	new BufferedReader(new InputStreamReader(new FileInputStream(file_output), "UTF8"));
            File_with_anchor_txt file = new File_with_anchor_txt(file_output, bw, br, record_list, jTextArea1);
            Parse_XML_wiki xmlw = new Parse_XML_wiki(file_input, file, jTextArea1);
		
            file.erase_file();			//delete existing record in file
            xmlw.read_wiki();			//extract page title, anchor link and anchor text from file input
            bw.close();	//close text file
            br.close();

	//Create Statistics ------------------------------------------------------
	//  file_input = "../data/anchor_program_output_complete.txt";		//extracted pages and anchors from whole wikipedia
            file_input = "../data/program_anchor_output.txt";
            BufferedReader brstat = new BufferedReader(new InputStreamReader(new FileInputStream(file_input), "UTF8"));
            File_with_anchor_txt fa = new File_with_anchor_txt(file_output, null, brstat, record_list, jTextArea1);
            Statistics stat = new Statistics(brstat, fa, record_list, jTextArea1);
		
            //fa.load_file_to_record_list(3);
            //stat.print_list();
            //fa.count_file_lines();
			
            //	stat.return_page_with_biggest_amount_of_anchor();
            Map<String, Frequencies> map;
            map = stat.hash_map(0);	//1 -> hash_map of anchor_text | 0 -> hash_map of anchor_links
            //stat.iterate_hash_map(map,0);
            brstat.close();
			
            //	System.out.println("Map size: " + map.size() + "  Archaeological | Df: "+ map.get("Archaeological").get_Df() + " Cf: "+ map.get("Archaeological").get_Cf());
			
            //System.out.println("\n\nSORTED MAP:");
            Map<String, Frequencies> SortedMap;
	
            SortedMap = stat.sort_hash_map_CF(map);
            System.out.println("\nSortet by CF");
            stat.iterate_hash_map(SortedMap, 10);
            stat.print_hash_map_to_file(SortedMap, 0, "../data/Statistics/program_output_sorted_anchor_link_CF .TXT");
			
            SortedMap = stat.sort_hash_map_DF(map);
            System.out.println("\nSortet by DF");
            stat.iterate_hash_map(SortedMap, 10);
            stat.print_hash_map_to_file(SortedMap, 0, "../data/Statistics/program_output_sorted_anchor_link_DF .TXT");
			
            stat.average_CF_DF(map);
    } 
}