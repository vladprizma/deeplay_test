import errorcode.GameSolverErrorCode;
import exception.GameSolverException;

public class Params {
    private static String pathToTermsFile = "./inputData/baseTerms.json";

    public static void setPathToTermsFile(final String path) throws GameSolverException {
        if (isBlank(path))
            throw new GameSolverException(GameSolverErrorCode.INCORRECT_PATH_TO_TERMS_FILE);
        pathToTermsFile = path;
    }

    public static String getPathToTermsFile() {
        return pathToTermsFile;
    }

    public static boolean isBlank(String string) {
        return string == null || string.length() == 0 || string.trim().length() == 0;
    }
}
