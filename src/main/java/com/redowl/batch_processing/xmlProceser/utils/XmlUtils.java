package com.redowl.batch_processing.xmlProceser.utils;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

public class XmlUtils {

    // Static utility method to create JAXBElement
    public static JAXBElement<String> createJAXBElement(String name, String value) {
        return new JAXBElement<>(new QName(name), String.class, value);
    }

    // Static utility method to create XMLGregorianCalendar
    public static XMLGregorianCalendar createXMLGregorianCalendar(String dateString) {
        // Ensure the date string includes seconds
        if (dateString != null && dateString.endsWith("T00:00")) {
            dateString = dateString + ":00";
        }

        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(dateString);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T, U> void setIfNotNull(T target, U value, BiConsumer<T, U> setter) {
        if (value != null) {
            setter.accept(target, value);
        }
    }

    // Overloaded method to handle primitive types with their wrapper classes
    public static <T> void setIfNotNull(T target, int value, IntConsumer setter) {
        if (value != 0) { // Assuming 0 as a non-valid value
            setter.accept(value);
        }
    }

    public static <T> void setIfNotNull(T target, double value, DoubleConsumer setter) {
        if (value != 0.0) { // Assuming 0.0 as a non-valid value
            setter.accept(value);
        }
    }

    public static <T> void setIfNotDefault(T target, int value, int defaultValue, BiConsumer<T, Integer> setter) {
        if (value != defaultValue) {
            setter.accept(target, value);
        }
    }

    public static LocalDate convertDateToLocalDate(Date date) {

        LocalDate localDate = Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return localDate;
    }

}