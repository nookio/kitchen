package models.enums;

import java.util.*;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/6 下午11:32
 * @Descrition:
 */
public enum Sign {
    DEFAULT(0, "无"),
    SUBWAY_STATION(1, "地铁站"),
    BUS_STATION(2, "公交车站"),
    SCHOOL(3, "学校"),
    MART(4, "商场/购物中心"),
    RAILWAY_STATION(5, "火车站"),
    AIRPORT(6, "机场"),
    DOCK(7, "码头"),
    BUS_TERMINAL(8, "长途客运站"),
    HOSPITAL(9, "医院"),
    MARKET(10, "市场"),
    ADDITIONAL1(11, "扩展预留"),
    ADDITIONAL2(12, "扩展预留");

    private Integer id;
    private String name;

    Sign(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static final Map<Integer, Sign> signs = new HashMap<>();
    public static final List<Integer> ids = new ArrayList<>();
    public static final List<String> names = new ArrayList<>();

    static{
        for (Sign sign : values()){
            signs.put(sign.getId(), sign);
            ids.add(sign.getId());
            names.add(sign.getName());
        }
    }

    public Sign getById(Integer id){
        return signs.getOrDefault(id, DEFAULT);
    }

    public List<Integer> getIds(){
       return ids;
    }

    public Collection<Sign> list(){
        return signs.values();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
