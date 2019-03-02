package com.dtdx.zuul.videoserver.service.impl;

import com.dtdx.zuul.videoserver.domain.VideoSearchVo;
import com.dtdx.zuul.videoserver.service.VideoSearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName VideoSearchServiceImpl
 * @Description TODO
 * @Author huawei
 * @Date 2019/3/2 17:18
 * @Version 1.0
 **/

@Service
public class VideoSearchServiceImpl implements VideoSearchService {

    private static List<VideoSearchVo> videos = new ArrayList<>();

    static {

        VideoSearchVo video1 = VideoSearchVo.builder().name("绿皮书").year("2019").category("movie").desc("一名黑人钢琴家，为前往种族歧视严重的南方巡演，找了一个粗暴的白人混混做司机。在一路开车南下的过程里，截然不同的两人矛盾不断，引发了不少争吵和笑料。但又在彼此最需要的时候，一起共渡难关。行程临近结束，两人也慢慢放下了偏见。。。。。。 　　绿皮书，是一本专为黑人而设的旅行指南，标注了各城市中允许黑人进入的旅店、餐馆。电影由真实故事改编。").build();
        VideoSearchVo video2 = VideoSearchVo.builder().name("王牌对王牌第4季").year("2019").category("variety").desc("《王牌对王牌》是浙江卫视推出的大型原创室内竞技真人秀节目，节目每期围绕一个主题，邀请两支王牌团队，由两队固定队长各带领多名热门IP嘉宾进行PK对战，通过才艺比拼、游戏竞技，决出王牌中的王牌。").build();
        VideoSearchVo video3 = VideoSearchVo.builder().name("知否知否应是绿肥红瘦").year("2019").category("tv").desc("盛家六姑娘明兰从小聪颖貌美，却遭遇嫡母不慈，姐妹难缠，父亲不重视，生母被害去世的困境。她藏起聪慧，掩埋锋芒，忍辱负重逆境成长，在万般打压之下依然自立自强，终历尽艰难为母报仇。在这一过程中，明兰结识了宁远侯府二公子顾廷烨。顾廷烨帮过明兰，也刻薄过明兰，他见过明兰软糯表皮下的聪慧锐利，也见过她刚强性格中的脆弱孤单，对她早已倾心。").build();

        videos.add(video1);
        videos.add(video2);
        videos.add(video3);

    }

    /**
     * 根据视频的名称查询
     * @param name
     * @return
     */
    @Override
    public VideoSearchVo searchByName(String name) {

        for (VideoSearchVo video : videos) {
            if(StringUtils.equals(name,video.getName())) {
                return video;
            }
        }

        return null;
    }

    /**
     * 根据视频的分类查询
     * @param category
     * @return
     */
    @Override
    public List<VideoSearchVo> searchByCategory(String category) {

        List<VideoSearchVo> result = new ArrayList<>();
        for (VideoSearchVo video : videos) {
            if(StringUtils.equals(category,video.getCategory())) {
                result.add(video);
            }

        }
        return result;
    }
}
