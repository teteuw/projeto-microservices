package br.com.teteu.api.gateway;

public class Greeting {
    private final Long id;
    private final String content;
    public Long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }
    
}
