import classifier.ClassifierRequest;
import classifier.ClassifierRequestImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClassifiersTest {

    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();

    @Test
    void allClassifiersTest() {
        getClassifiersTest();
        getStopsTest();
        getFullStopsTest();
        getRoutesTest();
        getRoutesWithStopsTest();
        getStopsOnMapTest();
        getRoutesOnMapTest();
    }

    @Test
    void getClassifiersTest() {
        try {
            CLASSIFIER_REQUEST.getClassifiers();
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getStopsTest() {
        try {
            CLASSIFIER_REQUEST.getStops();
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getFullStopsTest() {
        try {
            CLASSIFIER_REQUEST.getFullStops();
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRoutesTest() {
        try {
            CLASSIFIER_REQUEST.getRoutes();
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRoutesWithStopsTest() {
        try {
            CLASSIFIER_REQUEST.getRoutesWithStops();
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getStopsOnMapTest() {
        try {
            CLASSIFIER_REQUEST.getStopsOnMap();
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRoutesOnMapTest() {
        try {
            CLASSIFIER_REQUEST.getRoutesOnMap();
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
