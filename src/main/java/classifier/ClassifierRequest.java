package classifier;

import classifier.pojo.*;
import exception.APIResponseException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;

public interface ClassifierRequest {

    String CLASSIFIERS_URL = "https://tosamara.ru/api/classifiers";
    String STOPS_URL = CLASSIFIERS_URL + "/stops.xml";
    String STOPS_FULL_URL = CLASSIFIERS_URL + "/stopsFullDB.xml";
    String ROUTES_URL = CLASSIFIERS_URL + "/routes.xml";
    String ROUTES_AND_STOPS_CORRESPONDENCE_URL = CLASSIFIERS_URL + "/routesAndStopsCorrespondence.xml";
    String GEOPORTAL_STOPS_CORRESPONDENCE_URL = CLASSIFIERS_URL + "/GeoportalStopsCorrespondence.xml";
    String GEOPORTAL_ROUTES_CORRESPONDENCE_URL = CLASSIFIERS_URL + "/GeoportalRoutesCorrespondence.xml";

    default <T> T doClassifierRequest(Class<T> classifierType, String url) throws Exception {
        Response response = Request.Get(url)
                .execute();
        Serializer serializer = new Persister(new AnnotationStrategy());
        HttpResponse httpResponse = response.returnResponse();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == SC_OK) {
            String content = IOUtils.toString(httpResponse.getEntity().getContent());
            if (serializer.validate(classifierType, content)) {
                return serializer.read(classifierType, content);
            } else {
                throw new Exception(String.format("content %s can't be deserialized", content));
            }
        } else {
            throw new APIResponseException(statusCode);
        }
    }

    /**
     * Метод получения списка справочников.
     *
     * @return список справочников.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    List<Classifier> getClassifiers() throws Exception;

    /**
     * Метод получения списка остановок.
     *
     * @return список остановок.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    List<Stop> getStops() throws Exception;

    /**
     * Метод получения списка остановок с расширенной информацией.
     *
     * @return список остановок с расширенной информацией.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    List<FullStop> getFullStops() throws Exception;

    /**
     * Метод получения списка маршрутов.
     *
     * @return список маршрутов.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    List<Route> getRoutes() throws Exception;

    /**
     * Метод получения списка связей маршрутов и остановок.
     *
     * @return список связей маршрутов и остановок.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    List<RouteWithStops> getRoutesWithStops() throws Exception;

    /**
     * Метод получения остановок на карте {@see <a href="https://map.samadm.ru/transport/">Муниципального геопортала Самары</a>}
     *
     * @return список остановок на карте геопортала.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    StopsOnMap getStopsOnMap() throws Exception;

    /**
     * Метод получения маршрутов на карте {@see <a href="https://map.samadm.ru/transport/">Муниципального геопортала Самары</a>}
     * Связывает маршруты со слоями и объектами на карте.
     * В каждом слое обыкновенно находятся два линейных объекта - прямое и обратное направление одного маршрута, и несколько объектов транспорта, которые движутся в реальном времени.
     *
     * @return список маршрутов на карте геопортала.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    List<RouteOnMap> getRoutesOnMap() throws Exception;

}
