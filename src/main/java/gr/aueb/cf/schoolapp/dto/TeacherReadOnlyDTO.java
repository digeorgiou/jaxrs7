package gr.aueb.cf.schoolapp.dto;

public record TeacherReadOnlyDTO(
        Long id,
        String ssn,
        String firstname,
        String lastname
) {}
