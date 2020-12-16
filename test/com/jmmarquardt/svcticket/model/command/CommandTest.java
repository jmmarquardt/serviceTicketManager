package com.jmmarquardt.svcticket.model.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * CommandTest is a suite of JUnit Jupiter unit tests for the constructor and
 * getter methods of the Command object class.
 * 
 * @author John-Michael Marquardt, jmmarquardt@gmail.com
 */
public class CommandTest {
	private final String ERR = "Invalid Command.";
	private final String OWNER = "Owner";
	private final String NOTE = "This is a note.";

	private Command c;

	/**
	 * Test method for Command constructor.
	 */
	@Test
	public void testCommand() {
		// CommandValue is null
		try {
			c = new Command(null, OWNER, Command.FeedbackCode.AWAITING_CHANGE, Command.ResolutionCode.COMPLETED,
					Command.CancellationCode.DUPLICATE, NOTE);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(e, ERR);
		}
//		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for the non-static Command method getCommandValue().
	 */
	@Test
	public void testGetCommandValue() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for the non-static Command method getOwnerId().
	 */
	@Test
	public void testGetOwnerId() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for the non-static Command method getNote().
	 */
	@Test
	public void testGetNote() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for the non-static Command method getFeedbackCode().
	 */
	@Test
	public void testGetFeedbackCode() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for the non-static Command method getResolutionCode().
	 */
	@Test
	public void testGetResolutionCode() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for the non-static Command method CancellationCode().
	 */
	@Test
	public void testGetCancellationCode() {
		fail("Not yet implemented"); // TODO
	}

}