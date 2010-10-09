/**
 *
 */
package de.aidger.utils.pdf;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import de.aidger.model.Runtime;
import de.aidger.model.models.Assistant;
import de.aidger.model.models.Contract;
import de.aidger.model.models.Course;
import de.aidger.model.models.Employment;
import de.aidger.model.models.FinancialCategory;
import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;

/**
 * Tests the class BudgetReportConverter.
 * 
 * @author aidGer Team
 */
public class BudgetReportConverterTest {

    private static Course course = null;

    private static Assistant assistant = null;

    private static Employment employment1 = null;

    private static Employment employment2 = null;

    private static Contract contract = null;

    private static FinancialCategory financialCategory = null;

    private static boolean openSetting = false;

    /**
     * Prepares this test.
     * 
     * @throws AdoHiveException
     */
    @BeforeClass
    public static void beforeClassSetUp() throws AdoHiveException {
        de.aidger.model.Runtime.getInstance().initialize();

        String autoOpen = Runtime.getInstance().getOption("auto-open");
        if (autoOpen.equals("true")) {
            openSetting = true;
        }
        Runtime.getInstance().setOption("auto-open", "false");

        financialCategory = new FinancialCategory();
        financialCategory.setBudgetCosts(new Integer[] { 1000 });
        financialCategory.setFunds(new Integer[] { 10000000 });
        financialCategory.setName("Test Category");
        financialCategory.setYear((short) 2010);
        financialCategory.save();

        course = new Course();
        course.setAdvisor("Tester");
        course.setDescription("Description");
        course.setFinancialCategoryId(financialCategory.getId());
        course.setGroup("2");
        course.setLecturer("Test Tester");
        course.setNumberOfGroups(3);
        course.setPart('a');
        course.setRemark("Remark");
        course.setScope("Sniper Scope");
        course.setSemester("SS09");
        course.setTargetAudience("Testers");
        course.setUnqualifiedWorkingHours(100.0);
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
        employment1.setCostUnit(1);
        employment1.setHourCount(10.0);
        employment1.setContractId(contract.getId());
        employment1.setFunds("Test unit");
        employment1.setMonth((byte) 1);
        employment1.setQualification("g");
        employment1.setRemark("Test remark");
        employment1.setYear((short) 1970);
        employment1.setNew(true);
        employment1.save();

        employment2 = new Employment();
        employment2.setAssistantId(assistant.getId());
        employment2.setCourseId(course.getId());
        employment2.setCostUnit(2);
        employment2.setHourCount(10.0);
        employment2.setContractId(contract.getId());
        employment2.setFunds("Test unit");
        employment2.setMonth((byte) 1);
        employment2.setQualification("g");
        employment2.setRemark("Test remark");
        employment2.setYear((short) 1970);
        employment2.setNew(true);
        employment2.save();
    }

    /**
     * Tests the constructor of the class BudgetReportConverter.
     */
    @Test
    public void testConstructor() {
        System.out.println("Constructor");

        File testFile = new File("Test_Report");

        new BudgetReportConverter(testFile, null);

        File file = new File("Test_Report.pdf");

        assertTrue(file.exists());

        testFile = new File("Test_Report.pdf");

        new BudgetReportConverter(testFile, null);

        file = new File("Test_Report.pdf");

        assertTrue(file.exists());
    }

    /**
     * Cleans up after the tests.
     * 
     * @throws AdoHiveException
     */
    @After
    public void cleanUp() throws AdoHiveException {

        course.remove();

        assistant.remove();

        employment1.remove();

        employment2.remove();

        contract.remove();

        financialCategory.remove();

        File file = new File("Test_Report.pdf");
        file.delete();
    }

    /**
     * Cleans up after all tests have completed.
     */
    @AfterClass
    public static void afterClassCleanUp() {
        Runtime.getInstance().setOption("auto-open", "" + openSetting);
    }
}
