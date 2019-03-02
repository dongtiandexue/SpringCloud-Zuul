package com.dtdx.zuul.videoserver.controller;

import com.dtdx.zuul.videoserver.domain.VideoSearchVo;
import com.dtdx.zuul.videoserver.service.VideoSearchService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName VideoSearchController
 * @Description 视频伪查询接口后端
 * @Author huawei
 * @Date 2019/3/2 16:42
 * @Version 1.0
 **/
@RestController
@RequestMapping("video-search")
public class VideoSearchController {

    private static final Logger log = LoggerFactory.getLogger(VideoSearchController.class);


    @Autowired
    private VideoSearchService searchService;

    /**
     * 根据视频的名称搜索
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "searchByName", method = RequestMethod.GET)
    public Object searchByName(@RequestParam("name") String name) {

        if (StringUtils.isBlank(name)) {
            log.info("Bad request");
            return "Bad request";
        }

        VideoSearchVo videoSearchVo = searchService.searchByName(name);
        if (videoSearchVo != null) {
            return videoSearchVo;
        }

        return "Your search not exist";
    }

    /**
     * 根据视频的分类搜索
     *
     * @param category
     * @return
     */
    @RequestMapping(value = "searchByCategory", method = RequestMethod.GET)
    public Object searchByCategory(@RequestParam("category") String category) {

        if (StringUtils.isBlank(category)) {
            log.info("Bad request");
            return "Bad request";
        }

        List<VideoSearchVo> videoSearchVos = searchService.searchByCategory(category);
        return videoSearchVos;

    }


}
