/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin.bean;

import java.util.List;
import java.util.Optional;

/**
 * Convenience class for entries page handling
 */
public class EntriesPage {
    private Optional<String> pagingString;
    private List<Optional<Entry>>entries;

    public EntriesPage(Optional<String> pagingState, List<Optional<Entry>> entries){
        this.pagingString = pagingState;
        this.entries = entries;
    }

    public Optional<String> getPagingString() {
        return pagingString;
    }

    public void setPagingString(String pagingString) {
        this.pagingString = Optional.ofNullable(pagingString);
    }

    public List<Optional<Entry>> getEntries() {
        return entries;
    }

    public void setEntries(List<Optional<Entry>> entries) {
        this.entries = entries;
    }


}
