package com.github.useful_solutions.tosamara_sdk.classifier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClassifierRequestTest {

    @Test
    void getClassifiersTest() {
        try {
            ClassifierAssert.assertClassifiers(Classifiers.getClassifiers());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getAllClassifiersTest() {
        try {
            ClassifierAssert.assertAllClassifiers(Classifiers.getAllClassifiers());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getStopsTest() {
        try {
            ClassifierAssert.assertStops(Classifiers.getStops());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getFullStopsTest() {
        try {
            ClassifierAssert.assertFullStops(Classifiers.getFullStops());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRoutesTest() {
        try {
            ClassifierAssert.assertRoutes(Classifiers.getRoutes());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRoutesWithStopsTest() {
        try {
            ClassifierAssert.assertRoutesWithStops(Classifiers.getRoutesWithStops());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getStopsOnMapTest() {
        try {
            ClassifierAssert.assertStopsOnMap(Classifiers.getStopsOnMap());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRoutesOnMapTest() {
        try {
            ClassifierAssert.assertRoutesOnMap(Classifiers.getRoutesOnMap());
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
