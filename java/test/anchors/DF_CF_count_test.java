package test;

import src.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
import javax.swing.JTextArea;
import org.junit.Test;


/**
 *  DF_CF_count_test.java
 *
 *  Launching this class will perform test with hash map 
 *  and check validity of values in hash map by
 *  comparing them with expected values. 
 *
 *@author	$Author: Filip Blanarik $
 */
public class DF_CF_count_test {
	
	
    /**
     *	setUp
     *
     *	Preparation for testing
     *	Method create and populate has map with values
     *
     *@return map
     *@throws java.lang.Exception
     */
    public Map<String, Frequencies> setUp() throws Exception
    {								 
	JTextArea jTextArea1 = new javax.swing.JTextArea();
        
        List<Page> record_list = new ArrayList<Page>();
	String file_input = "../data/program_anchor_output.txt";
	String file_output = null;
	BufferedReader brstat = new BufferedReader(new InputStreamReader(new FileInputStream(file_input), "UTF8"));
	File_with_anchor_txt fa	= new File_with_anchor_txt(file_output, null, brstat, record_list,jTextArea1);
	Statistics stat	= new Statistics(brstat, fa, record_list, jTextArea1);
	Map<String, Frequencies> map;
	map = stat.hash_map(1);	//0 -> hash_map of anchor_links
		
	brstat.close();		//close text file
		
	return map;
    }
	
    /**
     *	test()
     *
     * Execute and validate test with hash map
     * @throws java.lang.Exception
     */
    @Test
    public void test() throws Exception
    {
	Map<String, Frequencies> map;
	map = setUp();		
		
	String file_input = "../data/sample_df_cf_test.txt";
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file_input), "UTF-8"));
		
	try {
            String str;
            int DF = 0;
            int CF = 0;
            String link = null;
            while((str = br.readLine()) != null )
            {	
		String [] str_array = str.split("\t");
				
		link = str_array[0]; 
		DF = Integer.parseInt(str_array[1]);	
		CF = Integer.parseInt(str_array[2]);
		//System.out.println(link + " " + DF + "  " + CF);
				
		if(map.containsKey(link) == true)
		{
                    assertEquals(CF, map.get(link).get_Cf());
                    assertEquals(DF, map.get(link).get_Df());
								
                    //System.out.print(link + "\t\t\tCF: " + CF + " " + map.get(link).get_Cf()+ " ");
                    //System.out.println("\t\t\tDF: " + DF + " " + map.get(link).get_Df());
		}
            }
	}
	catch (UnsupportedEncodingException e) 
	{   System.out.println(e.getMessage()); } 
	catch (IOException e) 
	{   System.out.println(e.getMessage()); }
	catch (Exception e)
	{   System.out.println(e.getMessage()); }
		
	br.close();	//close text file
    }
}
