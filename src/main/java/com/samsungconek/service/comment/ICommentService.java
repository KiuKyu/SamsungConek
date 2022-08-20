package com.samsungconek.service.comment;

import com.samsungconek.model.entity.Comment;
import com.samsungconek.service.IGeneralService;

public interface ICommentService extends IGeneralService<Comment> {
    Comment update (Long id, Comment newComment);
}
