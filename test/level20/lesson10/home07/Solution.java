package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {
    static final long serialVersionUID = 2L;

    transient private FileOutputStream stream;
    private String fileName;

    public static void main(String args[]) throws Exception {

        Solution solution = new Solution("C:\\new.txt");
        solution.writeObject("Hi");
        solution.close();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\new1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(solution);

        objectOutputStream.flush();
        objectOutputStream.close();


        FileInputStream fileInputStream = new FileInputStream("C:\\new1.txt");
        ObjectInputStream  objectInputStream= new ObjectInputStream(fileInputStream);
        Solution loadedObject = (Solution) objectInputStream.readObject();
        objectInputStream.close();
        loadedObject.writeObject("Hi2");

    }

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(fileName);
        out.flush();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        fileName = (String)in.readObject();
        stream = new FileOutputStream(fileName,true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
