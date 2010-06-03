package de.aidger.view.tabs;

import static de.aidger.utils.Translation._;

import javax.swing.JButton;

import de.aidger.model.models.Course;
import de.aidger.view.tabs.MasterDataViewerTab.MasterDataType;

/**
 * A tab for editing / creating new courses.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class CourseEditorTab extends MasterDataEditorTab {

    /**
     * Constructs a course editor tab.
     */
    public CourseEditorTab() {
        super(MasterDataType.Course);
    }

    /**
     * Constructs a course editor tab.
     * 
     * @param course
     *            The course that will be edited
     */
    public CourseEditorTab(Course course) {
        super(MasterDataType.Course, course);

        txtDescription.setText(course.getDescription());
        txtSemester.setText(course.getSemester());
        txtLecturer.setText(course.getLecturer());
        txtTargetAudience.setText(course.getTargetAudience());
        spNumberOfGroups.setValue(course.getNumberOfGroups());
        txtGrantedAWH.setText(String.valueOf(course
                .getUnqualifiedWorkingHours()));
        txtScope.setText(course.getScope());
        txtPart.setText(String.valueOf(course.getPart()));
        txtGroup.setText(course.getGroup());
        txtRemark.setText(course.getRemark());

        // TODO set financial category
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
        Course course = (Course) model;

        // just temporary..
        if (txtGrantedAWH.getText().isEmpty()) {
            txtGrantedAWH.setText("0");
        }

        if (txtPart.getText().isEmpty()) {
            txtPart.setText(" ");
        }

        course.setDescription(txtDescription.getText());
        course.setSemester(txtSemester.getText());
        course.setLecturer(txtLecturer.getText());
        course.setNumberOfGroups((Integer) spNumberOfGroups.getValue());
        course.setTargetAudience(txtTargetAudience.getText());
        course.setUnqualifiedWorkingHours(Double.valueOf(txtGrantedAWH
                .getText()));
        course.setScope(txtScope.getText());
        course.setPart(txtPart.getText().charAt(0));
        course.setGroup(txtGroup.getText());
        course.setRemark(txtRemark.getText());

        // TODO set financial category
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
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
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
        spNumberOfGroups = new javax.swing.JSpinner();
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
        cmbFinancialCategory = new javax.swing.JComboBox();
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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(spNumberOfGroups, gridBagConstraints);

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

        lblFinancialCategory.setText(_("Financial Category"));
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

        cmbFinancialCategory.setModel(new javax.swing.DefaultComboBoxModel(
                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(cmbFinancialCategory, gridBagConstraints);

        btnSave.setText(_("Save"));
        buttons.add(btnSave);

        btnCancel.setText(_("Cancel"));
        buttons.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(buttons, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel buttons;
    private javax.swing.JComboBox cmbFinancialCategory;
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
    private javax.swing.JSpinner spNumberOfGroups;
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
