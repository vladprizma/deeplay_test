package errorcode;

public enum GameSolverErrorCode {
    INCORRECT_FIELD_STRING_LENGTH("Field string length should be equal 16"),
    TERMS_WRONG_PARAMETERS("Terms set incorrectly"),
    NO_TERMS_FOUND("No terms were found in given file"),
    NO_SUCH_CREATURE_FOUND("No such creature found"),
    NO_SUCH_COST_SYMBOL_FOUND("No such symbol-cost mapping found"),

    NULL_STATE("State parameter is null"),
    INCORRECT_PATH_TO_TERMS_FILE("Given string path to file is either null or doesn't contain non-whitespace symbols"),
    INCORRECT_FILE("Given path to the file either doesn't exists, hidden, a directory or unreadable");

    private final String errorString;

    GameSolverErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
