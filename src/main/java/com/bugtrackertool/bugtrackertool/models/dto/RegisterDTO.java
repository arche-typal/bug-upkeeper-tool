package com.bugtrackertool.bugtrackertool.models.dto;

public class RegisterDTO extends LoginDTO{

    private String verifyHash;

    public String getVerifyHash() {
        return verifyHash;
    }

    public void setVerifyHash(String verifyHash) {
        this.verifyHash = verifyHash;
    }
}
