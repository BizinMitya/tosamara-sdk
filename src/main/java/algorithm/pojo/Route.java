package algorithm.pojo;

import java.util.List;

public class Route {

    private List<String> numbers;
    private TransportType transportType;

    public Route(List<String> numbers, TransportType transportType) {
        this.numbers = numbers;
        this.transportType = transportType;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

}
