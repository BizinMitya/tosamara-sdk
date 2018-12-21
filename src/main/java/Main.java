import api.APIRequest;
import api.APIRequestImpl;
import api.entities.Action;
import api.record.Criterion;
import api.record.request.GeoPoint;
import api.record.response.FindShortestPathResponse;
import api.record.response.GetFirstArrivalToStopResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static api.record.TransportType.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> ksIds = new ArrayList<>();
        ksIds.add(13);

        APIRequest apiRequest = new APIRequestImpl();
        GetFirstArrivalToStopResponse getFirstArrivalToStopResponse = apiRequest.getFirstArrivalToStop(ksIds, 5);

        // findShortestPath test
        GeoPoint firstPoint = new GeoPoint(53.2031789523201, 50.1480975970282);
        GeoPoint secondPoint = new GeoPoint(53.2564253474421, 50.2189579250588);
        FindShortestPathResponse shortestPath = apiRequest.findShortestPath(firstPoint, secondPoint, Criterion.time, bus, tram);
        for (Action action : shortestPath.actions) {
            System.out.println(action);
        }
    }

}
