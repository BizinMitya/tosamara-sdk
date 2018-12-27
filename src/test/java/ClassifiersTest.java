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
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getStopsTest() {
        try {
            CLASSIFIER_REQUEST.getStops();
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getFullStopsTest() {
        try {
            CLASSIFIER_REQUEST.getFullStops();
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getRoutesTest() {
        try {
            CLASSIFIER_REQUEST.getRoutes();
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getRoutesWithStopsTest() {
        try {
            CLASSIFIER_REQUEST.getRoutesWithStops();
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getStopsOnMapTest() {
        try {
            CLASSIFIER_REQUEST.getStopsOnMap();
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getRoutesOnMapTest() {
        try {
            CLASSIFIER_REQUEST.getRoutesOnMap();
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

}
