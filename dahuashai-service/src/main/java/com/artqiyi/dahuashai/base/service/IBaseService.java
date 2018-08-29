package com.artqiyi.dahuashai.base.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/4/23
 * Modify On: 2018/4/23 by chencunjun
 */

/**
 * 基础服务接口
 */
public interface IBaseService<T,K>  {

    /**
     * 分页列表
     * @param page
     * @param pageSize
     * @param example
     * @return
     */
    PageInfo<T> page(int page, int pageSize, K example);
    /**
     * 保存或更新
     * @param t
     * @return
     */
    public long saveOrUpdate(T t);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public int deleteById(long id);

    /**
     * 根据查询实例删除
     * @param k
     * @return
     */
    public int deleteByExample(K k);


    /**
     * 根据查询实例更新
     * @param t
     * @param k
     * @return
     */
    public int updateByExample(T t,K k);

    /**
     * 根据查询实例查询
     * @param k
     * @return
     */
    public List<T> selectByExample(K k);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public T selectById(long id);

    /**
     * 根据查询条件统计
     * @param k
     * @return
     */
    public long countByExample(K k);
}
