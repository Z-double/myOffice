package cn.mylife.service.user;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

/**
 * Service层基类，定义通用的增，删，改，查功能接口。
 *
 * @author zz
 * @date 2015年5月6日 下午5:41:57
 * @version 0.0.1
 * @param <T>
 */
public interface BaseService<T> {
    /**
     * 保存数据
     *
     * @author zz
     * @date 2015年5月6日 下午5:42:42
     * @throws
     * @return void 返回类型
     */
    public void save(T t);

    /**
     * 删除数据
     *
     * @author zz
     * @date 2015年5月6日 下午5:43:08
     * @throws
     * @return void 返回类型
     */
    @Transactional
    public void delete(Serializable id);

    /**
     * 更新数据
     *
     * @author zz
     * @date 2015年5月6日 下午5:43:19
     * @throws
     * @return void 返回类型
     */
    @Transactional
    public void update(T t);

    /**
     * 根据ID获取数据
     *
     * @author zz
     * @date 2015年5月6日 下午5:43:30
     * @throws
     * @return T 返回类型
     */
    public T get(Serializable id);

    /**
     * 获取所有的数据
     *
     * @author zz
     * @date 2015年5月6日 下午5:43:52
     * @throws
     * @return List<T> 返回类型
     */
    public List<T> getAll();
}