/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package han.registration;

import java.io.Serializable;

/**
 *
 * @author WINDOWS
 */
public class RegistrationInsertError implements Serializable {
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String confirmNotMatch;
    private String lastNameLengthErr;
    private String usernameIsExisted;
    
    public void RegistrationInsertError(){
        this.usernameLengthErr = "";
        this.passwordLengthErr = "";
        this.confirmNotMatch = "";
        this.lastNameLengthErr = "";
        this.usernameIsExisted = "";
    }
    
    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getLastNameLengthErr() {
        return lastNameLengthErr;
    }

    public void setLastNameLengthErr(String lastNameLengthErr) {
        this.lastNameLengthErr = lastNameLengthErr;
    }

    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }
    
    
}
