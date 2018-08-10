package com.hlj.common.dtos.login;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
//import com.hlj.thrift.Function;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class FunctionDto {
//    private Function parent;
//    private List<Function> childrens;
//
//    public static List<FunctionDto> build(List<Function> functions) {
//        List<FunctionDto> list = Lists.newArrayList();
//        Map<Long, FunctionDto> map = Maps.newHashMap();
//        for (Function function : functions) {
//            if (function.getParentId() == 0L) {
//                FunctionDto dto = new FunctionDto();
//                dto.setParent(function);
//                dto.setChildrens(new ArrayList<>());
//                list.add(dto);
//                map.put(function.getId(), dto);
//            }
//        }
//        for (Function function : functions) {
//            Long parentId = function.getParentId();
//            if (map.containsKey(parentId)) {
//                map.get(parentId).getChildrens().add(function);
//            }
//        }
//        return list;
//    }
}