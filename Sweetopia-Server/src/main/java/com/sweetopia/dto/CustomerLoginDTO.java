package com.sweetopia.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerLoginDTO {
    private String userPassword;
    private String email;
}
