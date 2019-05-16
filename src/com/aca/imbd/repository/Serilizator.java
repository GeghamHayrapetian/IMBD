package com.aca.imbd.repository;

import java.io.*;
import java.util.Base64;

public class Serilizator {

    public static Object deserialize(String string) throws IOException,
            ClassNotFoundException {
        byte[] objectData = Base64.getDecoder().decode(string);
        ObjectInputStream objectInStream = new ObjectInputStream(new ByteArrayInputStream(objectData));
        Object object = objectInStream.readObject();
        objectInStream.close();
        return object;
    }

    public static String serialize(Serializable object) throws IOException {
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutStream = new ObjectOutputStream(byteOutStream);
        objectOutStream.writeObject(object);
        objectOutStream.close();
        return Base64.getEncoder().encodeToString(byteOutStream.toByteArray());
    }

}
