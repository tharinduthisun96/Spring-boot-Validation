package com.validation.validation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.*;
import java.sql.Date;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserCreateDto {
    @NotNull(message = "Name is Empty")
    private String name;

    @Email(message = "Wrong Email")
    private String email;

    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "Wrong Phone Number")
    private String mobile;

    @NotBlank
    private String gender;

    @Min(18)
    @Max(60)
    private int age;

    @Past(message = "Start should not be today")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "DOB cannot null")
    private Date dob;
}
