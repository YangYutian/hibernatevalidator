package org.hibernate.validator.referenceguide.chapter06;

import javax.validation.constraints.NotNull;

public class ContactDetails {
    @NotNull(message = "Name is mandatory", payload = Severity.Error.class)
    private String name;

    @NotNull(message = "Phone number not specified, but not mandatory",
            payload = Severity.Info.class)
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
