package com.hyd.financial.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/4/20 17:46
 */
@Data
@NoArgsConstructor
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
