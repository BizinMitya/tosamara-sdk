package api.record.response;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "classifiers")
public class Classifiers {

    @ElementList(entry = "file", inline = true)
    private List<Classifier> files;

    public Classifiers() {
    }

    public List<Classifier> getFiles() {
        return files;
    }

    public void setFiles(List<Classifier> files) {
        this.files = files;
    }

}
