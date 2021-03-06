import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void testAddChromebook() {
		//fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that can add a new item
		// Jay's work
		assertNotNull("Test if there is valid Chrombook arraylist to add to", chromebookList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addChromebook(chromebookList, cb1);
		assertEquals("Test if that Chromebook arraylist size is 1?",1,chromebookList.size());
		
		//The item just added is the same as the first item of the list
		assertSame("Test that Chrombook is added same as the 1st item of the list?", cb1, chromebookList.get(0));
		
		//Add another item. Test the size of the list is 2?
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that Chrombook arraylist size is 2?",2,chromebookList.size());
		
		
	}
	
	@Test
	public void testRetrieveAllCamcorder() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void testRetrieveAllChromebook() {
		//fail("Not yet implemented");
		// write your code here
		//Jay's work
		assertNotNull("Test whether there is a valid Chromebook arraylist to retrieve from", chromebookList);
		
		//Test if Item list of not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Chrombook arraylist to add to", chromebookList);
		
		//test if the list of chromebook retrieved from the SourceCenter is empty
			String allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
			String testOutput = "";
			assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
			
		//Given an empty list, after adding 2 items, test if the size of the list is 2
			ResourceCentre.addChromebook(chromebookList, cb1);
			ResourceCentre.addChromebook(chromebookList, cb2);
			assertEquals("Test that chromebook arraylist size is 2",2, chromebookList.size());
			
			//Test if the expected output string same as the list of chromebooks retreive from the Sourcecentre
			allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
			testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
			testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n", "CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
			assertEquals("Test that viewAllChromebooklist", testOutput, allChromebook);
			
	}

	@Test
	public void testDoLoanCamcorder() {
		//fail("Not yet implemented");
		// write your code here
		//Test that the item list is not null but empty
		// Jay's work
		assertNotNull(camcorderList);
        
        // Test if items is available to loan
        ResourceCentre.addCamcorder(camcorderList, cc1);
        boolean loan = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "7-7-2021");
        assertTrue("Check that item is available", loan);
        
        
        // Test if items is unavailable to loan
        ResourceCentre.addCamcorder(camcorderList, cc2);
        assertFalse("Check that item is unavailable ", camcorderList.get(1).getIsAvailable() == false);
        
            
        // Test that the item that is being loaned exist
        for(Camcorder c: camcorderList)
        {
            assertFalse("Check that item does not exist.", c.getAssetTag() == "CC1234");
        }
		
	}
	
	@Test
	public void testDoLoanChromebook() {
		//fail("Not yet implemented");
		// write your code here
		// Russell's work
		//Test that the list is not null
		assertNotNull("Test if there is a chromebook list to check",chromebookList);
		
		//Add an item into the list and loan it out, then check if it is possible to loan a loaned item
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "27/7/2021");
		
		
		assertFalse("Cant loan a chromebook that is already on loan",ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "27/7/2021"));
		
	}
	
	@Test
	public void testDoReturnCamcorder() {
		//fail("Not yet implemented");		
		// write your code here
		//Boundary condition TC
		// Xi hui's work
		assertNotNull("Test if there is a valid Camcorder arraylist to add to", camcorderList);
		
		//error
		ResourceCentre.addCamcorder(camcorderList, cc1);
		Boolean isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
		assertFalse("Test if available chromebook CC0011 is returned -false?", isReturned);
		
		//normal
		ResourceCentre.addCamcorder(camcorderList, cc2);
		cc2.setIsAvailable(false);
		isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0012");
		assertTrue("Test if loaned out camcorder CC0012 is returned -true", isReturned);
		
		//error
		isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0013");
		assertFalse("Test if loaned out camcorder CC0013 is returned - false ", isReturned);
		
		
	}
	@Test
	public void testDoReturnChromebook() {
		//fail("Not yet implemented");
		// write your code here
		// Som's work
		assertNotNull("Test if there is a valid Chromebook arraylist to add to", chromebookList);
		
		ResourceCentre.addChromebook(chromebookList, cb1);
		Boolean isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
		assertFalse("Test if available chromebook CB0011 is returned -false?", isReturned);
		
		
		
		isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0013");
		assertFalse("Test if loaned out chromebook CB0013 is returned - false ", isReturned);
		
		ResourceCentre.addChromebook(chromebookList, cb2);
		cb2.setIsAvailable(false);
		isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0012");
		assertTrue("Test if loaned out chromebook CB0012 is returned -true", isReturned);
		
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
