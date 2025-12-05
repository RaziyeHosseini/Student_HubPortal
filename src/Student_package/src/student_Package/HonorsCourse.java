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
 * Purpose: The responsibility of HonorsCourse is to represent an honors course
 * with enhanced grade point calculation.
 *
 * HonorsCourse is-a relationship with Courses (inherits from Courses)
 * HonorsCourse is a specialized course type that provides bonus points for
 * non failing grades
 *
 * Version: 2024-03-11
 */
package Student_package.src.student_Package;

<<<<<<< HEAD

/**
 * Purpose: The reponsibility of HonorsCourse is ...
 *
 * HonorsCourse is-a ... HonorsCourse is ...
 */
=======
>>>>>>> 0bfc390f81bbf85a13b9fa7ca7af237c8e6e4bfa
public class HonorsCourse extends Courses
{

	/**
	 * Construct a new HonorsCourse.
	 * <p>
	 * HonorsCourse is a specialized {@link Courses} instance where the
	 * honors flag is always true. Credit hours are provided at
	 * construction time and used later by {@link GPACalculator} when
	 * computing weighted GPA.
	 *
	 * @param courseName the display name of the course (without honors or
	 *                   credit markers)
	 * @param creditHours number of credit hours for this course (positive)
	 */
	public HonorsCourse(String courseName, int creditHours)
	{
		super(courseName, true, creditHours);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Calculate grade points for the given letter grade in this honors
	 * course. Honors courses add one bonus point to non-failing grades.
	 *
	 * This method is called by {@link GPACalculator#calculateGPA} for each
	 * course when computing the weighted GPA.
	 *
	 * @param grade the letter grade (A, B, C, D, F)
	 * @return grade points including the honors bonus for non-F grades
	 */
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