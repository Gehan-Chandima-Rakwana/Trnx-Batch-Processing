package com.redowl.batch_processing.xmlProceser.utils;


import com.redowl.batch_processing.xmlProceser.enums.GNCB1;
import com.redowl.batch_processing.xmlProceser.enums.TagEnum;

public class EnumTagVerifier {
    public static boolean isTagValid(String enumTagName, String scenario) {
        switch (scenario) {
            case "GNCB1":
                TagEnum enumValueS1 = getEnumValue(enumTagName, GNCB1.class);
                return enumValueS1.isRepeatable();
            default:
                return false;
        }
    }

    public static <T extends Enum<T> & TagEnum> T getEnumValue(String enumConstant, Class<T> enumClass) {
        return Enum.valueOf(enumClass, enumConstant);
    }

}


