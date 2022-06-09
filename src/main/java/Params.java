import errorcode.GameSolverErrorCode;
import exception.GameSolverException;

public class Params {
    public static final String baseTermsPath = "./inputData/baseTerms.json";
    public static final String fictionTermsPath = "./inputData/fictionTerms.json";

    private static String pathToTermsFile = fictionTermsPath;

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
