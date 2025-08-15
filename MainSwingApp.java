package staj;

import staj.models.User;
import staj.services.UserService;

import javax.swing.*;
import java.awt.*;

public class MainSwingApp {
    private static UserService userService = new UserService();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainSwingApp::showLoginScreen);
    }

    private static void showLoginScreen() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signupButton);

        frame.add(panel);
        frame.setVisible(true);

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String pass = new String(passwordField.getPassword());
            User user = userService.login(email, pass);

            if (user != null) {
                frame.dispose();
                showDashboard(user);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid email or password");
            }
        });

        signupButton.addActionListener(e -> {
            frame.dispose();
            showSignupScreen();
        });
    }

    private static void showSignupScreen() {
        JFrame frame = new JFrame("Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField roleField = new JTextField();

        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Role (client/trainer/admin):"));
        panel.add(roleField);
        panel.add(registerButton);
        panel.add(backButton);

        frame.add(panel);
        frame.setVisible(true);

        registerButton.addActionListener(e -> {
            int id = userService.getNextId();
            String name = nameField.getText();
            String email = emailField.getText();
            String pass = new String(passwordField.getPassword());
            String role = roleField.getText();

            User user = new User(id, name, email, pass, role);
            if (userService.register(user)) {
                JOptionPane.showMessageDialog(frame, "Registration successful!");
                frame.dispose();
                showLoginScreen();
            } else {
                JOptionPane.showMessageDialog(frame, "User already exists!");
            }
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            showLoginScreen();
        });
    }

    private static void showDashboard(User user) {
        JFrame frame = new JFrame("Dashboard - " + user.getRole());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Welcome, " + user.getName() + "! Role: " + user.getRole(), SwingConstants.CENTER);

        frame.add(label);
        frame.setVisible(true);
    }
}