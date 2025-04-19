package com.login;

import javax.swing.*;
import java.awt.*;

public class Loginpage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Loginpage() {
        setTitle("Login Page");
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Font customFont = new Font("Segoe UI", Font.PLAIN, 20);
        Font titleFont = new Font("Segoe UI", Font.BOLD, 32);

        // Background Panel with Image
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

        // Main panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setOpaque(false);

        JLabel welcomeLabel = new JLabel("Welcome!");
        welcomeLabel.setFont(titleFont);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setForeground(new Color(33, 49, 89));
        formPanel.add(welcomeLabel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        Dimension fieldSize = new Dimension(380, 55);

        usernameField = new JTextField();
        usernameField.setFont(customFont);
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));
        usernameField.setPreferredSize(fieldSize);
        usernameField.setMaximumSize(fieldSize);
        usernameField.setMinimumSize(fieldSize);
        formPanel.add(usernameField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        passwordField = new JPasswordField();
        passwordField.setFont(customFont);
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        passwordField.setPreferredSize(fieldSize);
        passwordField.setMaximumSize(fieldSize);
        passwordField.setMinimumSize(fieldSize);
        formPanel.add(passwordField);
        formPanel.add(Box.createRigidArea(new Dimension(0, 25)));

        JButton loginButton = new JButton("Log in");
        loginButton.setFont(customFont);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setBackground(Color.WHITE);
        loginButton.setPreferredSize(fieldSize);
        loginButton.setMaximumSize(fieldSize);
        loginButton.setMinimumSize(fieldSize);
        formPanel.add(loginButton);
        formPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JButton forgotPassword = new JButton("Forgot Password");
        forgotPassword.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        forgotPassword.setBorderPainted(false);
        forgotPassword.setContentAreaFilled(false);
        forgotPassword.setForeground(Color.BLUE);
        forgotPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(forgotPassword);
        formPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JButton createButton = new JButton("Create");
        createButton.setFont(customFont);
        createButton.setBackground(Color.WHITE);
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createButton.setPreferredSize(fieldSize);
        createButton.setMaximumSize(fieldSize);
        createButton.setMinimumSize(fieldSize);
        formPanel.add(createButton);
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel registerLabel = new JLabel("Don't Have an Account?");
        registerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        registerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(registerLabel);

        // Adding form panel to background
        backgroundPanel.add(formPanel);
        add(backgroundPanel);

        // Event Handlers
        loginButton.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (user.equals("admin") && pass.equals("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        createButton.addActionListener(e -> {
            new RegistrationPage().setVisible(true);
            dispose();
        });

        forgotPassword.addActionListener(e -> JOptionPane.showMessageDialog(this, "Redirecting to Password Recovery..."));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Loginpage().setVisible(true);
        });
    }
}
