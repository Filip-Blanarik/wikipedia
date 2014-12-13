package src;

import java.awt.Color;
import java.io.*;
import java.util.List;
import javax.swing.JTextArea;

/**
 *  File_with_anchor.java
 *
 *  Class has methods for write, read and erase selected file 
 *
 *@author	$Author: Filip Blanarik $
 */
public class File_with_anchor_txt 
{
    private String file;
    private BufferedWriter bw;
    private BufferedReader br;
    private List<Page> list_of_records;
    private JTextArea jTextArea1;
    
    /**
     * File_with_anchor_txt
     * constructor of class File_with_anchor_txt
     * @param file_name
     * @param bw
     * @param br
     * @param record_list
     * @param jTextArea1
     */
    public File_with_anchor_txt(String file_name, BufferedWriter bw, BufferedReader br, List<Page> record_list, JTextArea jTextArea1)
    {
	this.file = file_name;
	this.bw = bw;
	this.br = br;
	this.list_of_records = record_list;
        this.jTextArea1 = jTextArea1;
    }	
	
    /**
     * add_page_title
     * method add page title to file and separate it with tab \t 
     * @param page_title 
     */
    public void add_page_title(String page_title)
    {		
	try {
            bw.write(page_title + "\t");
	}
	catch (IOException e) 
	{   System.out.println(e.getMessage());	
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(e.getMessage());
        }
    }
	
    /**
     * add_page_anchor
     * method add anchor text and page link and separate them with tab \t
     * @param page_link
     * @param page_anchor 
     */
    public void add_page_anchor(String page_link, String page_anchor)
    {
    	try {
            bw.write(page_link + "\t" + page_anchor + "\t");
	}
	catch (IOException e) 
	{   System.out.println(e.getMessage()); 
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(e.getMessage());
        }	
    }
	
    /**
     * erase_file
     * method erase file content
     */
    public void erase_file()
    {	
        try {
            PrintWriter	wr = new PrintWriter(file);
            wr.print("");
            wr.close();
	} 
	catch (FileNotFoundException e) 
	{   e.printStackTrace();    
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(e.getMessage());
        }		
    }
	

    /**
     * file_new_line
     * method break line in file
     */
    public void file_new_line()
    {	
        try {
            bw.newLine();
	}
	catch (IOException e) 
	{   System.out.println(e.getMessage()); 
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(e.getMessage());
        }
    }
//---------------------------------------------------------
    /**
     * load_file_to_record_list
     * method load file content into structured list
     * @param number_of_rows 
     */
    public void load_file_to_record_list(int number_of_rows)
    {
	if(number_of_rows == 0)
	{   number_of_rows = 999999;    }
	
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
                    {	page_pom.set_anchor(str_array[j], str_array[j+1]);  }	//anchor_link anchor_text
								    	
                    list_of_records.add(page_pom);	//add one line from file to structured list
                    i++;
		}
		else
		{   break;  }
				
            }
            System.out.print("i = " + i + "\t");
        }
	catch (UnsupportedEncodingException e) 
        {   System.out.println(e.getMessage());	
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(e.getMessage());
        } 
	catch (IOException e) 
	{   System.out.println(e.getMessage());	
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(e.getMessage());
        }
	catch (Exception e)
	{   System.out.println(e.getMessage());	
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(e.getMessage());
        }
    }

    /**
     * count_file_lines     * 
     * method print number of lines in file
     */
    public void count_file_lines()
    {
        int row_count = 0;
	try {
            while ((br.readLine()) != null)
            {	row_count++;    }
	} 
	catch (IOException e) 
	{   e.printStackTrace();    
            jTextArea1.setForeground(Color.red);
            jTextArea1.setText(e.getMessage());
        }
        System.out.println("File has " + row_count + " rows");
    }
}