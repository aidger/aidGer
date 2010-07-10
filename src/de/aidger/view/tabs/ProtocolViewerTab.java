/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

/*
 * ProtocolPanel.java
 * 
 * Created on 11.06.2010, 17:08:19
 */

package de.aidger.view.tabs;

import static de.aidger.utils.Translation._;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import de.aidger.controller.ActionNotFoundException;
import de.aidger.controller.ActionRegistry;
import de.aidger.controller.actions.ProtocolExportAction;
import de.aidger.model.reports.ProtocolCreator;
import de.aidger.view.UI;

/**
 * This tab displays the activity protocol in a table.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class ProtocolViewerTab extends Tab {

    /**
     * The table model of the content table.
     */
    private final DefaultTableModel activityTableModel = new DefaultTableModel(
        null, new String[] { _("Affected assistant"), _("Affected course"),
                _("Type"), _("Date"), _("Content"), _("Sender"),
                _("Processor"), _("Remark") }) {
        boolean[] canEdit = new boolean[] { false, false, false, false, false,
                false, false, false };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    /**
     * The protocol creator that gets the activities for this panel.
     */
    private final ProtocolCreator protocolCreator = new ProtocolCreator();

    /**
     * The activities of this panel.
     */
    private ArrayList<Object[]> activities = new ArrayList<Object[]>();

    /**
     * Initializes a new ProtocolViewerTab and registers a change listener to
     * the spinner.
     * 
     * @param protocolCreator
     *            The protocol creator that called this viewer.
     */
    public ProtocolViewerTab() {
        initComponents();

        daySpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if ((Integer) daySpinner.getValue() < -1) {
                    daySpinner.setValue(-1);
                }
                clearTable();
                activities = protocolCreator
                    .createProtocol((Integer) daySpinner.getValue());
                for (Object activity : activities) {
                    addActivity((Object[]) activity);
                }
            }
        });

        try {
            exportProtocolButton.setAction(ActionRegistry.getInstance().get(
                ProtocolExportAction.class.getName()));
        } catch (ActionNotFoundException ex) {
            UI.displayError(ex.getMessage());
        }
        clearTable();
        activities = protocolCreator.createProtocol((Integer) daySpinner
            .getValue());
        for (Object activity : activities) {
            addActivity((Object[]) activity);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.tabs.Tab#getTabName()
     */
    @Override
    public String getTabName() {
        return _("Activity export");
    }

    /**
     * Get the amount of days selected.
     * 
     * @return The amount of days
     */
    public int getDays() {
        return (Integer) daySpinner.getValue();
    }

    /**
     * Removes all the rows from the content table.
     */
    private void clearTable() {
        while (activityTableModel.getRowCount() > 0) {
            activityTableModel.removeRow(0);
        }
    }

    /**
     * Adds an activity to the table.
     * 
     * @param course
     *            The activity to be added to the table.
     */
    private void addActivity(Object[] activity) {
        activityTableModel.addRow(activity);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        exportProtocolButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        contentPanel = new javax.swing.JPanel();
        contentScrollPane = new javax.swing.JScrollPane();
        contentTable = new javax.swing.JTable();
        filterLabel = new javax.swing.JPanel();
        spinnerLabel = new javax.swing.JLabel();
        daySpinner = new javax.swing.JSpinner();

        setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        exportProtocolButton.setText(_("Export"));
        exportProtocolButton.setFocusable(false);
        exportProtocolButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportProtocolButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(exportProtocolButton);
        jToolBar1.add(jSeparator2);

        add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        contentPanel.setLayout(new java.awt.BorderLayout());

        contentTable.setModel(activityTableModel);
        contentScrollPane.setViewportView(contentTable);

        contentPanel.add(contentScrollPane, java.awt.BorderLayout.CENTER);

        filterLabel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        spinnerLabel.setText(_("Number of days before today to display: "));
        filterLabel.add(spinnerLabel);

        daySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                daySpinnerStateChanged(evt);
            }
        });
        filterLabel.add(daySpinner);

        contentPanel.add(filterLabel, java.awt.BorderLayout.PAGE_START);

        add(contentPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void daySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_daySpinnerStateChanged
        daySpinner.setVisible(false);
        daySpinner.setVisible(true);
    }// GEN-LAST:event_daySpinnerStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JScrollPane contentScrollPane;
    private javax.swing.JTable contentTable;
    private javax.swing.JSpinner daySpinner;
    private javax.swing.JButton exportProtocolButton;
    private javax.swing.JPanel filterLabel;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel spinnerLabel;
    // End of variables declaration//GEN-END:variables

}
