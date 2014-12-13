package src;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.Map.Entry;
import javax.swing.JTextArea;


/**
 *  Statistics.java
 *
 *  Perform statistics count for specified file	
 *
 *@author	$Author: Filip Blanarik $
 */
public class Statistics {
	
    private File_with_anchor_txt class_file;	
    private List<Page> record_list;
    private BufferedReader br;
    private JTextArea jTextArea1;
	
    /**
     * Statistics
     * constructor of class Statistics 
     * @param br
     * @param class_file
     * @param record_list
     * @param jTextArea1
     */
    public Statistics(BufferedReader br, File_with_anchor_txt class_file, List<Page> record_list, JTextArea jTextArea1)
    {
	this.class_file = class_file;
	this.record_list = record_list;
	this.br = br;
        this.jTextArea1 = jTextArea1;
    }
	
    /**
     *	print_list
     *
     *	Read all values from collection list and print them on System.out
     */
    public void print_list()
    {
    	for(Page e: record_list)
	{
            System.out.println(e.return_page_title());
            for(Anchor a: e.return_anchor_list())
            {
		System.out.println("\t" + a.return_anchor_link() + "\t" +a.return_anchor_text());
            }
	}
    }
	
    /**
     *	return_page_with_biggest_amount_of_anchor
     *  
     *	Read specified file and count number of anchor links in pages.
     *  Method is implemented in very inefficient way
     *
     *@return page_pom - page with largest number of anchor links 
     */	
    public String return_page_with_biggest_amount_of_anchor()
    {
    	int anchor_count; 
	int max = -9999999;
	String page_pom = null;
				
	int number_of_rows = 10000;
		
	int i;
	for(i=0;i<10000;i++) 
	{	
            class_file.load_file_to_record_list(number_of_rows);
            if(record_list.isEmpty() == true)	
            {	
                System.out.println("Record list is empty");
		break;	
            }
            for(Page e: record_list)
            {
		anchor_count = 0; 
		//System.out.println(e.return_page_title());
		for(Anchor a: e.return_anchor_list())
		{
                    anchor_count++;
                    //System.out.println("\t" + a.return_anchor_link() + "\t" +a.return_anchor_text());
		}
				
		if(anchor_count > max)
		{
                    max = anchor_count;
                    page_pom = e.return_page_title();
		}	
            }
            System.out.println("Index: " + i + "| " + record_list.size() + "\t" + page_pom + "\t" + max);
            record_list.clear();
            System.gc();
        }
			
	System.out.println("Page with biggest amount of anchor: " + page_pom + "  Počet: " + max);
		
	return page_pom;
    }
	
    /**
     *	hash_map
     *
     *	Create hash map with 
     *      - anchor_link as key or anchor_text as key 
     *      - anchor_link as key if link_or_text = 0;
     *      - anchor_text as key if link_or_text = 1;
     *      - CF (collection frequency)
     *      - DF (document frequency)
     *	values assigned to a key
     *
     *@param link_or_text
     *@return map 
     */
    public Map<String, Frequencies> hash_map(int link_or_text)
    {	//key , value
	Map<String, Frequencies> map = new HashMap<String, Frequencies>();	
	//put(key,value)-storing
	//get(key)	-retrieving
		
	try {
            String str;
            int i = 0;
            int j;
            int pom = 0;
            int number_of_anchors = 0;

            while(((str = br.readLine()) != null))
            {	
		String [] str_array = str.split("\t");

		if(link_or_text == 1)	//1 -> hash_map of anchor_text
		{	j = 2;	}
		else if(link_or_text == 0)	//0 -> hash_map of anchor_links
		{	j = 1;	}
		else	{	j = 0;	}
				
		for(;(j < (str_array.length)); j = j+2)	//anchor_link [j] anchor_text [j+1]
		{						
                    Frequencies f = new Frequencies();
			
                    if(map.containsKey(str_array[j]) == true)	//already in hash map
                    {	
			f.set_Cf(map.get(str_array[j]).get_Cf() + 1);	//CF Increment collection frequency for link already in hashmap 
						
			if(map.get(str_array[j]).get_marker() != i)	//DF
			{	f.set_Df(map.get(str_array[j]).get_Df() + 1);	}
			else
			{	f.set_Df(map.get(str_array[j]).get_Df());	}
                    }
                    else		//new in hash map
                    {	f.set_Cf(1);		//CF Set collection frequency for new link in hash map
                        f.set_Df(1);		//DF
                    }		

                    f.set_marker(i);            //occurrence in page
                    map.put(str_array[j], f);	//Update hash map
                    number_of_anchors++;
		}	
	    	i++;	//new row - new page
				
		pom++;
		if(pom >= 500000)   //progress report 
		{
                    System.out.println("Progress: " + i + " pages");
                    jTextArea1.setForeground(Color.black);    jTextArea1.append("\tProgress: " + i + " pages\n");
                    pom = 0;
		}
            }
            System.out.println("Number of pages: i = " + i + "\tNumber of anchros: " + number_of_anchors);
            jTextArea1.setForeground(Color.black);    jTextArea1.append("\tHashmap createt from File | Number of pages: i = " + i + "\t Number of anchros: " + number_of_anchors + "\n");
			
	}
	catch (UnsupportedEncodingException e) 
	{   System.out.println(e.getMessage()); } 
	catch (IOException e) 
	{   System.out.println(e.getMessage()); }
	catch (Exception e)
	{   System.out.println(e.getMessage()); }
	
	System.out.println("Map size: " + map.size());
        jTextArea1.setForeground(Color.black);    jTextArea1.append("\tHash_Map size: " + map.size() + "\n");
	
	return map;
    }
	
