package de.aidger.view.tabs;

import static de.aidger.utils.Translation._;

import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import de.aidger.controller.ActionNotFoundException;
import de.aidger.controller.ActionRegistry;
import de.aidger.controller.actions.ReportExportAction;
import de.aidger.controller.actions.ReportGenerateAction;
import de.aidger.model.models.Course;
import de.aidger.model.reports.BalanceFilter;
import de.aidger.utils.reports.BalanceHelper;
import de.aidger.view.UI;
import de.aidger.view.reports.BalanceFilterPanel;
import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;
import de.unistuttgart.iste.se.adohive.model.ICourse;

/**
 * A tab for viewing balance reports.
 * 
 * @author aidGer Team
 */
public class BalanceViewerTab extends Tab {

    /**
     * States which calculation method should be used. 0 - neutral, 1 -
     * pessimistic, 0 - historicl
     */
    private int calculationMethod = 0;

    /**
     * The balanceFilter of this balance.
     */
    private BalanceFilter balanceFilter = null;

    /**
     * The type of balance report this is. 1 is full, 2 is annual, 3 is
     * semester.
     */
    private int typeOfBalance = 0;

    /**
     * Initializes a new BalanceViewerTab, which will have the balance
     * manipulation elements and the created Semesters added to it.
     */
    public BalanceViewerTab(Integer index) {
        initComponents();
        try {
            generateButton.setAction(ActionRegistry.getInstance().get(
                ReportGenerateAction.class.getName()));
            exportButton.setAction(ActionRegistry.getInstance().get(
                ReportExportAction.class.getName()));
        } catch (ActionNotFoundException ex) {
            UI.displayError(ex.getMessage());
        }

        typeOfBalance = index;
        balanceFilter = new BalanceFilter();
        switch (index) {
        case 1:
            /*
             * This is a full balance report.
             */
            yearLabel.setVisible(false);
            yearComboBox.setVisible(false);
            break;
        case 2:
            /*
             * This is an annual balance report.
             */
            Vector availableYears = new BalanceHelper().getYears();
            for (Object year : availableYears) {
                yearComboBox.addItem(year);
            }
            break;
        case 3:
            /*
             * This is a semester balance report.
             */
            yearLabel.setText(_("Semester" + ":"));
            Vector semesters = new BalanceHelper().getSemesters();
            for (Object semester : semesters) {
                yearComboBox.addItem(semester);
            }
            break;
        }
        filterNameComboBox.addItem(_("Group"));
        filterNameComboBox.addItem(_("Lecturer"));
        filterNameComboBox.addItem(_("Target Audience"));
    }

    /**
     * Get the name of the tab and constructor options if necessary.
     * 
     * @return A string representation of the class
     */
    @Override
    public String toString() {
        return getClass().getName() + "<" + Integer.class.getName() + "@"
                + Integer.toString(typeOfBalance);
    }

    /**
     * Get the type of balance.
     * 
     * @return The type of balance
     */
    public int getType() {
        return typeOfBalance;
    }

    /**
     * Returns the balance filter.
     * 
     * @return The balance filter
     */
    public BalanceFilter getBalanceFilter() {
        return balanceFilter;
    }

    /**
     * Get the year currently selected-
     * 
     * @return The year
     */
    public Object getYear() {
        return yearComboBox.getSelectedIndex() > -1 ? yearComboBox
            .getSelectedItem() : null;
    }

    /**
     * Add a new panel
     * 
     * @param panel
     *            The panel to add
     */
    public void addPanel(JPanel panel) {
        contentPanel.add(panel);
        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
    }

    /**
     * Clear the panel.
     */
    public void clearPanel() {
        contentPanel.removeAll();
    }

    /**
     * Removes the given panel from the filter panel.
     * 
     * @param panel
     *            The panel to remove
     */
    public void removeFilterPanel(JPanel panel) {
        filterContentPanel.remove(panel);
        filterContentPanel.setVisible(false);
        filterContentPanel.setVisible(true);
    }

