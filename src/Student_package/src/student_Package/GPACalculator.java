/**
 * Lead Author(s):
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
 *         Version: 2025-11-14
 */
package Student_package.src.student_Package;

/**
 * Purpose: The reponsibility of GPACalculator is ...
 *
 * GPACalculator is-a ... GPACalculator is ...
 */

import java.util.HashMap;
import java.util.Map;

public class GPACalculator
{
	// New file exists
	double totalCredits = 0;
	double totalPoints = 0;
	double creditHours = 0;

	public double calculateGPA(HashMap<Courses, String> courseList)
	{

		double totalPoints = 0;
		double totalCredits = 0;
		for (Map.Entry<Courses, String> entry : courseList.entrySet())
		{
			Courses course = entry.getKey();
			String grade = entry.getValue();
			double gradePoints = course.getGradePoints(grade);
			int creditHours = course.getCreditHours();

			totalPoints += gradePoints * creditHours;
			totalCredits += creditHours;
		}
		return totalCredits == 0 ? 0 : totalPoints / totalCredits;
	}
}
