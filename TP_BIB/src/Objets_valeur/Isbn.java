package src.Objets_valeur;
import java.util.Objects;

public final class Isbn {
    private final String value;
    public Isbn(String v){
        Objects.requireNonNull(v, "L'ISBN ne peut pas être null");
        v = v.trim();
        if (!v.matches("^(97(8|9))?\\d{9}(\\d|X)$")) {
            throw new IllegalArgumentException("Format ISBN invalide : " + v);
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
        if (!(obj instanceof Isbn other)) 
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
