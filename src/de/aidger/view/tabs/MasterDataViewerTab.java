package de.aidger.view.tabs;

import static de.aidger.utils.Translation._;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.TableColumn;

import de.aidger.model.Runtime;
import de.aidger.model.models.Course;
import de.aidger.view.models.CourseTableModel;
import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;

/**
 * A tab which will be used to display the master data.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class MasterDataViewerTab extends Tab {
    public enum MasterDataType {
        Course, Assistant, FinancialCategory, HourlyWage
    }

    private final int[][] tableHeaderSize;

    private final List<String> hiddenColumns = new ArrayList<String>();

    private final MasterDataType type;

    /**
     * Constructs a new master data viewer tab.
     */
    @SuppressWarnings("unchecked")
    public MasterDataViewerTab(MasterDataType type) {
        this.type = type;
        initComponents();

        Course c = new Course();
        c.setDescription("Description");
        c.setFinancialCategoryId(1);
        c.setGroup("2");
        c.setLecturer("Test Tester");
        c.setNumberOfGroups(3);
        c.setPart('a');
        c.setRemark("Remark");
        c.setScope("Sniper Scope");
        c.setSemester("SS 09");
        c.setTargetAudience("Testers");
        c.setUnqualifiedWorkingHours(100);

        try {
            c.save();
        } catch (AdoHiveException e) {
            e.printStackTrace();
        }

        table.setModel(new CourseTableModel());
        // table.setComponentPopupMenu(new JPopupMenu());
        table.setAutoCreateRowSorter(true);
        table.setDoubleBuffered(true);
        table.setFocusCycleRoot(true);

        tableHeaderSize = new int[table.getColumnCount()][3];

        // column filtering
        String[] hiddenColumns = Runtime.getInstance().getOptionArray(
                "hiddenColumns" + type);

        if (hiddenColumns == null) {
            switch (type) {
            case Course:
                hiddenColumns = new String[] { "6", "7", "8", "9", "10" };
                break;
            default:
                hiddenColumns = new String[] {};
                break;
            }

            Runtime.getInstance().setOptionArray("hiddenColumns" + type,
                    hiddenColumns);
        }

        for (int i = 0; i < hiddenColumns.length; ++i) {
            if (!hiddenColumns[i].isEmpty()) {
                toggleColumnVisibility(Integer.valueOf(hiddenColumns[i]));
            }
        }

        JPopupMenu headerMenu = new JPopupMenu();

        Enumeration en = table.getTableHeader().getColumnModel().getColumns();

        while (en.hasMoreElements()) {
            TableColumn column = (TableColumn) en.nextElement();

            JCheckBoxMenuItem mi = new JCheckBoxMenuItem(new AbstractAction(
                    column.getHeaderValue().toString()) {
                public void actionPerformed(ActionEvent evt) {
                    String cmd = evt.getActionCommand();

                    int index = table.getTableHeader().getColumnModel()
                            .getColumnIndex(cmd);

                    toggleColumnVisibility(index);
                }
            });

            if (column.getPreferredWidth() != 0) {
                mi.setSelected(true);
            } else {
                mi.setSelected(false);
            }

            headerMenu.add(mi);
        }

        table.getTableHeader().addMouseListener(new PopupListener(headerMenu));
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.tabs.Tab#getName()
     */
    @Override
    public String getName() {
        return _("Master Data");
    }

    private void toggleColumnVisibility(int index) {
        TableColumn column = table.getTableHeader().getColumnModel().getColumn(
                index);

        if (column.getPreferredWidth() != 0) {
            tableHeaderSize[index][0] = column.getPreferredWidth();
            tableHeaderSize[index][1] = column.getMinWidth();
            tableHeaderSize[index][2] = column.getMaxWidth();

            column.setMinWidth(0);
            column.setMaxWidth(0);
            column.setPreferredWidth(0);

            hiddenColumns.add(String.valueOf(index));
        } else {
            column.setMinWidth(tableHeaderSize[index][1]);
            column.setMaxWidth(tableHeaderSize[index][2]);
            column.setPreferredWidth(tableHeaderSize[index][0]);

            column.sizeWidthToFit();

            hiddenColumns.remove(String.valueOf(index));
        }

        Runtime.getInstance().setOptionArray("hiddenColumns" + type,
                hiddenColumns.toArray(new String[0]));

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
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setText(_("View"));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton5.setText(_("Edit"));
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        jButton2.setText(_("Add"));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setText(_("Delete"));
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton4.setText(_("Activites"));
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jScrollPane1.setViewportView(table);

        jTextField1.setText(_("Search"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout
                .setHorizontalGroup(layout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout
                                        .createSequentialGroup()
                                        .addGroup(
                                                layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                layout
                                                                        .createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addGroup(
                                                                                layout
                                                                                        .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(
                                                                                                jTextField1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                150,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(
                                                                                                jScrollPane1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                530,
                                                                                                Short.MAX_VALUE)))
                                                        .addComponent(
                                                                jToolBar1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                542,
                                                                Short.MAX_VALUE))
                                        .addContainerGap()));
        layout
                .setVerticalGroup(layout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout
                                        .createSequentialGroup()
                                        .addComponent(
                                                jToolBar1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                25,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(
                                                jTextField1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(
                                                jScrollPane1,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                256, Short.MAX_VALUE)
                                        .addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable table;

    // End of variables declaration//GEN-END:variables

    class PopupListener extends MouseAdapter {
        JPopupMenu popupMenu;

        public PopupListener(JPopupMenu popup) {
            this.popupMenu = popup;
        }

        @Override
        public void mousePressed(MouseEvent me) {
            showPopup(me);
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            showPopup(me);
        }

        private void showPopup(MouseEvent me) {
            if (me.isPopupTrigger()) {
                popupMenu.show(me.getComponent(), me.getX(), me.getY());
            }
        }
    }
}
