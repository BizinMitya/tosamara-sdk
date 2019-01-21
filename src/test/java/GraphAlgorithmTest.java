import algorithm.GraphAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class GraphAlgorithmTest {

    @Test
    void test() {
        try {
            List<Integer> from = Arrays.asList(193, 194, 656, 737);
            List<Integer> to = Arrays.asList(254, 510, 1304, 1353);
            GraphAlgorithm.getAllRoutesBetweenTwoPoints(from, to).forEach(routeWithStops -> System.out.println(routeWithStops.number));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
