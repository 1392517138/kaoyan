package edu.cqupt.kaoyan.sys.entity.DTO;

import edu.cqupt.kaoyan.sys.entity.ReplyList;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Aaron
 * @description
 * @date 2020/4/15 9:34 PM
 */
@Data
public class ReplyListDTO extends ReplyList {

    private List<String> url = new LinkedList<>();

}
