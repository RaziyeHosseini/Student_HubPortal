/**
* Lead Author(s):
* @author raziyehosseini; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-11-03
*/
package Student_package;
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
	private HashMap<courses, String> courseList = new HashMap<courses, String>();
	
	
	
	public student(int ID, String name , String Lname, HashMap<courses, String> courseList) {
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






















