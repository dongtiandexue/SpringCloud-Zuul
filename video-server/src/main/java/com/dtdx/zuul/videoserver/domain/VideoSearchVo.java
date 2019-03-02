package com.dtdx.zuul.videoserver.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName VideoSearchVo
 * @Description 视频查询结果实体类
 * @Author huawei
 * @Date 2019/3/2 16:43
 * @Version 1.0
 **/

@Data
@Builder
public class VideoSearchVo implements Serializable {

    /**
     * 视频名称
     */
    private String name;

    /**
     * 上映年份
     */
    private String year;

    /**
     * 分类（电影、电视剧。。。）
     */
    private String category;

    /**
     * 简介
     */
    private String desc;
}
