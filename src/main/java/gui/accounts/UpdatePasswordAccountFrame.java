package gui.accounts;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import domain.IUser;
import gui.AppFrame;
import service.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

/**
 * Classe représentant une fenêtre de modification du mot de passe de l'utilisateur connecté.
 *
 * @author Laurent THIEBAULT & Ludovic LANDSCHOOT
 */
public class UpdatePasswordAccountFrame extends AppFrame {
    private UserService userService;

    private IUser user;

    private JPanel mainPanel;
    private JLabel errorLabel;
    private JButton saveButton;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;

    public UpdatePasswordAccountFrame(IUser user) {
        this.userService = UserService.getInstance();
        this.user = user;
        initComponents();
        initButtons();
        this.setVisible(true);
    }

    /**
     * Initialise les boutons de la fenêtre.
     */
    public void initButtons() {
        saveButton.addActionListener((ActionEvent e) -> {
            if (!fieldsEmpty()) {
                if (Arrays.equals(passwordField1.getPassword(), passwordField2.getPassword())) {
                    user.setPassword(new String(passwordField1.getPassword()));
                    userService.updatePassword(user);
                    JOptionPane.showMessageDialog(new JFrame(), "Mot de passe mis à jour avec succès.");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Les champs doivent être identiques.");
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Veuillez remplir l'ensemble des champs.");
            }
        });
    }

    /**
     * Permet de savoir si un champ n'est pas rempli.
     * @return
     */
    public boolean fieldsEmpty() {
        return this.passwordField1.getPassword().length == 0 ||
                this.passwordField2.getPassword().length == 0;
    }

    @Override
    public void initComponents() {
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setContentPane(mainPanel);

        this.setTitle("Modifier le mot de passe");
        this.setSize(400, 230);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
        mainPanel.setLayout(new GridLayoutManager(6, 3, new Insets(0, 0, 0, 0), -1, -1));
        final Spacer spacer1 = new Spacer();
        mainPanel.add(spacer1, new GridConstraints(0, 2, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Confirmation");
        mainPanel.add(label1, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        errorLabel = new JLabel();
        errorLabel.setForeground(new Color(-3932139));
        errorLabel.setText("");
        mainPanel.add(errorLabel, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Mot de passe");
        mainPanel.add(label2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveButton = new JButton();
        saveButton.setText("Enregistrer");
        mainPanel.add(saveButton, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordField1 = new JPasswordField();
        mainPanel.add(passwordField1, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        passwordField2 = new JPasswordField();
        mainPanel.add(passwordField2, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
