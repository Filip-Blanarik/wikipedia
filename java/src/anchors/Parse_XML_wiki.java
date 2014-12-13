package src;

import java.awt.Color;
import java.io.*;
import java.util.regex.*;
import javax.swing.JTextArea;

/**
 *  Parse_XML_wiki.java
 *
 *  Methods in this class parse selected XML file and extract page title,
 *  and anchor link / text 
 *
 *@author	$Author: Filip Blanarik $
 */
public class Parse_XML_wiki 
{
    private InputStream ins = null; 	// raw byte-stream
    private Reader r = null; 		// cooked reader
    private BufferedReader br = null; 	// buffered for readLine()


    private String path;		//wikipedia xml dump path
    private File_with_anchor_txt file;	
    private JTextArea jTextArea1;

    /**
     * Parse_XML_wiki
     * constructor of class Parse_XML_wiki 
     * @param path
     * @param file
     * @param jTextArea1
     */
    public Parse_XML_wiki(String path, File_with_anchor_txt file, JTextArea jTextArea1)
    {
	this.path = path;
	this.file = file;
        this.jTextArea1 = jTextArea1;
    }

    /**
     * read_wiki
     * Method read wikipedia dump and search for page_title, page_link and page_anchor
     * @throws Exception 
     */
    public void read_wiki () throws Exception
    {
        int i = 0;
	int j = 0;
	int k = 0;

        Pattern p_title = Pattern.compile("(<title>)(.+)(</title>)");	//compile regular expression for finding page title
	Pattern p_anchor = Pattern.compile("\\[\\[([^:\\]]+?)\\|(.+?)\\]\\]|\\[\\[([^:\\|]+?)\\]\\](\\p{L}*)");	//compile regular expression for anchor and link
	Matcher m_title = null;
	Matcher m_anchor = null;
		
	try 
	{   String s;
	    ins = new FileInputStream(path);
	    r = new InputStreamReader(ins, "UTF-8"); 
	    br = new BufferedReader(r);
	    
	    while ((s = br.readLine()) != null)// && i < 100) 
	    {	//System.out.println(s);	
	    	m_title = p_title.matcher(s); 
	    	while(m_title.find())	// if page title is found
	    	{
                    if(j>0)	{ file.file_new_line();	}	// if is not first line of file: new page title at new line 
		    file.add_page_title(m_title.group(2).trim());	//write page title to the file
		    j++;
		}
		    	
	    	m_anchor = p_anchor.matcher(s);
		while(m_anchor.find())	//if page anchor and link is found
		{
                    //group 1 = anchor_link	//group 2 = anchor_text	//group 3 = anchor_link when anchor_text is not presented
		    //group 4 = text after anchor when anchor_text is not presented
		    if(m_anchor.group(3) != null)	//if anchor text is not presented
		    {	file.add_page_anchor(m_anchor.group(3).trim(), m_anchor.group(3).trim().concat(m_anchor.group(4))); }
		    else
		    {	file.add_page_anchor(m_anchor.group(1).trim(), m_anchor.group(2).trim());   }
		    k++;
		}
		i++;
            }
            System.out.println("Loaded Rows: "+ i + " |  Loaded pages: " + j + "| Loaded anchors: " + k);
            jTextArea1.setForeground(Color.black);
            jTextArea1.setText("Loaded Rows: "+ i + " |  Loaded pages: " + j + "| Loaded anchors: " + k + "\n");
	}
	catch (Exception e)
	{   System.err.println(e.getMessage());    
            jTextArea1.setForeground(Color.red);    jTextArea1.setText(e.getMessage());
        }	 // handle exception
	finally 
	{   if (br != null) { try { br.close(); } catch(Throwable t) { /* ensure close happens */ } }
	    if (r != null) { try { r.close(); } catch(Throwable t) { /* ensure close happens */ } }
	    if (ins != null) { try { ins.close(); } catch(Throwable t) { /* ensure close happens */ } }
	}
    }
}