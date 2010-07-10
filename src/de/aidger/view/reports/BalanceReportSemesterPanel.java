package de.aidger.view.reports;

import static de.aidger.utils.Translation._;

import java.util.ArrayList;

import javax.swing.JPanel;

import de.aidger.model.reports.BalanceReportGroupCreator;
import de.aidger.model.reports.BalanceReportSemesterCreator;

/**
 * A JPanel which holds all the groups of a semester.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class BalanceReportSemesterPanel extends javax.swing.JPanel {

    /**
     * The name of the semester.
     */
    private final String name;

    /**
     * The semester creator, which adds groups to this semester panel.
     */
    private BalanceReportSemesterCreator semesterCreator = null;

    /**
     * Initializes a new BalanceReportSemesterViewer.
     * 
     * @param semester
     *            The name of the semester.
     */
    public BalanceReportSemesterPanel(String semester,
            BalanceReportSemesterCreator semesterCreator) {
        this.semesterCreator = semesterCreator;
        this.name = semester;
        initComponents();
        addGroups();
    }

    /**
     * Adds all the groups of this semester to the panel.
     */
    public void addGroups() {
        ArrayList<ArrayList<Object>> groupCreators = semesterCreator
            .getGroupCreators();
        for (Object groupCreator : groupCreators) {
            createGroup(new BalanceReportGroupPanel(
                ((String) ((ArrayList<Object>) groupCreator).get(1)),
                (BalanceReportGroupCreator) ((ArrayList<Object>) groupCreator)
                    .get(0)));
        }
    }

    /**
     * Adds a new group panel to the semester panel.
     * 
     * @param panel
     *            The panel to be added
     */
    public void createGroup(JPanel panel) {
        this.add(panel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createTitledBorder(_("Semester") + (" ") + name));
        setLayout(new java.awt.GridLayout(0, 1, 0, 10));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
