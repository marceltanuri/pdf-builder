package com.mtanuri.pdfbuilder.model;

import java.util.Arrays;
import java.util.List;

public class DemoDTO {
    private final String author = "Fernando Pessoa";
    private final List<String> titles = Arrays.asList("Mensagem", "Ficções de interlúdio", "Livro do desassossego");

    public String getAuthor() {
        return author;
    }

    public List<String> getTitles() {
        return titles;
    }
}
