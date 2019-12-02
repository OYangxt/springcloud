package com.neoway.springcloud.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 20190712713
 * @date 2019/10/31 9:47
 */
@Data
@NoArgsConstructor
public class Dept implements Serializable {

    private static final long serialVersionUID = -7099597938775389627L;
    private Long deptNum;
    private String deptName;
    private String dbSource;

    public Dept(String deptName) {
        this.deptName = deptName;
    }
}
