package com.hp.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.hp.server.dao.BasicMapper;
import com.hp.server.dto.*;
import com.hp.server.service.BasicService;
import com.hp.server.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BasicServiceImpl implements BasicService {

    @Autowired
    BasicMapper basicMapper;

    /**
     * 新增小区
     *
     * @param region
     * @return
     */
    @Override
    public Integer saveRegion(BasicRegionVo region) {
        return basicMapper.saveRegion(region);
    }

    /**
     * 查询小区
     *
     * @param region
     * @return
     */
    @Override
    public String regionName(BasicRegionVo region) {
        return basicMapper.regionName(region);
    }

    /**
     * 查询楼宇id
     * @param vo
     * @return
     */
    @Override
    public String towerId(BasicTowerVo vo) {
        return basicMapper.towerId(vo);
    }

    /**
     * 获取小区列表
     *
     * @param region
     * @return
     */
    @Override
    public List<BasicRegionDTO> getRegion(BasicRegionDTO region) {
        PageHelper.offsetPage(region.getBeginRow(), region.getLimitRow());
        return basicMapper.getRegion(region);
    }

    /**
     * 更新小区
     *
     * @param region
     * @return
     */
    @Override
    public Integer updateRegion(BasicRegionVo region) {
        return basicMapper.updateRegion(region);
    }

    /**
     * 逻辑删除小区
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteRegion(String id) {
        Integer towers = basicMapper.countTowers(id);
        if (towers != null && towers >= 1) {
            return -1;
        } else {
            return basicMapper.deleteRegion(id);
        }
    }

    /**
     * 新增楼宇
     *
     * @param tower
     * @return
     */
    @Override
    public Integer saveTower(BasicTowerVo tower) {
        return basicMapper.saveTower(tower);
    }

    /**
     * 查询楼宇数量
     *
     * @param dto
     * @return
     */
    @Override
    public Integer countTower(BasicTowerVo dto) {
        return basicMapper.countTower(dto);
    }

    /**
     * 获取楼宇列表
     *
     * @param tower
     * @return
     */
    @Override
    public List<BasicTowerDTO> getTower(BasicTowerDTO tower) {
        PageHelper.offsetPage(tower.getBeginRow(), tower.getLimitRow());
        return basicMapper.getTower(tower);
    }

    /**
     * 更新楼宇
     *
     * @param tower
     * @return
     */
    @Override
    public Integer updateTower(BasicTowerVo tower) {
        return basicMapper.updateTower(tower);
    }

    /**
     * 逻辑删除楼宇
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public Integer deleteTower(String id) {
        Integer cells = basicMapper.countCells(id);
        if (cells != null && cells >= 1) {
            return -1;
        } else {
            return basicMapper.deleteTower(id);
        }
    }

    /**
     * 新增单元
     *
     * @param cell
     * @return
     */
    @Override
    public Integer saveCell(BasicCellVo cell) {
        return basicMapper.saveCell(cell);
    }

    /**
     * 查询单元名称
     *
     * @param dto
     * @return
     */
    @Override
    public String cellName(BasicCellVo dto) {
        return basicMapper.cellName(dto);
    }

    /**
     * 查询单元Id
     *
     * @param dto
     * @return
     */
    @Override
    public String cellNameId(BasicCellVo dto) {
        return basicMapper.cellNameId(dto);
    }

    /**
     * 获取单元列表
     *
     * @param cell
     * @return
     */
    @Override
    public List<BasicCellDTO> getCell(BasicCellDTO cell) {
        PageHelper.offsetPage(cell.getBeginRow(), cell.getLimitRow());
        return basicMapper.getCell(cell);
    }

    /**
     * 更新单元
     *
     * @param cell
     * @return
     */
    @Override
    public Integer updateCell(BasicCellVo cell) {
        return basicMapper.updateCell(cell);
    }

    /**
     * 逻辑删除单元
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteCell(String id) {
        return basicMapper.deleteCell(id);
    }

    /**
     * 新建分组
     *
     * @param dto
     * @return
     */
    @Override
    public Integer saveGroup(BasicGroupVo dto) {
        Integer integer = basicMapper.countGroup(dto);
        if (integer >= 1) {
            return -1;
        }
        return basicMapper.saveGroup(dto);
    }

    /**
     * 分页查询分组列表
     *
     * @param vo
     * @return
     */
    @Override
    public List<BasicGroupDTO> getGroup(BasicGroupDTO vo) {
        PageHelper.offsetPage(vo.getBeginRow(), vo.getLimitRow());
        return basicMapper.getGroup(vo);
    }

    /**
     * 更新分组
     *
     * @param dto
     * @return
     */
    @Override
    public Integer updateGroup(BasicGroupVo dto) {
        return basicMapper.updateGroup(dto);
    }

    /**
     * 查询分组id
     *
     * @param vo
     * @return
     */
    @Override
    public String getGroupId(BasicGroupVo vo) {
        return basicMapper.getGroupId(vo);
    }

    /**
     * 获取热换站id
     *
     * @param vo
     * @return
     */
    @Override
    public String getSiteId(BasicSiteVo vo) {
        return basicMapper.getSiteId(vo);
    }

    /**
     * 逻辑删除分组
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public Integer deleteGroup(String id) {
        Integer countSites = basicMapper.countSites(id);
        if (countSites != null && countSites >= 1) {
            return -1;
        } else {
            return basicMapper.deleteGroup(id);
        }
    }

    /**
     * 保存热换站
     *
     * @return
     */
    @Override
    public Integer saveSuit(BasicSiteVo dto) {
        Integer integer = basicMapper.countSite(dto);
        if (integer >= 1) {
            return -1;
        }
        return basicMapper.saveSuit(dto);
    }

    /**
     * 分页查询热换站
     *
     * @param vo
     * @return
     */
    @Override
    public List<BasicSiteDTO> getSite(BasicSiteDTO vo) {
        PageHelper.offsetPage(vo.getBeginRow(), vo.getLimitRow());
        return basicMapper.getSite(vo);
    }

    /**
     * 更新热换站
     *
     * @param dto
     * @return
     */
    @Override
    public Integer updateSite(BasicSiteVo dto) {
        return basicMapper.updateSite(dto);
    }

    /**
     * 获取机组id
     *
     * @param vo
     * @return
     */
    @Override
    public String getUnitId(BasicUnitVo vo) {
        return basicMapper.getUnitId(vo);
    }

    /**
     * 逻辑删除热换站
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteSite(String id) {
        Integer countUnits = basicMapper.countUnits(id);
        if (countUnits != null && countUnits >= 1) {
            return -1;
        } else {
            return basicMapper.deleteSite(id);
        }
    }

    /**
     * 新增机组
     *
     * @param dto
     * @return
     */
    @Override
    public Integer saveUnit(BasicUnitVo dto) {
        Integer integer = basicMapper.countUnit(dto);
        if (integer >= 1) {
            return -1;
        }
        return basicMapper.saveUnit(dto);
    }

    /**
     * 分页查询机组信息
     *
     * @param vo
     * @return
     */
    @Override
    public List<BasicUnitDTO> getUnit(BasicUnitDTO vo) {
        PageHelper.offsetPage(vo.getBeginRow(), vo.getLimitRow());
        return basicMapper.getUnit(vo);
    }

    /**
     * 更新机组信息
     *
     * @param dto
     * @return
     */
    @Override
    public Integer updateUnit(BasicUnitVo dto) {
        return basicMapper.updateUnit(dto);
    }

    /**
     * 逻辑删除机组信息
     *
     * @param id
     * @return
     */
    @Override
    public Integer delUnit(String id) {
        return basicMapper.delUnit(id);
    }

    /**
     * 根据机组名称查询是否重复
     *
     * @param dto
     * @return
     */
    @Override
    public Integer countUnit(BasicUnitVo dto) {
        return basicMapper.countUnit(dto);
    }

    /**
     * 查询热换站内机组数量
     *
     * @param id
     * @return
     */
    @Override
    public Integer countUnits(String id) {
        return basicMapper.countUnits(id);
    }

    /**
     * 批量删除机组信息
     *
     * @param id
     * @return
     */
    @Override
    public Integer delUnits(String id) {
        return basicMapper.delUnits(id);
    }

    /**
     * 小区树形结构下拉框
     *
     * @param companyId
     * @return
     */
    @Override
    public List<BasicRegionVo> getRegionTrees(Long companyId) {
        ArrayList<HashMap<Object, Object>> list = new ArrayList<>();
        List<BasicRegionVo> regionTree = basicMapper.getRegionTree(companyId);
        BasicRegionVo regionVo = new BasicRegionVo();
        regionVo.setRegion("未绑定");
        regionVo.setId(Long.valueOf(0));
        regionTree.add(regionVo);
        if (regionTree != null && regionTree.size() > 0) {
            for (BasicRegionVo basicRegionVo : regionTree) {
                basicRegionVo.setKey(basicRegionVo.getId() + ":regionId");
                basicRegionVo.setTitle(basicRegionVo.getRegion());
                List<BasicTowerVo> towerTree = basicMapper.getTowerTree(basicRegionVo.getId());
                if (towerTree != null && towerTree.size() > 0) {
                    for (BasicTowerVo basicTowerVo : towerTree) {
                        basicTowerVo.setKey(basicTowerVo.getId() + ":towerId");
                        basicTowerVo.setTitle(basicTowerVo.getTower());
                        List<BasicCellVo> cellTree = basicMapper.getCellTree(basicTowerVo.getId());
                        if (cellTree != null && cellTree.size() > 0) {
                            for (BasicCellVo basicCellVo : cellTree) {
                                basicCellVo.setKey(basicCellVo.getId() + ":cellId");
                                basicCellVo.setTitle(basicCellVo.getCell());
                            }
                            basicTowerVo.setChildren(cellTree);
                        }
                    }
                    basicRegionVo.setChildren(towerTree);
                }

            }
        }

        return regionTree;
    }

    /**
     * 机组树形结构下拉框
     *
     * @param companyId
     * @return
     */
    @Override
    public List<BasicGroupVo> getGroupTrees(Long companyId) {
        List<BasicGroupVo> groupTree = basicMapper.getGroupTree(companyId);
        BasicGroupVo groupVo = new BasicGroupVo();
        groupVo.setGroups("未绑定");
        groupVo.setId(Long.valueOf(0));
        groupTree.add(groupVo);
        if (groupTree != null && groupTree.size() > 0) {
            for (BasicGroupVo groupDTO : groupTree) {
                groupDTO.setKey(groupDTO.getId() + ":groupId");
                groupDTO.setTitle(groupDTO.getGroups());
                List<BasicSiteVo> siteTree = basicMapper.getSiteTree(groupDTO.getId());
                if (siteTree != null && siteTree.size() > 0) {
                    for (BasicSiteVo siteDTO : siteTree) {
                        siteDTO.setKey(siteDTO.getId() + ":siteId");
                        siteDTO.setTitle(siteDTO.getSite());
                        List<BasicUnitVo> unitTree = basicMapper.getUnitTree(siteDTO.getId());
                        if (unitTree != null && unitTree.size() > 0) {
                            for (BasicUnitVo unitVo : unitTree) {
                                unitVo.setKey(unitVo.getId() + ":unitId");
                                unitVo.setTitle(unitVo.getUnit());
                            }
                            siteDTO.setChildren(unitTree);
                        }
                    }
                    groupDTO.setChildren(siteTree);
                }

            }
        }
        return groupTree;
    }

    /**
     * 小区集合
     *
     * @param companyId
     * @return
     */
    @Override
    public List<BasicRegionVo> getRegionList(Long companyId) {
        return basicMapper.getRegionList(companyId);
    }

    /**
     * 楼宇集合
     *
     * @param companyId
     * @return
     */
    @Override
    public List<BasicTowerVo> getTowerList(Long companyId) {
        return basicMapper.getTowerList(companyId);
    }

    /**
     * 分组集合
     *
     * @param companyId
     * @return
     */
    @Override
    public List<BasicGroupVo> getGroupList(Long companyId) {
        return basicMapper.getGroupList(companyId);
    }

    /**
     * 热换站集合
     *
     * @param companyId
     * @return
     */
    @Override
    public List<BasicSiteVo> getSiteList(Long companyId) {
        return basicMapper.getSiteList(companyId);
    }

    /**
     * 根据条件查询客户档案列表
     *
     * @param dto
     * @return
     */
    @Override
    public List<BasicClientVo> listBasicClient(BasicClientQueryDTO dto) {
        PageHelper.offsetPage(dto.getBeginRow(), dto.getLimitRow());
        return basicMapper.listBasicClient(dto);
    }
}
