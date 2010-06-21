package de.aidger.view.tabs;

import static de.aidger.utils.Translation._;

import java.util.List;

import javax.swing.JPanel;

import de.aidger.controller.ActionNotFoundException;
import de.aidger.controller.ActionRegistry;
import de.aidger.controller.actions.DetailViewerCancelAction;
import de.aidger.controller.actions.DetailViewerEditAction;
import de.aidger.model.AbstractModel;
import de.aidger.model.models.Assistant;
import de.aidger.model.models.Contract;
import de.aidger.model.models.Course;
import de.aidger.model.models.Employment;
import de.aidger.model.models.FinancialCategory;
import de.aidger.model.models.HourlyWage;
import de.aidger.view.UI;
import de.aidger.view.forms.AssistantViewerForm;
import de.aidger.view.forms.ContractViewerForm;
import de.aidger.view.forms.CourseViewerForm;
import de.aidger.view.forms.EmploymentViewerForm;
import de.aidger.view.forms.FinancialCategoryViewerForm;
import de.aidger.view.forms.Form;
import de.aidger.view.forms.HourlyWageViewerForm;
import de.aidger.view.models.ListModel;
import de.aidger.view.tabs.ViewerTab.DataType;

/**
 * A tab which will be used to view the model.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class DetailViewerTab extends Tab {

    /**
     * The model for the detail viewer.
     */
    @SuppressWarnings("unchecked")
    protected AbstractModel model = null;

    /**
     * The type of the data.
     */
    private final DataType type;

    /**
     * Constructs a data detail viewer tab.
     * 
     * @param type
     *            type of the data
     * @param model
     *            the data model
     */
    @SuppressWarnings("unchecked")
    public DetailViewerTab(DataType type, AbstractModel model) {
        this.type = type;
        this.model = model;

        init();
    }

    /**
     * Return a parseable string that lets the UI initalise the tab.
     * 
     * @return A parseable string
     */
    @Override
    public String toString() {
        String ret = getClass().getName() + "<" + DataType.class.getName()
                + "@" + type + "<" + model.getClass().getName() + "@"
                + model.getId();

        return ret;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.tabs.Tab#getPredecessor()
     */
    @Override
    public Tab getPredecessor() {
        Tab p = super.getPredecessor();

        if (p == null) {
            p = new ViewerTab(getType());
        }

        return p;
    }

    /**
     * Initializes the components and the button actions.
     */
    private void init() {
        initComponents();

        try {
            btnEdit.setAction(ActionRegistry.getInstance().get(
                DetailViewerEditAction.class.getName()));

            btnCancel.setAction(ActionRegistry.getInstance().get(
                DetailViewerCancelAction.class.getName()));
        } catch (ActionNotFoundException e) {
            UI.displayError(e.getMessage());
        }

    }

    /**
     * Returns the data model.
     * 
     * @return the data model
     */
    @SuppressWarnings("unchecked")
    public AbstractModel getModel() {
        return model;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.aidger.view.tabs.Tab#getTabName()
     */
    @Override
    public String getTabName() {
        switch (type) {
        case Course:
            return _("View course");
        case Assistant:
            return _("View assistant");
        case FinancialCategory:
            return _("View financial category");
        case HourlyWage:
            return _("View hourly wage");
        case Employment:
            return _("View employment");
        case Contract:
            return _("View contract");
        default:
            return "";
        }
    }

    /**
     * Returns all list models of the tab.
     * 
     * @return all list models
     */
    public List<ListModel> getListModels() {
        return ((Form) viewerForm).getListModels();
    }

    /**
     * Returns the type of the data that is added or edited.
     * 
     * @return the type of the data
     */
    public DataType getType() {
        return type;
    }

    /**
     * Returns the data viewer form.
     * 
     * @return the data viewer form.
     */
    public JPanel getViewerForm() {
        return viewerForm;
    }

    /**
     * Creates a new viewer form.
     * 
     * @return the created viewer form
     */
    public JPanel createViewerForm() {
        switch (type) {
        case Course:
            return new CourseViewerForm((Course) model);
        case Assistant:
            return new AssistantViewerForm((Assistant) model);
        case FinancialCategory:
            return new FinancialCategoryViewerForm((FinancialCategory) model);
        case HourlyWage:
            return new HourlyWageViewerForm((HourlyWage) model);
        case Employment:
            return new EmploymentViewerForm((Employment) model);
        case Contract:
            return new ContractViewerForm((Contract) model);
        default:
            return new JPanel();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        viewerForm = createViewerForm();
        buttons = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        filler = new javax.swing.JLabel();
        filler2 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        viewerForm.setBorder(javax.swing.BorderFactory.createTitledBorder(
            javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1),
            getTabName()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(viewerForm, gridBagConstraints);

        btnEdit.setText(_("Edit"));
        buttons.add(btnEdit);

        btnCancel.setText(_("Cancel"));
        buttons.add(btnCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(buttons, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weighty = 1.0;
        add(filler, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.weightx = 1.0;
        add(filler2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JPanel buttons;
    private javax.swing.JLabel filler;
    private javax.swing.JLabel filler2;
    private javax.swing.JPanel viewerForm;
    // End of variables declaration//GEN-END:variables

}
