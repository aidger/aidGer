package de.aidger.view.models;

import static de.aidger.utils.Translation._;

import java.util.Date;
import java.util.List;

import de.aidger.model.AbstractModel;
import de.aidger.model.models.Contract;
import de.aidger.utils.Logger;
import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;
import de.unistuttgart.iste.se.adohive.model.IContract;

/**
 * The class represents the table model for the contracts data.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class ContractTableModel extends TableModel {
    /**
     * Constructs the table model for contracts.
     */
    public ContractTableModel() {
        super(new String[] { _("Completion date"), _("Confirmation date"),
                _("Start date"), _("End date"), _("Type"), _("Delegation") });
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.models.TableModel#getAllModels()
     */
    @Override
    @SuppressWarnings("unchecked")
    public void getAllModels() {
        List<IContract> contracts = null;

        try {
            contracts = (new Contract()).getAll();
        } catch (AdoHiveException e) {
            Logger.error(e.getMessage());
        }

        for (IContract c : contracts) {
            Contract contract = new Contract(c);

            models.add(contract);
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
        Contract contract = (Contract) model;

        return new Object[] { contract.getCompletionDate(),
                contract.getConfirmationDate(), contract.getStartDate(),
                contract.getEndDate(), contract.getType(),
                contract.isDelegation() };
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
     */
    @Override
    public Class<?> getColumnClass(int column) {
        // sort specific columns properly
        if (column == 0 || column == 1 || column == 2 || column == 3) {
            return Date.class;
        }

        return super.getColumnClass(column);
    }
}
