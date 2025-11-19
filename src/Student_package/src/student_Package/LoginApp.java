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
 *         Version: 2025-11-04
 */
package Student_package.src.student_Package;

/**
 * Purpose: The reponsibility of LoginApp is ...
 *
 * LoginApp is-a ...
 * LoginApp is ...
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class LoginApp
{
	private HashMap<String, Student> studentsDatabase;

	public static void main(String[] args)
	{
		new LoginApp();
	}

	public LoginApp()
	{
		studentsDatabase = loadStudentsFromFile("student_info.txt");
		createLoginGUI();
	}

	private void createLoginGUI()
	{
		JFrame frame = new JFrame("Student Portal Login");
		JTextField nameField = new JTextField(15);
		JTextField idField = new JTextField(15);
		JButton enter = new JButton("Enter");

		JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.add(new JLabel("First Name:"));
		panel.add(nameField);
		panel.add(new JLabel("Student ID:"));
		panel.add(idField);
		panel.add(new JLabel(""));
		panel.add(enter);

		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		enter.addActionListener(e -> {
			String firstName = nameField.getText().trim();
			String studentId = idField.getText().trim();

			if (authenticateStudent(firstName, studentId))
			{
				Student Student = studentsDatabase.get(studentId);
				showStudentDashboard(Student);
				frame.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "Student not found!");
			}
		});
	}

	private boolean authenticateStudent(String firstName, String studentId)
	{
		Student student = studentsDatabase.get(studentId);
		return student != null
				&& student.getFirstname().equalsIgnoreCase(firstName);
	}

	private HashMap<String, Student> loadStudentsFromFile(String filename)
	{
		HashMap<String, Student> students = new HashMap<>();

		try (Scanner scanner = new Scanner(new File(filename)))
		{
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine().trim();
				if (line.isEmpty() || line.startsWith("ID")) continue;

				// Parse: "100, Raz, Hosseyni, Math1:A, Science2*:B,
				// English3*:C"
				String[] parts = line.split(",");
				if (parts.length >= 3)
				{
					String studentId = parts[0].trim();
					String firstName = parts[1].trim();
					String lastName = parts[2].trim();

					HashMap<Courses, String> courseGrades = new HashMap<>();

					// Add courses and grades
					for (int i = 3; i < parts.length; i++)
					{
						String courseGrade = parts[i].trim();
						String[] courseParts = courseGrade.split(":");
						if (courseParts.length == 2)
						{
							String courseName = courseParts[0].trim();
							String grade = courseParts[1].trim();

							boolean isHonors = courseName.contains("*");
							courseName = courseName.replace("*", ""); // Remove honor marker

							Courses course;
							if (isHonors)
							{
								course = new HonorsCourse(courseName, 3); // 3 credit hours 
							}
							else
							{
								course = new Courses(courseName, isHonors, 3);
							}
							courseGrades.put(course, grade);
						}
					}

					Student student = new Student(studentId, firstName,
							lastName, courseGrades);
					students.put(studentId, student);
				}
			}
		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,
					"Error loading Student data: " + e.getMessage());
		}

		return students;
	}

	private void showStudentDashboard(Student student)
	{
		// Create the second window with Student information
		JFrame dashboard = new JFrame(
				"Student Dashboard - " + student.getFirstname());
		JTextArea infoArea = new JTextArea(20, 30);
		infoArea.setEditable(false);

		// Build display text
		StringBuilder sb = new StringBuilder();
		sb.append("Student ID: ").append(student.getId()).append("\n");
		sb.append("Name: ").append(student.getFirstname()).append(" ")
				.append(student.getLname()).append("\n\n");
		sb.append("Courses and Grades:\n");

		for (Map.Entry<Courses, String> entry : student.getCourseGrades()
				.entrySet())
		{
			Courses course = entry.getKey();
			String grade = entry.getValue();
			sb.append("- ").append(course.getCourseName());
			if (course.isHonors()) sb.append(" (Honors)");
			sb.append(": ").append(grade).append("\n");
		}

		sb.append("\nOverall GPA: ")
				.append(String.format("%.2f", student.calculateGPA()));
		infoArea.setText(sb.toString());

		dashboard.add(new JScrollPane(infoArea));
		dashboard.pack();
		dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashboard.setLocationRelativeTo(null);
		dashboard.setVisible(true);
	}
}

//
// JFrame frame = new JFrame("Login");
// JTextField nameField = new JTextField(15);
// JTextField idField = new JTextField(15);
// JButton enter = new JButton("Enter");
//
// JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
// panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//
// panel.add(new JLabel("Name:"));
// panel.add(nameField);
// panel.add(new JLabel("ID:"));
// panel.add(idField);
// panel.add(new JLabel("")); // empty cell
// panel.add(enter);
//
// frame.add(panel);
// frame.pack();
// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// frame.setLocationRelativeTo(null); // center the frame
// frame.setVisible(true);
//
//// Action listener for the enter button, UPDATE CODE BELOW for when we need to
//// add the 2nd window for the Student details
// enter.addActionListener(e -> {
// String name = nameField.getText();
// String id = idField.getText();
// if (checkUser(name, id)) {
// JOptionPane.showMessageDialog(frame, "Found!");
// } else {
// JOptionPane.showMessageDialog(frame, "Not Found!");
// }
// });