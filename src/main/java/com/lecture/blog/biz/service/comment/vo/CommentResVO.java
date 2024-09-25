package com.lecture.blog.biz.service.comment.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("CommentResVO")
public class CommentResVO {

    // 스터디 댓글 ID
    private String blogPostCommentId;

    // 스터디 ID
    private String blogPostId;

    // 스터티 댓글 내용
    private String blogCommentCon;

    // 스터디 부모 댓글 ID
    private String blogParentCommentId;

    // 스터디 자식 댓글 목록
    private List<CommentResVO> blogChildCommentList;

    // 삭제 여부
    private String delYn;

    // 등록 사용자
    private String rgsnUserId;
    // 등록 사용자 명
    private String rgsnUserNm;

    // 등록 일시
    private Timestamp rgsnTs;

    // 수정 사용자
    private String amnnUserId;
    // 수정 사용자 명
    private String amnnUserNm;

    // 수정 일시
    private Timestamp amnnTs;


}