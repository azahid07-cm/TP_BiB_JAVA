package src.Objets_valeur;
import java.util.Objects;

public final class Email {
    private final String value;
    public Email(String v){
        Objects.requireNonNull(v, "L'email ne peut pas être null");
        v = v.trim().toLowerCase();
        if (!v.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            throw new IllegalArgumentException("Format d'email invalide : " + v);
        }
        this.value = v;
    }
    
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (!(obj instanceof Email other)) 
            return false;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString(){
        return this.getValue();
    }   
}
