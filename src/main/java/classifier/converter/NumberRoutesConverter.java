package classifier.converter;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberRoutesConverter implements Converter<List<String>> {

    @Override
    public List<String> read(InputNode node) throws Exception {
        String value = node.getValue();
        if (value != null) {
            return Stream.of(value.replaceAll("\\s", "")
                    .split(","))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public void write(OutputNode node, List<String> value) {
        if (value != null) {
            StringJoiner stringJoiner = new StringJoiner(", ");
            value.forEach(stringJoiner::add);
            node.setValue(stringJoiner.toString());
        }
    }

}
