package gui;

import domain.User;
import service.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

public class LoginFrame extends AppFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JPanel navPanel;
    private JPanel bodyPanel;
    private JLabel logoLabel;
    private JPanel formPanel;
    private JTextField loginField;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton connectButton;
    private JLabel errorLabel;
    private JLabel userLabel;

    private UserService userService;

    public LoginFrame() {
        this.userService = UserService.getInstance();
        this.setContentPane(this.mainPanel);
        initFrame();
        initPanels();
        initLabels();
        configConnectButton();
        this.setVisible(true);
    }

    public void initPanels() {
        this.bodyPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
    }

    public void initLabels() {
        this.titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.userLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logo.png"));
        this.logoLabel.setIcon(icon);
    }

    public void configConnectButton() {
        connectButton.addActionListener(event -> {
            if (!fieldEmpty()) {
                try {
                    checkUser(this.userService.findByCredentials(this.loginField.getText(), new String(this.passwordField.getPassword())));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                this.errorLabel.setText("Veuillez remplir l'ensemble des champs");
            }
        });
    }

    public boolean fieldEmpty() {
        return this.loginField.getText() == "" || this.passwordField.getPassword().length == 0;
    }

    public void checkUser(User user) {
        if (user != null) {
            this.setVisible(false);
            if (user.getRole().equals("USER_ADMIN")) {
                new AdminFrame();
            } else {
                new UserFrame();
            }
        } else {
            this.errorLabel.setText("Identifiant / Mot de passe incorrects");
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        navPanel = new JPanel();
        navPanel.setLayout(new BorderLayout(0, 0));
        navPanel.setBackground(new Color(-12887656));
        navPanel.setForeground(new Color(-1771521));
        mainPanel.add(navPanel, BorderLayout.NORTH);
        titleLabel = new JLabel();
        titleLabel.setEnabled(true);
        titleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));
        titleLabel.setForeground(new Color(-1705985));
        titleLabel.setHorizontalAlignment(2);
        titleLabel.setText("chatbook");
        navPanel.add(titleLabel, BorderLayout.WEST);
        userLabel = new JLabel();
        userLabel.setForeground(new Color(-1705985));
        userLabel.setText("Label");
        navPanel.add(userLabel, BorderLayout.EAST);
        bodyPanel = new JPanel();
        bodyPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.add(bodyPanel, BorderLayout.CENTER);
        logoLabel = new JLabel();
        logoLabel.setHorizontalAlignment(0);
        logoLabel.setText("");
        bodyPanel.add(logoLabel, BorderLayout.NORTH);
        formPanel = new JPanel();
        formPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(40, 200, 200, 200), -1, -1));
        bodyPanel.add(formPanel, BorderLayout.CENTER);
        loginLabel = new JLabel();
        loginLabel.setText("Identifiant");
        formPanel.add(loginLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordLabel = new JLabel();
        passwordLabel.setText("Mot de passe");
        formPanel.add(passwordLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        loginField = new JTextField();
        formPanel.add(loginField, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        passwordField = new JPasswordField();
        formPanel.add(passwordField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        connectButton = new JButton();
        connectButton.setText("Se connecter");
        formPanel.add(connectButton, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        errorLabel = new JLabel();
        errorLabel.setForeground(new Color(-3932126));
        errorLabel.setText("");
        formPanel.add(errorLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
