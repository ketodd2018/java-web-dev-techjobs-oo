package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    public static Job baker;
    public static Job crafter;

    @BeforeClass
    public static void setJobObjects(){
        baker = new Job ("Baker", new Employer("Bakery"), new Location("Baker St"), new PositionType("Baker"), new CoreCompetency("Baking"));
        crafter = new Job ("", new Employer(), new Location(), new PositionType(), new CoreCompetency());
    }
    @Test
    public void testSettingJobId(){
//        System.out.println(baker.getId());
        assertNotEquals(baker.getId(), crafter.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", productTester.getName());
        assertEquals("ACME", productTester.getEmployer().getValue());
        assertEquals("Desert", productTester.getLocation().getValue());
        assertEquals("Quality control", productTester.getPositionType().getValue());
        assertEquals("Persistence", productTester.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality (){
        Job baker1 = new Job ("Baker", new Employer("Bakery"), new Location("Baker St"), new PositionType("Baker"), new CoreCompetency("Baking"));
        Job baker2 = new Job ("Baker", new Employer("Bakery"), new Location("Baker St"), new PositionType("Baker"), new CoreCompetency("Baking"));
        assertNotEquals(baker1, baker2);
    }
    @Test
    public void testForToString (){
        assertTrue(crafter.toString().contains("ID"));
        assertTrue(crafter.toString().contains("Name"));
        assertTrue(crafter.toString().contains("Employer"));
        assertTrue(crafter.toString().contains("Location"));
        assertTrue(crafter.toString().contains("Position Type"));
        assertTrue(crafter.toString().contains("Core Competency"));
    }
    @Test
    public void testForEmpty(){
        assertTrue(crafter.toString().contains("Data not available."));
        assertTrue(crafter.toString().contains("Location: Data not available."));
        assertTrue(crafter.toString().contains("Position Type: Data not available."));
        assertTrue(crafter.toString().contains("Core Competency: Data not available."));
    }
}
