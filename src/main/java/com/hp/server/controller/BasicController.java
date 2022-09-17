package com.hp.server.controller;

import com.github.pagehelper.PageInfo;
import com.hp.server.dto.*;
import com.hp.server.result.ResultBody;
import com.hp.server.service.BasicService;
import com.hp.server.service.DeviceService;
import com.hp.server.vo.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/basic")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BasicController {

    @Autowired
    BasicService service;

    @Autowired
    DeviceService deviceService;

    /**
     * 保存小区名称
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:basic:region:XQadd")
    @PostMapping("/save/region")
    public ResultBody saveRegion(@RequestBody @Valid BasicRegionVo dto) {
        ResultBody resultBody = new ResultBody();
        String s = service.regionName(dto);
        if (s != null) {
            resultBody.setCode(400);
            resultBody.setMessage("小区名称重复");
            resultBody.setMessageToUser("小区名称重复");
            return resultBody;
        }
        Integer integer = service.saveRegion(dto);

        if (integer < 0) {
            resultBody.setCode(400);
            resultBody.setMessage("保存失败");
            resultBody.setMessageToUser("保存失败");
        }
        return resultBody;
    }

    /**
     * 获取小区列表
     *
     * @param vo
     * @return
     */
    @RequiresPermissions("perm:basic:region")
    @GetMapping("/get/region")
    public ResultBody getRegion(@Valid BasicRegionDTO vo) {
        List<BasicRegionDTO> region = service.getRegion(vo);
        return new ResultBody(new PageInfo<>(region));
    }

    /**
     * 更新小区
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:basic:region:XQupdate")
    @PostMapping("/update/region")
    public ResultBody updateRegion(@RequestBody BasicRegionVo dto) {
        ResultBody resultBody = new ResultBody();
        String s = service.regionName(dto);
        if (s != null && !s.equals(dto.getId().toString())) {
            resultBody.setCode(400);
            resultBody.setMessage("小区名称重复");
            resultBody.setMessageToUser("小区名称重复");
            return resultBody;
        } else if (s != null && s.equals(dto.getId().toString())) {
            return resultBody;
        }
        Integer integer = service.updateRegion(dto);
        if (integer < 0) {
            resultBody.setCode(400);
            resultBody.setMessage("更新失败");
            resultBody.setMessageToUser("更新失败");
        }
        return resultBody;
    }

    /**
     * 逻辑删除小区
     *
     * @param id
     * @return
     */
    @RequiresPermissions("perm:basic:region:XQdelete")
    @PostMapping("/del/region")
    public ResultBody deleteRegion(@RequestParam("id") String id) {
        ResultBody resultBody = new ResultBody();
        DeviceManagerDTO managerDTO = new DeviceManagerDTO();
        managerDTO.setRegionId(Long.valueOf(id));
        List<DeviceManagerVo> device = deviceService.getDevice(managerDTO);
        if (device != null && device.size() > 0) {
            resultBody.setCode(400);
            resultBody.setMessage("本小区已关联设备不可删除");
            resultBody.setMessageToUser("本小区已关联设备不可删除");
            return resultBody;
        }
        Integer integer = service.deleteRegion(id);

        if (integer != null && integer == 0) {
            resultBody.setCode(400);
            resultBody.setMessage("删除失败");
            resultBody.setMessageToUser("删除失败");
        }
        if (integer != null && integer == -1) {
            resultBody.setCode(400);
            resultBody.setMessage("本小区已关联楼宇不可删除");
            resultBody.setMessageToUser("本小区已关联楼宇不可删除");
        }
        return resultBody;
    }

    /**
     * 新增楼宇
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:basic:region:LYadd")
    @PostMapping("/save/tower")
    public ResultBody saveTower(@RequestBody BasicTowerVo dto) {
        ResultBody resultBody = new ResultBody();
        Integer num = service.countTower(dto);
        if (num != null && num >= 1) {
            resultBody.setCode(400);
            resultBody.setMessage("楼宇名称重复");
            resultBody.setMessageToUser("楼宇名称重复");
            return resultBody;
        }

        Integer integer = service.saveTower(dto);
        if (integer != null && integer < 0) {
            resultBody.setCode(400);
            resultBody.setMessage("保存失败");
            resultBody.setMessageToUser("保存失败");
        }
        return resultBody;
    }

    /**
     * 获取楼宇列表
     *
     * @param vo
     * @return
     */
    @RequiresPermissions("perm:basic:region")
    @GetMapping("/get/tower")
    public ResultBody getTower(@Valid BasicTowerDTO vo) {
        ResultBody resultBody = new ResultBody();
        List<BasicTowerDTO> tower = service.getTower(vo);
        return new ResultBody(new PageInfo<>(tower));
    }

    /**
     * 更新楼宇
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:basic:region:LYupdate")
    @PostMapping("/update/tower")
    public ResultBody updateTower(@RequestBody BasicTowerVo dto) {
        ResultBody resultBody = new ResultBody();
        String s = service.towerId(dto);
        if (s != null && !s.equals(dto.getId().toString())) {
            resultBody.setCode(400);
            resultBody.setMessage("楼宇名称重复");
            resultBody.setMessageToUser("楼宇名称重复");
            return resultBody;
        } else if (s != null && s.equals(dto.getId().toString())) {
            return resultBody;
        }
        Integer integer = service.updateTower(dto);
        if (integer != null && integer < 0) {
            resultBody.setCode(400);
            resultBody.setMessage("更新失败");
            resultBody.setMessageToUser("更新失败");
        }
        return resultBody;
    }

    /**
     * 逻辑删除楼宇
     *
     * @param id
     * @return
     */
    @RequiresPermissions("perm:basic:region:LYdelete")
    @PostMapping("/del/tower")
    public ResultBody deleteTower(@RequestParam("id") String id) {
        ResultBody resultBody = new ResultBody();
        DeviceManagerDTO managerDTO = new DeviceManagerDTO();
        managerDTO.setTowerId(Long.valueOf(id));
        List<DeviceManagerVo> device = deviceService.getDevice(managerDTO);
        if (device != null && device.size() > 0) {
            resultBody.setCode(400);
            resultBody.setMessage("本楼宇已关联设备不可删除");
            resultBody.setMessageToUser("本楼宇已关联设备不可删除");
            return resultBody;
        }
        Integer integer = service.deleteTower(id);
        if (integer != null && integer < 1) {
            resultBody.setCode(400);
            resultBody.setMessage("删除失败");
            resultBody.setMessageToUser("删除失败");
        }
        if (integer != null && integer == -1) {
            resultBody.setCode(400);
            resultBody.setMessage("本楼宇已关联单元不可删除");
            resultBody.setMessageToUser("本楼宇已关联单元不可删除");
        }
        return resultBody;
    }

    /**
     * 新增单元
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:basic:region:DYadd")
    @PostMapping("/save/cell")
    public ResultBody saveCell(@RequestBody @Valid BasicCellVo dto) {
        ResultBody resultBody = new ResultBody();
        String s = service.cellName(dto);
        if (s != null && s.equals(dto.getCell())) {
            resultBody.setCode(400);
            resultBody.setMessage("单元名称重复");
            resultBody.setMessageToUser("单元名称重复");
            return resultBody;
        }
        Integer integer = service.saveCell(dto);
        if (integer != null && integer < 0) {
            resultBody.setCode(400);
            resultBody.setMessage("保存失败");
            resultBody.setMessageToUser("保存失败");
        }
        return resultBody;
    }

    /**
     * 获取单元列表
     *
     * @param vo
     * @return
     */
    @RequiresPermissions("perm:basic:region")
    @GetMapping("/get/cell")
    public ResultBody getCell(@Valid BasicCellDTO vo) {
        List<BasicCellDTO> cell = service.getCell(vo);
        return new ResultBody(new PageInfo<>(cell));
    }

    /**
     * 更新单元
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:basic:region:DYupdate")
    @PostMapping("/update/cell")
    public ResultBody updateCell(@RequestBody @Valid BasicCellVo dto) {
        ResultBody resultBody = new ResultBody();
        String s = service.cellNameId(dto);
        if (s != null && !s.equals(dto.getId().toString())) {
            resultBody.setCode(400);
            resultBody.setMessage("单元名称重复");
            resultBody.setMessageToUser("单元名称重复");
        } else if (s != null && s.equals(dto.getId().toString())) {
            return resultBody;
        }
        Integer integer = service.updateCell(dto);
        if (integer != null && integer < 0) {
            resultBody.setCode(400);
            resultBody.setMessage("更新失败");
            resultBody.setMessageToUser("更新失败");
        }
        return resultBody;
    }

    /**
     * 逻辑删除单元
     *
     * @param id
     * @return
     */
    @RequiresPermissions("perm:basic:region:DYdelete")
    @PostMapping("/del/cell")
    public ResultBody deleteCell(@RequestParam("id") String id) {
        ResultBody resultBody = new ResultBody();
        DeviceManagerDTO managerDTO = new DeviceManagerDTO();
        managerDTO.setCellId(Long.valueOf(id));
        List<DeviceManagerVo> device = deviceService.getDevice(managerDTO);
        if (device != null && device.size() > 0) {
            resultBody.setCode(400);
            resultBody.setMessage("本单元已关联设备不可删除");
            resultBody.setMessageToUser("本单元已关联设备不可删除");
            return resultBody;
        }
        Integer integer = service.deleteCell(id);
        if (integer != null && integer < 0) {
            resultBody.setCode(400);
            resultBody.setMessage("删除失败");
            resultBody.setMessageToUser("删除失败");
        }
        return resultBody;
    }

    /**
     * 新增分组
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:basic:unit:FZadd")
    @PostMapping("/save/groups")
    public ResultBody saveGroup(@RequestBody @Valid BasicGroupVo dto) {
        Integer integer = service.saveGroup(dto);
        ResultBody resultBody = new ResultBody();
        if (integer != null && integer == -1) {
            resultBody.setCode(400);
            resultBody.setMessage("分组重复");
            resultBody.setMessageToUser("分组重复");
        } else if (integer != null && integer == 0) {
            resultBody.setCode(400);
            resultBody.setMessage("新增失败");
            resultBody.setMessageToUser("新增失败");
        }
        return resultBody;
    }


    /**
     * 分页查询分组信息
     *
     * @param vo
     * @return
     */
    @RequiresPermissions("perm:basic:unit")
    @GetMapping("/get/group")
    public ResultBody getGroup(@Valid BasicGroupDTO vo) {
        List<BasicGroupDTO> group = service.getGroup(vo);
        return new ResultBody(new PageInfo<>(group));
    }


    /**
     * 更新分组
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:basic:unit:FZupdate")
    @PostMapping("/update/group")
    public ResultBody updateGroup(@RequestBody @Valid BasicGroupVo dto) {
        ResultBody resultBody = new ResultBody();
        String id = service.getGroupId(dto);
        if (id != null && !id.equals(dto.getId())) {
            resultBody.setCode(400);
            resultBody.setMessage("分组重复");
            resultBody.setMessageToUser("分组重复");
            return resultBody;
        } else if (id != null && id.equals(dto.getId())) {
            return resultBody;
        }
        Integer integer = service.updateGroup(dto);
        if (integer != null && integer == 0) {
            resultBody.setCode(400);
            resultBody.setMessage("更新失败");
            resultBody.setMessageToUser("更新失败");
        }
        return resultBody;
    }

    /**
     * 逻辑删除分组
     *
     * @param id
     * @return
     */
    @RequiresPermissions("perm:basic:unit:FZdelete")
    @PostMapping("/del/group")
    public ResultBody delGroup(@RequestParam("id") String id) {
        ResultBody resultBody = new ResultBody();
        DeviceManagerDTO managerDTO = new DeviceManagerDTO();
        managerDTO.setGroupId(Long.valueOf(id));
        List<DeviceManagerVo> device = deviceService.getDevice(managerDTO);
        if (device != null && device.size() > 0) {
            resultBody.setCode(400);
            resultBody.setMessage("本分组已关联设备不可删除");
            resultBody.setMessageToUser("本分组已关联设备不可删除");
            return resultBody;
        }
        Integer integer = service.deleteGroup(id);
        if (integer != null && integer < 1) {
            resultBody.setCode(400);
            resultBody.setMessage("删除失败");
            resultBody.setMessageToUser("删除失败");
        }
        if (integer != null && integer == -1) {
            resultBody.setCode(400);
            resultBody.setMessage("本分组已关联热换站不可删除");
            resultBody.setMessageToUser("本分组已关联热换站不可删除");
        }
        return resultBody;
    }

    /**
     * 新增热换站
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:basic:unit:HRZadd")
    @PostMapping("/save/site")
    public ResultBody saveSite(@RequestBody @Valid BasicSiteVo dto) {
        ResultBody resultBody = new ResultBody();
        Integer integer = service.saveSuit(dto);
        if (integer != null && integer == -1) {
            resultBody.setCode(400);
            resultBody.setMessage("名称重复");
            resultBody.setMessageToUser("名称重复");
        } else if (integer != null && integer == 0) {
            resultBody.setCode(400);
            resultBody.setMessage("新增失败");
            resultBody.setMessageToUser("新增失败");
        }
        return resultBody;
    }


    /**
     * 分页查询热换站
     *
     * @param vo
     * @return
     */
    @RequiresPermissions("perm:basic:unit")
    @GetMapping("/get/site")
    public ResultBody getSite(@Valid BasicSiteDTO vo) {
        return new ResultBody(new PageInfo<>(service.getSite(vo)));
    }

    /**
     * 更新热换站
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:basic:unit:HRZupdate")
    @PostMapping("/update/site")
    public ResultBody updateSite(@RequestBody @Valid BasicSiteVo dto) {
        ResultBody resultBody = new ResultBody();
        String id = service.getSiteId(dto);
        if (id != null && !id.equals(dto.getId())) {
            resultBody.setCode(400);
            resultBody.setMessage("名称重复");
            resultBody.setMessageToUser("名称重复");
            return resultBody;
        } else if (id != null && id.equals(dto.getId())) {
            return resultBody;
        }
        Integer integer = service.updateSite(dto);
        if (integer != null && integer < 1) {
            resultBody.setCode(400);
            resultBody.setMessage("更新失败");
            resultBody.setMessageToUser("更新失败");
        }
        return resultBody;
    }

    /**
     * 逻辑删除热换站
     *
     * @param id
     * @return
     */
    @RequiresPermissions("perm:basic:unit:HRZdelete")
    @PostMapping("/del/site")
    public ResultBody delSite(@RequestParam("id") String id) {
        ResultBody resultBody = new ResultBody();
        DeviceManagerDTO managerDTO = new DeviceManagerDTO();
        managerDTO.setSiteId(Long.valueOf(id));
        List<DeviceManagerVo> device = deviceService.getDevice(managerDTO);
        if (device != null && device.size() > 0) {
            resultBody.setCode(400);
            resultBody.setMessage("本热换站已关联设备不可删除");
            resultBody.setMessageToUser("本热换站已关联设备不可删除");
            return resultBody;
        }
        Integer integer = service.deleteSite(id);
        if (integer != null && integer < 1) {
            resultBody.setCode(400);
            resultBody.setMessage("删除失败");
            resultBody.setMessageToUser("删除失败");
        }
        if (integer != null && integer == -1) {
            resultBody.setCode(400);
            resultBody.setMessage("本热换站已关联机组不可删除");
            resultBody.setMessageToUser("本热换站已关联机组不可删除");
        }
        return resultBody;
    }

    /**
     * 新增机组
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:basic:unit:JZadd")
    @PostMapping("/save/unit")
    public ResultBody saveUnit(@RequestBody @Valid BasicUnitVo dto) {
        ResultBody resultBody = new ResultBody();
        Integer integer = service.saveUnit(dto);
        if (integer != null && integer == -1) {
            resultBody.setCode(400);
            resultBody.setMessage("名称重复");
            resultBody.setMessageToUser("名称重复");
        } else if (integer != null && integer == 0) {
            resultBody.setCode(400);
            resultBody.setMessage("新增失败");
            resultBody.setMessageToUser("新增失败");
        }
        return resultBody;
    }

    /**
     * 分页查询机组信息
     *
     * @param vo
     * @return
     */
    @RequiresPermissions("perm:basic:unit")
    @GetMapping("/get/unit")
    public ResultBody getUnit(@Valid BasicUnitDTO vo) {
        return new ResultBody(new PageInfo<>(service.getUnit(vo)));
    }

    /**
     * 更新机组信息
     *
     * @param dto
     * @return
     */
    @RequiresPermissions("perm:basic:unit:JZupdate")
    @PostMapping("/update/unit")
    public ResultBody updateUnit(@RequestBody @Valid BasicUnitVo dto) {
        ResultBody resultBody = new ResultBody();
        String id = service.getUnitId(dto);
        if (id != null && !id.equals(dto.getId().toString())) {
            resultBody.setCode(400);
            resultBody.setMessage("机组重复");
            resultBody.setMessageToUser("机组重复");
            return resultBody;
        }
        Integer integer = service.updateUnit(dto);
        if (integer != null && integer < 1) {
            resultBody.setCode(400);
            resultBody.setMessage("更新失败");
            resultBody.setMessageToUser("更新失败");
        }
        return resultBody;
    }

    /**
     * 逻辑删除机组信息
     *
     * @param id
     * @return
     */
    @RequiresPermissions("perm:basic:unit:JZdelete")
    @PostMapping("/del/unit")
    public ResultBody delUnit(@RequestParam("id") String id) {
        ResultBody resultBody = new ResultBody();
        DeviceManagerDTO managerDTO = new DeviceManagerDTO();
        managerDTO.setUnitId(Long.valueOf(id));
        List<DeviceManagerVo> device = deviceService.getDevice(managerDTO);
        if (device != null && device.size() > 0) {
            resultBody.setCode(400);
            resultBody.setMessage("本机组已关联设备不可删除");
            resultBody.setMessageToUser("本机组已关联设备不可删除");
            return resultBody;
        }
        Integer integer = service.delUnit(id);
        if (integer != null && integer < 1) {
            resultBody.setCode(400);
            resultBody.setMessage("删除失败");
            resultBody.setMessageToUser("删除失败");
        }
        return resultBody;
    }

    /**
     * 小区树形结构下拉框
     *
     * @param companyId
     * @return
     */
    @GetMapping("/getRegionTrees")
    public ResultBody getRegionTrees(@RequestParam("companyId") Long companyId) {
        return new ResultBody(service.getRegionTrees(companyId));
    }

    /**
     * 机组树形结构下拉框
     *
     * @param companyId
     * @return
     */
    @GetMapping("/getGroupTrees")
    public ResultBody getGroupTrees(@RequestParam("companyId") Long companyId) {
        return new ResultBody(service.getGroupTrees(companyId));
    }

    /**
     * 小区集合
     *
     * @param id
     * @return
     */
    @GetMapping("/getSelect/region")
    public ResultBody getSelectRegionList(@RequestParam("id") Long id) {
        return new ResultBody(service.getRegionList(id));
    }

    /**
     * 楼宇集合
     *
     * @param id
     * @return
     */
    @GetMapping("/getSelect/tower")
    public ResultBody getSelectTowerList(@RequestParam("id") Long id) {
        return new ResultBody(service.getTowerList(id));
    }

    /**
     * 分组集合
     *
     * @param id
     * @return
     */
    @GetMapping("/getSelect/group")
    public ResultBody getSelectGroupList(@RequestParam("id") Long id) {
        return new ResultBody(service.getGroupList(id));
    }

    /**
     * 热换站集合
     *
     * @param id
     * @return
     */
    @GetMapping("/getSelect/site")
    public ResultBody getSelectSiteList(@RequestParam("id") Long id) {
        return new ResultBody(service.getSiteList(id));
    }

    /**
     * 根据条件查询客户档案列表
     *
     * @param dto  查询条件
     * @return
     */
    @RequiresPermissions("perm:basic:client")
    @GetMapping(value="/listBasicClient")
    public ResultBody listBasicClient(BasicClientQueryDTO dto){
        PageInfo pageInfo = new PageInfo<>(service.listBasicClient(dto));
        return new ResultBody(pageInfo);
    }
}
