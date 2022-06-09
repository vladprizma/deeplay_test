package exception;

import errorcode.GameSolverErrorCode;

public class GameSolverException extends Exception {
    private final GameSolverErrorCode gameSolverErrorCode;

    public GameSolverException(GameSolverErrorCode gameSolverErrorCode) throws GameSolverException {
        if (gameSolverErrorCode == null)
            throw new GameSolverException(GameSolverErrorCode.NULL_STATE);
        this.gameSolverErrorCode = gameSolverErrorCode;
    }

    public String getMessage() {
        return gameSolverErrorCode.getErrorString();
    }
}
