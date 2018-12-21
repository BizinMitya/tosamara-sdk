import api.APIRequest;
import api.APIRequestImpl;
import api.record.request.GeoPoint;
import api.record.response.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static api.record.Criterion.time;
import static api.record.TransportType.*;

class SmokeTest {

    private static final APIRequest API_REQUEST = new APIRequestImpl();

    @Test
    void smokeTest1() {
        Stops stops = API_REQUEST.getStops();
        for (Stop stop : stops.stops) {
            try {
                GetFirstArrivalToStopResponse getFirstArrivalToStopResponse = API_REQUEST.getFirstArrivalToStop(stop.ksId, 1);
                if (!getFirstArrivalToStopResponse.transports.isEmpty()) {
                    System.out.println(
                            "Остановка: " + stop.title + ", " +
                                    getFirstArrivalToStopResponse.transports.get(0).number +
                                    "(" + getFirstArrivalToStopResponse.transports.get(0).stateNumber + ")" + " -> " +
                                    getFirstArrivalToStopResponse.transports.get(0).nextStopName +
                                    ", через " + getFirstArrivalToStopResponse.transports.get(0).timeInSeconds + " сек."
                    );
                }
            } catch (Throwable t) {
                Assertions.fail(t);
            }
        }
    }

    @Test
    void smokeTest2() {
        Random random = new Random();
        FullStops fullStops = API_REQUEST.getFullStops();
        FullStop firstStop = fullStops.stops.get(random.nextInt(fullStops.stops.size()));
        FullStop secondStop = fullStops.stops.get(random.nextInt(fullStops.stops.size()));
        GeoPoint firstPoint = new GeoPoint(firstStop.latitude, firstStop.longitude);
        GeoPoint secondPoint = new GeoPoint(secondStop.latitude, secondStop.longitude);
        try {
            FindShortestPathResponse shortestPath =
                    API_REQUEST.findShortestPath(firstPoint, secondPoint, time,
                            bus, tram, trolleybus, metro, riverfleet, railway);
            for (Action action : shortestPath.actions) {
                System.out.println(action);
            }
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

}
