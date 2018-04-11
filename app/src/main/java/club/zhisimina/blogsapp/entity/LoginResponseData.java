package club.zhisimina.blogsapp.entity;

/**
 * 登录的响应数据
 */
public class LoginResponseData {

    // 用户信息
    private User uinfo;
    // 用户登录后的验证I
    private String sessionId;


    public User getUinfo() {
        return uinfo;
    }

    public void setUinfo(User uinfo) {
        this.uinfo = uinfo;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "LoginResponseData{" +
                ", uinfo=" + uinfo +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
