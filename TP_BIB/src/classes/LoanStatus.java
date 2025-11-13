package src.classes;

public enum LoanStatus {
    ONGOING, 
    RETURNED, 
    LATE;

    public boolean canTransitionTo(LoanStatus nextStatus) {
        if (this == nextStatus) 
            return false;
        return switch (this) {
            case ONGOING -> nextStatus == RETURNED || nextStatus == LATE;
            case LATE -> nextStatus == RETURNED;
            case RETURNED -> false;
        };
    }

    public boolean isActive() {
        return this == ONGOING || this == LATE;
    }
}
