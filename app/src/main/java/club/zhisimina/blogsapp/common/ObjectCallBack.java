package club.zhisimina.blogsapp.common;

/**
 * @description  单对象回调
 * @author  fupengpeng
 * @date  2018/4/11 0011 16:14
 */
public interface ObjectCallBack<T> {

    /**
     * 当操作成功时，调用该方法
     *
     * @param data
     */
    void onSuccess(T data);

    /**
     * 当操作失败时，调用该方法
     *
     * @param e
     */
    void onFail(Exception e);
}
