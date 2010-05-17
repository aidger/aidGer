package de.aidger.controller.actions;

import static de.aidger.utils.Translation._;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

import de.aidger.view.UI;

/**
 * PrintAction sends the current contents to the printer.
 * 
 * @author aidGer Team
 */
@SuppressWarnings("serial")
public class PrintAction extends AbstractAction {

    /**
     * Initializes the print action.
     */
    public PrintAction() {
        putValue(Action.NAME, _("Print"));
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P,
                ActionEvent.CTRL_MASK));
        putValue(Action.SHORT_DESCRIPTION, _("Print program contents"));
    }

    /*
     * (non-Javadoc)
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /* Get the Panel to print */
        final javax.swing.JPanel panel = UI.getInstance().getCurrentTab().
                getContent();

        /* Get PrinterJob and modify default format */
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(_("Print current tab"));
        PageFormat format = pj.defaultPage();
        format.setOrientation(PageFormat.LANDSCAPE);

        /* Add a new printable which paints the panel */
        pj.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                panel.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });

        /* Display the print dialog and finally print */
        if (pj.printDialog()) {
            try {
                pj.print();
            } catch (Exception ex) {
                UI.displayError(ex.getMessage());
            }
        }
    }

}
