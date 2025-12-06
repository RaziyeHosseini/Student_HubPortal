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

public class Student {

	// Fields
	private String ID;
	private String Firstname;
	private String Lname;
	private HashMap<Courses, String> courseGrades; // Map of Courses to grades

	/**
	 * Construct a new Student object.
	 *
	 * @param ID           unique student identifier (string)
	 * @param Firstname    student's first name
	 * @param Lname        student's last name
	 * @param courseGrades initial map of {@link Courses} to letter grade
	 */
	public Student(String ID, String Firstname, String Lname, HashMap<Courses, String> courseGrades)

	{

		this.ID = ID;
		this.Firstname = Firstname;
		this.Lname = Lname;
		this.courseGrades = courseGrades;

	}

	// Methods

	/**
	 * Add or update a course grade for this student.
	 *
	 * This method inserts the provided {@link Courses} instance and the
	 * corresponding letter grade into the student's internal course map.
	 *
	 * @param course the course to add or update
	 * @param grade  the letter grade (e.g., "A", "B")
	 */

	public void addCourseGrade(Courses course, String grade) {
		courseGrades.put(course, grade);

	}

	/**
	 * Calculate the student's overall GPA.
	 *
	 * This delegates to {@link GPACalculator#calculateGPA(HashMap)} using the
	 * student's internal course->grade map. The returned value is the weighted GPA
	 * based on each course's credit hours.
	 *
	 * @return weighted GPA (0.0 if the student has no credited courses)
	 */
	public double calculateGPA() {
		GPACalculator gpaCalculator = new GPACalculator();
		return gpaCalculator.calculateGPA(courseGrades);
	}

	// Getters

	// Getter methods

	/**
	 * Get the student's ID.
	 *
	 * @return student ID string
	 */

	public String getId() {
		return ID;
	}

	/**
	 * Get the student's first name.
	 *
	 * @return first name
	 */
	public String getFirstname() {
		return Firstname;
	}

	/**
	 * Get the student's last name.
	 *
	 * @return last name
	 */
	public String getLname() {
		return Lname;
	}

	/**
	 * Get the student's course->grade map.
	 *
	 * This returns the internal map used by the GPA calculation and UI display.
	 * Modifying the returned map will affect the student's recorded courses.
	 *
	 * @return map of {@link Courses} to letter grade strings
	 */
	public HashMap<Courses, String> getCourseGrades() {
		return courseGrades;
	}

}