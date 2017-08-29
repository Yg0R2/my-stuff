package yg0r2.scripts.args.parser;

import org.testng.annotations.Test;
import yg0r2.scripts.args.Args;
import yg0r2.scripts.args.parser.exception.IllegalArgumentException;
import yg0r2.scripts.args.parser.exception.MissingArgumentException;
import yg0r2.scripts.args.parser.exception.MissingScriptException;
import yg0r2.scripts.args.parser.exception.ParserException;

import java.util.Arrays;

import static org.testng.Assert.*;

public class ArgParserTest {

    private String[] arguments;
    private ArgParser underTest;

    @Test(expectedExceptions = MissingScriptException.class)
    public void testMissingCommandException() throws ParserException {
        // GIVEN

        arguments = new String[0];

        // WHEN

        underTest = new ArgParser(arguments);
        underTest.parse();

        // THEN
    }

    @Test
    public void testEmptyParameterList() throws ParserException {
        // GIVEN

        arguments = new String[] { "command" };

        // WHEN

        underTest = new ArgParser(arguments);
        Args args = underTest.parse();

        // THEN

        assertEquals(args.getScriptType(), "command");
    }

    @Test
    public void testEnvironmentVariables() throws ParserException {
        // GIVEN

        arguments = new String[] { "command", "-Dmaven.test.skip=true" };

        // WHEN

        underTest = new ArgParser(arguments);
        Args args = underTest.parse();

        // THEN

        assertEquals(args.getEnvironmentVariable(), Arrays.asList("-Dmaven.test.skip=true"));
    }

    @Test(expectedExceptions = MissingArgumentException.class,
        expectedExceptionsMessageRegExp = "String parameter '--stringParameter' value is missing\\.")
    public void testMissingStringValueException_WhenStringParameterValueMissing() throws ParserException {
        // GIVEN

        arguments = new String[] { "command", "--stringParameter" };

        // WHEN

        underTest = new ArgParser(arguments);
        underTest.parse();

        // THEN
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
        expectedExceptionsMessageRegExp = "Invalid parameter 'parameter'\\.")
    public void testIllegalArgumentException() throws ParserException {
        // GIVEN

        arguments = new String[] { "command", "parameter" };

        // WHEN

        underTest = new ArgParser(arguments);
        underTest.parse();

        // THEN
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
        expectedExceptionsMessageRegExp = "String parameter '--stringParameter' value is missing\\.")
    public void testIllegalArgumentException_WhenStringParameterValueMissing() throws ParserException {
        // GIVEN

        arguments = new String[] { "command", "--stringParameter", "-nextParameter" };

        // WHEN

        underTest = new ArgParser(arguments);
        underTest.parse();

        // THEN
    }

    @Test
    public void testStringParameter() throws ParserException {
        // GIVEN

        arguments = new String[] { "command", "--stringParameter", "stringParameterValue" };

        // WHEN

        underTest = new ArgParser(arguments);
        Args args = underTest.parse();

        // THEN

        assertEquals(args.getStringValue("stringParameter"), "stringParameterValue");
    }

    @Test
    public void testBooleanParameter() throws ParserException {
        // GIVEN

        arguments = new String[] { "command", "-booleanParameter" };

        // WHEN

        underTest = new ArgParser(arguments);
        Args args = underTest.parse();

        // THEN

        assertTrue(args.getBooleanValue("booleanParameter"));
        assertFalse(args.getBooleanValue("booleanParameter2"));
    }

}
