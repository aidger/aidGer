package de.aidger.view.forms;

import static de.aidger.utils.Translation._;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.text.DefaultFormatter;

import de.aidger.model.models.HourlyWage;
import de.aidger.view.utils.InputPatternFilter;

/**
 * A form used for editing / creating new hourly wages.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class HourlyWageEditorForm extends JPanel {

    public enum Qualification {
        u(_("Unchecked")), g(_("Checked")), b(_("Bachelor"));

        /**
         * The display name of an item.
         */
        private final String displayName;

        /**
         * Constructs a qualification item.
         * 
         * @param displayName
         *            the display name of the item
         */
        Qualification(final String displayName) {
            this.displayName = displayName;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return displayName;
        }
    }

    /**
     * Constructs a hourly wage editor form.
     * 
     * @param hw
     *            the hourly wage that will be edited
     */
    public HourlyWageEditorForm(HourlyWage hw) {
        initComponents();

        // add input filters
        InputPatternFilter.addFilter(txtWage, "[0-9]+[.,]?[0-9]{0,2}");

        ((DefaultFormatter) ((JSpinner.DefaultEditor) spDate.getEditor())
            .getTextField().getFormatter()).setAllowsInvalid(false);

        if (hw != null) {
            cmbQualification.setSelectedItem(Qualification.valueOf(hw
                .getQualification()));
            txtWage.setText(String.valueOf(hw.getWage()));

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, hw.getMonth() - 1);
            cal.set(Calendar.YEAR, hw.getYear());
            spDate.setValue(cal.getTime());

            lblStartDate.setVisible(false);
            spStartDate.setVisible(false);
            lblFinishDate.setVisible(false);
            spFinishDate.setVisible(false);
        } else {
            lblDate.setVisible(false);
            spDate.setVisible(false);

            Calendar now = Calendar.getInstance();
            now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now
                .get(Calendar.DATE));

            spStartDate.setValue(now.getTime());
            spFinishDate.setValue(now.getTime());
        }
    }

    /**
     * Get the qualification needed for the wage.
     * 
     * @return The qualification needed for the wage
     */
    public String getQualification() {
        return ((Qualification) cmbQualification.getSelectedItem()).name();
    }

    /**
     * Get the month the wage is valid in.
     * 
     * @return The month the wage is valid in
     */
    public byte getMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime((Date) spDate.getValue());

        return (byte) (cal.get(Calendar.MONTH) + 1);
    }

    /**
     * Get the year the wage is valid in.
     * 
     * @return The year the wage is valid in
     */
    public short getYear() {
        Calendar cal = Calendar.getInstance();
        cal.setTime((Date) spDate.getValue());

        return (short) cal.get(Calendar.YEAR);
    }

    /**
     * Get the start date the wage is valid in.
     * 
     * @return The start date the wage is valid in
     */
    public Date getStartDate() {
        return (Date) spStartDate.getValue();
    }

    /**
     * Get the finish date the wage is valid in.
     * 
     * @return The finish date the wage is valid in
     */
    public Date getFinishDate() {
        return (Date) spFinishDate.getValue();
    }

    /**
     * Returns if form is in edit mode.
     * 
     * @return if form is in edit mode.
     */
    public boolean isEditMode() {
        return spDate.isVisible();
    }

    /**
     * Get the wage per hour.
     * 
     * @return The wage per hour
     * @throws NumberFormatException
     */
    public double getWage() throws NumberFormatException {
        return Double.valueOf(txtWage.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblQualification = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        lblFinishDate = new javax.swing.JLabel();
        lblWage = new javax.swing.JLabel();
        cmbQualification = new javax.swing.JComboBox();
        spDate = new javax.swing.JSpinner();
        spStartDate = new javax.swing.JSpinner();
        spFinishDate = new javax.swing.JSpinner();
        txtWage = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        lblQualification.setText(_("Qualification"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblQualification, gridBagConstraints);

        lblDate.setText(_("Date"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblDate, gridBagConstraints);

        lblStartDate.setText(_("Start date"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblStartDate, gridBagConstraints);

        lblFinishDate.setText(_("Finish date"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblFinishDate, gridBagConstraints);

        lblWage.setText(_("Wage"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblWage, gridBagConstraints);

        cmbQualification.setModel(new javax.swing.DefaultComboBoxModel(
            Qualification.values()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(cmbQualification, gridBagConstraints);

        spDate.setModel(new javax.swing.SpinnerDateModel());
        spDate
            .setEditor(new javax.swing.JSpinner.DateEditor(spDate, "MM.yyyy"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(spDate, gridBagConstraints);

        spStartDate.setModel(new javax.swing.SpinnerDateModel());
        spStartDate.setEditor(new javax.swing.JSpinner.DateEditor(spStartDate,
            "MM.yyyy"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(spStartDate, gridBagConstraints);

        spFinishDate.setModel(new javax.swing.SpinnerDateModel());
        spFinishDate.setEditor(new javax.swing.JSpinner.DateEditor(
            spFinishDate, "MM.yyyy"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(spFinishDate, gridBagConstraints);

        txtWage.setMinimumSize(new java.awt.Dimension(200, 25));
        txtWage.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtWage, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbQualification;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFinishDate;
    private javax.swing.JLabel lblQualification;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblWage;
    private javax.swing.JSpinner spDate;
    private javax.swing.JSpinner spFinishDate;
    private javax.swing.JSpinner spStartDate;
    private javax.swing.JTextField txtWage;
    // End of variables declaration//GEN-END:variables

}
