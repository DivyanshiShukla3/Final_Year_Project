package com.login;

import javax.swing.*;
import java.awt.*;

public class RegistrationPage extends JFrame {
    private JTextField emailField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public RegistrationPage() {
        setTitle("Registration Page");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Font customFont = new Font("Segoe UI", Font.PLAIN, 20);
        Font titleFont = new Font("Segoe UI", Font.BOLD, 30);

        // Background Panel with image
        JPanel backgroundPanel = new JPanel() {
            ImageIcon bg = new ImageIcon("images/bg.png");
            Image image = bg.getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setOpaque(false);

        JLabel titleLabel = new JLabel("Create an Account");
        titleLabel.setFont(titleFont);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(33, 49, 89));
        formPanel.add(titleLabel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        Dimension fieldSize = new Dimension(400, 55);

        emailField = new JTextField();
        emailField.setFont(customFont);
        emailField.setBorder(BorderFactory.createTitledBorder("Email"));
        setFieldSize(emailField, fieldSize);
        formPanel.add(emailField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        usernameField = new JTextField();
        usernameField.setFont(customFont);
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));
        setFieldSize(usernameField, fieldSize);
        formPanel.add(usernameField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        passwordField = new JPasswordField();
        passwordField.setFont(customFont);
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        setFieldSize(passwordField, fieldSize);
        formPanel.add(passwordField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(customFont);
        confirmPasswordField.setBorder(BorderFactory.createTitledBorder("Confirm Password"));
        setFieldSize(confirmPasswordField, fieldSize);
        formPanel.add(confirmPasswordField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton registerButton = new JButton("Register");
        registerButton.setFont(customFont);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        setFieldSize(registerButton, fieldSize);
        formPanel.add(registerButton);
        formPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JButton googleButton = new JButton("Sign in with Google");
        googleButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        googleButton.setForeground(Color.WHITE);
        googleButton.setBackground(new Color(219, 68, 55)); // Google red
        googleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        setFieldSize(googleButton, fieldSize);
        formPanel.add(googleButton);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton backToLogin = new JButton("Back to Login");
        backToLogin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        backToLogin.setBorderPainted(false);
        backToLogin.setContentAreaFilled(false);
        backToLogin.setForeground(Color.BLUE);
        backToLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(backToLogin);

        backgroundPanel.add(formPanel);
        add(backgroundPanel);

        // Action listeners
        registerButton.addActionListener(e -> {
            String email = emailField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Registered successfully!");
            }
        });

        backToLogin.addActionListener(e -> {
            new Loginpage().setVisible(true);
            dispose();
        });

        googleButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Redirecting to Google sign-in...");
        });
    }

    private void setFieldSize(JComponent comp, Dimension size) {
        comp.setPreferredSize(size);
        comp.setMaximumSize(size);
        comp.setMinimumSize(size);
        comp.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegistrationPage().setVisible(true);
        });
    }
}
