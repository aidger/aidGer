package de.aidger.view.models;

import static de.aidger.utils.Translation._;

import java.util.List;

import de.aidger.model.AbstractModel;
import de.aidger.model.models.Assistant;
import de.aidger.utils.Logger;
import de.aidger.view.forms.HourlyWageEditorForm.Qualification;
import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;
import de.unistuttgart.iste.se.adohive.model.IAssistant;

/**
 * The class represents the table model for the master data assistants.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class AssistantTableModel extends TableModel {
    /**
     * Constructs the table model for assistants.
     */
    public AssistantTableModel() {
        super(new String[] { _("ID"), _("First Name"), _("Last Name"),
                _("Email"), _("Qualification") });
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.models.TableModel#getAllModels()
     */
    @Override
    @SuppressWarnings("unchecked")
    protected void getAllModels() {
        List<IAssistant> assistants = null;

        try {
            assistants = (new Assistant()).getAll();
        } catch (AdoHiveException e) {
            Logger.error(e.getMessage());
        }

        for (IAssistant a : assistants) {
            Assistant assistant = new Assistant(a);

            models.add(assistant);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @seede.aidger.view.models.TableModel#convertModelToRow(de.aidger.model.
     * AbstractModel)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected Object[] convertModelToRow(AbstractModel model) {
        Assistant assistant = (Assistant) model;

        return new Object[] { assistant.getId(), assistant.getFirstName(),
                assistant.getLastName(), assistant.getEmail(),
                Qualification.valueOf(assistant.getQualification()) };
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
     */
    @Override
    public Class<?> getColumnClass(int column) {
        // sort specific columns properly
        if (column == 0) {
            return Integer.class;
        }

        return super.getColumnClass(column);
    }
}
