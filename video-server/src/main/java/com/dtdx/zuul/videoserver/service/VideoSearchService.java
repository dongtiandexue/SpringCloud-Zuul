package com.dtdx.zuul.videoserver.service;

import com.dtdx.zuul.videoserver.domain.VideoSearchVo;

import java.util.List;

/**
 * 视频查询业务端
 */
public interface VideoSearchService {

     VideoSearchVo searchByName(String name);

    List<VideoSearchVo> searchByCategory(String category);
}
