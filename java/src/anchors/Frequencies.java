package src;


/**
 *  Frequencies.java
 *
 *  Class has methods witch define set and return operations on Frequencies
 *
 *@author	$Author: Filip Blanarik $
 */
public class Frequencies {
    private int Df=0;
    private int Cf=0;
    private int marker=-1;

    /**
     * get_Df
     * @return Df
     */
    public int get_Df() 
    {	return Df;	}

    /**
     * set_Df
     * @param Df 
     */
    public void set_Df(int Df) 
    {	this.Df = Df;	}

    /**
     * get_Cf
     * @return Cf
     */
    public int get_Cf() 
    {	return Cf;	}
    
    /**
    * set_Cf
    * @param Cf 
    */
    public void set_Cf(int Cf) 
    {	this.Cf = Cf;	}
    
    /**
     * set_marker
     * @param marker 
     */
    public void set_marker(int marker)
    {	this.marker = marker;	}
    
    /**
     * get_marker
     * @return  marker
     */
    public int get_marker()
    {	return marker;	}
}