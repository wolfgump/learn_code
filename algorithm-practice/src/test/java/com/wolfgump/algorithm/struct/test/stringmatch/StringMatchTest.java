package com.wolfgump.algorithm.struct.test.stringmatch;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.struct.stringmatch.StringMatch;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class StringMatchTest extends AlgorithmApplicationTests {
	@Test
	public void testBFTrue(){
		String haystack="abccca";
		String needle="c";
		boolean result= StringMatch.bfMatch(haystack.toCharArray(),needle.toCharArray());
		Assert.assertTrue(result);
	}
	@Test
	public void testBFFalse(){
		String haystack="abccca";
		String needle="abcccc";
		boolean result= StringMatch.bfMatch(haystack.toCharArray(),needle.toCharArray());
		Assert.assertFalse(result);
	}
	@Test
	public void testRKTrue(){
		String haystack="abccca";
		String needle="c";
		boolean result= StringMatch.rKMatch(haystack.toCharArray(),needle.toCharArray());
		Assert.assertTrue(result);
	}
	@Test
	public void testRKFalse(){
		String haystack="abccca";
		String needle="abcccc";
		boolean result= StringMatch.rKMatch(haystack.toCharArray(),needle.toCharArray());
		Assert.assertFalse(result);
	}
}
