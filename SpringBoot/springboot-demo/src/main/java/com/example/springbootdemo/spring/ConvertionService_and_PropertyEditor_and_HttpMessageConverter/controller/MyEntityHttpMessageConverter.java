package com.example.springbootdemo.spring.ConvertionService_and_PropertyEditor_and_HttpMessageConverter.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

//@Component
public class MyEntityHttpMessageConverter extends AbstractGenericHttpMessageConverter<MyEntity> {

    public MyEntityHttpMessageConverter() {
        super(new MediaType("text", "arnold"));
    }

    /**
     * support 要配个content type（MediaType）
     * 不如用canRead直接啊
     * @param clazz
     * @return
     */
    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz == MyEntity.class;
    }


//    @Override
//    public boolean canRead(Type type, Class<?> contextClass, MediaType mediaType) {
//        return type.getTypeName().equals(MyEntity.class.getTypeName());
//    }

    @Override
    public boolean canWrite(Type type, Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    protected void writeInternal(MyEntity myEntity, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println("MyEntityHttpMessageConverter:" + myEntity.toString());
        HttpHeaders headers = outputMessage.getHeaders();
        MediaType contentType = headers.getContentType();
        Charset charset = null;
        if (contentType != null) {
            charset = contentType.getCharset();
        }
        charset = charset == null ? Charset.forName("UTF-8") : charset;
        String string = "aaa" + myEntity.getName() + "out:" + myEntity.getAge();


        OutputStream body = outputMessage.getBody();
        StreamUtils.copy(string,charset,body);


    }

    @Override
    protected MyEntity readInternal(Class<? extends MyEntity> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        HttpHeaders headers = inputMessage.getHeaders();
        MediaType contentType = headers.getContentType();
        Charset charset = null;
        if (contentType != null) {
            charset = contentType.getCharset();
        }
        charset = charset == null ? Charset.forName("UTF-8") : charset;

        InputStream body = inputMessage.getBody();

        String string = StreamUtils.copyToString(body, charset);
        MyEntity myEntity = new MyEntity(string);
        myEntity.setAge(33);
        return myEntity;
    }

    @Override
    public MyEntity read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        return readInternal(null,inputMessage);
    }


//    @Override
//    protected boolean supports(Class<?> clazz) {
//        return true;
//    }
//
//    @Override
//    protected MyEntity readInternal(Class<? extends MyEntity> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
//        InputStream body = inputMessage.getBody();
//        Charset charset = getContentTypeCharset(inputMessage.getHeaders().getContentType());
//        String string = StreamUtils.copyToString(inputMessage.getBody(), charset);
//        MyEntity myEntity = new MyEntity(string);
//        myEntity.setAge(33);
//
//        return myEntity;
//    }
//
//    @Override
//    protected void writeInternal(MyEntity myEntity, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
//        HttpHeaders headers = outputMessage.getHeaders();
//        Charset charset = getContentTypeCharset(headers.getContentType());
//        StreamUtils.copy(myEntity.toString(), charset, outputMessage.getBody());
//    }
//
//    private Charset getContentTypeCharset(@Nullable MediaType contentType) {
//        if (contentType != null && contentType.getCharset() != null) {
//            return contentType.getCharset();
//        }
//        else {
//            Charset charset = getDefaultCharset();
//            Assert.state(charset != null, "No default charset");
//            return charset;
//        }
//    }
}
