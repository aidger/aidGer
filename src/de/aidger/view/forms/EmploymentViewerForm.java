package de.aidger.view.forms;

import static de.aidger.utils.Translation._;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JPanel;

import de.aidger.model.Runtime;
import de.aidger.model.models.Assistant;
import de.aidger.model.models.Contract;
import de.aidger.model.models.CostUnit;
import de.aidger.model.models.Course;
import de.aidger.model.models.Employment;
import de.aidger.view.forms.HourlyWageEditorForm.Qualification;
import de.aidger.view.models.UIAssistant;
import de.aidger.view.models.UIContract;
import de.aidger.view.models.UICourse;
import de.aidger.view.utils.NumberFormat;
import de.aidger.view.utils.UICostUnit;
import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;
import de.unistuttgart.iste.se.adohive.model.IAssistant;
import de.unistuttgart.iste.se.adohive.model.IContract;
import de.unistuttgart.iste.se.adohive.model.ICourse;

/**
 * A form used for viewing employments in detail.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class EmploymentViewerForm extends JPanel {

    /**
     * Constructs an employment viewer form.
     * 
     * @param employment
     *            The employment that will be displayed
     */
    public EmploymentViewerForm(Employment employment) {
        initComponents();

        try {
            IAssistant a_ = (new Assistant()).getById(employment
                .getAssistantId());

            Assistant a = new UIAssistant(a_);

            ICourse c_ = (new Course()).getById(employment.getCourseId());

            Course c = new UICourse(c_);

            IContract co_ = (new Contract())
                .getById(employment.getContractId());

            Contract co = new UIContract(co_);

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, employment.getMonth() - 1);
            cal.set(Calendar.YEAR, employment.getYear());

            assistant.setText(a.toString());
            course.setText(c.toString());
            contract.setText(co.toString());
            date.setText((new SimpleDateFormat("MM.yyyy"))
                .format(cal.getTime()));
            hourCount.setText(NumberFormat.getInstance().format(
                employment.getHourCount()));
            costUnit.setText(UICostUnit.valueOf(employment.getCostUnit()));
            CostUnit costUnit_ = Runtime.getInstance().getDataXMLManager()
                .fromTokenDB(employment.getFunds());
            funds.setText(costUnit_ == null ? employment.getFunds() : costUnit_
                .toString());
            qualification.setText(Qualification.valueOf(
                employment.getQualification()).toString());
            remark.setText(employment.getRemark());

        } catch (AdoHiveException e) {
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

        lblAssistant = new javax.swing.JLabel();
        lblCourse = new javax.swing.JLabel();
        lblContract = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblHourCount = new javax.swing.JLabel();
        lblCostUnit = new javax.swing.JLabel();
        lblFunds = new javax.swing.JLabel();
        lblQualification = new javax.swing.JLabel();
        lblRemark = new javax.swing.JLabel();
        assistant = new javax.swing.JLabel();
        course = new javax.swing.JLabel();
        contract = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        hourCount = new javax.swing.JLabel();
        costUnit = new javax.swing.JLabel();
        funds = new javax.swing.JLabel();
        qualification = new javax.swing.JLabel();
        remark = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        lblAssistant.setText(_("Assistant"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        add(lblAssistant, gridBagConstraints);

        lblCourse.setText(_("Course"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        add(lblCourse, gridBagConstraints);

        lblContract.setText(_("Contract"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblContract, gridBagConstraints);

        lblDate.setText(_("Date"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblDate, gridBagConstraints);

        lblHourCount.setText(_("Hour count"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblHourCount, gridBagConstraints);

        lblCostUnit.setText(_("Cost unit"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        add(lblCostUnit, gridBagConstraints);

        lblFunds.setText(_("Funds"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblFunds, gridBagConstraints);

        lblQualification.setText(_("Qualification"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        add(lblQualification, gridBagConstraints);

        lblRemark.setText(_("Remark"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblRemark, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(assistant, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(course, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(contract, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(date, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(hourCount, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(costUnit, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(funds, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(qualification, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(remark, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assistant;
    private javax.swing.JLabel contract;
    private javax.swing.JLabel costUnit;
    private javax.swing.JLabel course;
    private javax.swing.JLabel date;
    private javax.swing.JLabel funds;
    private javax.swing.JLabel hourCount;
    private javax.swing.JLabel lblAssistant;
    private javax.swing.JLabel lblContract;
    private javax.swing.JLabel lblCostUnit;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFunds;
    private javax.swing.JLabel lblHourCount;
    private javax.swing.JLabel lblQualification;
    private javax.swing.JLabel lblRemark;
    private javax.swing.JLabel qualification;
    private javax.swing.JLabel remark;
    // End of variables declaration//GEN-END:variables
}
