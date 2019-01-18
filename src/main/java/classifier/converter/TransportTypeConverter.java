package classifier.converter;

import api.record.pojo.TransportType;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class TransportTypeConverter implements Converter<TransportType> {

    @Override
    public TransportType read(InputNode node) throws Exception {
        String value = node.getValue();
        return TransportType.convert(value);
    }

    @Override
    public void write(OutputNode node, TransportType value) {

    }

}
