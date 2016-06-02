package com.liveperson.tutorial.spring.boot.ws.pojo;

/**
 * @author elyran
 * @since 5/31/16.
 */
public class HelloMessage {
    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static class Coder extends JsonCoder<HelloMessage> {}

    @Override
    public String toString() {
        return "HelloMessage{" +
                "name='" + name + '\'' +
                '}';
    }
}
