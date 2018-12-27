package classifier;

import classifier.pojo.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.Nullable;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import static org.apache.http.HttpStatus.SC_OK;

public interface ClassifierRequest {

    String BASE_URL = "http://tosamara.ru/api";
    String CLASSIFIERS_URL = BASE_URL + "/classifiers";
    String STOPS_URL = CLASSIFIERS_URL + "/stops.xml";
    String STOPS_FULL_URL = CLASSIFIERS_URL + "/stopsFullDB.xml";
    String ROUTES_URL = CLASSIFIERS_URL + "/routes.xml";
    String ROUTES_AND_STOPS_CORRESPONDENCE_URL = CLASSIFIERS_URL + "/routesAndStopsCorrespondence.xml";
    String GEOPORTAL_STOPS_CORRESPONDENCE_URL = CLASSIFIERS_URL + "/GeoportalStopsCorrespondence.xml";
    String GEOPORTAL_ROUTES_CORRESPONDENCE_URL = CLASSIFIERS_URL + "/GeoportalRoutesCorrespondence.xml";

    Logger LOGGER = Logger.getLogger(ClassifierRequest.class);

    @Nullable
    default <T> T doClassifierRequest(Class<T> classifierType, String url) {
        try {
            Response response = Request.Get(url)
                    .execute();
            Serializer serializer = new Persister();
            HttpResponse httpResponse = response.returnResponse();
            if (httpResponse.getStatusLine().getStatusCode() == SC_OK) {
                return serializer.read(classifierType, httpResponse.getEntity().getContent());
            } else {
                LOGGER.error("response code: " + httpResponse.getStatusLine().getStatusCode());
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Метод получения списка справочников.
     *
     * @return объект справочников.
     */
    Classifiers getClassifiers();

    /**
     * Метод получения списка остановок.
     *
     * @return список остановок.
     */
    Stops getStops();

    /**
     * Метод получения списка остановок с расширенной информацией.
     *
     * @return список остановок с расширенной информацией.
     */
    FullStops getFullStops();

    /**
     * Метод получения списка маршрутов.
     *
     * @return список маршрутов.
     */
    Routes getRoutes();

    /**
     * Метод получения списка связей маршрутов и остановок.
     *
     * @return список связей маршрутов и остановок.
     */
    RoutesWithStops getRoutesWithStops();

    /**
     * Метод получения остановок на карте {@see <a href="https://map.samadm.ru/transport/">Муниципального геопортала Самары</a>}
     *
     * @return список остановок на карте геопортала.
     */
    StopsOnMap getStopsOnMap();

    /**
     * Метод получения маршрутов на карте {@see <a href="https://map.samadm.ru/transport/">Муниципального геопортала Самары</a>}
     * Связывает маршруты со слоями и объектами на карте.
     * В каждом слое обыкновенно находятся два линейных объекта - прямое и обратное направление одного маршрута, и несколько объектов транспорта, которые движутся в реальном времени.
     *
     * @return список маршрутов на карте геопортала.
     */
    RoutesOnMap getRoutesOnMap();

}
