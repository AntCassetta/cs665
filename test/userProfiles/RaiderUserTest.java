package userProfiles;

import static org.junit.Assert.*;

import org.junit.Test;

public class RaiderUserTest {

	@Test
	public void test() {
		RaiderUser testUser = RaiderUser.getInstane();
		
		testUser.setUserName("TestOwner");
		testUser.setUserID(01);
		testUser.setUserType("owner");
		
		assertEquals("TestOwner", testUser.getUserName());
		assertEquals(01, testUser.getUserID());
		assertEquals("owner", testUser.getUserType());
	}

}
