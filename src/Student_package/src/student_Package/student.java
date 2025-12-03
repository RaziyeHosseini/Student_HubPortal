/**
 * Lead Author(s): Iker Nunez & Raziye Hosseini
 * 
 * Other Contributors:
 * https://chat.deepseek.com/share/z0pmyett4yclj8i6wl (Used to make my Javadoc)
 *
 * References:
 * Morelli, R., & Walde, R. (2016).
 * Java, Java, Java: Object-Oriented Problem Solving
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 * Purpose: The responsibility of Student is to store student information and
 * manage course grades.
 *
 * Student HAS-a relationship with Courses, GPACalculator, & HonorsCourse
 * Student is the main entity representing a student with personal information
 * and academic records
 *
 * Version: 2024-03-11
 */
package Student_package.src.student_Package;

import java.util.HashMap;

public class Student
{
	private String ID;
	private String Firstname;
	private String Lname;
	private HashMap<Courses, String> courseGrades; // Map of Courses to grades

	public Student(String ID, String Firstname, String Lname,
			HashMap<Courses, String> courseGrades)
	{

		this.ID = ID;
		this.Firstname = Firstname;
		this.Lname = Lname;
		this.courseGrades = courseGrades;

	}

	public void addCourseGrade(Courses course, String grade)
	{
		courseGrades.put(course, grade);

	}

	public double calculateGPA()
	{
		GPACalculator gpaCalculator = new GPACalculator();
		return gpaCalculator.calculateGPA(courseGrades);
	}

	// Getter methods

	public String getId()
	{
		return ID;
	}

	public String getFirstname()
	{
		return Firstname;
	}

	public String getLname()
	{
		return Lname;
	}

	public HashMap<Courses, String> getCourseGrades()
	{
		return courseGrades;
	}

}
