package AnchorTextAndStatistics;

import java.io.*;
import java.util.List;

public class File_with_anchor_txt 
{
	private String file;
	private BufferedWriter bw;
	private BufferedReader br;
	private List<Page> list_of_records;
	
	//constructor
	public File_with_anchor_txt(String file_name, BufferedWriter bw, BufferedReader br, List<Page> record_list) {
		this.file = file_name;
		this.bw = bw;
		this.br = br;
		this.list_of_records = record_list;
	}	
	
	//method add page title to file and separate it with tab \t 
	public void add_page_title(String page_title)
	{		
		try {
			bw.write(page_title + "\t");
		}
		catch (IOException e) 
		{	System.out.println(e.getMessage());	}
	}
	
	//method add anchor text and page link and separate them with tab \t
	public void add_page_anchor(String page_link, String page_anchor)
	{
		try {
			bw.write(page_link + "\t" + page_anchor + "\t");
		}
		catch (IOException e) 
		{	System.out.println(e.getMessage());	}	
	}
	
	//method erase file content
	public void erase_file()
	{	try {
			PrintWriter	wr = new PrintWriter(file);
			wr.print("");
			wr.close();
		} 
		catch (FileNotFoundException e) 
		{	e.printStackTrace();	}		
	}
	
	//method break line in file
	public void file_new_line()
	{	try {
			bw.newLine();
		}
		catch (IOException e) 
		{	System.out.println(e.getMessage());	}
	}
//---------------------------------------------------------
	//method load file content into structured list
	public void load_file_to_record_list(int number_of_rows)
	{
		if(number_of_rows == 0)
		{	number_of_rows = 999999;	}
		
		try {
			String str;
			int i = 0;
			Page page_pom = null;	//pom record 

			while (i < number_of_rows) 
		    {	
				if((str = br.readLine()) != null)
				{
					page_pom = new Page();	//create new record in list
					String [] str_array = str.split("\t");
					page_pom.set_page_title(str_array[0]);	//page title
					int j;
					for(j = 1; (j < (str_array.length-1)); j = j+2)
					{	page_pom.set_anchor(str_array[j], str_array[j+1]);	}	//anchor_link anchor_text
								    	
					list_of_records.add(page_pom);	//add one line from file to structured list
			    	i++;
				}
				else
				{	break;	}
				
		    }
			System.out.print("i = " + i + "\t");
		}
		catch (UnsupportedEncodingException e) 
		{	System.out.println(e.getMessage());	} 
		catch (IOException e) 
		{	System.out.println(e.getMessage());	}
		catch (Exception e)
		{	System.out.println(e.getMessage());	}
	}

	
	//method print number of lines in file
	public void count_file_lines()
	{
		int row_count = 0;
		String str = null;
		try {
			while ((str = br.readLine()) != null)
			{	row_count++;	}
		} 
		catch (IOException e) 
		{	e.printStackTrace();	}
	    System.out.println("File has " + row_count + " rows");
	}
}
