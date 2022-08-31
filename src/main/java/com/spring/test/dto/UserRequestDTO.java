package com.spring.test.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDTO {

    @NotBlank(message = "İsim Boş Bırakılamaz")
    String name;
    @NotBlank(message = "Soyisim Boş Bırakılamaz")
    String surname;
    @NotBlank(message = "Hesap Bakiyesi boş bırakılamaz")
    BigDecimal accountBalance;

    @NotBlank(message = "TC Kimlik numarası boş bırakılamaz")
    String tcIdentity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getTcIdentity() {
        return tcIdentity;
    }

    public void setTcIdentity(String tcIdentity) {
        this.tcIdentity = tcIdentity;
    }
}
