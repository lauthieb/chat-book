package gui.login;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import domain.User;
import gui.AppFrame;
import gui.MainFrame;
import persistence.db.SingletonDB;
import service.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Classe représentant la fenêtre de connexion à l'application.
 *
 * @author Laurent THIEBAULT & Ludovic LANDSCHOOT
 */
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
        initComponents();
        configListeners();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
            SingletonDB.getInstance().close();
            }
        });
        this.setVisible(true);
    }

    /**
     * Initialise les composants de la fenêtre.
     */
    public void initComponents() {
        this.titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/logo.png"));
        this.logoLabel.setIcon(icon);
        this.bodyPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
    }

    /**
     * Configure les listeners sur les différents boutons et champs de saisie.
     */
    public void configListeners() {
        connectButton.addActionListener((ActionEvent e) -> connect());

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    connect();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        loginField.addKeyListener(keyListener);
        passwordField.addKeyListener(keyListener);
    }

    /**
     * Connexion à l'application
     */
    private void connect() {
        if (!fieldsEmpty()) {
            try {
                checkUser(this.userService.findByCredentials(this.loginField.getText(), new String(this.passwordField.getPassword())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.errorLabel.setText("Veuillez remplir l'ensemble des champs");
        }
    }

    /**
     * Permet de savoir si un champ n'est pas rempli.
     * @return
     */
    public boolean fieldsEmpty() {
        return this.loginField.getText() == "" || this.passwordField.getPassword().length == 0;
    }

    /**
     * Permet de savoir si l'utilisateur peut accéder à l'application.
     * @param user
     */
    public void checkUser(User user) {
        if (user != null) {
            this.setVisible(false);
            new MainFrame();
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
        bodyPanel = new JPanel();
        bodyPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.add(bodyPanel, BorderLayout.CENTER);
        logoLabel = new JLabel();
        logoLabel.setHorizontalAlignment(0);
        logoLabel.setText("");
        bodyPanel.add(logoLabel, BorderLayout.NORTH);
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayoutManager(4, 2, new Insets(40, 200, 200, 200), -1, -1));
        bodyPanel.add(formPanel, BorderLayout.CENTER);
        loginLabel = new JLabel();
        loginLabel.setText("Identifiant");
        formPanel.add(loginLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordLabel = new JLabel();
        passwordLabel.setText("Mot de passe");
        formPanel.add(passwordLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        loginField = new JTextField();
        formPanel.add(loginField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        passwordField = new JPasswordField();
        formPanel.add(passwordField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        connectButton = new JButton();
        connectButton.setText("Se connecter");
        formPanel.add(connectButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        errorLabel = new JLabel();
        errorLabel.setForeground(new Color(-3932126));
        errorLabel.setText("");
        formPanel.add(errorLabel, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
