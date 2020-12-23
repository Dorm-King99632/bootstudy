package com.dormking.bootstudy.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package: com.dormking.bootstudy.bean
 * @ClassName: Position
 * @Author: dormking
 * @CreateTime: 2020/11/21 01:22
 * @Description:
 */
public class Position  implements Serializable {

    private Integer id;

    private double position_x;

    private double position_y;

    private Date insertTime;

    private String name;

    private String cId;

    private double gas;

    private String mapName;

    private Integer mapId;

    public Position(Integer id, double position_x, double position_y, Date insertTime, String name, String cId, double gas, String mapName, Integer mapId) {
        this.id = id;
        this.position_x = position_x;
        this.position_y = position_y;
        this.insertTime = insertTime;
        this.name = name;
        this.cId = cId;
        this.gas = gas;
        this.mapName = mapName;
        this.mapId = mapId;
    }

    public Position() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPosition_x() {
        return position_x;
    }

    public void setPosition_x(double position_x) {
        this.position_x = position_x;
    }

    public double getPosition_y() {
        return position_y;
    }

    public void setPosition_y(double position_y) {
        this.position_y = position_y;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", position_x=" + position_x +
                ", position_y=" + position_y +
                ", insertTime=" + insertTime +
                ", name='" + name + '\'' +
                ", cId='" + cId + '\'' +
                ", gas=" + gas +
                ", mapName='" + mapName + '\'' +
                ", mapId=" + mapId +
                '}';
    }
}
