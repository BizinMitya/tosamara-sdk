package algorithm.pojo;

/**
 * Узел в цепочке маршрута: остановка или поездка не транспорте
 */
public class Node {

    private Integer id;
    private Type type;

    public Node(Integer id, Type type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public enum Type {

        stop,
        route

    }

}
