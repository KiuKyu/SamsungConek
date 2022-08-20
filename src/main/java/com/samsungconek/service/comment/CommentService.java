package com.samsungconek.service.comment;

import com.samsungconek.model.entity.Comment;
import com.samsungconek.repository.ICommentRepository;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = commentRepository.findAll();
        BusinessAssert.isTrue(comments.size() > 0, BusinessExceptionCode.EMPTY_LIST, "Danh sách rỗng");
        return comments;
    }

    @Override
    public Comment findById(Long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        BusinessAssert.isTrue(commentOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return commentOptional.get();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public CustomResponse deleteById(Long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        BusinessAssert.isTrue(commentOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        commentRepository.deleteById(id);
        return new CustomResponse("Thành công", 1);
    }

    @Override
    public Comment update(Long id, Comment newComment) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        BusinessAssert.isTrue(commentOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return commentRepository.save(newComment);
    }
}
