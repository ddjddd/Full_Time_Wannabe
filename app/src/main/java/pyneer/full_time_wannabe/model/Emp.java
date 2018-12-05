package pyneer.full_time_wannabe.model;

import java.io.Serializable;

/**
 * Default Emp(part_time) Model
 */

public class Emp implements Serializable {
    public String id;
    public String pw;
    public String name;
    public String phone;
    public String bank;
    public String account;


    // Creation
    public Emp() {}
    public Emp(String id, String pw, String name, String phone) {
        this.id = id;
        this.pw = pw;
        this.name = pw;
        this.phone = phone;
        this.bank = " ";
        this.account = " ";
    }
    public Emp(String id, String pw, String name, String phone, String bank, String account) {
        this.id = id;
        this.pw = pw;
        this.name = pw;
        this.phone = phone;
        this.bank = bank;
        this.account = account;
    }
}
