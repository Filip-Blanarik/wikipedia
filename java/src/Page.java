package AnchorTextAndStatistics;

import java.util.*;

public class Page 
{
	private String page_title;
	private List <Anchor> anchor_list = new ArrayList<Anchor>();	
	
	public String return_page_title()
	{	return page_title;	}
	
	public List<Anchor> return_anchor_list()
	{	return anchor_list;	}
	//---------------------
	
	public void set_page_title(String page_title)
	{	this.page_title = page_title;	}
	
	public void set_anchor(String anchor_link, String anchor_text)
	{	
		Anchor anchor = new Anchor();
		anchor.set_anchor_link(anchor_link);
		anchor.set_anchor_text(anchor_text);
		
		anchor_list.add(anchor);
	}
	
	
}
	

