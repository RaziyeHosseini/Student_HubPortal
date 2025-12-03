/**
 * Lead Author(s): Iker Nunez & Raziye Hosseini
 * 
 * Other Contributors:
 * 
 *
 * References:
 * Morelli, R., & Walde, R. (2016).
 * Java, Java, Java: Object-Oriented Problem Solving
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 *
 * Version: 2024-03-11
 */
package Student_package.src.student_Package;

/**
 * Purpose: The responsibility of HonorsCourse is to represent an honors course
 * with enhanced grade point calculation.
 *
 * HonorsCourse is-a relationship with Courses (inherits from Courses)
 * HonorsCourse is a specialized course type that provides bonus points for
 * non failing grades
 */
public class HonorsCourse extends Courses
{

	public HonorsCourse(String courseName, int creditHours)
	{
		super(courseName, true, creditHours);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getGradePoints(String grade)
	{
		double basepoints = 0;
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
				basepoints = 0.0; // Invalid grade
				break;
		}
		if (!grade.equalsIgnoreCase("F"))
		{
			return basepoints += 1.0; // Honors course bonus
		}
		return basepoints;
	}

}