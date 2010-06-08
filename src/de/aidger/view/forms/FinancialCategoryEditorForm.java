package de.aidger.view.forms;

import static de.aidger.utils.Translation._;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.aidger.model.models.FinancialCategory;

/**
 * A form used for editing / creating new financial categories.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class FinancialCategoryEditorForm extends JPanel {

    /**
     * Constructs a financial category editor form.
     * 
     * @param fc
     *            the financial category that will be edited
     */
    public FinancialCategoryEditorForm(FinancialCategory fc) {
        initComponents();

        // add input filters
        InputPatternFilter.addFilter(txtYear, "[0-9]{0,4}");

        if (fc != null) {
            txtName.setText(fc.getName());
            txtYear.setText(String.valueOf(fc.getYear()));

            // TODO
        }
    }

    /**
     * Get the budget costs of the category.
     * 
     * @return The budget costs of the category
     */
    public int[] getBudgetCosts() {
        int[] budgetCosts = new int[fundsLines.size()];

        for (int i = 0; i < fundsLines.size(); ++i) {
            budgetCosts[i] = Integer.valueOf(fundsLines.get(i).txtBudgetCosts
                    .getText());
        }

        return budgetCosts;
    }

    /**
     * Get the funds of the category.
     * 
     * @return The funds of the category
     */
    public int[] getFunds() {
        int[] funds = new int[fundsLines.size()];

        for (int i = 0; i < fundsLines.size(); ++i) {
            funds[i] = Integer.valueOf((String) fundsLines.get(i).cmbFunds
                    .getSelectedItem());
        }

        return funds;
    }

    /**
     * Get the name of the category.
     * 
     * @return The name of the category
     */
    public String getFCName() {
        return txtName.getText();
    }

    /**
     * Get the year the category is valid.
     * 
     * @return The year the category is valid
     */
    public short getYear() {
        String year = txtYear.getText();

        if (year.isEmpty()) {
            ;
        }

        return Short.valueOf(year);
    }

    /**
     * Adds a new funds line to the form.
     */
    private void addNewFunds() {
        GridBagConstraints gridBagConstraints;

        JLabel lblFunds = new JLabel();
        lblFunds.setText(_("Funds"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblFunds, gridBagConstraints);

        JComboBox cmbFunds = new JComboBox();
        cmbFunds.setEditable(true);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(cmbFunds, gridBagConstraints);

        InputPatternFilter.addFilter(cmbFunds, "[0-9]{0,8}");

        JLabel lblBudgetCosts = new JLabel();
        lblBudgetCosts.setText(_("Budget Costs"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblBudgetCosts, gridBagConstraints);

        JTextField txtBudgetCosts = new JTextField();
        txtBudgetCosts.setMinimumSize(new java.awt.Dimension(200, 25));
        txtBudgetCosts.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtBudgetCosts, gridBagConstraints);

        InputPatternFilter.addFilter(txtBudgetCosts, "[0-9]+");

        JButton btnPlusMinus = new JButton();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;

        FundsLine fl = new FundsLine(lblFunds, cmbFunds, lblBudgetCosts,
                txtBudgetCosts, btnPlusMinus);

        if (fundsLines.isEmpty()) {
            btnPlusMinus.setText("+");

            gridBagConstraints.gridy = 1;

            btnPlusMinus.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    addNewFunds();
                }
            });
        } else {
            btnPlusMinus.setText("-");

            gridBagConstraints.gridy = GridBagConstraints.RELATIVE;

            btnPlusMinus.setAction(new RemoveFundsAction(fl));
        }

        add(btnPlusMinus, gridBagConstraints);

        fundsLines.add(fl);
    }

    /**
     * Initializes the components.
     */
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblName = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();

        fundsLines = new Vector<FundsLine>();

        setLayout(new java.awt.GridBagLayout());

        lblName.setText(_("Name"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblName, gridBagConstraints);

        lblYear.setText(_("Year"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblYear, gridBagConstraints);

        txtName.setMinimumSize(new java.awt.Dimension(200, 25));
        txtName.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtName, gridBagConstraints);

        txtYear.setMinimumSize(new java.awt.Dimension(200, 25));
        txtYear.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(txtYear, gridBagConstraints);

        addNewFunds();
    }

    private JLabel lblName;
    private JLabel lblYear;
    private JTextField txtName;
    private JTextField txtYear;

    private List<FundsLine> fundsLines;

    /**
     * This class represents a funds line in the form.
     * 
     * @author aidGer Team
     */
    private class FundsLine {
        public JLabel lblFunds;
        public JComboBox cmbFunds;
        public JLabel lblBudgetCosts;
        public JTextField txtBudgetCosts;
        public JButton btnPlusMinus;

        /**
         * Initializes a funds line.
         * 
         */
        public FundsLine(JLabel lblFunds, JComboBox cmbFunds,
                JLabel lblBudgetCosts, JTextField txtBudgetCosts,
                JButton btnPlusMinus) {
            this.lblFunds = lblFunds;
            this.cmbFunds = cmbFunds;
            this.lblBudgetCosts = lblBudgetCosts;
            this.txtBudgetCosts = txtBudgetCosts;
            this.btnPlusMinus = btnPlusMinus;
        }
    }

    /**
     * Removes a funds line from the form by clicking on "-" button.
     * 
     * @author aidGer Team
     */
    public class RemoveFundsAction extends AbstractAction {
        /**
         * The funds line that will be removed.
         */
        private final FundsLine fundsLine;

        /**
         * Initializes the action.
         */
        public RemoveFundsAction(FundsLine fundsLine) {
            putValue(Action.NAME, "-");

            this.fundsLine = fundsLine;
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
         * )
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            remove(fundsLine.lblFunds);
            remove(fundsLine.cmbFunds);
            remove(fundsLine.lblBudgetCosts);
            remove(fundsLine.txtBudgetCosts);
            remove(fundsLine.btnPlusMinus);

            fundsLines.remove(fundsLine);

            revalidate();
        }
    }

}
