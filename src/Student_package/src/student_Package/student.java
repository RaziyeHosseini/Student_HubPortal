/**
 * Lead Author(s): Iker Nunez & Raziye Hosseini
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
 *         Version: 2025-11-04
 */
package Student_package.src.student_Package;



import java.util.HashMap;

/**
 * Purpose: The reponsibility of Student is ...
 *
 * Student is-a ... Student is ...
 */
public class Student
{
	private String ID;
	private String Firstname;
	private String Lname;
	private HashMap<Courses, String> courseGrades; // Map of Courses to grades

	public Student(String ID, String Firstname, String Lname, HashMap<Courses, String> courseGrades)
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
