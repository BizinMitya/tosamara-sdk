package algorithm.pojo;

import java.util.List;

public class Transport {

    private List<Route> routes;

    public Transport(List<Route> routes) {
        this.routes = routes;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

}
