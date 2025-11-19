/**
 * Lead Author(s):
 * 
 * @author raziyehosseini; Student ID
 * @author Full name; Student ID
 *         <<Add additional lead authors here>>
 *
 *         Other Contributors:
 *         Full name; Student ID or contact information if not in class
 *         <<Add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 *         <<Add more references here>>
 *
 *         Version: 2025-11-03
 */
package Student_package.src.student_Package;

import java.util.HashMap;

/**
 * Purpose: The reponsibility of Courses is ...
 *
 * Courses is-a ... Courses is ...
 */
public class Courses
{

	String courseName;

	boolean isHonors;

	private int creditHours; // number of credit hours for the course

	public Courses(String courseName, boolean isHonors, int creditHours)
	{
		this.courseName = courseName;
		this.isHonors = isHonors;
		this.creditHours = creditHours;
		// TODO Auto-generated constructor stub
	}

	public double getGradePoints(String grade)
	{
		double basepoints = 0.0;
		switch (grade.toUpperCase())
		{
			case "A":
				basepoints = 4.0;
				break;
			case "B":
				basepoints = 3.0;
				break;
			case "C":
				basepoints = 2.0;
				break;
			case "D":
				basepoints = 1.0;
				break;
			case "F":
				basepoints = 0.0;
				break;
			default:
				basepoints = 0.0;

		}

		if (isHonors && !grade.equalsIgnoreCase("F"))
		{
			return basepoints + 1.0;
		}
		else
		{
			return basepoints;
		}

	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public boolean isHonors()
	{
		return isHonors;
	}
	
	public int getCreditHours()
	{
		return creditHours;
	}
	

}
