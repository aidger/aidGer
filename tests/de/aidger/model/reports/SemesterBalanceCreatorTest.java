/**
 * 
 */
package de.aidger.model.reports;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import de.aidger.model.models.Assistant;
import de.aidger.model.models.Contract;
import de.aidger.model.models.Course;
import de.aidger.model.models.Employment;
import de.aidger.utils.reports.BalanceHelper;
import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;

/**
 * @author Phil
 * 
 */
public class SemesterBalanceCreatorTest {

    private Course course = null;

    private Assistant assistant = null;

    private Employment employment1 = null;

    private Employment employment2 = null;

    private Contract contract = null;

    private SemesterBalanceCreator balanceCreator = null;

    private BalanceHelper balanceHelper = null;

    public SemesterBalanceCreatorTest() {
        de.aidger.model.Runtime.getInstance().initialize();
    }

    /**
     * Prepares this test.
     * 
     * @throws AdoHiveException
     */
    @Before
    public void setUp() throws AdoHiveException {
        balanceHelper = new BalanceHelper();

        course = new Course();
        course.setAdvisor("Tester");
        course.setDescription("Description");
        course.setFinancialCategoryId(1);
        course.setGroup("2");
        course.setLecturer("Test Tester");
        course.setNumberOfGroups(3);
        course.setPart('a');
        course.setRemark("Remark");
        course.setScope("Sniper Scope");
        course.setSemester("SS09");
        course.setTargetAudience("Testers");
        course.setUnqualifiedWorkingHours(100);
        course.save();

        assistant = new Assistant();
        assistant.setEmail("test@example.com");
        assistant.setFirstName("Test");
        assistant.setLastName("Tester");
        assistant.setQualification("g");
        assistant.save();

        contract = new Contract();
        contract.setNew(true);
        contract.setStartDate(new Date(1970, 1, 1));
        contract.setCompletionDate(new Date(1970, 1, 3));
        contract.setConfirmationDate(new Date(1970, 1, 2));
        contract.setEndDate(new Date(1970, 1, 4));
        contract.setDelegation(true);
        contract.setType("Test type");
        contract.save();

        employment1 = new Employment();
        employment1.setAssistantId(assistant.getId());
        employment1.setCourseId(course.getId());
        employment1.setFunds(1);
        employment1.setHourCount(10.0);
        employment1.setContractId(contract.getId());
        employment1.setCostUnit("Test unit");
        employment1.setMonth((byte) 1);
        employment1.setQualification("g");
        employment1.setRemark("Test remark");
        employment1.setYear((short) 1970);
        employment1.setNew(true);
        employment1.save();

        employment2 = new Employment();
        employment2.setAssistantId(assistant.getId());
        employment2.setCourseId(course.getId());
        employment2.setFunds(2);
        employment2.setHourCount(10.0);
        employment2.setContractId(contract.getId());
        employment2.setCostUnit("Test unit");
        employment2.setMonth((byte) 1);
        employment2.setQualification("g");
        employment2.setRemark("Test remark");
        employment2.setYear((short) 1970);
        employment2.setNew(true);
        employment2.save();
    }

    /**
     * Tests the constructor of the SemesterBalanceCreator class.
     */
    @Test
    public void testConstructor() {
        System.out.println("Constructor/addSemester()");

        balanceCreator = new SemesterBalanceCreator();

        assertNotNull(balanceCreator);
    }

    /**
     * Tests the method getSemester() of the SemesterBalanceCreator class.
     * 
     * @throws AdoHiveException
     */
    @Test
    public void testGetSemester() {
        balanceCreator = new SemesterBalanceCreator();

        assertNotNull(balanceCreator);

        Vector semesters = balanceHelper.getSemesters();

        for (int i = 1; i < semesters.size(); i++) {
            assertTrue(balanceCreator.addSemester("" + semesters.get(i)));
        }
    }

    /**
     * Tests the method getViewerTab() of the class AnnualBalanceCreator.
     */
    @Test
    public void testGetViewerTab() {
        System.out.println("getViewerTab()");

        balanceCreator = new SemesterBalanceCreator();

        assertNotNull(balanceCreator.getViewerTab());
    }
}
