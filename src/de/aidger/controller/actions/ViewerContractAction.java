package de.aidger.controller.actions;

import static de.aidger.utils.Translation._;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import de.aidger.model.models.Contract;
import de.aidger.model.models.Employment;
import de.aidger.view.UI;
import de.aidger.view.tabs.DetailViewerTab;
import de.aidger.view.tabs.ViewerTab;
import de.aidger.view.tabs.ViewerTab.DataType;
import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;
import javax.swing.ImageIcon;

/**
 * This action shows the contract for a given model.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class ViewerContractAction extends AbstractAction {

    /**
     * Initializes the action.
     */
    public ViewerContractAction() {
        putValue(Action.NAME, _("Contract"));
        putValue(Action.SMALL_ICON, new ImageIcon(getClass().getResource(
                "/de/aidger/res/icons/document-text.png")));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ViewerTab tab = (ViewerTab) UI.getInstance().getCurrentTab();

        if (tab.getTable().getSelectedRow() == -1) {
            UI.displayError(_("Please select an entry from the table."));
        } else if (tab.getTable().getSelectedRowCount() > 1) {
            UI.displayError(_("Please select only one entry from the table."));
        } else {
            int index = tab.getTable().getRowSorter().convertRowIndexToModel(
                tab.getTable().getSelectedRow());

            Employment employment = (Employment) tab.getTableModel().getModel(
                index);

            try {
                Contract contract = new Contract((new Contract())
                    .getById(employment.getContractId()));

                UI.getInstance().replaceCurrentTab(
                    new DetailViewerTab(DataType.Contract, contract));
            } catch (AdoHiveException e1) {
                UI
                    .displayError(_("The related contract could not be displayed."));
            }
        }
    }
}