    /**
     * Get the calculation method to be used with this balance.
     * 
     * @return 0 if neutral, 1 if pessimistic, 2 if historical
     */
    public int getCalculationMethod() {
        return calculationMethod;
    }

    /**
     * Removes the specified filter from the filters list.
     * 
     * @param type
     *            The type of filter.
     * @param value
     *            The value of the filter.
     */
    public void removeFilter(int type, String value) {
        switch (type) {
        case 0:
            if (balanceFilter.getGroups().contains(value)) {
                balanceFilter.removeGroup(value);
            }
            break;
        case 1:
            if (balanceFilter.getLecturers().contains(value)) {
                balanceFilter.removeLecturer(value);
            }
            break;
        case 2:
            if (balanceFilter.getTargetAudiences().contains(value)) {
                balanceFilter.removeTargetAudience(value);
            }
            break;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.tabs.Tab#getTabName()
     */
    @Override
    public String getTabName() {
        return _("Balance Viewing");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        yearLabel = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox();
        generateButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        filtersPanel = new javax.swing.JPanel();
        filterContentPanel = new javax.swing.JPanel();
        filterCreationPanel = new javax.swing.JPanel();
        filtersLabel = new javax.swing.JLabel();
        filterNameComboBox = new javax.swing.JComboBox();
        filterComboBox = new javax.swing.JComboBox();
        addFilterButton = new javax.swing.JButton();
        pessimisticCalculationRadio = new javax.swing.JRadioButton();
        historicalCalculationRadio = new javax.swing.JRadioButton();

        setLayout(new java.awt.BorderLayout());

        contentPanel.setLayout(new javax.swing.BoxLayout(contentPanel, javax.swing.BoxLayout.Y_AXIS));
        add(contentPanel, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        yearLabel.setText(_("Year") + ":");
        jToolBar1.add(yearLabel);

        jToolBar1.add(yearComboBox);

        generateButton.setText(_("Generate"));
        generateButton.setFocusable(false);
        generateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        generateButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(generateButton);

        exportButton.setText(_("Export"));
        exportButton.setFocusable(false);
        exportButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(exportButton);

        jPanel1.add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        filtersPanel.setLayout(new java.awt.BorderLayout());

        filterContentPanel.setLayout(new java.awt.GridLayout(0, 1));
        filtersPanel.add(filterContentPanel, java.awt.BorderLayout.PAGE_END);

        filterCreationPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        filtersLabel.setText(_("Filters") + ":");
        filterCreationPanel.add(filtersLabel);

        filterNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterNameComboBoxItemStateChanged(evt);
            }
        });
        filterCreationPanel.add(filterNameComboBox);

        filterCreationPanel.add(filterComboBox);

        addFilterButton.setText("+");
        addFilterButton.setFocusable(false);
        addFilterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addFilterButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFilterButtonActionPerformed(evt);
            }
        });
        filterCreationPanel.add(addFilterButton);

        pessimisticCalculationRadio.setText(_("Pessimistic calculation"));
        pessimisticCalculationRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pessimisticCalculationRadioActionPerformed(evt);
            }
        });
        filterCreationPanel.add(pessimisticCalculationRadio);

        historicalCalculationRadio.setText(_("Historical calculation"));
        historicalCalculationRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historicalCalculationRadioActionPerformed(evt);
            }
        });
        filterCreationPanel.add(historicalCalculationRadio);

        filtersPanel.add(filterCreationPanel, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(filtersPanel, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void pessimisticCalculationRadioActionPerformed(
            java.awt.event.ActionEvent evt) {// GEN-FIRST:event_pessimisticCalculationRadioActionPerformed
        if (pessimisticCalculationRadio.isSelected()) {
            historicalCalculationRadio.setSelected(false);
            calculationMethod = 1;
        } else {
            calculationMethod = 0;
        }
    }// GEN-LAST:event_pessimisticCalculationRadioActionPerformed

    private void historicalCalculationRadioActionPerformed(
            java.awt.event.ActionEvent evt) {// GEN-FIRST:event_historicalCalculationRadioActionPerformed
        if (historicalCalculationRadio.isSelected()) {
            pessimisticCalculationRadio.setSelected(false);
            calculationMethod = 2;
        } else {
            calculationMethod = 0;
        }
    }// GEN-LAST:event_historicalCalculationRadioActionPerformed

    private void addFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addFilterButtonActionPerformed
        switch (filterNameComboBox.getSelectedIndex()) {
        /*
         * If the filter doesn't exist, delete it, repaint the combo box and set
         * the selected index of the name combo box to the type of filter added.
         */
        case 0:
            if (!balanceFilter.getGroups().contains(
                filterComboBox.getSelectedItem())
                    && filterComboBox.getItemCount() > 0) {
                balanceFilter.addGroup((String) filterComboBox
                    .getSelectedItem());
                filterContentPanel.add(new BalanceFilterPanel(0,
                    (String) filterComboBox.getSelectedItem(), this));
            }
            break;
        case 1:
            if (!balanceFilter.getLecturers().contains(
                filterComboBox.getSelectedItem())
                    && filterComboBox.getItemCount() > 0) {
                balanceFilter.addLecturer((String) filterComboBox
                    .getSelectedItem());
                filterContentPanel.add(new BalanceFilterPanel(1,
                    (String) filterComboBox.getSelectedItem(), this));
            }
            break;
        case 2:
            if (!balanceFilter.getTargetAudiences().contains(
                filterComboBox.getSelectedItem())
                    && filterComboBox.getItemCount() > 0) {
                balanceFilter.addTargetAudience((String) filterComboBox
                    .getSelectedItem());
                filterContentPanel.add(new BalanceFilterPanel(2,
                    (String) filterComboBox.getSelectedItem(), this));
            }
            break;
        }
        filterContentPanel.setVisible(false);
        filterContentPanel.setVisible(true);
    }// GEN-LAST:event_addFilterButtonActionPerformed

    private void filterNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_filterNameComboBoxItemStateChanged
        switch (filterNameComboBox.getSelectedIndex()) {
        /*
         * Clear the filter combo box and add all entries of this filter type.
         */
        case 0:
            filterComboBox.removeAllItems();
            List<ICourse> courses = null;
            try {
                courses = (new Course()).getAll();
            } catch (AdoHiveException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Vector courseGroups = new Vector();
            for (ICourse course : courses) {
                if (!courseGroups.contains(course.getGroup())) {
                    courseGroups.add(course.getGroup());
                    filterComboBox.addItem(course.getGroup());
                }
            }
            break;
        case 1:
            filterComboBox.removeAllItems();
            courses = null;
            try {
                courses = (new Course()).getAll();
            } catch (AdoHiveException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Vector courseLecturers = new Vector();
            for (ICourse course : courses) {
                if (!courseLecturers.contains(course.getLecturer())) {
                    courseLecturers.add(course.getLecturer());
                    filterComboBox.addItem(course.getLecturer());
                }
            }
            break;
        case 2:
            filterComboBox.removeAllItems();
            courses = null;
            try {
                courses = (new Course()).getAll();
            } catch (AdoHiveException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Vector courseAudiences = new Vector();
            for (ICourse course : courses) {
                if (!courseAudiences.contains(course.getTargetAudience())) {
                    courseAudiences.add(course.getTargetAudience());
                    filterComboBox.addItem(course.getTargetAudience());
                }
            }
            break;
        }
    }// GEN-LAST:event_filterNameComboBoxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFilterButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton exportButton;
    private javax.swing.JComboBox filterComboBox;
    private javax.swing.JPanel filterContentPanel;
    private javax.swing.JPanel filterCreationPanel;
    private javax.swing.JComboBox filterNameComboBox;
    private javax.swing.JLabel filtersLabel;
    private javax.swing.JPanel filtersPanel;
    private javax.swing.JButton generateButton;
    private javax.swing.JRadioButton historicalCalculationRadio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JRadioButton pessimisticCalculationRadio;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables

}
