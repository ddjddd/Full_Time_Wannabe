package pyneer.full_time_wannabe.model;

import java.io.Serializable;

/**
 * Default Emp(part_time) Model
 */

public class Boss implements Serializable {
    public String id;
    public String pw;
    public String name;
    public String phone;


    // Creation
    public Boss() {}
    public Boss(String id, String pw, String name, String phone) {
        this.id = id;
        this.pw = pw;
        this.name = pw;
        this.phone = phone;
    }
}
