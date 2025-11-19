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
import java.util.HashMap;
import java.io.*;

public class LoginApp {
	
	private HashMap<String, String> students = new HashMap<>();
	//String filename = "student_info.txt";
    public static void main(String[] args) {
        new LoginApp();
    }

    public LoginApp() {
    	
    	loadStudentsFormFile("student_info.txt");
    	//System.out.println(students);       
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
                System.out.println(name + id);
            } else {
                JOptionPane.showMessageDialog(frame, "Not Found!");
                System.out.println(name + id);
            }
            System.out.println(name + id);
//            System.out.println(students);
//            File f = new File(filename);
//            System.out.println("Looking for file at: " + f.getAbsolutePath());

            
        });
    }
    
    
    //load info hash map
    private void loadStudentsFormFile(String filename) {
    	try (BufferedReader br = new BufferedReader(new FileReader(filename))){
    		String line;
    		
    		while((line = br.readLine())!= null) {
    			//System.out.println(line);
    			String [] parts = line.split(",");
    			//System.out.println(parts);
    			if(parts.length >= 2) {
    				String id = parts[0].trim();
    				String name = parts[1].trim();
    				students.put(id, name);
    				System.out.println(students);
    			}
    		}
    		
    		
    	}catch(IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
    	}
    	
    }
    

    private boolean checkUser(String name, String id) {
        return students.containsKey(id) && students.get(id).equals(name);
    }

}


















