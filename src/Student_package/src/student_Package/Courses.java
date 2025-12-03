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

	// Method to get grade points based on grade and honors status
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

	// Getter methods
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

	// Override equals and hashCode for proper comparison in HashMap
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Courses other = (Courses) obj;
		return this.creditHours == other.creditHours
				&& this.isHonors == other.isHonors
				&& (this.courseName == null ? other.courseName == null
						: this.courseName.equalsIgnoreCase(other.courseName));
	}

	// Override hashCode for proper hashing in HashMap
	@Override
	public int hashCode()
	{
		int result = 17;
		result = 31 * result + (courseName == null ? 0
				: courseName.toLowerCase().hashCode());
		result = 31 * result + (isHonors ? 1 : 0);
		result = 31 * result + creditHours;
		return result;
	}

	// Override toString for better representation
	@Override
	public String toString()
	{
		return courseName + (isHonors ? " (Honors)" : "") + " [" + creditHours
				+ "cr]";
	}

}