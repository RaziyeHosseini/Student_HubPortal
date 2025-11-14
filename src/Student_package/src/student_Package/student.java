package student_Package;

import java.util.HashMap;
/**
 * Purpose: The reponsibility of student is ...
 *
 * student is-a ...
 * student is ...
 */
public class student
{
	private int ID;
	private String name ;
	private String Lname;
	private HashMap<Course, String> courseList = new HashMap<Course, String>();
	
	
	
	public student(int ID, String name , String Lname, HashMap<Course, String> courseList) {
		this.setID(ID);
		this.setName(name) ;
		this.setLname(Lname) ;
		this.courseList = courseList;
		
	}
	
	/**
	 * @return the iD
	 */
	public int getID()
	{
		return ID;
	}



	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD)
	{
		ID = iD;
	}



	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}



	/**
	 * @return the lname
	 */
	public String getLname()
	{
		return Lname;
	}



	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname)
	{
		Lname = lname;
	}
}






















