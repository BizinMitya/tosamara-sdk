import algorithm.GraphAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GraphAlgorithmTest {

    @Test
    void test() {
        try {
            Integer from = 656;
            Integer to = 512;
            GraphAlgorithm.getAllRoutesBetweenTwoPoints(from, to)
                    .forEach(routeWithStops -> {
                        routeWithStops.forEach(route -> System.out.print(route.number + " "));
                        System.out.println();
                    });
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
