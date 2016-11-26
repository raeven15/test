package com.example.raeven.guidance;

/**
 * Created by Viana on 9/25/2016.
 */
public class User
{
    private String _name;
    private int _studnumber;
    private String _password;
    private String _address;
    private String _contactNumber;
    private String _course;
    private int _userType;


    public User()
    {
        this._name = "";
        this._studnumber = 0;
        this._password = "";
        this._address = "";
        this._contactNumber = "";
        this._course = "";
        this._userType = 0;
    }

    public String get_name() {
        return _name;
    }

    public int get_userType() {
        return _userType;
    }

    public void set_userType(int _userType) {
        this._userType = _userType;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_studnumber() {
        return _studnumber;
    }

    public void set_studnumber(int _studnumber) {
        this._studnumber = _studnumber;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public String get_contactNumber() {
        return _contactNumber;
    }

    public void set_contactNumber(String _contactNumber) {
        this._contactNumber = _contactNumber;
    }

    public String get_course() {
        return _course;
    }

    public void set_course(String _course) {
        this._course = _course;
    }
}
