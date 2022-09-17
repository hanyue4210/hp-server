package com.hp.server.dto;

import java.util.List;

/**
 * @author:mengchen
 * @date:2020/6/1
 * @description:
 */
public class OperationColumnListDTO {
    private List<OperationColumnDTO> operationColumnList;

    public List<OperationColumnDTO> getOperationColumnList() {
        return operationColumnList;
    }

    public void setOperationColumnList(List<OperationColumnDTO> operationColumnList) {
        this.operationColumnList = operationColumnList;
    }
}
