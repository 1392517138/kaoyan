package edu.cqupt.kaoyan.sys.entity.DTO;

import edu.cqupt.kaoyan.sys.entity.QuestionList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Aaron
 * @description
 * @date 2020/4/16 2:29 PM
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QuestionListDTO extends QuestionList {
    private List<String> url = new LinkedList<>();

}