    /**
     *	iterate_hash_map
     * 
     *	Iterate through whole hash map (count = 0) or selected number of records (count != 0)
     *	and print records on System.out 
     *		- anchor_link key 
     *		- CF (collection frequency)
     *		- DF (document frequency)
     *	values assigned to a key
     *
     *@param map
     *@param count
     *@return SortedMap
     */	
    public void iterate_hash_map(Map<String, Frequencies> map, int count)
    {
    	int pom = 0;
    	Iterator<String> keySetIterator = map.keySet().iterator();
	
	if (count == 0)
	{	
            while(keySetIterator.hasNext())
            {
                String key = keySetIterator.next();
                System.out.println("key: " + key + "\t\t\t|Df: " + map.get(key).get_Df() + " |Cf: " + map.get(key).get_Cf());
                jTextArea1.setForeground(Color.black);    jTextArea1.append("\tkey: " + key + "\t\t\t|Df: " + map.get(key).get_Df() + " |Cf: " + map.get(key).get_Cf() + "\n");
            }
            System.out.println("Map size: " + map.size());
	}
	else 
	{
            while(keySetIterator.hasNext() && (pom < count) )
            {
		String key = keySetIterator.next();
		System.out.println("key: " + key + "\t\t\t|Df: " + map.get(key).get_Df() + " |Cf: " + map.get(key).get_Cf());
		jTextArea1.setForeground(Color.black);    jTextArea1.append("\tkey: " + key + "\t\t\t|Df: " + map.get(key).get_Df() + " |Cf: " + map.get(key).get_Cf() + "\n");
                pom++;
            }
            System.out.println("Map size: " + map.size());
	}
    }
	
    /**
     *	sort_hash_map_CF
     * 
     *	Sort hash_map with defined comparator
     *      - CF (collection frequency) comparator
     *	values assigned to a key
     *@param map
     *@return SortedMap
     */	
    public Map<String, Frequencies> sort_hash_map_CF(Map<String, Frequencies> map)
    {
	List<Map.Entry<String,Frequencies>> entries = new LinkedList<Map.Entry<String,Frequencies>>(map.entrySet());
	
	Collections.sort(entries, new Comparator<Map.Entry<String,Frequencies>>()
	{
            @Override
            public int compare(Entry<String, Frequencies> arg0, Entry<String, Frequencies> arg1)
            {
		Frequencies fs0 = (Frequencies) arg0.getValue();
		Frequencies fs1 = (Frequencies) arg1.getValue();
				
		if(fs0.get_Cf() > fs1.get_Cf())
		{	return -1;	}
		else if(fs0.get_Cf() < fs1.get_Cf())
		{	return 1;	}
		else 
		{	return 0;	}				
            }		
	});
		
	HashMap<String,Frequencies> SortedMap = new LinkedHashMap<String,Frequencies>();
	for(Map.Entry<String,Frequencies> entry: entries)
	{  SortedMap.put(entry.getKey(), entry.getValue());	}

        return SortedMap;
    }
	
