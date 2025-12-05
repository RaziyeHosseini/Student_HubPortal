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
 * Purpose: The responsibility of GPACalculator is to calculate GPA based on
 * course grades and credit hours.
 *
 * GPACalculator is-a utility class
 * GPACalculator is responsible for computing the Grade Point Average using
 * weighted grade points
 *
 * Version: 2024-03-11
 */
package Student_package.src.student_Package;

import java.util.HashMap;
import java.util.Map;

public class GPACalculator
{
	// Fields
	double totalCredits = 0;
	double totalPoints = 0;
	double creditHours = 0;

<<<<<<< HEAD
	// Methods
=======
	/**
	 * Calculate the weighted GPA for a collection of courses and their
	 * respective letter grades.
	 * <p>
	 * This method iterates over the provided map of {@link Courses} to
	 * letter grade strings, asks each course for its grade points via
	 * {@link Courses#getGradePoints(String)}, multiplies by the course's
	 * credit hours (via {@link Courses#getCreditHours()}), sums the total
	 * points and credits, and returns the weighted GPA.
	 *
	 * @param courseList map where the key is a {@link Courses} instance and
	 *                   the value is the letter grade (e.g., "A", "B")
	 * @return the weighted GPA (0.0 if the total credits are zero)
	 */
>>>>>>> 0bfc390f81bbf85a13b9fa7ca7af237c8e6e4bfa
	public double calculateGPA(HashMap<Courses, String> courseList)
	{
		// Reset totals
		double totalPoints = 0;
		double totalCredits = 0;
		
		// Calculate total points and credits
		for (Map.Entry<Courses, String> entry : courseList.entrySet())
		{
			// Get course and grade
			Courses course = entry.getKey();
			String grade = entry.getValue();
			double gradePoints = course.getGradePoints(grade);
			int creditHours = course.getCreditHours();

			// Accumulate totals
			totalPoints += gradePoints * creditHours;
			totalCredits += creditHours;
		}
		// Calculate and return GPA
		return totalCredits == 0 ? 0 : totalPoints / totalCredits;
	}
}