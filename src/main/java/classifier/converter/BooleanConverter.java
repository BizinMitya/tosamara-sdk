package classifier.converter;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class BooleanConverter implements Converter<Boolean> {

    @Override
    public Boolean read(InputNode node) throws Exception {
        String value = node.getValue();
        return value.equals("1");
    }

    @Override
    public void write(OutputNode node, Boolean value) {
        node.setValue(value ? "1" : "0");
    }

}
