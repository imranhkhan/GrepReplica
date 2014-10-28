package com.pramati.grepreplica;




import org.junit.Before;
import org.junit.Test;


public class GrepCommandTest{
	
	private GrepCommand grepCommand;
	
	@Before
	public void setUp(){
		grepCommand = new GrepCommand();	
	}
	
	@Test(expected = RuntimeException.class)
	public void testGrep1(){
		grepCommand.grep("some-file","some-file");
	}

}

