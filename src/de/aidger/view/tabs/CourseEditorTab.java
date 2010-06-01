package de.aidger.view.tabs;

import static de.aidger.utils.Translation._;

/**
 * A Tab for editing/creating new courses.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class CourseEditorTab extends Tab {

    /**
     * Initializes a new CourseEditorTab with the required fields for all
     * relevant data.
     */
    public CourseEditorTab() {
        initComponents();
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.tabs.Tab#getTabName()
     */
    @Override
    public String getTabName() {
        return _("Course Editing");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblDescription = new javax.swing.JLabel();
        lblSemester = new javax.swing.JLabel();
        lblLecturer = new javax.swing.JLabel();
        lblNumberOfGroups = new javax.swing.JLabel();
        lblTargetAudience = new javax.swing.JLabel();
        lblGrantedAWH = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        txtSemester = new javax.swing.JTextField();
        txtLecturer = new javax.swing.JTextField();
        txtTargetAudience = new javax.swing.JTextField();
        txtGrantedAWH = new javax.swing.JTextField();
        lblScope = new javax.swing.JLabel();
        lblPart = new javax.swing.JLabel();
        lblGroup = new javax.swing.JLabel();
        lblRemark = new javax.swing.JLabel();
        lblFinancialCategory = new javax.swing.JLabel();
        filler = new javax.swing.JLabel();
        filler2 = new javax.swing.JLabel();
        txtScope = new javax.swing.JTextField();
        txtPart = new javax.swing.JTextField();
        txtGroup = new javax.swing.JTextField();
        txtRemark = new javax.swing.JTextField();
        buttons = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        lblDescription.setText(_("Description"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblDescription, gridBagConstraints);

        lblSemester.setText(_("Semester"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblSemester, gridBagConstraints);

        lblLecturer.setText(_("Lecturer"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblLecturer, gridBagConstraints);

        lblNumberOfGroups.setText(_("Number of Groups"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblNumberOfGroups, gridBagConstraints);

        lblTargetAudience.setText(_("Target Audience"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblTargetAudience, gridBagConstraints);

        lblGrantedAWH.setText(_("Granted AWH"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblGrantedAWH, gridBagConstraints);

        txtDescription.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtDescription, gridBagConstraints);

        txtSemester.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtSemester, gridBagConstraints);

        txtLecturer.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtLecturer, gridBagConstraints);

        txtTargetAudience.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtTargetAudience, gridBagConstraints);

        txtGrantedAWH.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtGrantedAWH, gridBagConstraints);

        lblScope.setText(_("Scope"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        add(lblScope, gridBagConstraints);

        lblPart.setText(_("Part"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        add(lblPart, gridBagConstraints);

        lblGroup.setText(_("Group"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        add(lblGroup, gridBagConstraints);

        lblRemark.setText(_("Remark"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        add(lblRemark, gridBagConstraints);

        lblFinancialCategory.setText(_("Group"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        add(lblFinancialCategory, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.weightx = 1.0;
        add(filler, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.weighty = 1.0;
        add(filler2, gridBagConstraints);

        txtScope.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtScope, gridBagConstraints);

        txtPart.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtPart, gridBagConstraints);

        txtGroup.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtGroup, gridBagConstraints);

        txtRemark.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtRemark, gridBagConstraints);

        btnSave.setText(_("Save"));
        buttons.add(btnSave);

        btnCancel.setText(_("Cancel"));
        buttons.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        add(buttons, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel buttons;
    private javax.swing.JLabel filler;
    private javax.swing.JLabel filler2;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblFinancialCategory;
    private javax.swing.JLabel lblGrantedAWH;
    private javax.swing.JLabel lblGroup;
    private javax.swing.JLabel lblLecturer;
    private javax.swing.JLabel lblNumberOfGroups;
    private javax.swing.JLabel lblPart;
    private javax.swing.JLabel lblRemark;
    private javax.swing.JLabel lblScope;
    private javax.swing.JLabel lblSemester;
    private javax.swing.JLabel lblTargetAudience;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtGrantedAWH;
    private javax.swing.JTextField txtGroup;
    private javax.swing.JTextField txtLecturer;
    private javax.swing.JTextField txtPart;
    private javax.swing.JTextField txtRemark;
    private javax.swing.JTextField txtScope;
    private javax.swing.JTextField txtSemester;
    private javax.swing.JTextField txtTargetAudience;
    // End of variables declaration//GEN-END:variables

}
