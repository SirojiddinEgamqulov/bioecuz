package bioecuz.bioeco.payload;

import lombok.Data;

@Data
public class ReqLogin {
    private String username;
    private String password;
    private boolean newUser;
    private String firebaseToken;
}
