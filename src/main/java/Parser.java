import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import errorcode.GameSolverErrorCode;
import exception.GameSolverException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Parser {

    public static Map<String, Terms> readTerms(final String pathToTerms) throws GameSolverException {
        File file = new File(pathToTerms);
        if (!file.exists() || file.isHidden() || file.isDirectory() || !file.canRead())
            throw new GameSolverException(GameSolverErrorCode.INCORRECT_FILE);

        Map<String, Terms> entityTerms = new HashMap<>();
        try (JsonReader reader = new JsonReader(new FileReader(file))) {
            Gson gson = new GsonBuilder().create();
            reader.beginArray();

            Terms term;
            while (reader.hasNext()) {
                term = gson.fromJson(reader, Terms.class);

                if (!Terms.isValid(term))
                    throw new GameSolverException(GameSolverErrorCode.TERMS_WRONG_PARAMETERS);

                entityTerms.put(term.getEntityName(), term);
            }

            if (entityTerms.isEmpty())
                throw new GameSolverException(GameSolverErrorCode.NO_TERMS_FOUND);

            return entityTerms;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
