package org.ksahli.bank.account;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

@Data
public class History {

    final private List<Entry> entries = new LinkedList<>();

    public void append(Entry entry) {
        entries.add(entry);
    }

    public void print(Consumer<String> printer) {
        this.entries.forEach(entry -> entry.print(printer));
    }

}
