package com.aca.imbd.repository;

import java.io.*;
import java.io.Serializable;

public class Repository<K, V extends Serializable> {
    private File file;

    public Repository(String filePath) {
        try {
            file = new File(filePath);
            file.createNewFile();
        } catch (IOException ex) {
        }
    }

    public void put(K key, V object) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(key.toString() + " " + Serilizator.serialize(object));
            writer.newLine();
            writer.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public V get(K id) throws IOException {
        String line = "";
        V object = null;
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                if ((line.split(" ")[0].equals(id.toString()))) {
                    String obj = line.split(" ")[1];
                    try {
                        object = (V) Serilizator.deserialize(obj);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

}




