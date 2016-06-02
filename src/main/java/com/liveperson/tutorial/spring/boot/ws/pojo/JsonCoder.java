package com.liveperson.tutorial.spring.boot.ws.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.*;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author elyran
 * @since 6/1/16.
 */
public abstract class JsonCoder<T> implements Encoder.TextStream<T>, Decoder.TextStream<T>{


    private Class<T> classType;
    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void init(EndpointConfig endpointConfig) {

        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type type = parameterizedType.getActualTypeArguments()[0];
        if (type instanceof Class) {
            classType = (Class<T>)type;
        }
        else if (type instanceof ParameterizedType) {
            classType = (Class<T>)((ParameterizedType)type).getRawType();
        }
    }

    @Override
    public void encode(T object, Writer writer) throws EncodeException, IOException {
        objectMapper.writeValue(writer, object);
    }

    @Override
    public T decode(Reader reader) throws DecodeException, IOException {
        return objectMapper.readValue(reader, classType);
    }

    @Override
    public void destroy() {

    }

}
