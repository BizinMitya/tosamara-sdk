package classifier.transformer;

import api.record.pojo.GeoPoint;
import org.simpleframework.xml.transform.Transform;

import java.util.ArrayList;
import java.util.List;

public class StringToGeoPointArrayTransform implements Transform<List<GeoPoint>> {

    @Override
    public List<GeoPoint> read(String value) {
        String[] stringPoints = value.split(" ");
        List<GeoPoint> points = new ArrayList<>(stringPoints.length);
        for (int i = 0; i < stringPoints.length; i++) {
            String[] coords = stringPoints[i].split(",");
            Double latitude = Double.parseDouble(coords[0]);
            Double longitude = Double.parseDouble(coords[1]);
            points.add(new GeoPoint(latitude, longitude));
        }
        return points;
    }

    @Override
    public String write(List<GeoPoint> value) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < value.size(); i++) {
            if (i == value.size() - 1) {
                stringBuilder.append(value.get(i).latitude).append(",").append(value.get(i).longitude).append(" ");
            } else {
                stringBuilder.append(value.get(i).latitude).append(",").append(value.get(i).longitude);
            }
        }
        return stringBuilder.toString();
    }

}
