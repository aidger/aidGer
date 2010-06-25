package de.aidger.view.forms;

import static de.aidger.utils.Translation._;

import javax.swing.JPanel;

import de.aidger.model.budgets.CourseBudget;
import de.aidger.model.models.Course;
import de.aidger.model.models.FinancialCategory;
import de.aidger.utils.Logger;
import de.aidger.view.models.UIFinancialCategory;
import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;
import de.unistuttgart.iste.se.adohive.model.IFinancialCategory;

/**
 * A form used for viewing courses in detail.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class CourseViewerForm extends JPanel {

    /**
     * Constructs a course viewer form.
     * 
     * @param course
     *            The course that will be displayed
     */
    public CourseViewerForm(Course course) {
        initComponents();

        description.setText(course.getDescription());
        semester.setText(course.getSemester());
        lecturer.setText(course.getLecturer());
        advisor.setText(course.getAdvisor());
        targetAudience.setText(course.getTargetAudience());
        numberOfGroups.setText(String.valueOf(course.getNumberOfGroups()));
        AWHperGroup.setText(String.valueOf(course.getUnqualifiedWorkingHours())
                + "h");
        bookedBudget.setText(String.valueOf((new CourseBudget(course))
            .getBookedBudget())
                + "h");
        totalBudget.setText(String.valueOf(course.getNumberOfGroups()
                * course.getUnqualifiedWorkingHours())
                + "h");
        scope.setText(course.getScope());
        part.setText(String.valueOf(course.getPart()));
        group.setText(course.getGroup());
        remark.setText(course.getRemark());

        try {
            IFinancialCategory fc = (new FinancialCategory()).getById(course
                .getFinancialCategoryId());

            financialCategory.setText(new UIFinancialCategory(fc).toString());
        } catch (AdoHiveException e) {
            Logger.error(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblDescription = new javax.swing.JLabel();
        lblSemester = new javax.swing.JLabel();
        lblLecturer = new javax.swing.JLabel();
        lblAdvisor = new javax.swing.JLabel();
        lblNumberOfGroups = new javax.swing.JLabel();
        lblTargetAudience = new javax.swing.JLabel();
        lblAWHperGroup = new javax.swing.JLabel();
        lblBookedBudget = new javax.swing.JLabel();
        lblTotalBudget = new javax.swing.JLabel();
        lblScope = new javax.swing.JLabel();
        lblPart = new javax.swing.JLabel();
        lblGroup = new javax.swing.JLabel();
        lblRemark = new javax.swing.JLabel();
        lblFinancialCategory = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        semester = new javax.swing.JLabel();
        lecturer = new javax.swing.JLabel();
        advisor = new javax.swing.JLabel();
        numberOfGroups = new javax.swing.JLabel();
        targetAudience = new javax.swing.JLabel();
        AWHperGroup = new javax.swing.JLabel();
        bookedBudget = new javax.swing.JLabel();
        totalBudget = new javax.swing.JLabel();
        scope = new javax.swing.JLabel();
        part = new javax.swing.JLabel();
        group = new javax.swing.JLabel();
        remark = new javax.swing.JLabel();
        financialCategory = new javax.swing.JLabel();

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

        lblAdvisor.setText(_("Advisor"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblAdvisor, gridBagConstraints);

        lblNumberOfGroups.setText(_("Number of Groups"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblNumberOfGroups, gridBagConstraints);

        lblTargetAudience.setText(_("Target Audience"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblTargetAudience, gridBagConstraints);

        lblAWHperGroup.setText(_("AWH per group"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblAWHperGroup, gridBagConstraints);

        lblBookedBudget.setText(_("Booked budgets"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblBookedBudget, gridBagConstraints);

        lblTotalBudget.setText(_("Total budgets"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblTotalBudget, gridBagConstraints);

        lblScope.setText(_("Scope"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblScope, gridBagConstraints);

        lblPart.setText(_("Part"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblPart, gridBagConstraints);

        lblGroup.setText(_("Group"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblGroup, gridBagConstraints);

        lblRemark.setText(_("Remark"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblRemark, gridBagConstraints);

        lblFinancialCategory.setText(_("Financial Category"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblFinancialCategory, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(description, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(semester, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lecturer, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(advisor, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(numberOfGroups, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(targetAudience, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(AWHperGroup, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(bookedBudget, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(totalBudget, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(scope, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(part, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(group, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(remark, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(financialCategory, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AWHperGroup;
    private javax.swing.JLabel advisor;
    private javax.swing.JLabel bookedBudget;
    private javax.swing.JLabel description;
    private javax.swing.JLabel financialCategory;
    private javax.swing.JLabel group;
    private javax.swing.JLabel lblAWHperGroup;
    private javax.swing.JLabel lblAdvisor;
    private javax.swing.JLabel lblBookedBudget;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblFinancialCategory;
    private javax.swing.JLabel lblGroup;
    private javax.swing.JLabel lblLecturer;
    private javax.swing.JLabel lblNumberOfGroups;
    private javax.swing.JLabel lblPart;
    private javax.swing.JLabel lblRemark;
    private javax.swing.JLabel lblScope;
    private javax.swing.JLabel lblSemester;
    private javax.swing.JLabel lblTargetAudience;
    private javax.swing.JLabel lblTotalBudget;
    private javax.swing.JLabel lecturer;
    private javax.swing.JLabel numberOfGroups;
    private javax.swing.JLabel part;
    private javax.swing.JLabel remark;
    private javax.swing.JLabel scope;
    private javax.swing.JLabel semester;
    private javax.swing.JLabel targetAudience;
    private javax.swing.JLabel totalBudget;
    // End of variables declaration//GEN-END:variables

}
