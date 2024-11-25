package com.mfons_projects.walletapp.Dtos.response;

import com.mfons_projects.walletapp.domain.enums.StatusResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositResponse {
    private StatusResponse Status;
}
