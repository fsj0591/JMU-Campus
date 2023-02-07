package com.xueyu.user.client;

import com.xueyu.common.core.result.RestResult;
import com.xueyu.user.sdk.pojo.vo.UserSimpleVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 用户服务客户端
 *
 * @author durance
 */
@FeignClient(value = "user-server", fallback = UserClientResolver.class)
public interface UserClient {

	/**
	 * 获取单个用户信息
	 *
	 * @param userId 用户id
	 * @return 用户信息
	 */
	@GetMapping("private/user/detail")
	RestResult<UserSimpleVO> getUserInfo(@RequestParam Integer userId);

	/**
	 * 批量获取用户信息
	 *
	 * @param userIds 用户id列表
	 * @return 用户信息
	 */
	@GetMapping("private/user/detail/list")
	RestResult<List<UserSimpleVO>> getUserDeatilInfoList(@RequestParam List<Integer> userIds);

	/**
	 * 按照用户id获取用户列表
	 *
	 * @param userIds 用户id列表
	 * @return 用户 id | 用户信息
	 */
	@GetMapping("private/user/detail/map")
	RestResult<Map<Integer, UserSimpleVO>> getUserDeatilInfoMap(@RequestParam List<Integer> userIds);

}
