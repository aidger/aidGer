package de.aidger.view.tabs;

import static de.aidger.utils.Translation._;

import javax.swing.JButton;

import de.aidger.model.models.Assistant;
import de.aidger.view.tabs.MasterDataViewerTab.MasterDataType;

/**
 * A tab used for editing / creating new assistants.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class AssistantEditorTab extends MasterDataEditorTab {

    /**
     * Constructs a new assistant editor tab.
     */
    public AssistantEditorTab() {
        super(MasterDataType.Assistant);
    }

    /**
     * Constructs a new assistant editor tab.
     * 
     * @param assistant
     *            The assistant who will be edited
     */
    public AssistantEditorTab(Assistant assistant) {
        super(MasterDataType.Assistant, assistant);

        // TODO
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.tabs.MasterDataEditorTab#init()
     */
    @Override
    protected void init() {
        initComponents();
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.tabs.MasterDataEditorTab#setModel()
     */
    @Override
    public void setModel() {
        Assistant assistant = (Assistant) model;

        assistant.setFirstName(txtFirstName.getText());
        assistant.setLastName(txtLastName.getText());
        assistant.setEmail(txtEmail.getText());
        assistant.setQualification(txtQualification.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblQualification = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtQualification = new javax.swing.JTextField();
        buttons = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        filler = new javax.swing.JLabel();
        filler2 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        lblFirstName.setText(_("First Name"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblFirstName, gridBagConstraints);

        lblLastName.setText(_("Last Name"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblLastName, gridBagConstraints);

        lblEmail.setText(_("Email"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblEmail, gridBagConstraints);

        lblQualification.setText(_("Qualification"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblQualification, gridBagConstraints);

        txtFirstName.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtFirstName, gridBagConstraints);

        txtLastName.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtLastName, gridBagConstraints);

        txtEmail.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtEmail, gridBagConstraints);

        txtQualification.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtQualification, gridBagConstraints);

        btnSave.setText(_("Save"));
        buttons.add(btnSave);

        btnCancel.setText(_("Cancel"));
        buttons.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(buttons, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.weightx = 1.0;
        add(filler, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weighty = 1.0;
        add(filler2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel buttons;
    private javax.swing.JLabel filler;
    private javax.swing.JLabel filler2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblQualification;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtQualification;

    // End of variables declaration//GEN-END:variables

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.tabs.MasterDataEditorTab#getButtonCancel()
     */
    @Override
    protected JButton getButtonCancel() {
        return btnCancel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.tabs.MasterDataEditorTab#getButtonSave()
     */
    @Override
    protected JButton getButtonSave() {
        return btnSave;
    }

}
