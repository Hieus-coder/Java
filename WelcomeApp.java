import javax.swing.*;
import java.awt.event.*;

public class WelcomeApp {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Welcome to!");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        // Label and text field for full name
        JLabel nameLabel = new JLabel("Full name:");
        nameLabel.setBounds(10, 10, 100, 25);
        frame.add(nameLabel);
        
        JTextField nameField = new JTextField();
        nameField.setBounds(120, 10, 150, 25);
        frame.add(nameField);
        
        // Gender selection
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(10, 45, 100, 25);
        frame.add(genderLabel);
        
        JRadioButton maleButton = new JRadioButton("Mr.");
        maleButton.setBounds(120, 45, 60, 25);
        JRadioButton femaleButton = new JRadioButton("Miss");
        femaleButton.setBounds(180, 45, 60, 25);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        
        frame.add(maleButton);
        frame.add(femaleButton);
        
        // Result label
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(10, 80, 100, 25);
        frame.add(resultLabel);
        
        JTextField resultField = new JTextField();
        resultField.setBounds(120, 80, 250, 25);
        resultField.setEditable(false);
        frame.add(resultField);
        
        // Buttons
        JButton welcomeButton = new JButton("Welcome");
        welcomeButton.setBounds(50, 120, 100, 25);
        frame.add(welcomeButton);
        
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(160, 120, 100, 25);
        frame.add(clearButton);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(270, 120, 100, 25);
        frame.add(cancelButton);
        
        // Action listener for Welcome button
        welcomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String gender = maleButton.isSelected() ? "Mr." : femaleButton.isSelected() ? "Miss" : "";
                if (!name.isEmpty() && !gender.isEmpty()) {
                    resultField.setText("Welcome " + gender + " " + name);
                } else {
                    resultField.setText("Please enter your name and select a gender.");
                }
            }
        });
        
        // Action listener for Clear button
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                genderGroup.clearSelection();
                resultField.setText("");
            }
        });
        
        // Action listener for Cancel button
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // Show frame
        frame.setVisible(true);
    }
}
