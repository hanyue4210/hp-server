package com.hp.server.dto;

import java.util.List;

/**
 * @author:mengchen
 * @date:2020/5/27
 * @description:
 */
public class OneNetPutDownBatchDTO {
    private List<OneNetPutDownDTO> oneNetPutDownBatchList;

    public List<OneNetPutDownDTO> getOneNetPutDownBatchList() {
        return oneNetPutDownBatchList;
    }

    public void setOneNetPutDownBatchList(List<OneNetPutDownDTO> oneNetPutDownBatchList) {
        this.oneNetPutDownBatchList = oneNetPutDownBatchList;
    }
}
