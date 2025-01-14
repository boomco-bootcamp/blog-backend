package com.lecture.blog.biz.service.blog.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("BlogInfoVO")
public class BlogInfoVO {

    // 블로그 ID
    private String blogId;

    // 유저 ID
    private String userId;

    // 블로그 명
    private String blogNm;

    // 블로그 소개
    private String blogCon;

    // 삭제 여부
    private String delYn;

    // 등록 사용자
    private String rgsnUserId;

    // 등록 일시
    private Timestamp rgsnTs;

    // 수정 사용자
    private String amnnUserId;

    // 수정 일시
    private Timestamp amnnTs;

    // 블로그 배너 파일 ID
    private String blogBannerFileId;

    // 전체 방문자
    private String totalBlogViewsCnt;
    // 오늘 방문자
    private String todayBlogViewsCnt;



}
