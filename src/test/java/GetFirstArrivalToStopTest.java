import api.APIRequest;
import api.APIRequestImpl;
import api.record.response.GetFirstArrivalToStopResponse;
import api.record.pojo.Stop;
import api.record.pojo.Stops;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetFirstArrivalToStopTest {

    private static final APIRequest API_REQUEST = new APIRequestImpl();

    @Test
    void forAllStopsTest() {
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

}
