package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {


//    @NotBlank
    private String name;

    private String nickName;

    @NotBlank
    @Size(min = 1,max = 12)
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @YearMonth(pattern = "yyyy-MM")
    private String birtDayYearMonth;

    @AssertTrue(message = "이름 또는 닉네임 중 하나라도 입력되어야 합니다.")
    public boolean isNameCheck(){
        if (Objects.nonNull(name) && !name.isBlank()){
            return true;
        }

        if (Objects.nonNull(nickName) &&!nickName.isBlank()){
            return true;
        }
        return false;
    }
}
