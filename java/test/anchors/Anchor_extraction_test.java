package test;

import static org.junit.Assert.*;
import java.io.*;
import javax.swing.JTextArea;
import org.junit.Test;
import src.*;

/**
 *  Anchor_extraction_test.java
 *
 *  Launching this class will perform test with page title, 
 *  anchor link and anchor text extraction  
 *  and check validity of extraction by
 *  comparing with expected values. 
 *
 *@author	$Author: Filip Blanarik $
 */
public class Anchor_extraction_test {
	
    /**
     *	setUp
     *
     *	Preparation for testing
     *@throws java.lang.Exception
     */
    public void setUp() throws Exception
    {
        JTextArea jTextArea1 = new javax.swing.JTextArea();
        
        String file_input = "../data/sample_input_enwiki-pages-articles-123.xml";
	String file_output = "../data/program_output_anchor_test.txt";
	        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_output, true),"UTF8"));
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file_output), "UTF8"));
	File_with_anchor_txt file = new File_with_anchor_txt(file_output, bw, br, null, jTextArea1);
	Parse_XML_wiki xmlw = new Parse_XML_wiki(file_input, file, jTextArea1);
		
	file.erase_file();	
	xmlw.read_wiki();
	bw.close();	//close text file
	br.close();
    }
	
    /**
     *	test()
     *
     *	Execute and validate test with anchor link extraction
     * @throws java.lang.Exception
     */
    @Test
    public void test() throws Exception
    {
	setUp();		
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("../data/program_output_anchor_test.txt"), "UTF8"));
	BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("../data/sample_anchor_extraction_test.txt"), "UTF8"));
		
	String str_real_output = "";
	String str_expected_output = "";
		
	try {
            //real output
            String str;
            while((str = br.readLine()) != null)
            {	str_real_output = str_real_output + str + "\n";	}
			
            //expected output
            String str2;
            while((str2 = br2.readLine()) != null)
            {	str_expected_output = str_expected_output + str2 + "\n";    }
	}
	catch (UnsupportedEncodingException e) 
	{   System.out.println(e.getMessage()); } 
	catch (IOException e) 
	{   System.out.println(e.getMessage()); }
	catch (Exception e)
	{   System.out.println(e.getMessage()); }
		
	assertEquals(str_expected_output, str_real_output);
		
	br.close();	//close text file
	br2.close();
    }
}
