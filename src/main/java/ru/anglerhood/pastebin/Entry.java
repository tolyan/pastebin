/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Entry {
    private Boolean isPrivate;
    private final Date createdAt;
    private final Date modifiedAt;
    private String title;
    private String body;
    private Date expires;
    private String secret;
    private UUID uuid;

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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
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

    public Boolean isPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
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
        return Objects.equals(createdAt, entry.getCreatedAt()) &&
                Objects.equals(title, entry.getTitle()) &&
                Objects.equals(body, entry.getBody()) &&
                Objects.equals(expires, entry.getExpires()) &&
                Objects.equals(secret, entry.getSecret()) &&
                Objects.equals(isPrivate, entry.isPrivate());
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