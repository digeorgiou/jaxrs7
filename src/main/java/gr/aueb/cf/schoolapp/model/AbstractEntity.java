package gr.aueb.cf.schoolapp.model;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass // με αυτο το annotation δηλωνουμε οτι κληρονομειται μονο,
// δεν δημιουργειται πινακας"Abstract Entity στην βαση
public abstract class AbstractEntity {

    @Column(name = "created_at", nullable = false , updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(unique = true , updatable = false , nullable = false, length = 36)
    private String uuid = UUID.randomUUID().toString();

    @PrePersist //αυτοματα τρεχει πριν το persist και αρχικοποιει τις τιμες
    protected void onCreate() {
        if(createdAt == null) createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
