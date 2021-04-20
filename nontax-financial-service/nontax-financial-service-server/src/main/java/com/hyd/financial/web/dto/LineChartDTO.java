package com.hyd.financial.web.dto;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/4/20 17:46
 */
public class LineChartDTO {
    private List<String> duration;
    private List<Long> numbers;

    public List<String> getDuration() {
        return duration;
    }

    public void setDuration(List<String> duration) {
        this.duration = duration;
    }

    public List<Long> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "LineChartDTO{" +
                "duration=" + duration +
                ", numbers=" + numbers +
                '}';
    }
}
