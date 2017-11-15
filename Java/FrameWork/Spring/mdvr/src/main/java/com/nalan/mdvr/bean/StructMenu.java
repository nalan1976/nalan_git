package com.nalan.mdvr.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class StructMenu {
//    private List<TwoLevelMenu> menuList;
    private List<Map<Integer, String>> menuList;

}
/*
@Data
class TwoLevelMenu*/
/* implements Comparable*//*
{
    Map<Integer, String> twoLevelMenu;
*/
/*        @Override
        public int compareTo(Object o){
            return -1;
        }*//*

}*/
