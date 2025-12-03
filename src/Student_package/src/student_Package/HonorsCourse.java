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
 * Version: 2025-12-03
 */
package Student_package.src.student_Package;


/**
 * Purpose: The reponsibility of HonorsCourse is ...
 *
 * HonorsCourse is-a ... HonorsCourse is ...
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