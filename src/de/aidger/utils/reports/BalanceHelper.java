/**
 * 
 */
package de.aidger.utils.reports;

import java.util.List;
import java.util.Vector;

import de.aidger.model.models.Assistant;
import de.aidger.model.models.Course;
import de.aidger.model.models.Employment;
import de.aidger.model.reports.BalanceCourse;
import de.unistuttgart.iste.se.adohive.exceptions.AdoHiveException;
import de.unistuttgart.iste.se.adohive.model.IAssistant;
import de.unistuttgart.iste.se.adohive.model.ICourse;
import de.unistuttgart.iste.se.adohive.model.IEmployment;

/**
 * This class is used to get all the existing semesters and years.
 * 
 * @author aidGer Team
 */
public class BalanceHelper {

    /**
     * Initializes a new BalanceHelper.
     */
    public BalanceHelper() {
    }

    /**
     * Calculates the data relevant for the balance into a balance course model.
     * Returns that balance course model.
     * 
     * @param course
     *            The course to be calculated.
     * @return The balance course model.
     */
    public static BalanceCourse getBalanceCourse(ICourse course) {
        BalanceCourse balanceCourse = new BalanceCourse();
        balanceCourse.setTitle(course.getDescription());
        balanceCourse.setPart(course.getPart());
        balanceCourse.setLecturer(course.getLecturer());
        balanceCourse.setTargetAudience(course.getTargetAudience());
        double plannedAWS = 0;
        double basicAWS = course.getNumberOfGroups()
                * course.getUnqualifiedWorkingHours();
        balanceCourse.setBasicAWS(basicAWS);
        int studentFees = 0;
        int resources = 0;
        List<IEmployment> employments = null;
        List<IAssistant> assistants = null;
        try {
            employments = (new Employment()).getAll();
            assistants = (new Assistant()).getAll();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        for (IEmployment employment : employments) {
            if (employment.getCourseId() == course.getId()) {
                //TODO find out int for student fee funds
                if (employment.getFunds() == 1) {
                    for (IAssistant assistant : assistants) {
                        if (employment.getAssistantId() == assistant.getId()) {
                            //TODO change to get correct hourly wage
                            studentFees = studentFees
                                    + (int) (10.0 * employment.getHourCount() * 1.28);
                        }
                    }
                    //TODO find out int for student fee funds
                } else if (employment.getFunds() == 2) {
                    for (IAssistant assistant : assistants) {
                        if (employment.getAssistantId() == assistant.getId()) {
                            //TODO change to get correct hourly wage
                            resources = resources
                                    + (int) (10.0 * employment.getHourCount() * 1.28);
                        }
                    }
                }
                //TODO find out correct calculation
                plannedAWS = plannedAWS + employment.getHourCount();
            }
        }
        balanceCourse.setPlannedAWS(plannedAWS);
        balanceCourse.setStudentFees(studentFees);
        balanceCourse.setResources(resources);
        return balanceCourse;
    }

    /**
     * Checks all the courses for their semesters and returns all the semesters
     * afterwards.
     * 
     * @return A Vector containing the semesters as Strings.
     */
    public Vector getSemesters() {
        Vector semesters = new Vector();
        List<ICourse> courses = null;
        semesters.add("");
        try {
            courses = (new Course()).getAll();
        }
        catch (AdoHiveException e) {
            e.printStackTrace();
        }
        for (ICourse course : courses) {
            if (!semesters.contains(course.getSemester())) {
                semesters.add(course.getSemester());
            }
        }
        return semesters;
    }

    /**
     * Checks all the semesters for their years and returns the years as a
     * vector afterwards.
     * 
     * @return The vector of years as ints.
     */
    public Vector getYears() {
        Vector semesters = getSemesters();
        semesters.remove(0);
        Vector years = new Vector();
        years.add("");
        /*
         * Check for every semester out of the semester vector, if the year of
         * that semester is already noted and add it if it's not.
         */
        for (Object semester : semesters) {
            char[] semesterChar = ((String) semester).toCharArray();
            int year = 0;
            if (Character.isDigit(semesterChar[0])) {
                //The semester is in the form YYYY.
                for (int i = 0; i < semesterChar.length; i++) {
                    year = year + Character.getNumericValue(semesterChar[i])
                            * (int) Math.pow(10, 3 - i);
                }
            } else {
                //The semester is in the form SSYY or WSYYYY.
                int i = 0;
                while (!Character.isDigit(semesterChar[i])) {
                    i++;
                }
                int power = 0;
                switch (semesterChar.length - i) {
                case 2:
                    //The semester is in the form SSYY
                    year = 2000;
                    power = 10;
                    for (int j = i; j < semesterChar.length; j++) {
                        year = year
                                + Character.getNumericValue(semesterChar[j])
                                * power;
                        if (power == 10) {
                            power = 1;
                        } else {
                            power = 10;
                        }
                    }
                    break;
                case 4:
                    /*
                     * The semester is in the form WSYYYY. Both semester years
                     * must be checked
                     */
                    for (int l = 0; l < 3; l = l + 2) {
                        year = 2000;
                        power = 10;
                        for (int j = i + l; j < semesterChar.length - (2 - l); j++) {
                            year = year
                                    + Character
                                        .getNumericValue(semesterChar[j])
                                    * power;
                            if (power == 10) {
                                power = 1;
                            } else {
                                power = 10;
                            }
                        }
                        if (!years.contains(year)) {
                            years.add(year);
                        }
                    }
                    break;
                }
            }
            if (!years.contains(year)) {
                years.add(year);
            }
        }
        return years;
    }
}
