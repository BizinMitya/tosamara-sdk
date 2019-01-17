package classifier.transformer;

import org.simpleframework.xml.transform.Transform;

public class StringToArrayTransform implements Transform<String[]> {

    @Override
    public String[] read(String value) {
        value = value.replaceAll("\\s", "");
        return value.split(",");
    }

    @Override
    public String write(String[] value) {
        return null;
    }

}
