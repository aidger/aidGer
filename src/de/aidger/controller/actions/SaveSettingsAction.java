package de.aidger.controller.actions;

import static de.aidger.utils.Translation._;

import java.io.File;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;

import de.aidger.model.Runtime;
import de.aidger.model.validators.PresenceValidator;
import de.aidger.view.UI;
import de.aidger.view.SettingsDialog;

/**
 * Saves the settings in the dialog and closes it.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class SaveSettingsAction extends AbstractAction {

    /**
     * Initializes the save settings action.
     */
    public SaveSettingsAction() {
        putValue(Action.NAME, _("Save"));
        putValue(Action.SHORT_DESCRIPTION, _("Save settings"));
    }

    /**
     * Saves the settings in the configuration and closes the dialog.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        SettingsDialog dlg = (SettingsDialog) ((JComponent) e.getSource())
                .getTopLevelAncestor();

        if (!PresenceValidator.validate(dlg.getUsername())) {
            UI.displayError(_("Username is empty."));
            return;
        }
        Runtime.getInstance().setOption("name", dlg.getUsername());

        Runtime.getInstance().setOption("pdf-viewer", dlg.getPDFViewer());
        if (!dlg.getPDFViewer().isEmpty() && !(new File(dlg.getPDFViewer())).
                exists()) {
            UI.displayError(_("PDF Viewer points to nonexistant file."));
            return;
        }

        if (dlg.getSelectedLanguage() == -1 ||
                dlg.getSelectedLanguage() >= Runtime.getInstance().
                getLanguages().size()) {
            UI.displayError(_("No Language selected or incorrect language selected."));
            return;
        }
        Runtime.getInstance().setOption(
                "language",
                Runtime.getInstance().getLanguages().get(
                        dlg.getSelectedLanguage()).fst());

        if (dlg.getNumOfActivities() <= 0) {
            UI.displayError(_("The number of activities needs to be bigger than 0."));
            return;
        }
        Runtime.getInstance().setOption("activities",
                Integer.toString(dlg.getNumOfActivities()));

        Runtime.getInstance().setOption("auto-open",
                Boolean.toString(dlg.isOpenSelected()));
        Runtime.getInstance().setOption("auto-save",
                Boolean.toString(dlg.isSaveSelected()));

        dlg.setVisible(false);
        dlg.dispose();
    }
}
