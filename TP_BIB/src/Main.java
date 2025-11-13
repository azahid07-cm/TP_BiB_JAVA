package src;
import src.Objets_valeur.Isbn;
import src.Objets_valeur.Email;
import src.classes.Book;
import src.classes.Member;
import src.classes.Loan;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Isbn isbn1 = new Isbn("9781234567897");
        Isbn isbn2 = new Isbn("9789876543210");
        System.out.println("ISBN equals: " + isbn1.equals(isbn2));
        System.out.println("ISBN hashCode: " + isbn1.hashCode() + " == " + isbn2.hashCode());
        System.out.println("ISBN toString: " + isbn1);

        Email email1 = new Email("test@example.com");
        Email email2 = new Email("test@example.com");
        System.out.println("Email equals: " + email1.equals(email2));
        System.out.println("Email hashCode: " + email1.hashCode() + " == " + email2.hashCode());
        System.out.println("Email toString: " + email1);

        Book b1 = new Book(isbn1, "Java 1", "Aissam", 2023);
        Book b2 = new Book(isbn2, "Java 1", "Zahid", 2023);
        System.out.println("Book equals: " + b1.equals(b2));
        System.out.println("Book hashCode: " + b1.hashCode() + " == " + b2.hashCode());
        System.out.println("Book toString: " + b1);

        Member m1 = new Member(1, "aissam", email1, LocalDate.of(2010, 1, 1));
        Member m2 = new Member(1, "aissam", email2, LocalDate.of(2010, 1, 1));
        System.out.println("Member equals: " + m1.equals(m2)); 
        System.out.println("Member hashCode: " + m1.hashCode() + " == " + m2.hashCode());
        System.out.println("Member toString: " + m1);

        Loan loan1 = new Loan(b1, m1, LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 15));
        Loan loan2 = new Loan(b2, m2, LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 15));
        System.out.println("Loan equals: " + loan1.equals(loan2));
        System.out.println("Loan hashCode: " + loan1.hashCode() + " == " + loan2.hashCode());
        System.out.println("Loan toString: " + loan1);
        
        //verification de logique de retard
        System.out.println("Loan overdue: " + loan1.isOverdue());
        loan1.checkLate();
        System.out.println("Loan status after checkLate: " + loan1.getStatus());
    }
}

