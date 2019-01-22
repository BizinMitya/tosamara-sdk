package classifier.converter;

import classifier.pojo.Affiliation;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class AffiliationConverter implements Converter<Affiliation> {

    @Override
    public Affiliation read(InputNode node) throws Exception {
        String value = node.getValue();
        return Affiliation.convert(value);
    }

    @Override
    public void write(OutputNode node, Affiliation value) {
        node.setValue(Affiliation.convert(value));
    }

}
