package de.aidger.controller.actions;

import static de.aidger.utils.Translation._;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import de.aidger.view.UI;
import de.aidger.view.tabs.DetailViewerTab;
import de.aidger.view.tabs.ViewerTab;

/**
 * This action replaces the current tab with the model viewer tab when user
 * cancelled his previous step in detail viewer tab.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class DetailViewerCancelAction extends AbstractAction {

    /**
     * Initializes the action.
     */
    public DetailViewerCancelAction() {
        putValue(Action.NAME, _("Cancel"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        DetailViewerTab tab = (DetailViewerTab) UI.getInstance()
            .getCurrentTab();

        UI.getInstance().replaceCurrentTab(new ViewerTab(tab.getType()));
    }
}