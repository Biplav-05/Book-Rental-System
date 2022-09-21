package com.example.bookkeepingsys.pojo;

        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

        import javax.persistence.Entity;
        import javax.validation.constraints.Email;
        import javax.validation.constraints.NotBlank;
        import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorPojo {
    private Integer id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "please enter valid email..")
    private String email;
    @Pattern(regexp ="^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",
            message = "Enter valid mobile number")
    private String mobileNumber;
}
