import algorithm.RoutesMatrix;
import algorithm.pojo.Transport;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

class MatrixTest {

    @Test
    void test() {
        Transport[][] transports = RoutesMatrix.getMatrix();
        for (int i = 0; i < transports.length; i++) {
            for (int j = i; j < transports[i].length; j++) {
                if (transports[i][j] != null) {
                    System.out.println("От " + (i + 1) + " до " + (j + 1));
                    transports[i][j].getRoutes().stream()
                            .filter(route -> !route.getNumbers().isEmpty())
                            .forEach(route -> {
                                StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
                                route.getNumbers().forEach(stringJoiner::add);
                                System.out.println(route.getTransportType() + ": " + stringJoiner);
                            });
                    System.out.println();
                }
            }
        }
    }

}
