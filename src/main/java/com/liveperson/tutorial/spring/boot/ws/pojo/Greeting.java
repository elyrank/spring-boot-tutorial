package com.liveperson.tutorial.spring.boot.ws.pojo;

/**
 * @author elyran
 * @since 5/31/16.
 */
public class Greeting {

    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public static class Coder extends JsonCoder<Greeting> {}

}