    /**
     *	sort_hash_map_DF
     * 
     *	Sort hash_map with defined comparator
     *      - DF (document frequency) comparator
     *	values assigned to a key
     *
     *@param map
     *@return SortedMap
     */	
    public Map<String, Frequencies> sort_hash_map_DF(Map<String, Frequencies> map)
    {
	List<Map.Entry<String,Frequencies>> entries = new LinkedList<Map.Entry<String,Frequencies>>(map.entrySet());
	
	Collections.sort(entries, new Comparator<Map.Entry<String,Frequencies>>()
	{
            @Override
            public int compare(Entry<String, Frequencies> arg0, Entry<String, Frequencies> arg1)
            {
            	Frequencies fs0 = (Frequencies) arg0.getValue();
		Frequencies fs1 = (Frequencies) arg1.getValue();
			
		if(fs0.get_Df() > fs1.get_Df())
		{	return -1;	}
		else if(fs0.get_Df() < fs1.get_Df())
		{	return 1;	}
		else 
		{	return 0;	}				
            }		
	});
		
	HashMap<String,Frequencies> SortedMap = new LinkedHashMap<String,Frequencies>();
	for(Map.Entry<String,Frequencies> entry: entries)
	{  SortedMap.put(entry.getKey(), entry.getValue());	}

	return SortedMap;
    }
	
    /**
     * print_hash_map_to_file
     * 
     * Method print first "count" anchors from hash_map into file with DF and CF statistics
     * Iterate through whole hash map (count = 0) or selected number of records (count != 0)
     * 
     * @param map
     * @param count
     * @param output_file_name
     * @throws IOException 
     * @throws UnsupportedEncodingException 
     */	
    public void print_hash_map_to_file(Map<String, Frequencies> map, int count, String output_file_name) throws UnsupportedEncodingException, IOException
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_file_name, false),"UTF8"));
        int pom = 0;
	Iterator<String> keySetIterator = map.keySet().iterator();
		
	if (count == 0)
	{	
            while(keySetIterator.hasNext())
            {
		String key = keySetIterator.next();
		bw.write(key + "\t" + map.get(key).get_Df() + "\t" + map.get(key).get_Cf());
		bw.newLine();
            }
	}
	else
	{
            while(keySetIterator.hasNext() && (pom < count) )
            {
		String key = keySetIterator.next();
		bw.write(key + "\t" + map.get(key).get_Df() + "\t" + map.get(key).get_Cf());
		bw.newLine();
		pom++;
            }
	}
		
	bw.close();	
    }
	
    /**
     * average_CF_DF
     * 
     * Method Iterate through whole hash map and count
     * average CF and DF
     * 
     * @param map
     */	
    public void average_CF_DF(Map<String, Frequencies> map)
    {
        int number_of_anchors = map.size();
        double DF_count = 0;
	double CF_count = 0; 
	Iterator<String> keySetIterator = map.keySet().iterator();
		
	while(keySetIterator.hasNext())
	{
            String key = keySetIterator.next();
            //System.out.println("key: " + key + "\t\t\t|Df: " + map.get(key).get_Df() + " |Cf: " + map.get(key).get_Cf());
			
            DF_count = DF_count + map.get(key).get_Df();
            CF_count = CF_count + map.get(key).get_Cf();
			
	}
            System.out.println("SUM of DF: " + DF_count + "   SUM of CF: " + CF_count);
	    jTextArea1.setForeground(Color.black);    jTextArea1.append("\tSUM of DF: " + DF_count + "   SUM of CF: " + CF_count + "\n");
           
            System.out.println("Average DF: " + DF_count/number_of_anchors + "   Average CF: " + CF_count/number_of_anchors);
            jTextArea1.setForeground(Color.black);    jTextArea1.append("\tAverage DF: " + DF_count/number_of_anchors + "   Average CF: " + CF_count/number_of_anchors + "\n");
    }
}