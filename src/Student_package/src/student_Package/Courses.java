/**
 * Lead Author(s): Iker Nunez & Raziye Hosseini
 * 
 * Other Contributors:
 * https://chat.deepseek.com/share/z0pmyett4yclj8i6wl (Used to make my Javadoc)
 * CoPilot Made changes as well, refer to CONTRIBUTORS.md for details &
 * README.md
 * References:
 * Morelli, R., & Walde, R. (2016).
 * Java, Java, Java: Object-Oriented Problem Solving
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 * Purpose: The responsibility of Courses is to represent a course with its
 * name, honors status, and credit hours.
 *
 * Courses is-a base class for all course types
 * Courses is the fundamental class that defines course properties and basic
 * grade point calculation
 *
 * Version: 2024-03-11
 */
package Student_package.src.student_Package;

<<<<<<< HEAD

/**
 * Purpose: The reponsibility of Courses is ...
 *
 * Courses is-a ... Courses is ...
 */
=======
>>>>>>> 0bfc390f81bbf85a13b9fa7ca7af237c8e6e4bfa
public class Courses
{

	String courseName;

	boolean isHonors;

	private int creditHours; // number of credit hours for the course

	/**
	 * Construct a new Courses instance.
	 *
	 * @param courseName the display name of the course
	 * @param isHonors true if the course is honors
	 * @param creditHours number of credit hours for this course (positive integer)
	 */
	public Courses(String courseName, boolean isHonors, int creditHours)
	{
		this.courseName = courseName;
		this.isHonors = isHonors;
		this.creditHours = creditHours;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Calculate grade points for a given letter grade.
	 * <p>
	 * This method returns the numeric grade points for the provided grade
	 * (A=4, B=3, C=2, D=1, F=0). If the course is honors and the grade is
	 * not an F, one bonus point is added. This method is used by
	 * {@link GPACalculator} when computing weighted GPA.
	 *
	 * @param grade the letter grade (case-insensitive)
	 * @return the grade points for the grade, including honors bonus where
	 *         applicable
	 */
	public double getGradePoints(String grade)
	{
		// Base grade points
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
		// Honors course bonus
		if (isHonors && !grade.equalsIgnoreCase("F"))
		{
			return basepoints + 1.0;
		}
		else
		{
			return basepoints;
		}

	}
	
	/**
	 * Get the course's display name.
	 *
	 * This value is used when listing a student's courses in the UI (for
	 * example, in {@link LoginApp#showStudentDashboard}).
	 *
	 * @return the course name as stored
	 */
	public String getCourseName()
	{
		return courseName;
	}

	/**
	 * Indicates whether this course is an honors course.
	 *
	 * @return true if the course is honors, false otherwise
	 */
	public boolean isHonors()
	{
		return isHonors;
	}

	/**
	 * Returns the number of credit hours for this course.
	 *
	 * The credit hours are used by {@link GPACalculator} to compute the
	 * weighted GPA (gradePoints * creditHours).
	 *
	 * @return credit hours (positive integer, default 3 when not
	 *         specified in input)
	 */
	public int getCreditHours()
	{
		return creditHours;
	}

	/**
	 * Equality is based on course name (case-insensitive), honors status,
	 * and credit hours. This ensures consistent behavior when using
	 * Courses as keys in maps (for example in {@link Student} courseGrades
	 * map).
	 *
	 * @param obj other object to compare
	 * @return true if both represent the same course
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Courses other = (Courses) obj;
		return this.creditHours == other.creditHours
				&& this.isHonors == other.isHonors
				&& (this.courseName == null ? other.courseName == null : this.courseName.equalsIgnoreCase(other.courseName));
	}

	/**
	 * Compute a hash code consistent with {@link #equals(Object)} so this
	 * object can be used reliably as a key in hash-based collections.
	 *
	 * @return hash code
	 */
	@Override
	public int hashCode()
	{
		int result = 17;
		result = 31 * result + (courseName == null ? 0 : courseName.toLowerCase().hashCode());
		result = 31 * result + (isHonors ? 1 : 0);
		result = 31 * result + creditHours;
		return result;
	}

	/**
	 * String representation used for debugging and display. Includes honors
	 * marker and credit hours.
	 *
	 * @return formatted course string
	 */
	@Override
	public String toString()
	{
		return courseName + (isHonors ? " (Honors)" : "") + " [" + creditHours + "cr]";
	}

}