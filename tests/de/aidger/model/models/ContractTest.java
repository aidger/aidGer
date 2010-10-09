package de.aidger.model.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;

/**
 * Tests the Contract class.
 * 
 * @author aidGer Team
 */
public class ContractTest {

    protected Contract contract = null;

    protected static Assistant assistant = null;

    @BeforeClass
    public static void beforeClassSetUp() throws AdoHiveException {
        de.aidger.model.Runtime.getInstance().initialize();

        assistant = new Assistant();
        assistant.setEmail("test@example.com");
        assistant.setFirstName("Test");
        assistant.setLastName("Tester");
        assistant.setQualification("g");
        assistant.save();
    }

    @Before
    public void setUp() {
        contract = new Contract();
        contract.setId(1);
        contract.setAssistantId(assistant.getId());
        contract.setCompletionDate(new Date(10));
        contract.setConfirmationDate(new Date(100));
        contract.setDelegation(false);
        contract.setEndDate(new Date(1000));
        contract.setStartDate(new Date(20));
        contract.setType("Type");
    }

    /**
     * Test of constructor, of class Contract.
     */
    @Test
    public void testConstructor() throws AdoHiveException {
        System.out.println("Constructor");

        contract.setNew(true);
        contract.save();

        Contract result = new Contract(contract.getById(contract.getId()));

        assertNotNull(result);
        assertEquals(contract, result);
    }

    /**
     * Test of validation, of class Contract.
     */
    @Test
    public void testValidation() throws AdoHiveException {
        System.out.println("Validation");

        contract.setNew(true);
        assertTrue(contract.save());

        contract.setAssistantId(0);
        assertFalse(contract.save());
        contract.resetErrors();
        contract.setAssistantId(assistant.getId());

        contract.setCompletionDate(null);
        assertFalse(contract.save());
        contract.resetErrors();
        contract.setCompletionDate(new Date(10));

        contract.setEndDate(null);
        assertFalse(contract.save());
        contract.resetErrors();
        contract.setEndDate(new Date(1000));

        contract.setStartDate(null);
        assertFalse(contract.save());
        contract.resetErrors();
        contract.setStartDate(new Date(20));

        contract.setType(null);
        assertFalse(contract.save());
        contract.resetErrors();

        contract.setType("012345678901234567890");
        assertFalse(contract.save());
        contract.resetErrors();
        contract.setType("Type");

        contract.setConfirmationDate(new Date(1));
        assertFalse(contract.save());
        contract.resetErrors();
        contract.setConfirmationDate(new Date(10));

        contract.setEndDate(new Date(10));
        assertFalse(contract.save());
        contract.resetErrors();
        contract.setEndDate(new Date(1000));
    }

    /**
     * Test of validateOnRemove, of class Contract.
     */
    @Test
    public void testValidateOnRemove() throws AdoHiveException {
        System.out.println("validateOnRemove");

        assertTrue(contract.save());
        assertTrue(contract.remove());

        contract.save();

        FinancialCategory fc = new FinancialCategory();
        fc.setBudgetCosts(new Integer[] { 100 });
        fc.setFunds(new Integer[] { 10001000 });
        fc.setName("name");
        fc.setYear((short) 2010);
        fc.save();

        Course course = new Course();
        course.setAdvisor("Tester");
        course.setDescription("Description");
        course.setFinancialCategoryId(fc.getId());
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

        Employment employment = new Employment();
        employment.setAssistantId(assistant.getId());
        employment.setContractId(contract.getId());
        employment.setCourseId(course.getId());
        employment.setFunds("0711");
        employment.setCostUnit(1);
        employment.setHourCount(40.0);
        employment.setMonth((byte) 10);
        employment.setQualification("g");
        employment.setRemark("Remark");
        employment.setYear((short) 2010);
        employment.save();

        assertFalse(contract.remove());
        contract.resetErrors();
        employment.remove();

        assertTrue(contract.remove());
    }

    /**
     * Test of clone method, of class Contract.
     */
    @Test
    public void testClone() {
        System.out.println("clone");

        Contract result = contract.clone();

        assertEquals(contract.getId(), result.getId());
        assertEquals(contract.getCompletionDate(), result.getCompletionDate());
        assertEquals(contract.getConfirmationDate(), result
            .getConfirmationDate());
        assertEquals(contract.isDelegation(), result.isDelegation());
        assertEquals(contract.getEndDate(), result.getEndDate());
        assertEquals(contract.getStartDate(), result.getStartDate());
        assertEquals(contract.getType(), result.getType());
    }

    /**
     * Test of equals method, of class Contract.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Contract result = contract.clone();

        assertEquals(contract, result);
        assertFalse(contract.equals(new Object()));

        result.setCompletionDate(null);
        result.setConfirmationDate(null);
        result.setEndDate(null);
        result.setStartDate(null);
        assertFalse(contract.equals(result));
    }

    /**
     * Test of hashCode method, of class Contract.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Contract result = contract.clone();

        assertEquals(contract.hashCode(), result.hashCode());
    }

    /**
     * Test of getContracts method, of class Contract.
     */
    @Test
    public void testGetContracts() throws AdoHiveException {
        System.out.println("getContracts");

        contract.setNew(true);
        contract.save();

        List result = contract.getContracts(new Date(20), new Date(1000));

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

}