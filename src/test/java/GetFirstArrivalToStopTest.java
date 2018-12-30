import api.APIRequest;
import api.APIRequestImpl;
import api.record.response.GetFirstArrivalToStopResponse;
import classifier.ClassifierRequest;
import classifier.ClassifierRequestImpl;
import classifier.pojo.Stop;
import classifier.pojo.Stops;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetFirstArrivalToStopTest {

    private static final APIRequest API_REQUEST = new APIRequestImpl();
    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();

    @Test
    void forAllStopsTest() {
        try {
            Stops stops = CLASSIFIER_REQUEST.getStops();
            for (Stop stop : stops.stops) {
                GetFirstArrivalToStopResponse getFirstArrivalToStopResponse = API_REQUEST.getFirstArrivalToStop(stop.ksId, Integer.MAX_VALUE);
                if (!getFirstArrivalToStopResponse.arrivalTransports.isEmpty()) {
                    getFirstArrivalToStopResponse.arrivalTransports.forEach(transport ->
                            System.out.println(
                                    "Остановка: " + stop.title + ", " +
                                            transport.number +
                                            "(" + transport.stateNumber + ")" + " -> " +
                                            transport.nextStopName +
                                            ", через " + transport.timeInSeconds + " сек."
                            )
                    );
                }
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
