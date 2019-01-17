package classifier.transformer;

import api.record.pojo.GeoPoint;
import org.simpleframework.xml.transform.Transform;

public class StringToGeoPointArrayTransform implements Transform<GeoPoint[]> {

    @Override
    public GeoPoint[] read(String value) {
        String[] stringPoints = value.split(" ");
        GeoPoint[] points = new GeoPoint[stringPoints.length];
        for (int i = 0; i < points.length; i++) {
            String[] coords = stringPoints[i].split(",");
            Double latitude = Double.parseDouble(coords[0]);
            Double longitude = Double.parseDouble(coords[1]);
            points[i] = new GeoPoint(latitude, longitude);
        }
        return points;
    }

    @Override
    public String write(GeoPoint[] value) {
        return null;
    }

}
