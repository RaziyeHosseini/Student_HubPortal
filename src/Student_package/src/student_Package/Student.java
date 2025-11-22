package Student_package.src.student_Package;

import java.util.HashMap;

/**
 * Purpose: The reponsibility of Student is ...
 *
 * Student is-a ... Student is ...
 */
public class Student
{
	
	// Fields
	private String ID;
	private String Firstname;
	private String Lname;
	private HashMap<Courses, String> courseGrades; // Map of Courses to grades

	// Constructor
	public Student(String ID, String Firstname, String Lname, HashMap<Courses, String> courseGrades)
	{

		this.ID = ID;
		this.Firstname = Firstname;
		this.Lname = Lname;
		this.courseGrades = courseGrades;

	}

	// Methods
	public void addCourseGrade(Courses course, String grade)
	{
		courseGrades.put(course, grade);

	}

	public double calculateGPA()
	{
		GPACalculator gpaCalculator = new GPACalculator();
		return gpaCalculator.calculateGPA(courseGrades);
	}


	// Getters
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
