package com.palmble.sp.manger.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.palmble.sp.manger.model.Banner;
import com.palmble.sp.manger.model.Result;
import com.palmble.sp.manger.utils.ResultInfo;

public interface BannerService {

	PageInfo<Banner> getBannerList(Map<String, Object> map);

	Result addOrEditBanner(Banner banner);

	Banner getBannerInfo(Integer id);

	ResultInfo delBanner(Integer id);

	ResultInfo uodateBannerState(Integer id, Integer bannerState);

	ResultInfo bannerChangeSort(Integer id, Integer sort); 
}
