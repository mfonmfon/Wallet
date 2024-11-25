package com.mfons_projects.walletapp.Dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
}
