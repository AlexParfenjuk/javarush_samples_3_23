package com.javarush.test.level18.lesson08.task02;

import java.io.IOException;
import java.io.OutputStream;

public interface AmigoOutputStream{
    public void flush() throws IOException;

    void write(int b) throws IOException;

    void write(byte[] b) throws IOException;

    void write(byte[] b, int off, int len) throws IOException;

    void close() throws IOException;
}
