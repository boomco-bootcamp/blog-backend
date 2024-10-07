package com.lecture.blog.biz.service.category;


import com.lecture.blog.biz.service.category.vo.CategoryVO;
import com.lecture.blog.biz.service.category.vo.MyCategoryReqVO;
import com.lecture.blog.biz.service.category.vo.MyCategorySaveReqVO;

import java.util.List;

public interface CategoryService {

    /**
     * 블로그 카테고리 전체 목록 조회
     * @return
     */
    List<CategoryVO> searchAllCategoryList();

    /**
     * 관심 카테고리 목록 조회
     * @param reqVO
     * @return
     */
    List<CategoryVO> seachMyCategoryList(MyCategoryReqVO reqVO);

    /**
     * 블로그 카테고리 작성
     * @param reqVO
     * @return
     * @throws Exception
     */
    int saveCategoryInfo(CategoryVO reqVO) throws Exception;

    /**
     * 블로그 카테고리 삭제
     * @param reqVO
     * @return
     * @throws Exception
     */
    int deleteCategoryInfo(CategoryVO reqVO) throws Exception;

    /**
     * 관심 카테고리 추가 / 삭제
     * @param saveReqVO
     * @return
     * @throws Exception
     */
    int saveMyCategory(MyCategorySaveReqVO saveReqVO) throws Exception;

}
