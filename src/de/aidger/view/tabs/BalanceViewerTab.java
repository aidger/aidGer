package de.aidger.view.tabs;

import static de.aidger.utils.Translation._;

import java.io.File;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

import de.aidger.controller.ActionNotFoundException;
import de.aidger.controller.ActionRegistry;
import de.aidger.model.models.Course;
import de.aidger.model.reports.AnnualBalanceCreator;
import de.aidger.model.reports.BalanceFilter;
import de.aidger.model.reports.SemesterBalanceCreator;
import de.aidger.utils.pdf.BalanceReportConverter;
import de.aidger.utils.reports.BalanceHelper;
import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;
import de.unistuttgart.iste.se.adohive.model.ICourse;

/**
 * A tab for viewing balance reports.
 * 
 * @author aidGer Team
 */
public class BalanceViewerTab extends Tab {

    private BalanceFilter balanceFilter = null;

    private int typeOfBalance = 0;

    /**
     * Initializes a new BalanceViewerTab, which will have the created Semesters
     * added to it.
     */
    public BalanceViewerTab(int index) {
        initComponents();
        try {
            generateButton.setAction(ActionRegistry.getInstance().get(
                GenerateReportAction.class.getName()));
        } catch (ActionNotFoundException ex) {
            Logger.getLogger(BalanceViewerTab.class.getName()).log(
                Level.SEVERE, null, ex);
        }

        typeOfBalance = index;
        balanceFilter = new BalanceFilter();
        switch (index) {
        case 1:
            yearLabel.setVisible(false);
            yearComboBox.setVisible(false);
            filterNameComboBox.addItem(_("Group"));
            filterNameComboBox.addItem(_("Lecturer"));
            filterNameComboBox.addItem(_("Target Audience"));
            existingFilterLabel.setVisible(false);
            existingFilterNameComboBox.setVisible(false);
            existingFilterComboBox.setVisible(false);
            break;
        case 2:
            Vector availableYears = new BalanceHelper().getYears();
            for (Object year : availableYears) {
                yearComboBox.addItem(year);
            }
            filterNameComboBox.addItem(_("Group"));
            filterNameComboBox.addItem(_("Lecturer"));
            filterNameComboBox.addItem(_("Target Audience"));
            existingFilterLabel.setVisible(false);
            existingFilterNameComboBox.setVisible(false);
            existingFilterComboBox.setVisible(false);
            break;
        case 3:
            Vector semesters = new BalanceHelper().getSemesters();
            for (Object semester : semesters) {
                yearComboBox.addItem(semester);
            }
            filterNameComboBox.addItem(_("Group"));
            filterNameComboBox.addItem(_("Lecturer"));
            filterNameComboBox.addItem(_("Target Audience"));
            existingFilterLabel.setVisible(false);
            existingFilterNameComboBox.setVisible(false);
            existingFilterComboBox.setVisible(false);
            break;
        }
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
     * Get the year currently selected-
     * 
     * @return The year
     */
    public Object getYear() {
        return yearComboBox.getSelectedIndex() > 0 ? yearComboBox
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

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.tabs.Tab#getTabName()
     */
    @Override
    public String getTabName() {
        return _("Balance Viewing");
    }

    private void refreshExistingFilters() {
        existingFilterNameComboBox.removeAllItems();
        existingFilterComboBox.removeAllItems();
        if (balanceFilter.getGroups().isEmpty()
                || balanceFilter.getLecturers().isEmpty()
                || balanceFilter.getTargetAudiences().isEmpty()) {
            existingFilterLabel.setVisible(false);
            existingFilterNameComboBox.setVisible(false);
            existingFilterComboBox.setVisible(false);
        } else {
            if (!balanceFilter.getGroups().isEmpty()) {
                for (Object group : balanceFilter.getGroups()) {
                    existingFilterNameComboBox.addItem(group);
                }
                existingFilterLabel.setVisible(true);
            }
            if (!balanceFilter.getLecturers().isEmpty()) {
                for (Object lecturer : balanceFilter.getLecturers()) {
                    existingFilterNameComboBox.addItem(lecturer);
                }
                existingFilterLabel.setVisible(true);
            }
            if (!balanceFilter.getTargetAudiences().isEmpty()) {
                for (Object targetAudience : balanceFilter.getTargetAudiences()) {
                    existingFilterNameComboBox.addItem(targetAudience);
                }
                existingFilterLabel.setVisible(true);
            }
        }
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
    // desc="Generated Code">//GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        yearLabel = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox();
        generateButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        filtersLabel = new javax.swing.JLabel();
        filterNameComboBox = new javax.swing.JComboBox();
        filterComboBox = new javax.swing.JComboBox();
        addFilterButton = new javax.swing.JButton();
        existingFilterLabel = new javax.swing.JLabel();
        existingFilterNameComboBox = new javax.swing.JComboBox();
        existingFilterComboBox = new javax.swing.JComboBox();
        removeFilterButton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();

        jTextField3.setText("jTextField3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
            jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100,
            Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100,
            Short.MAX_VALUE));

        setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        yearLabel.setText(_("Year") + ":");
        jToolBar1.add(yearLabel);

        jToolBar1.add(yearComboBox);

        generateButton.setText(_("Generate"));
        generateButton.setFocusable(false);
        generateButton
            .setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        generateButton
            .setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(generateButton);

        exportButton.setText(_("Export"));
        exportButton.setFocusable(false);
        exportButton
            .setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(exportButton);

        filtersLabel.setText(_("Filters") + ":");
        jToolBar1.add(filtersLabel);

        filterNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterNameComboBoxItemStateChanged(evt);
            }
        });
        jToolBar1.add(filterNameComboBox);

        jToolBar1.add(filterComboBox);

        addFilterButton.setText("+");
        addFilterButton.setFocusable(false);
        addFilterButton
            .setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addFilterButton
            .setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFilterButtonActionPerformed(evt);
            }
        });
        addFilterButton
            .setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addFilterButton
            .setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(addFilterButton);

        existingFilterLabel.setText(_("Existing filters") + ":");
        jToolBar1.add(existingFilterLabel);

        jToolBar1.add(existingFilterNameComboBox);

        jToolBar1.add(existingFilterComboBox);

        removeFilterButton.setText("-");
        removeFilterButton.setFocusable(false);
        removeFilterButton
            .setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeFilterButton
            .setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        removeFilterButton
            .addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    removeFilterButtonActionPerformed(evt);
                }
            });
        jToolBar1.add(removeFilterButton);

        add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        contentPanel.setLayout(new java.awt.GridLayout(0, 1));
        add(contentPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addFilterButtonActionPerformed
        switch (filterNameComboBox.getSelectedIndex()) {
        case 0:
            if (!balanceFilter.getGroups().contains(
                filterComboBox.getSelectedItem())) {
                balanceFilter.addGroup((String) filterComboBox
                    .getSelectedItem());
            }
            refreshExistingFilters();
            break;
        case 1:
            if (!balanceFilter.getGroups().contains(
                filterComboBox.getSelectedItem())) {
                balanceFilter.addGroup((String) filterComboBox
                    .getSelectedItem());
            }
            break;
        case 2:
            if (!balanceFilter.getGroups().contains(
                filterComboBox.getSelectedItem())) {
                balanceFilter.addGroup((String) filterComboBox
                    .getSelectedItem());
            }
            break;
        }
    }// GEN-LAST:event_addFilterButtonActionPerformed

    private void removeFilterButtonActionPerformed(
            java.awt.event.ActionEvent evt) {// GEN-FIRST:event_removeFilterButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_removeFilterButtonActionPerformed

    private void filterNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_filterNameComboBoxItemStateChanged
        switch (filterNameComboBox.getSelectedIndex()) {
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

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exportButtonActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        File file;
        FileFilter pdfFilter = new FileFilter() {
            @Override
            public boolean accept(File arg0) {
                String fileName = arg0.getName();
                int fileExtensionStart = fileName.lastIndexOf('.');
                String fileExtension = fileName
                    .substring(fileExtensionStart + 1);
                return fileExtension.equals("pdf");
            }

            @Override
            public String getDescription() {
                return _("PDF files");
            }
        };

        fileChooser.addChoosableFileFilter(pdfFilter);

        boolean exit = false;

        do {
            int retVal = fileChooser.showDialog(exportButton, _("Export"));

            if (retVal == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                if (file.isDirectory()) {
                    // This shouldn't happen but check for it anyways
                    JOptionPane.showMessageDialog(exportButton,
                        _("Please choose a file."));
                } else if (file.exists()) {
                    // Ask if the user wants to overwrite the file
                    retVal = JOptionPane.showOptionDialog(exportButton,
                        _("Are you sure you want to overwrite the file?"),
                        _("Overwrite file?"), JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (retVal == JOptionPane.YES_OPTION) {
                        exit = true;
                    }
                } else {
                    exit = true;
                }
            } else {
                return;
            }
        } while (!exit);

        new BalanceReportConverter(file, typeOfBalance, yearComboBox
            .getSelectedItem());

    }// GEN-LAST:event_exportButtonActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_generateButtonActionPerformed
        switch (typeOfBalance) {
        case 1:
            clearPanel();
            SemesterBalanceCreator fullBalanceCreator = new SemesterBalanceCreator(
                this);
            Vector semesters = new BalanceHelper().getSemesters();
            for (int i = 1; i < semesters.size(); i++) {
                fullBalanceCreator.addSemester((String) semesters.get(i), null);
            }
            break;
        case 2:
            clearPanel();
            if (yearComboBox.getSelectedIndex() > 0) {
                AnnualBalanceCreator annualBalanceCreator = new AnnualBalanceCreator(
                    this);
                annualBalanceCreator.addYear((Integer) yearComboBox
                    .getSelectedItem(), null);
            }
            break;
        case 3:
            clearPanel();
            if (yearComboBox.getSelectedIndex() > 0) {
                SemesterBalanceCreator semesterBalanceCreator = new SemesterBalanceCreator(
                    this);
                semesterBalanceCreator.addSemester((String) yearComboBox
                    .getSelectedItem(), null);
            }
        }
    }// GEN-LAST:event_generateButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFilterButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JComboBox existingFilterComboBox;
    private javax.swing.JLabel existingFilterLabel;
    private javax.swing.JComboBox existingFilterNameComboBox;
    private javax.swing.JButton exportButton;
    private javax.swing.JComboBox filterComboBox;
    private javax.swing.JComboBox filterNameComboBox;
    private javax.swing.JLabel filtersLabel;
    private javax.swing.JButton generateButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton removeFilterButton;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables

}
