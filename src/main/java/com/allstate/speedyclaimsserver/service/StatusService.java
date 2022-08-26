package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Statuses;

import java.util.List;

public interface StatusService {

    public Statuses findStatusById(Integer id);

}
