package AnchorTextAndStatistics;

import java.util.List;

public class Statistics {
	
	
	private File_with_anchor_txt file;	
	private List<Page> record_list;
	
	//constructor
	public Statistics(File_with_anchor_txt file, List<Page> record_list)
	{
		this.file = file;
		this.record_list = record_list;
	}
	
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
	
	public void return_page_with_biggest_amount_of_anchor()
	{
		int anchor_count; 
		int max = -9999999;
		String page_pom = null;
				
		int number_of_rows = 10000;
		
		int i;
		for(i=0;i<1600;i++) 
		{	
			file.load_file_to_record_list(number_of_rows);
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
			
		System.out.println("Page with biggest amount of anchor: " + page_pom + "  Poèet: " + max);
	}
	
}
