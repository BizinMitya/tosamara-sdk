package com.useful_solutions.tosamara_sdk;

import com.useful_solutions.tosamara_sdk.api.APIRequest;
import com.useful_solutions.tosamara_sdk.api.APIRequestImpl;
import com.useful_solutions.tosamara_sdk.api.record.response.GetFirstArrivalToStopResponse;
import com.useful_solutions.tosamara_sdk.classifier.ClassifierRequest;
import com.useful_solutions.tosamara_sdk.classifier.ClassifierRequestImpl;
import com.useful_solutions.tosamara_sdk.classifier.pojo.Stop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GetFirstArrivalToStopTest {

    private static final APIRequest API_REQUEST = new APIRequestImpl();
    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();

    @Test
    void forAllStopsTest() {
        try {
            List<Stop> stops = CLASSIFIER_REQUEST.getStops();
            for (Stop stop : stops) {
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
