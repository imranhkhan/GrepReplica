package com.pramati.grepreplica.regex.handler;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pramati.grepreplica.regex.Context;

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

	public void testHandleTrue() {
		EasyMock.expect(grepContext.getRegExChar()).andReturn('a');
		EasyMock.expect(grepContext.getStrChar()).andReturn('a');
		EasyMock.replay(grepContext);

		assertEquals(charHandler.handle(), true);
	}

	public void testHandleFalse() {
		EasyMock.expect(grepContext.getRegExChar()).andReturn('a');
		EasyMock.expect(grepContext.getStrChar()).andReturn('b');
		EasyMock.replay(grepContext);

		assertFalse(charHandler.handle());
	}

	public void testHandleException() {
		EasyMock.expect(grepContext.getRegExChar()).andThrow(
				new RuntimeException());
		EasyMock.expect(grepContext.getStrChar()).andReturn('b');
		EasyMock.expect(grepContext.canIncrement()).andReturn(true);
		EasyMock.replay(grepContext);

		assertFalse(charHandler.handle());
	}

	@After
	public void clean() {
		grepContext = null;
		charHandler = null;
	}
}
