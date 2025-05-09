package gr.aueb.cf.jax.dto;

public record TeacherReadOnlyDTO(
        Long id,
        String ssn,
        String firstname,
        String lastname
) {}
