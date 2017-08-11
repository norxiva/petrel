package my.norxiva.petrel.util;

import java.util.UUID;

import static my.norxiva.petrel.util.StringUtils.DASH;
import static my.norxiva.petrel.util.StringUtils.EMPTY;

public class IdUtils {

    public static String uuidWithNoDash() {
        return UUID.randomUUID().toString().replaceAll(DASH, EMPTY);
    }

    public static String uuid(){
        return UUID.randomUUID().toString();
    }

}
