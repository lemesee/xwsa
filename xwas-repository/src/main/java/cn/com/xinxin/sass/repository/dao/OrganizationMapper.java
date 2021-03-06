package cn.com.xinxin.sass.repository.dao;

/*
 *
 * Copyright 2020 www.xinxindigits.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"),to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice
 * shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Redistribution and selling copies of the software are prohibited, only if the authorization from xinxin digits
 * was obtained.Neither the name of the xinxin digits; nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written permission.
 *
 */

import cn.com.xinxin.sass.repository.model.OrganizationDO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrganizationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table organization
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table organization
     *
     * @mbg.generated
     */
    int insert(OrganizationDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table organization
     *
     * @mbg.generated
     */
    int insertSelective(OrganizationDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table organization
     *
     * @mbg.generated
     */
    OrganizationDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table organization
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OrganizationDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table organization
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(OrganizationDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table organization
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OrganizationDO record);

    List<OrganizationDO> findByCondition(@Param("condition") OrganizationDO condition);


    List<OrganizationDO> selectAllOrgsByTenantId(@Param("tenantId")String tenantId);

    OrganizationDO findByCode(@Param("code") String code);

    int updateByCodeSelective(OrganizationDO record);

    int deleteByCodes(@Param("codes") List<String> codes, @Param("tenantId") String tenantId);

    List<OrganizationDO> findChildren(@Param("parentIds") List<Long> parentIds);

    int deleteByIds(List<Long> ids);

    List<OrganizationDO> findNotRoot(@Param("tenantId") String tenantId);

    /**
     *
     * @param orgIds
     * @return
     */
    List<OrganizationDO> queryOrgListByOrgIds(@Param("orgIds") List<Long> orgIds);
}