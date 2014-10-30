package com.pramati.grepreplica.regex.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pramati.grepreplica.regex.minimal.Context;
import com.pramati.grepreplica.regex.minimal.handler.DOTHandler;

public class DOTHandlerTest {

	private Context grepContext;
	private DOTHandler dotHandler;
	
	@Before
	public void setUp(){
		grepContext = EasyMock.createNiceMock(Context.class);
		dotHandler = new DOTHandler(grepContext);
	}
	
	@Test
	public void testHandleTrue() {
		EasyMock.expect(grepContext.getRegExChar()).andReturn('.');
		EasyMock.expect(grepContext.getStrChar()).andReturn('a');
		EasyMock.expect(grepContext.canIncrement()).andReturn(true);
		EasyMock.replay(grepContext);
		
		assertEquals(dotHandler.handle(), true);
	}
	
	@Test
	public void testHandleFalse() {
		EasyMock.expect(grepContext.getRegExChar()).andReturn('a');
		EasyMock.expect(grepContext.getStrChar()).andReturn('c');
		EasyMock.expect(grepContext.canIncrement()).andReturn(true);
		EasyMock.replay(grepContext);
		
		assertFalse(dotHandler.handle());
	}

	@After
	public void clean() {
		grepContext = null;
		dotHandler = null;
	}
}
