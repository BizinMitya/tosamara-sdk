import api.APIRequest;
import api.APIRequestImpl;
import api.record.response.GetFirstArrivalToStopResponse;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> ksIds = new ArrayList<>();
        ksIds.add(13);

        APIRequest apiRequest = new APIRequestImpl();
        GetFirstArrivalToStopResponse getFirstArrivalToStopResponse = apiRequest.getFirstArrivalToStop(ksIds, 5);
        System.out.println(getFirstArrivalToStopResponse);
    }

}
