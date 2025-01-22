package org.test.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Age is required")
    @Pattern(regexp = "\\d{1,3}", message = "Age must be a number and valid")
    private String age;
    @NotBlank(message = "ClassName is required")
    private String className;
    @NotBlank(message = "PhoneNumber is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

}
