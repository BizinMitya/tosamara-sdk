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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < value.size(); i++) {
            if (i == value.size() - 1) {
                stringBuilder.append(value.get(i));
            } else {
                stringBuilder.append(value.get(i)).append(", ");
            }
        }
        return stringBuilder.toString();
    }

}
