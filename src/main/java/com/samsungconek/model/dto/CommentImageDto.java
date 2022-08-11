package com.samsungconek.model.dto;

import com.samsungconek.model.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@Data
public class CommentImageDto {
    private Long id;

    private Comment comment;

    private List<MultipartFile> image;
}
