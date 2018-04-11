package club.zhisimina.blogsapp.model.factory;


import club.zhisimina.blogsapp.model.impl.VersionModel;
import club.zhisimina.blogsapp.model.interf.IVersionModel;

/**
 * 版本业务工厂
 */
public class VersionModelFactory {

    /**
     * 创建版本业务实例
     *
     * @return 版本业务实例
     */
    public static IVersionModel newInstance() {
        return new VersionModel();
    }
}
