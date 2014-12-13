package src;



/**
 *  Anchor.java
 *
 *  Class has methods witch define set and return operations on Anchor  
 *
 *@author	$Author: Filip Blanarik $
 */
public class Anchor {
    private String anchor_link;
    private String anchor_text;
		
   /**
    * return_anchor_link
    * @return anchor_link
    */
    public String return_anchor_link()
    {	return anchor_link;	}

    /**
     * return_anchor_text
     * @return  anchor_text
     */
    public String return_anchor_text()
    {	return anchor_text;	}
    //---------------------
	
    /**
     * set_anchor_link
     * @param anchor_link 
     */
    public void set_anchor_link(String anchor_link)
    {	this.anchor_link = anchor_link;	}
	
    /**
     * set_anchor_text
     * @param anchor_text 
     */
    public void set_anchor_text(String anchor_text)
    {	this.anchor_text = anchor_text;	}
}