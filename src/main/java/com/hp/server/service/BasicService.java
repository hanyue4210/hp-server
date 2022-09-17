package com.hp.server.service;

import com.hp.server.dto.*;
import com.hp.server.vo.*;

import java.util.List;

public interface BasicService {

    /**
     * 新增小区
     *
     * @param region
     * @return
     */
    Integer saveRegion(BasicRegionVo region);

    /**
     * 查询小区
     *
     * @param region
     * @return
     */
    String regionName(BasicRegionVo region);
    /**
     * 查询楼宇id
     * @param vo
     * @return
     */
    String towerId(BasicTowerVo vo);

    /**
     * 获取小区列表
     *
     * @param region
     * @return
     */

    List<BasicRegionDTO> getRegion(BasicRegionDTO region);

    /**
     * 更新小区
     *
     * @param region
     * @return
     */

    Integer updateRegion(BasicRegionVo region);

    /**
     * 逻辑删除小区
     *
     * @param id
     * @return
     */
    Integer deleteRegion(String id);


    /**
     * 新增楼宇
     *
     * @param tower
     * @return
     */
    Integer saveTower(BasicTowerVo tower);

    /**
     * 查询楼宇数量
     *
     * @param dto
     * @return
     */
    Integer countTower(BasicTowerVo dto);

    /**
     * 获取楼宇列表
     *
     * @param tower
     * @return
     */

    List<BasicTowerDTO> getTower(BasicTowerDTO tower);

    /**
     * 更新楼宇
     *
     * @param tower
     * @return
     */

    Integer updateTower(BasicTowerVo tower);

    /**
     * 逻辑删除楼宇
     *
     * @param id
     * @return
     */

    Integer deleteTower(String id);


    /**
     * 新增单元
     *
     * @param cell
     * @return
     */
    Integer saveCell(BasicCellVo cell);

    /**
     * 查询单元名称
     *
     * @param dto
     * @return
     */
    String cellName(BasicCellVo dto);
    /**
     * 查询单元id
     *
     * @param dto
     * @return
     */
    String cellNameId(BasicCellVo dto);

    /**
     * 获取单元列表
     *
     * @param cell
     * @return
     */

    List<BasicCellDTO> getCell(BasicCellDTO cell);

    /**
     * 更新单元
     *
     * @param cell
     * @return
     */

    Integer updateCell(BasicCellVo cell);

    /**
     * 逻辑删除单元
     *
     * @param id
     * @return
     */

    Integer deleteCell(String id);

    /**
     * 新建分组
     *
     * @param dto
     * @return
     */
    Integer saveGroup(BasicGroupVo dto);

    /**
     * 分页查询分组列表
     *
     * @param vo
     * @return
     */
    List<BasicGroupDTO> getGroup(BasicGroupDTO vo);

    /**
     * 更新分组
     *
     * @param dto
     * @return
     */
    Integer updateGroup(BasicGroupVo dto);
    /**
     * 查询分组id
     * @param vo
     * @return
     */
    String getGroupId(BasicGroupVo vo);
    /**
     * 获取热换站id
     * @param vo
     * @return
     */
    String getSiteId(BasicSiteVo vo);

    /**
     * 逻辑删除分组
     *
     * @param id
     * @return
     */
    Integer deleteGroup(String id);

    /**
     * 保存热换站
     *
     * @return
     */
    Integer saveSuit(BasicSiteVo dto);

    /**
     * 分页查询热换站
     *
     * @param vo
     * @return
     */
    List<BasicSiteDTO> getSite(BasicSiteDTO vo);

    /**
     * 更新热换站
     *
     * @param dto
     * @return
     */
    Integer updateSite(BasicSiteVo dto);
    /**
     * 获取机组id
     * @param vo
     * @return
     */
    String getUnitId(BasicUnitVo vo);

    /**
     * 逻辑删除热换站
     *
     * @param id
     * @return
     */
    Integer deleteSite(String id);

    /**
     * 新增机组
     *
     * @param dto
     * @return
     */
    Integer saveUnit(BasicUnitVo dto);

    /**
     * 分页查询机组信息
     *
     * @param vo
     * @return
     */
    List<BasicUnitDTO> getUnit(BasicUnitDTO vo);

    /**
     * 更新机组信息
     *
     * @param dto
     * @return
     */
    Integer updateUnit(BasicUnitVo dto);

    /**
     * 逻辑删除机组信息
     *
     * @param id
     * @return
     */
    Integer delUnit(String id);

    /**
     * 根据机组名称查询是否重复
     *
     * @param dto
     * @return
     */
    Integer countUnit(BasicUnitVo dto);

    /**
     * 查询热换站内机组数量
     *
     * @param id
     * @return
     */
    Integer countUnits(String id);

    /**
     * 批量删除机组信息
     *
     * @param id
     * @return
     */
    Integer delUnits(String id);

    /**
     * 小区树形结构下拉框
     *
     * @param companyId
     * @return
     */
    List<BasicRegionVo> getRegionTrees(Long companyId);

    /**
     * 机组树形结构下拉框
     *
     * @param companyId
     * @return
     */
    List<BasicGroupVo> getGroupTrees(Long companyId);

    /**
     * 小区集合
     *
     * @param companyId
     * @return
     */
    List<BasicRegionVo> getRegionList(Long companyId);

    /**
     * 楼宇集合
     *
     * @param companyId
     * @return
     */
    List<BasicTowerVo> getTowerList(Long companyId);

    /**
     * 分组集合
     *
     * @param companyId
     * @return
     */
    List<BasicGroupVo> getGroupList(Long companyId);

    /**
     * 热换站集合
     *
     * @param companyId
     * @return
     */
    List<BasicSiteVo> getSiteList(Long companyId);

    /**
     * 根据条件查询客户档案列表
     *
     * @param dto
     * @return
     */
    List<BasicClientVo> listBasicClient(BasicClientQueryDTO dto);
}
