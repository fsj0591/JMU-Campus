package com.xueyu.search.controller;

import com.xueyu.common.core.result.RestResult;
import com.xueyu.search.pojo.UserSearchVO;
import com.xueyu.search.service.PostSearchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("post/search")
public class PostSearchController {

    @Resource
    PostSearchService postSearchService;

    @PostMapping("page")
    public RestResult<List> searchByPage(UserSearchVO userSearchVO){
        return RestResult.ok(postSearchService.searchByPage(userSearchVO));
    }


}