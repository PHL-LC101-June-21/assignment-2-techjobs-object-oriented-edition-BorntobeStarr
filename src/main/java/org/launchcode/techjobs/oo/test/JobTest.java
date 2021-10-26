package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import javax.xml.namespace.QName;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job empty1;
    Job empty2;
    Job testJob;

    public void makeAJobObject(){
        testJob = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Before
    public void initiateTests (){
        empty1 = new Job();
        empty2 = new Job();
        makeAJobObject();
    }




    @Test
    public void testSettingJobId(){
        empty1 = new Job();
        empty2 = new Job();
        assertNotEquals(empty1, empty2);
        assertEquals(empty1.getId() + 1, empty2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        testJob = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality (){
    Job testJobEquality1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job testJobEquality2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertFalse(testJobEquality1.equals(testJobEquality2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        testJob = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', testJob.toString().charAt(0));
        assertEquals('\n', testJob.toString().charAt(testJob.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        testJob = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals('\n' +
                "ID: " + testJob.getId() + '\n' +
                "Name: " + testJob.getName() + '\n' +
                "Employer: " + testJob.getEmployer() + '\n' +
                "Location: " + testJob.getLocation() + '\n' +
                "Position Type: " + testJob.getPositionType() + '\n' +
                "Core Competency: " + testJob.getCoreCompetency() + '\n', testJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJobFields = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals('\n' +
                "ID: " + testJobFields.getId() + '\n' +
                "Name: Data not available" + '\n' +
                "Employer: Data not available" + '\n' +
                "Location: Data not available" + '\n' +
                "Position Type: Data not available" + '\n' +
                "Core Competency: Data not available" + '\n', testJobFields.toString());
    }

}
