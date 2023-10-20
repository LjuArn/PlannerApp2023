package com.example.plannerapp2023.service;

import com.example.plannerapp2023.domain.entity.PriorityEntity;
import com.example.plannerapp2023.domain.entity.enums.PriorityEnumName;

public interface PriorityService {
    void initBase();

    PriorityEntity findTaskByPriorityNameEnum(PriorityEnumName priorityNameEnum);
}
