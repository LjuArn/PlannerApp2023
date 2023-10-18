package com.example.plannerapp2023.service;


import com.example.plannerapp2023.domain.entity.PriorityEntity;
import com.example.plannerapp2023.domain.entity.enums.PriorityEnumName;
import com.example.plannerapp2023.repository.PriorityRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PriorityServiceImpl implements PriorityService {

    private  final PriorityRepository priorityRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void initBase() {
        if (priorityRepository.count() != 0) {
            return;
        }

        Arrays.stream(PriorityEnumName.values())
                .forEach(priorityEnumName -> {
                    PriorityEntity priority = new PriorityEntity();

                    priority.setPriorityName(priorityEnumName);

                    switch (priorityEnumName) {
                        case URGENT -> priority.setDescription("An urgent problem that blocks the system use until the issue is resolved.");
                        case IMPORTANT ->  priority.setDescription("A core functionality that your product is explicitly supposed to perform is compromised.");
                        case LOW -> priority.setDescription("Should be fixed if time permits but can be postponed.");
                    }


                    priorityRepository.save(priority);
                });




    }
}
