package src.classes;

import java.time.LocalDate;
import java.util.Objects;

public final class Loan {
    private final Book book;
    private final Member member;
    private final LocalDate loanDate;
    private final LocalDate dueDate;
    private LoanStatus status;

    public Loan(Book book, Member member, LocalDate loanDate, LocalDate dueDate) {
        Objects.requireNonNull(book, "Le livre est obligatoire");
        Objects.requireNonNull(member, "Le membre est obligatoire");
        Objects.requireNonNull(loanDate, "La date d'emprunt est obligatoire");
        Objects.requireNonNull(dueDate, "La date de retour est obligatoire");

        if (dueDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("La date de retour doit être après la date d'emprunt");
        }

        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.status = LoanStatus.ONGOING;

        if (LocalDate.now().isAfter(dueDate)) {
            this.status = LoanStatus.LATE;
        }
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void markReturned() {
        if (status.canTransitionTo(LoanStatus.RETURNED)) {
            status = LoanStatus.RETURNED;
        } else {
            throw new IllegalStateException("Impossible de changer le statut en RETURNED depuis " + status);
        }
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate) && status.isActive();
    }

    public void checkLate() {
        if (isOverdue() && status.canTransitionTo(LoanStatus.LATE)) {
            status = LoanStatus.LATE;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Loan other)) return false;
        return book.equals(other.book) && member.equals(other.member) && loanDate.equals(other.loanDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, member, loanDate);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book +
                ", member=" + member +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", status=" + status +
                '}';
    }
}
