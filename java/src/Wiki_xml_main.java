package AnchorTextAndStatistics;

import java.io.*;
import java.util.*;

public class Wiki_xml_main 
{
	public static void main (String[] args) throws Exception
	{
		String file_input = "../data/sample_input_enwiki-pages-articles-123.xml";
		//String file_input = "../data/enwiki-latest-pages-articles.xml";
		String file_output = "../data/anchor_program_output.txt";
		List<Page> record_list = new ArrayList<Page>();
		
		//-----------------------------------------------------
		//Extract Anchor
		BufferedWriter bw 			=	new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_output, true),"UTF-8"));
		BufferedReader br 			=	new BufferedReader(new InputStreamReader(new FileInputStream(file_output), "UTF8"));
		File_with_anchor_txt file 	= 	new File_with_anchor_txt(file_output, bw, br, record_list);
		XML_wiki xmlw 				=	new XML_wiki(file_input, file);
				
		//file.erase_file();		//delete existing record in file
		//xmlw.read_wiki();		//extract page title, anchor link and anchor text from file input
		bw.close();	//close text file
		br.close();
		//------------------------------------------------------
		//Create Statistics
		file_input = "../data/anchor_program_output_complete.txt";
		//file_input = "../data/anchor_program_output.txt";
		BufferedReader brstat 		=	new BufferedReader(new InputStreamReader(new FileInputStream(file_input), "UTF8"));
		File_with_anchor_txt fa		= 	new File_with_anchor_txt(file_output, null, brstat, record_list);
		Statistics stat				=	new Statistics(fa, record_list);
		
		//fa.load_file_to_record_list(3);
		//stat.print_list();
		//fa.count_file_lines();
		
		stat.return_page_with_biggest_amount_of_anchor();
		brstat.close();
		
	}
}
