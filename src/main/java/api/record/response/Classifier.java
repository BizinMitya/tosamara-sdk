package api.record.response;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "file")
public class Classifier {

    @Attribute
    private String name;

    @Element
    private Double modified;

    public Classifier() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getModified() {
        return modified;
    }

    public void setModified(Double modified) {
        this.modified = modified;
    }

}
