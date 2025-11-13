package src.classes;

import java.time.LocalDate;
import java.util.Objects;

import src.Objets_valeur.Email;

public class Member {
    private final int id;
    private final String fullName;
    private final Email email;
    private final LocalDate registrationDate;
    
    public Member(int id, String fullName, Email email, LocalDate registrationDate){
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant doit être positif");
        }
        Objects.requireNonNull(fullName, "Le nom complet est obligatoire");
        Objects.requireNonNull(email, "L'email est obligatoire");
        Objects.requireNonNull(registrationDate, "La date d'inscription est obligatoire");

        if (fullName.isBlank()) {
            throw new IllegalArgumentException("Le nom complet ne peut pas être vide");
        }
        if (registrationDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La date d'inscription ne peut pas être dans le futur");
        }
        
        this.id = id;
        this.fullName = fullName.trim();
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Email getEmail() {
        return email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (!(obj instanceof Member other)) 
            return false;
        return id==other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", nom_complet=" + fullName +
                ", Email=" + email +
                ", registrationDate=" + registrationDate +'}';
    }
}
