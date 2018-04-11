package club.zhisimina.blogsapp.entity.response;

/**
 * @description  响应解析基类
 * @author  fupengpeng
 * @date  2018/4/11 0011 16:14
 */
public class BaseResponse {
    /** 0:成功 1：失败 */
    private int code;
    /** 为1时，返回失败信息 */
    private String info;

    public BaseResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
