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
 * Purpose: The responsibility of LoginApp is to handle student login and
 * display the student dashboard.
 *
 * LoginApp is-a Swing application (GUI)
 * LoginApp is the main entry point that manages student authentication and
 * dashboard display
 *
 * Version: 2024-03-11
 */
package Student_package.src.student_Package;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginApp {
	private HashMap<String, Student> studentsDatabase;

	/**
	 * Application entry point.
	 * <p>
	 * This static main method starts the Swing application by constructing a new
	 * {@link LoginApp} instance which loads student data and opens the login GUI.
	 *
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		new LoginApp();
	}

	/**
	 * Initialize the application: load students from the provided data file and
	 * create the login GUI.
	 * <p>
	 * This constructor calls {@link #loadStudentsFromFile(String)} to populate the
	 * internal students database and then builds the login interface via
	 * {@link #createLoginGUI()}.
	 */
	public LoginApp() {
		studentsDatabase = loadStudentsFromFile("student_info.txt");
		createLoginGUI();
	}

	// Create the login GUI (First Window)

	/**
	 * Build and display the login window.
	 * <p>
	 * The GUI collects the student's first name and ID. When the user clicks
	 * "Enter" the supplied credentials are validated by
	 * {@link #authenticateStudent(String, String)}; if valid, the dashboard is
	 * shown via {@link #showStudentDashboard(Student)}.
	 */
	private void createLoginGUI() {
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

			// Authenticate student
			if (authenticateStudent(firstName, studentId)) {
				Student student = studentsDatabase.get(studentId);
				if (student != null) {
					showStudentDashboard(student);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "Student not found!");
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Student not found!");
			}
		});
	}

	// Authenticate student based on first name and ID

	/**
	 * Validate a student's first name and ID against the loaded database.
	 *
	 * This method performs a case-insensitive comparison of the provided first name
	 * with the stored student record. It is used by the login GUI to authenticate
	 * users before showing their dashboard.
	 *
	 * @param firstName the first name entered in the login form
	 * @param studentId the student ID entered in the login form
	 * @return true if a matching student is found and the name matches; false
	 *         otherwise
	 */
	private boolean authenticateStudent(String firstName, String studentId) {
		if (studentId == null)
			return false;
		Student student = studentsDatabase.get(studentId);
		return student != null && student.getFirstname().equalsIgnoreCase(firstName);
	}

	// Load students from file into HashMap
	private HashMap<String, Student> loadStudentsFromFile(String filename) {
		HashMap<String, Student> students = new HashMap<>();

		File file = new File(filename);
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();
				if (line.isEmpty())
					continue;
				// Skip potential merge markers or conflict sections
				if (line.startsWith("<<<<<<<") || line.startsWith("=======") || line.startsWith(">>>>>>>"))
					continue;
				if (line.startsWith("ID"))
					continue; // skip header if present

				String[] parts = line.split(",");
				if (parts.length < 3)
					continue; // malformed

				String studentId = parts[0].trim();
				String firstName = parts[1].trim();
				String lastName = parts[2].trim();

				HashMap<Courses, String> courseGrades = new HashMap<>();

				for (int i = 3; i < parts.length; i++) {
					String courseGrade = parts[i].trim();
					if (courseGrade.isEmpty())
						continue;
					String[] courseParts = courseGrade.split(":");
					if (courseParts.length != 2)
						continue;
					String courseName = courseParts[0].trim();
					String grade = courseParts[1].trim();

					// parse optional credit hours encoded as +n+
					int creditHours = 3; // default
					java.util.regex.Matcher m = java.util.regex.Pattern.compile("\\+(\\d+)\\+").matcher(courseName);
					if (m.find()) {
						try {
							creditHours = Integer.parseInt(m.group(1));
						} catch (NumberFormatException ex) {
							// keep default
						}
						courseName = courseName.replaceFirst("\\+" + m.group(1) + "\\+", "").trim();
					}

					boolean isHonors = courseName.contains("*");
					courseName = courseName.replace("*", "").trim();

					Courses course;
					if (isHonors) {
						course = new HonorsCourse(courseName, creditHours);
					} else {
						course = new Courses(courseName, false, creditHours);
					}

					courseGrades.put(course, grade);
				}

				Student student = new Student(studentId, firstName, lastName, courseGrades);
				students.put(studentId, student);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error loading Student data: " + e.getMessage());
		}

		return students;
	}

	// Display Student Dashboard

	/**
	 * Show the student dashboard window with the student's courses and GPA.
	 * <p>
	 * This method builds a textual summary of the student's ID, name, courses and
	 * grades, and computes the overall GPA via {@link Student#calculateGPA()} to
	 * display in the UI.
	 *
	 * @param student the {@link Student} whose dashboard to display
	 */
	private void showStudentDashboard(Student student) {
		// Create the second window with Student information
		JFrame dashboard = new JFrame("Student Dashboard - " + student.getFirstname());
		JTextArea infoArea = new JTextArea(20, 40);
		infoArea.setEditable(false);

		// Build display text
		StringBuilder sb = new StringBuilder();
		sb.append("Student ID: ").append(student.getId()).append("\n");
		sb.append("Name: ").append(student.getFirstname()).append(" ").append(student.getLname()).append("\n\n");
		sb.append("Courses and Grades:\n");

		// List courses and grades
		for (Map.Entry<Courses, String> entry : student.getCourseGrades().entrySet()) {
			Courses course = entry.getKey();
			String grade = entry.getValue();
			sb.append("- ").append(course.getCourseName());
			if (course.isHonors())
				sb.append(" (Honors)");
			sb.append(" [").append(course.getCreditHours()).append("cr]");
			sb.append(": ").append(grade).append("\n");
		}

		sb.append("\nOverall GPA: ").append(String.format("%.2f", student.calculateGPA()));

		infoArea.setText(sb.toString());

		// Add text area to dashboard
		dashboard.add(new JScrollPane(infoArea));
		dashboard.pack();
		dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashboard.setLocationRelativeTo(null);
		dashboard.setVisible(true);
	}
}