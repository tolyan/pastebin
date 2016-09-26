/**
 * Copyright © Anatoly Rybalchenko, 2016
 * a.rybalchenko@gmail.com
 */
package ru.anglerhood.pastebin;

import java.util.List;
import java.util.Optional;

public class EntriesPage {
    private Optional<String> pagingState;
    private List<Optional<Entry>>entries;

    public EntriesPage(Optional<String> pagingState, List<Optional<Entry>> entries){
        this.pagingState = pagingState;
        this.entries = entries;
    }

    public Optional<String> getPagingState() {
        return pagingState;
    }

    public void setPagingState(String pagingState) {
        this.pagingState = Optional.ofNullable(pagingState);
    }

    public List<Optional<Entry>> getEntries() {
        return entries;
    }

    public void setEntries(List<Optional<Entry>> entries) {
        this.entries = entries;
    }
}
