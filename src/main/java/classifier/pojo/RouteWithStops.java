package classifier.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "route")
public class RouteWithStops {

    /**
     * Классификаторный номер маршрута.
     */
    @Element(name = "KR_ID")
    public Integer krId;

    /**
     * Номер маршрута, тот, что пишется на табличках.
     */
    @Element(name = "number")
    public String number;

    /**
     * Направление движения, обычно — конечная остановка.
     */
    @Element(name = "direction")
    public String direction;

    @Element(name = "transportType")
    public TransportType transportType;

    /**
     * Признак выполняемости маршрута в настоящее время, 1 — да, 0 — нет.
     */
    @Element(name = "performing")
    public Integer performing;

    /**
     * Признак того, что маршрут прогнозируется по мониторингу в реальном времени.
     */
    @Element(name = "realtimeForecast")
    public Integer realtimeForecast;

    /**
     * Геометрическая форма маршрута, ломаной линии, заданной последовательностью точек в формате «долгота,широта долгота,широта ...» в системе координат WGS 84.
     */
    @Element(name = "geometry")
    public String geometry;

    @ElementList(entry = "stop", inline = true)
    public List<Stop> stops;

    static public class TransportType {

        /**
         * Числовой код вида транспорта:
         * 1 — автобус,
         * 2 — метрополитен,
         * 3 — трамвай,
         * 4 — троллейбус,
         * 5 - электропоезд,
         * 6 - речной транспорт
         */
        @Element(name = "id")
        public Integer id;

        /**
         * Вид транспорта: автобус, трамвай, троллейбус, метрополитен, электропоезд, речной транспорт.
         */
        @Element(name = "title")
        public String title;

    }

    static public class Stop {

        /**
         * Классификаторный номер остановки.
         */
        @Element(name = "KS_ID")
        public Integer ksId;

        /**
         * Собственное название.
         */
        @Element(name = "title")
        public String title;

        /**
         * Улица, на которой расположена остановка.
         */
        @Element(name = "adjacentStreet")
        public String adjacentStreet;

        /**
         * Преимущественное направление движения.
         */
        @Element(name = "direction", required = false)
        public String direction;

        /**
         * Плановое время прибытия на остановку от начала выполнения рейса, часто - не заполнено.
         */
        @Element(name = "scheduleTime")
        public Integer scheduleTime;

    }

}
