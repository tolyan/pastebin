/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin.bean;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;


public class Entry {
    private Boolean isPrivate;
    private Date createdAt;
    private Date modifiedAt;
    private String title;
    private String body;
    private Date expires;
    private String secret;
    private UUID uuid;

    public Entry(){}

    public Entry(UUID uuid,
                 Date createdAt,
                 Date modifiedAt,
                 String title,
                 String body,
                 Date expires,
                 String secret,
                 Boolean isPrivate) {
        this.uuid = uuid;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.title = title;
        this.body = body;
        this.expires = expires;
        this.secret = secret;
        this.isPrivate = isPrivate;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public int hashCode(){
        return  Objects.hash(createdAt, title, body, expires, secret, isPrivate);
    }


    @Override
    public boolean equals (Object obj){
        if (obj == this) return true;

        if (obj == null || obj.getClass() != this.getClass()) return false;

        Entry entry = (Entry) obj;
        return  Objects.equals(title, entry.getTitle()) &&
                Objects.equals(body, entry.getBody()) &&
                Objects.equals(expires, entry.getExpires()) &&
                Objects.equals(secret, entry.getSecret()) &&
                Objects.equals(isPrivate, entry.getPrivate());
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("title: ").append(this.title)
                .append(", body: ").append(this.body)
                .append(", expires: ").append(this.expires)
                .append(", secret: ").append(this.secret)
                .append(", private: ").append(this.isPrivate);
        return builder.toString();
    }


}
