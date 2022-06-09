import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
public class Terms {
    private String entityName;
    private Map<Character, Integer> cellCost;// Препятствие, стоимость перемещения

    public static boolean isValid(final Terms terms) {
        return !Params.isBlank(terms.getEntityName()) && terms.getCellCost().values().stream().noneMatch(num -> (num < 0 || num == Integer.MAX_VALUE));
    }

}
