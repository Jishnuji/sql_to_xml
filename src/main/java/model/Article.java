package model;

public class Article {
    private long id;
    private String name;
    private long code;
    private String userName;
    private String guid;

    public Article(long id, String name, long code, String userName, String guid) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.userName = userName;
        this.guid = guid;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public long getCode() {
        return code;
    }

    public String getUserName() {
        return userName;
    }

    public String getGuid() {
        return guid;
    }
}
