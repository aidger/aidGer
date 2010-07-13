package de.aidger.view;

import static de.aidger.utils.Translation._;
import de.aidger.controller.ActionNotFoundException;
import de.aidger.controller.ActionRegistry;
import de.aidger.controller.actions.ExitAction;
import de.aidger.controller.actions.FirstStartCloseAction;
import de.aidger.model.models.Activity;
import de.aidger.view.utils.InputPatternFilter;

import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.List;


/**
 * Displays a dialog to enter the name on the first start
 *
 * @author aidGer Team
 */
public class FirstStartDialog extends javax.swing.JDialog {

    /**
     * Has a connection been established.
     */
    protected boolean connected = false;

    /** 
     * Creates new form FirstStartDialog
     */
    public FirstStartDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try {
            jButton1.setAction(ActionRegistry.getInstance().get(
                    FirstStartCloseAction.class.getName()));
            jButton1.setEnabled(false);
            jButton2.setAction(ActionRegistry.getInstance().get(
                    ExitAction.class.getName()));
        } catch (ActionNotFoundException ex) {
            UI.displayError(ex.getMessage());
        }

        InputPatternFilter.addFilter(nameTextField, "[a-zA-ZüöäÜÖÄ]+");

        setDefaultCloseOperation(javax.swing.WindowConstants.
                DO_NOTHING_ON_CLOSE);

        BackgroundThread thread = new BackgroundThread();
        thread.start();

        setLocationRelativeTo(null);

        nameTextField.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                if (nameTextField.getText().isEmpty()) {
                    jButton1.setEnabled(false);
                } else if (connected) {
                    jButton1.setEnabled(true);
                }
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
 });
    }

    /**
     * Get the entered name.
     *
     * @return The entered name
     */
    public String getEnteredName() {
        return nameTextField.getText();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        connectLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(_("First Start"));
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModal(true);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(_("Welcome to aidGer"));

        jLabel2.setText(_("Before you can start working, please enter your Name."));

        jLabel3.setText(_("It will be used in all your activities."));

        jButton1.setText(_("Close"));

        jLabel4.setText(_("Name:"));

        jLabel5.setText(_("While you enter your name, aidGer will try to connect to the database."));

        connectLabel.setForeground(new java.awt.Color(255, 4, 4));
        connectLabel.setText(_("Trying to connect ..."));

        jButton2.setText("Quit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(connectLabel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(connectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel connectLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nameTextField;
    // End of variables declaration//GEN-END:variables


    private class BackgroundThread extends Thread {

        @Override
        public void run() {
            List lst = null;
            try {
                 lst = (new Activity()).getAll();
            } catch (AdoHiveException ex) {
            }

            if (lst == null) {
                connectLabel.setText(
                        _("Connection failed. Please check with your Administrator"));
            } else {
                connectLabel.setForeground(Color.green);
                connectLabel.setText(_("Connection successfull."));
                if (!nameTextField.getText().isEmpty()) {
                    jButton1.setEnabled(true);
                }
                connected = true;
            }
        }
    }

}
