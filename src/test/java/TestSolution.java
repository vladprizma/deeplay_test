import exception.GameSolverException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSolution {

    @Test
    public void testGetResultBaseTerms() throws GameSolverException {
        Params.setPathToTermsFile(Params.baseTermsPath);
        long start = System.currentTimeMillis();
        /*
        S T W S
        W T P P
        T P T T
        P W P P
        */
        assertEquals(10, Solution.getResult("STWSWTPPTPTTPWPP", "Human"));
        assertEquals(15, Solution.getResult("STWSWTPPTPTTPWPP", "Swamper"));
        assertEquals(12, Solution.getResult("STWSWTPPTPTTPWPP", "Woodman"));

        assertEquals(30, Solution.getResult("SSSSSSSSSSSSSSSS", "Human"));
        assertEquals(12, Solution.getResult("SSSSSSSSSSSSSSSS", "Swamper"));
        assertEquals(18, Solution.getResult("SSSSSSSSSSSSSSSS", "Woodman"));

        /*
        S S S S
        P S S S
        P S S S
        P P P S
        */
        assertEquals(10, Solution.getResult("SSSSPSSSPSSSPPPS", "Human"));
        assertEquals(12, Solution.getResult("SSSSPSSSPSSSPPPS", "Swamper"));
        assertEquals(13, Solution.getResult("SSSSPSSSPSSSPPPS", "Woodman"));

        /*
        S S P P
        S S S P
        S S S P
        S S S S
        */
        assertEquals(14, Solution.getResult("SSPPSSSPSSSPSSSS", "Human"));
        assertEquals(12, Solution.getResult("SSPPSSSPSSSPSSSS", "Swamper"));
        assertEquals(14, Solution.getResult("SSPPSSSPSSSPSSSS", "Woodman"));

        /*
        S P P S
        P S P S
        P S T S
        P S T S
        */
        assertEquals(14, Solution.getResult("SPPSPSPSPSTSPSTS", "Human"));
        assertEquals(12, Solution.getResult("SPPSPSPSPSTSPSTS", "Swamper"));
        assertEquals(13, Solution.getResult("SPPSPSPSPSTSPSTS", "Woodman"));

        long elapsedTimeMillis = System.currentTimeMillis() - start;
        System.out.println(elapsedTimeMillis / 1000F);

    }

    @Test
    public void testGetResultFictionTerms() throws GameSolverException {
        Params.setPathToTermsFile(Params.fictionTermsPath);
        /*
        U N R E
        A L U N
        R E A L
        U N R E
        -------
        1 3 4 2
        5 6 1 3
        4 2 5 6
        1 3 4 2
        */
        assertEquals(19, Solution.getResult("UNREALUNREALUNRE", "Someone"));
        assertEquals(6, Solution.getResult("UUUUUUUUUUUUUUUU", "Someone"));
        assertEquals(18, Solution.getResult("NNNNNNNNNNNNNNNN", "Someone"));
        assertEquals(12, Solution.getResult("EEEEEEEEEEEEEEEE", "Someone"));
    }
}