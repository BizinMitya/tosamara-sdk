import api.APIRequest;
import api.APIRequestImpl;
import api.record.pojo.Stop;
import api.record.pojo.Stops;
import api.record.response.GetFirstArrivalToStopResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetFirstArrivalToStopTest {

    private static final APIRequest API_REQUEST = new APIRequestImpl();

    @Test
    void forAllStopsTest() {
        Stops stops = API_REQUEST.getStops();
        for (Stop stop : stops.stops) {
            try {
                GetFirstArrivalToStopResponse getFirstArrivalToStopResponse = API_REQUEST.getFirstArrivalToStop(stop.ksId, Integer.MAX_VALUE);
                if (!getFirstArrivalToStopResponse.transports.isEmpty()) {
                    getFirstArrivalToStopResponse.transports.forEach(transport ->
                            System.out.println(
                                    "Остановка: " + stop.title + ", " +
                                            transport.number +
                                            "(" + transport.stateNumber + ")" + " -> " +
                                            transport.nextStopName +
                                            ", через " + transport.timeInSeconds + " сек."
                            )
                    );
                }
            } catch (Throwable t) {
                Assertions.fail(t);
            }
        }
    }

}
