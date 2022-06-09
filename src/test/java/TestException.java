import errorcode.GameSolverErrorCode;
import exception.GameSolverException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestException {

    @Test
    public void testIncorrectFieldLength() throws GameSolverException {
        Params.setPathToTermsFile(Params.baseTermsPath);
        try {
            Solution.getResult("SHORT", "Human");
        } catch (GameSolverException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(), GameSolverErrorCode.INCORRECT_FIELD_STRING_LENGTH.getErrorString());
        }
    }

    @Test
    public void testIncorrectPath() {
        try {
            Params.setPathToTermsFile(" ");
        } catch (GameSolverException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(), GameSolverErrorCode.INCORRECT_PATH_TO_TERMS_FILE.getErrorString());
        }
    }

    @Test
    public void testCreatureNotFound() throws GameSolverException {
        Params.setPathToTermsFile(Params.baseTermsPath);
        try {
            Solution.getResult("HOHOHONOHOHOHONO", "isThereCreatureLikeThat?");
        } catch (GameSolverException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(), GameSolverErrorCode.NO_SUCH_CREATURE_FOUND.getErrorString());
        }
    }

    @Test
    public void testSymbolNotFound() throws GameSolverException {
        Params.setPathToTermsFile(Params.baseTermsPath);
        try {
            Solution.getResult("isThereCellSymb?", "Human");
        } catch (GameSolverException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(), GameSolverErrorCode.NO_SUCH_COST_SYMBOL_FOUND.getErrorString());
        }
    }

    @Test
    public void testIncorrectParameters() throws GameSolverException {
        Params.setPathToTermsFile("./inputData/wrongNameTerms.json");
        try {
            Solution.getResult("HOHOHONOHOHOHONO", "");
        } catch (GameSolverException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(), GameSolverErrorCode.TERMS_WRONG_PARAMETERS.getErrorString());
        }

        Params.setPathToTermsFile("./inputData/incorrectValueTerms.json");
        try {
            Solution.getResult("HOHOHONOHOHOHONO", "HereNow");
        } catch (GameSolverException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(), GameSolverErrorCode.TERMS_WRONG_PARAMETERS.getErrorString());
        }
    }

    @Test
    public void testTermsNotFound() throws GameSolverException {
        Params.setPathToTermsFile("./inputData/noTerms.json");
        try {
            Solution.getResult("HOHOHONOHOHOHONO", "Someone");
        } catch (GameSolverException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(), GameSolverErrorCode.NO_TERMS_FOUND.getErrorString());
        }
    }

    @Test
    public void testIncorrectFilePath() throws GameSolverException {
        Params.setPathToTermsFile("./inputData");
        try {
            Solution.getResult("HOHOHONOHOHOHONO", "Someone");
        } catch (GameSolverException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(), GameSolverErrorCode.INCORRECT_FILE.getErrorString());
        }
    }

}
