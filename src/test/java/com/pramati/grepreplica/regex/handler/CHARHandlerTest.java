package com.pramati.grepreplica.regex.handler;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pramati.grepreplica.regex.minimal.Context;
import com.pramati.grepreplica.regex.minimal.handler.CHARHandler;

public class CHARHandlerTest {

	private Context grepContext;
	private CHARHandler charHandler;

	public CHARHandlerTest() {

	}

	@Before
	public void setUp() {
		grepContext = EasyMock.createNiceMock(Context.class);
		charHandler = new CHARHandler(grepContext);
	}

	@Test
	public void testHandleTrue() {
		EasyMock.expect(grepContext.getRegExChar()).andReturn('a');
		EasyMock.expect(grepContext.getStrChar()).andReturn('a');
		EasyMock.replay(grepContext);

		assertEquals(charHandler.handle(), true);
	}

	@After
	public void clean() {
		grepContext = null;
		charHandler = null;
	}
}
