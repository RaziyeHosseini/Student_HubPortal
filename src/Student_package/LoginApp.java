/**
* Lead Author(s):
* @author raziyehosseini; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-11-04
*/
package Student_package;

/**
 * Purpose: The reponsibility of LoginApp is ...
 *
 * LoginApp is-a ...
 * LoginApp is ...
 */
import javax.swing.*;
import java.awt.event.*;

public class LoginApp {
    public static void main(String[] args) {
        new LoginApp();
    }

    public LoginApp() {
        JFrame frame = new JFrame("Login");
        JTextField nameField = new JTextField(15);
        JTextField idField = new JTextField(15);
        JButton enter = new JButton("Enter");

        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("ID:"));
        frame.add(idField);
        frame.add(enter);

        frame.setLayout(new java.awt.FlowLayout());
        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        enter.addActionListener(e -> {
            String name = nameField.getText();
            String id = idField.getText();
            if (checkUser(name, id)) {
                JOptionPane.showMessageDialog(frame, "Found!");
            } else {
                JOptionPane.showMessageDialog(frame, "Not Found!");
            }
        });
    }

    private boolean checkUser(String name, String id) {
        return name.equals("Raziye") && id.equals("123");	//has to go to the text file to find the students name and id and check
    }
}

