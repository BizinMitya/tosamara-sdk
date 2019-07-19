package com.github.useful_solutions.tosamara_sdk.classifier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClassifierRequestTest {

    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();

    @Test
    void getClassifiersTest() {
        try {
            ClassifierAssert.assertClassifiers(CLASSIFIER_REQUEST.getClassifiers());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getAllClassifiersTest() {
        try {
            ClassifierAssert.assertAllClassifiers(CLASSIFIER_REQUEST.getAllClassifiers());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getStopsTest() {
        try {
            ClassifierAssert.assertStops(CLASSIFIER_REQUEST.getStops());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getFullStopsTest() {
        try {
            ClassifierAssert.assertFullStops(CLASSIFIER_REQUEST.getFullStops());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRoutesTest() {
        try {
            ClassifierAssert.assertRoutes(CLASSIFIER_REQUEST.getRoutes());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRoutesWithStopsTest() {
        try {
            ClassifierAssert.assertRoutesWithStops(CLASSIFIER_REQUEST.getRoutesWithStops());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getStopsOnMapTest() {
        try {
            ClassifierAssert.assertStopsOnMap(CLASSIFIER_REQUEST.getStopsOnMap());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRoutesOnMapTest() {
        try {
            ClassifierAssert.assertRoutesOnMap(CLASSIFIER_REQUEST.getRoutesOnMap());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
