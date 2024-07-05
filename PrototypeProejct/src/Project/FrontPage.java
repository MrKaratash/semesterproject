package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class FrontPage {
    public static void main(String[] args) {
     
        JFrame frame = new JFrame("Login Page");
        frame.setSize(352, 281);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

      
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 82, 80, 25);
        frame.getContentPane().add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(150, 82, 150, 25);
        frame.getContentPane().add(userText);


        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 118, 80, 25);
        frame.getContentPane().add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 118, 150, 25);
        frame.getContentPane().add(passwordText);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(116, 201, 100, 30);
        frame.getContentPane().add(loginButton);

  
        loginButton.addActionListener(new ActionListener() {
           
        	 public void actionPerformed(ActionEvent e) {
                 String username = userText.getText();
                 String password = new String(passwordText.getPassword());
                 if (database.authenticate(username, password)) {
                     JOptionPane.showMessageDialog(frame, "Login successful!");
                     openGameInfoPage();
                 } else {
                     JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                 }
             }
         });


        JButton registerButton = new JButton("Register");
        registerButton.setBounds(226, 201, 100, 30);
        frame.getContentPane().add(registerButton);
        
        JButton exitbtn = new JButton("Exit");
        exitbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        exitbtn.setBounds(0, 201, 106, 30);
        frame.getContentPane().add(exitbtn);
        
        JLabel lblNewLabel = new JLabel("KEREM GAMING MARKETPLACE");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(10, 11, 316, 45);
        frame.getContentPane().add(lblNewLabel);

    
        registerButton.addActionListener(new ActionListener() {
   
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
               
                    public void run() {
                        RegistrationPage.main(new String[]{});
                    }
                });
            }
        });

   
        frame.setVisible(true);
    }
private static void openGameInfoPage() {
    SwingUtilities.invokeLater(new Runnable() {
       
        public void run() {
            GameInfoPage.main(new String[]{});
        }
    });
}
}
