package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPage {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Registration Page");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

  
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 80, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(150, 30, 200, 25);
        frame.add(userText);

   
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 70, 80, 25);
        frame.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 70, 200, 25);
        frame.add(passwordText);

 
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(50, 110, 150, 25);
        frame.add(confirmPasswordLabel);

        JPasswordField confirmPasswordText = new JPasswordField(20);
        confirmPasswordText.setBounds(150, 110, 200, 25);
        frame.add(confirmPasswordText);


        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 160, 100, 30);
        frame.add(registerButton);


        registerButton.addActionListener(new ActionListener() {
    
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                String confirmPassword = new String(confirmPasswordText.getPassword());

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Passwords do not match.");
                    return;
                }

             

                JOptionPane.showMessageDialog(frame, "Registration successful!");
                frame.dispose();
            }
        });

 
        frame.setVisible(true);
    }
}
