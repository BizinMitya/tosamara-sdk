package classifier.transformer;

import org.simpleframework.xml.transform.Transform;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringToArrayTransform implements Transform<List<String>> {

    @Override
    public List<String> read(String value) {
        value = value.replaceAll("\\s", "");
        return Stream.of(value.split(","))
                .collect(Collectors.toList());
    }

    @Override
    public String write(List<String> value) {
        return null;
    }

}
