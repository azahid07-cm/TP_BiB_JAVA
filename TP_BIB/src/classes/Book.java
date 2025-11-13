package src.classes;
import java.util.Objects;

import src.Objets_valeur.Isbn;

public class Book {
    private final Isbn isbn;
    private final String title;
    private final String author;
    private final int publicationYear;

    public Book(Isbn isbn, String title, String author, int publicationYear) {
        Objects.requireNonNull(isbn, "L'ISBN est obligatoire");
        Objects.requireNonNull(title, "Le titre est obligatoire");
        Objects.requireNonNull(author, "L'auteur est obligatoire");

        if (title.isBlank()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide");
        }
        if (author.isBlank()) {
            throw new IllegalArgumentException("L'auteur ne peut pas être vide");
        }
        if (publicationYear <= 0) {
            throw new IllegalArgumentException("L'année de publication doit être positive");
        }

        this.isbn = isbn;
        this.title = title.trim();
        this.author = author.trim();
        this.publicationYear = publicationYear;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (!(obj instanceof Book other)) 
            return false;
        return isbn.equals(other.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title=" + title +
                ", author=" + author +
                ", publicationYear=" + publicationYear +'}';
    }
}
