package com.aca.imbd.project.user;

import java.io.Serializable;

public class Admin extends User implements Serializable {
    public Admin(String username, String password) {
        super(username, password);
    }

    public Admin() {
        super();
    }
}
