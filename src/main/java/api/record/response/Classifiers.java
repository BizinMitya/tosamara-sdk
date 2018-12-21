package api.record.response;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "classifiers")
public class Classifiers {

    @ElementList(entry = "file", inline = true)
    public List<Classifier> files;

}
