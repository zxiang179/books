package org.arch.estate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @Author: tianjin@pinduoduo.com
 * @Date: 2021/2/11 9:56 上午
 */
@Data
@Getter
@Setter
@ToString
public class ProvinceBO {

    private long visibleCount;

    private long totalCount;

    private String border;

    private List<AreaBO> bubbleList;

    public long getVisibleCount() {
        return visibleCount;
    }

    public void setVisibleCount(long visibleCount) {
        this.visibleCount = visibleCount;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public List<AreaBO> getBubbleList() {
        return bubbleList;
    }

    public void setBubbleList(List<AreaBO> bubbleList) {
        this.bubbleList = bubbleList;
    }
}
