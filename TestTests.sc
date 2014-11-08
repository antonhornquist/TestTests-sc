TestAssertionTests : Test {
	var
		v1,
		v2
	;

	setup {
		v1 = 1.24;
		v2 = (1..10).asArray;
	}

	test_assertBooleanShouldPass {
		this.assert(true);
		this.assertTrue(true);
		this.assertFalse(false);
	}

	test_assertNilShouldPass {
		this.assertNil(nil);
		this.assertNotNil(1.24);
	}

	test_assertEqualityShouldPass {
		this.assertEqual( 1, 1 );
		this.assertNotEqual( 1, 2 );
	}

	test_assertErrorThrownShouldPass {
		this.assertErrorThrown(Error, { Error("test").throw });
		this.assertErrorThrown(NotYetImplementedError, { this.notYetImplemented; });
	}

	test_assertAnyErrorThrownShouldPass {
		this.assertAnyErrorThrown({ Error("test").throw });
		this.assertAnyErrorThrown({ this.notYetImplemented; });
	}

	test_assertNoErrorThrownShouldPass {
		this.assertNoErrorThrown({ 1 + 1 });
	}

	test_setupShouldPass {
		this.assertEqual( v1, 1.24 );
		this.assertEqual( v2, (1..10).asArray );
	}

}

/*
	// These are deliberately commented out since they are tests for failures and errors. To test these just uncomment.

TestRunnerTests : Test {
	var
		v1;

	setup {
		v1 = \test;
	}

	test_failingTests {
		this.assertEqual(
			IdentityDictionary[
				(\numTests -> 5),
				(\numFailedAssertions -> 20),
				(\numErrors -> 0),
				(\numAssertions -> 20)
			],
			TestTestsShouldFail.runAllTests(silent: true)
		);
	}

	test_erroneousTests {
		this.assertEqual(
			IdentityDictionary[
				(\numTests -> 2),
				(\numFailedAssertions -> 0),
				(\numErrors -> 2),
				(\numAssertions -> 1)
			],
			TestTestsShouldReportError.runAllTests(silent: true)
		);
	}

	test_runAllTests {
		this.assertEqual(
			7,
			TestAssertionTests.runAllTests(silent: true)[\numTests]
		);
	}

	test_runSingleTest {
		this.assertEqual(
			1,
			TestAssertionTests.runTest(\test_assertBooleanShouldPass, silent: true)[\numTests]
		);
	}

	test_setup {
		this.assertEqual(
			\test,
			v1
		);
	}
}

TestTestsShouldFail : Test {
	test_assertBooleanShouldFail {
		[false, 1.0, $F, "hey"].do { |in| this.assert(in) };
		[false, 1.0, $F, "hey"].do { |in| this.assertTrue(in) };
		[true, 1.0, $F, "hey"].do { |in| this.assertFalse(in) };
	}

	test_assertNilShouldFail {
		this.assertNil(1.0);
		this.assertNotNil(nil);
	}

	test_assertEqualityShouldFail {
		this.assertEqual( 1, 2 );
		this.assertNotEqual( 1, 1 );
	}

	test_assertErrorThrownShouldFail {
		this.assertErrorThrown(NotYetImplementedError, { Error("test").throw });
		this.assertErrorThrown(Error, { this.notYetImplemented; });
		this.assertErrorThrown(Error, { nil });
	}

	test_assertAnyErrorThrownShouldFail {
		this.assertAnyErrorThrown({ nil });
	}
}

TestTestsShouldReportError : Test {
	test_assertErrorShouldReportError {
		1.noSuchMethod;
	}

	test_assertAssertionBeforeErrorShouldBeRecordedButReportError {
		this.assertTrue(true);
		1.noSuchMethod;
	}
}
*/
